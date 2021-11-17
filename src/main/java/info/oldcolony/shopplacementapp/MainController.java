package info.oldcolony.shopplacementapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ShopRepository shopRepository;
    private ShopPlacementModel model = null;
    private boolean hasBeenSetup = false;
    public final HashMap<String, Shop> shops = new HashMap<>();

    public MainController() {

    }

    public void setup() {
        setupShopModel();
        createTestStudentData();
        setupStudentModel();
        hasBeenSetup = true;
    }

    private void setupShopModel() {
        Iterable<ShopEntity> shopEntities = shopRepository.findAll();
        for (ShopEntity se : shopEntities) {
            Shop shop = new Shop(se.getName(), se.getCapacity());
            this.shops.put(se.getName(), shop);
        }
    }

    private void setupStudentModel() {
        // Generate all students by pulling info from student repo (database)
        Iterable<StudentEntity> studentEntities = studentRepository.findAll();
        ArrayList<Student>  students = new ArrayList<>();
        for (StudentEntity se : studentEntities) {
            Integer studentId = se.getStudentId();
            String firstName = se.getFirstName();
            String lastName = se.getLastName();
            String email = se.getEmail();
            double exploratoryGrade = se.getExploratoryGrade();
            // Student entity (SE) shop is the string value of the shop. The specific instance of the shop are stored in shops
            // instance variable. The string name of the shop is the key to look up the reference to the specific instance of that shop.
            Shop enrolledShop = shops.get(se.getEnrolledShop());
            Shop[] choices = {shops.get(se.getChoice1()), shops.get(se.getChoice2()), shops.get(se.getChoice3()), shops.get(se.getChoice4()), shops.get(se.getChoice5())};
            Student student = new Student(firstName,lastName,studentId,choices, exploratoryGrade);
            student.setEnrolledShop(enrolledShop);
            students.add(student);
        }
        Student[] studentArray = new Student[students.size()];
        students.toArray(studentArray);
        this.model = new ShopPlacementModel(studentArray);
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        StudentEntity n = new StudentEntity();
        n.setFirstName(name);
        n.setEmail(email);
        studentRepository.save(n);
        return "Saved";
    }

    @PutMapping(path="/sort")
    public void sortUsers() {
        if (!hasBeenSetup) setup();
        model.placeStudents();
        //TODO: Update student repo here by taking info in student objects and updating repo records
        HashMap<Integer, Student> students = model.getStudents();
        for(Integer studentId : students.keySet()) {
            StudentEntity se = studentRepository.findById(studentId).get();
            se.setEnrolledShop(students.get(studentId).getEnrolledShop().getName());
            studentRepository.save(se);
        }
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<StudentEntity> getAllUsers() {
        // This returns a JSON or XML with the users
        return studentRepository.findAll();
    }

    private void createTestStudentData() {
        studentRepository.deleteAll();
        for (int i = 0; i < 2; i++) {
            ArrayList<String> shopList = new ArrayList<>(shops.keySet());
            Collections.shuffle(shopList);
            StudentEntity se = new StudentEntity();
            String firstName = FakeNameGenerator.getFirstName();
            String lastName = FakeNameGenerator.getLastName();
            String email = lastName.toLowerCase() + firstName.toLowerCase().charAt(0) + "@oldcolony.info";
            double exploratoryGrade = Math.random() * 70 + 30;
            String[] shopChoices = new String[5];
            for (int j = 0; j < shopChoices.length; j++) {
                shopChoices[j] = shopList.get(j);
            }
            se.setFirstName(firstName);
            se.setLastName(lastName);
            se.setEmail(email);
            se.setExploratoryGrade(exploratoryGrade);
            int index = 0;
            se.setChoice1(shopChoices[index++]);
            se.setChoice2(shopChoices[index++]);
            se.setChoice3(shopChoices[index++]);
            se.setChoice4(shopChoices[index++]);
            se.setChoice5(shopChoices[index]);
            studentRepository.save(se);
        }
    }
}