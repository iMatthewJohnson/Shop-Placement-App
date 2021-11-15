package info.oldcolony.shopplacementapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private StudentRepository studentRepository;
    private ShopPlacementModel model;
    private HashMap<String, Shop> shops = new HashMap<>();

    public MainController() {
        // Generate all the shops and store in MainController instance variable
        HashMap<String, Integer> shopsAndCapacity = Shop.SHOPS_AND_CAPACITY;
        for (String shopName : shopsAndCapacity.keySet()) {
            Shop shop = new Shop(shopName, shopsAndCapacity.get(shopName));
            this.shops.put(shopName, shop);
        }
        // Generate all students by pulling info from student repo (database)
        Iterable<StudentEntity> studentEntities = studentRepository.findAll();
        ArrayList<Student> students = new ArrayList<>();
        for (StudentEntity se : studentEntities) {
            String studentId = se.getStudentId();
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
        Object[] studentArray = students.toArray();
        this.model = new ShopPlacementModel((Student[]) studentArray);
    }

    @SuppressWarnings("unchecked")
    public HashMap<String, Shop> getShops() {
        return (HashMap<String, Shop>) shops.clone();
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

    @GetMapping(path="/all")
    public @ResponseBody Iterable<StudentEntity> getAllUsers() {
        // This returns a JSON or XML with the users
        return studentRepository.findAll();
    }
}