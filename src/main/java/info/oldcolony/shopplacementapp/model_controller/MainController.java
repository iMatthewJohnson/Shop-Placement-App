package info.oldcolony.shopplacementapp.model_controller;

import com.sun.istack.NotNull;

import info.oldcolony.shopplacementapp.cruds.ShopEntity;
import info.oldcolony.shopplacementapp.cruds.ShopRepository;
import info.oldcolony.shopplacementapp.cruds.StudentEntity;
import info.oldcolony.shopplacementapp.cruds.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@Controller // This means that this class is a Controller
@RequestMapping(path="/api/v1") // All api request paths will be relative "/api/v1"
public class MainController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ShopRepository shopRepository;
    private final ShopPlacementModel shopPlacementModel;
    public final HashMap<String, Shop> shops;

    /**
     *
     */
    public MainController() {
        this.shops = loadShopModel();
        this.shopPlacementModel = loadStudentModel(this.shops);
    }

    /**
     * Post request that adds new user {@code firstName} and {@code lastName} to Student Repository database and model.
     * @param firstName first name of student to be added
     * @param lastName last name of student to be added
     * @return response body that indicates that new user was saved successfully.
     */
    @PostMapping(path="/users/students/add")
    public @ResponseBody String addNewStudent(@RequestParam @NonNull String firstName,
                                            @RequestBody @NonNull String lastName) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        StudentEntity se = new StudentEntity();
        se.setFirstName(firstName);
        se.setLastName(lastName);
        Student newStudent = new Student(se.getStudentId(), se.getFirstName(), se.getLastName());
        shopPlacementModel.add(newStudent);
        return String.format("New User %s %s with ID %d saved", firstName, lastName, se.getStudentId());
    }

    /**
     *
     */
    @PutMapping(path="/users/students/all/place_students")
    public void placeStudentsIntoShops() {
        shopPlacementModel.placeStudentsInShops();
        HashMap<Integer, Student> modelsStudents = shopPlacementModel.getAllStudents();
        for(Integer studentId : modelsStudents.keySet()) {
            Student student = modelsStudents.get(studentId);
            if (student.getEnrolledShop() != null) {
                StudentEntity se = studentRepository.findById(studentId).get();
                se.setEnrolledShop(student.getEnrolledShop().getName());
                studentRepository.save(se);
            }
        }
    }


    @GetMapping(path="/users/students/all")
    public @ResponseBody Iterable<StudentEntity> getAllUsers() {
        // This returns a JSON or XML with the users
        return studentRepository.findAll();
    }

    /**
     * Loads the information in the Student repo (database) and loads into the models within the program.
     * @param shops HashMap of {@code Shop} objects (using the {@code String} name of the shop as the key for the
     *              instance of each shop.
     * @return new instance of {@code ShopPlacementModel} with all students and information from Student repo.
     */
    private ShopPlacementModel loadStudentModel(@NotNull HashMap<String, Shop> shops) throws IllegalArgumentException {
        //TODO: Update to have a shopChoice field in the database that will hold a list of choices in order of
        // preference. Will need to choose delimiter format and parse through it.
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

    /**
     * Sets up the Shop Model as Java objects. This uses the information found in the ShopEntity database to get the
     * name and maximum capacity of each shop.
     * @return HashMap of {@code Shop} objects (using the {@code String} name of the shop as the key for the
     *         instance of each shop.
     */
    private HashMap<String, Shop> loadShopModel() {
        HashMap<String, Shop> shops = new HashMap<>();
        Iterable<ShopEntity> shopEntities = shopRepository.findAll();
        for (ShopEntity se : shopEntities) {
            Shop shop = new Shop(se.getName(), se.getCapacity());
            shops.put(se.getName(), shop);
        }
        return shops;
    }
}