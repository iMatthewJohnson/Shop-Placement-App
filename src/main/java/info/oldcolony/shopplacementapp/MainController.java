package info.oldcolony.shopplacementapp;

import com.sun.istack.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ShopRepository shopRepository;
    private final ShopPlacementModel model;
    public final HashMap<String, Shop> shops;

    /**
     *
     */
    public MainController() {
        this.shops = createShopModel();
        this.model = createStudentModel(this.shops);
    }


    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam @NonNull String firstName,
                                            @RequestBody @NonNull String lastName) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        StudentEntity n = new StudentEntity();
        n.setFirstName(firstName);
        n.setLastName(lastName);
        StudentEntity se = studentRepository.save(n);
        Student newStudent = new Student(se.getStudentId(), se.getFirstName(), se.getLastName());
        model.add(newStudent);
        return String.format("New User %s %s with ID %d saved", firstName, lastName, se.getStudentId());
    }

    @PutMapping(path="/sort")
    public void sortUsers() {
        model.placeStudents();
        HashMap<Integer, Student> students = model.getStudents();
        for(Integer studentId : students.keySet()) {
            Student student = students.get(studentId);
            if (student.getEnrolledShop() != null) {
                StudentEntity se = studentRepository.findById(studentId).get();

                se.setEnrolledShop(student.getEnrolledShop().getName());
                studentRepository.save(se);
            }
        }
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<StudentEntity> getAllUsers() {
        // This returns a JSON or XML with the users
        return studentRepository.findAll();
    }

    /**
     * Sets up the Shop Model as Java objects. This uses the information found in the ShopEntity database to get the
     * name and maximum capacity of each shop.
     * @return HashMap of {@code Shop} objects (using the {@code String} name of the shop as the key for the
     *         instance of each shop.
     */
    private HashMap<String, Shop> createShopModel() {
        HashMap<String, Shop> shops = new HashMap<>();
        Iterable<ShopEntity> shopEntities = shopRepository.findAll();
        for (ShopEntity se : shopEntities) {
            Shop shop = new Shop(se.getName(), se.getCapacity());
            shops.put(se.getName(), shop);
        }
        return shops;
    }

    /**
     * Sets up the Student Model as Java objects. This uses the information in the Student repo (database) to set up
     * each student as {@code Student} object.
     * @param shops HashMap of {@code Shop} objects (using the {@code String} name of the shop as the key for the
     *              instance of each shop.
     * @return new instance of {@code ShopPlacementModel} with all students and information from Student repo.
     */
    private ShopPlacementModel createStudentModel(@NotNull HashMap<String, Shop> shops) throws IllegalArgumentException {
        if (shops.size() < 1) throw new IllegalArgumentException("Shop model have at least one item");
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
            Student student = new Student(studentId, firstName,lastName, choices, exploratoryGrade, null);
            student.setEnrolledShop(enrolledShop);
            students.add(student);
        }
        Student[] studentArray = new Student[students.size()];
        students.toArray(studentArray);
        return new ShopPlacementModel(studentArray);
    }

//    private void createTestStudentData() {
//        studentRepository.deleteAll();
//        for (int i = 0; i < 150; i++) {
//            ArrayList<String> shopList = new ArrayList<>(shops.keySet());
//            Collections.shuffle(shopList);
//            StudentEntity se = new StudentEntity();
//            String firstName = FakeNameGenerator.getFirstName();
//            String lastName = FakeNameGenerator.getLastName();
//            String email = lastName.toLowerCase() + firstName.toLowerCase().charAt(0) + "@oldcolony.info";
//            double exploratoryGrade = Math.random() * 70 + 30;
//            exploratoryGrade = Double.parseDouble(String.format("%.4f", exploratoryGrade));
//            String[] shopChoices = new String[5];
//            for (int j = 0; j < shopChoices.length; j++) {
//                shopChoices[j] = shopList.get(j);
//            }
//            se.setStudentId(i);
//            se.setFirstName(firstName);
//            se.setLastName(lastName);
//            se.setEmail(email);
//            se.setExploratoryGrade(exploratoryGrade);
//            int index = 0;
//            se.setChoice1(shopChoices[index++]);
//            se.setChoice2(shopChoices[index++]);
//            se.setChoice3(shopChoices[index++]);
//            se.setChoice4(shopChoices[index++]);
//            se.setChoice5(shopChoices[index]);
//            studentRepository.save(se);
//        }
//    }
}