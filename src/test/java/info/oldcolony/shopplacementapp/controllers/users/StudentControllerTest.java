package info.oldcolony.shopplacementapp.controllers.users;

import info.oldcolony.shopplacementapp.controllers.TestStudent;
import info.oldcolony.shopplacementapp.model.student.Student;

import info.oldcolony.test.testhelpers.MockMvcRequestHelper;
import info.oldcolony.test.testhelpers.TestUtilities;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;
    private static final String BASE_URL = "/api/v1/users/students";
    private MockMvcRequestHelper mockMvcRequestHelper;

    @BeforeEach
    public void setup() {
        mockMvcRequestHelper = new MockMvcRequestHelper(mockMvc);
    }

    @Test
    public void addSingleStudent() throws Exception {
        Student testStudent = TestStudent.generateTestStudents(1).get(0);
        // build a hashmap of all properties
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", testStudent.getStudentId());
        params.put("firstName", testStudent.getFirstName());
        params.put("lastName", testStudent.getLastName());
        params.put("idOfEnrolledShop", testStudent.getIdOfEnrolledShop());
        params.put("idsOfShopChoices", testStudent.getIdsOfShopChoices());
        params.put("exploratoryGrade", testStudent.getExploratoryGrade());
        mockMvcRequestHelper.postQuery(BASE_URL, params);

        // Use API to get the student from the sever and compare it to the testStudent to make sure they are the same
        String newStudentString = mockMvcRequestHelper.getQuery(BASE_URL + "/" + testStudent.getStudentId(), "");
        assertEquals(testStudent.toString(), newStudentString);
    }

    @Test
    void addMultipleStudents() throws Exception {
        List<TestStudent> testStudents = TestStudent.generateTestStudents(10);
        mockMvcRequestHelper.postJson(BASE_URL, testStudents.toString());
        List<Integer> allStudentIds = new ArrayList<>();
        testStudents.forEach(testStudent -> allStudentIds.add(testStudent.getStudentId()));
        String jsonResponse = mockMvcRequestHelper.getQuery(BASE_URL, allStudentIds);
        assertEquals(TestUtilities.removeWhiteSpace(testStudents.toString()),
                TestUtilities.removeWhiteSpace(jsonResponse));
    }

    @Test
    void getById() {
    }

    @Test
    void getByIds() {
    }

    @Test
    void getAll() {
    }

    @Test
    void update() {
    }

    @Test
    void removeElementById() {
    }

    @Test
    void removeElementsByIds() {
    }

    @Test
    void removeAllElements() {
    }

    @Test
    void updateStudent() {
    }

    @Test
    void testRemoveElementById() {
    }
}