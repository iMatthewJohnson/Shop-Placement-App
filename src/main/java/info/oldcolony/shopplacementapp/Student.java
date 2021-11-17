package info.oldcolony.shopplacementapp;

public class Student implements Comparable {
    private String firstName;
    private String lastName;
    private Integer studentId;
    private Shop[] shopChoices;
    private Shop enrolledShop = null;
    private double exploratoryGrade;

    public static final int MAX_CHOICES = 5;
    private static final double INIT_GRADE = 100.0;

    public Student(String firstName, String lastName, Integer studentId, Shop[] shopChoices, double exploratoryGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.shopChoices = shopChoices;
        this.exploratoryGrade = exploratoryGrade;
    }

    public Student(String firstName, String lastName, Integer studentId) {
        this(firstName, lastName, studentId, null, INIT_GRADE);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public Shop getShopChoiceAtIndex(int index) {
        return shopChoices[index];
    }

    public void setShopChoiceAtIndex(int index, Shop shopChoice) {
        shopChoices[index] = shopChoice;
    }

    public double getExploratoryGrade() {
        return exploratoryGrade;
    }

    public void setExploratoryGrade(double exploratoryGrade) {
        this.exploratoryGrade = exploratoryGrade;
    }

    public void setEnrolledShop(Shop shop) {
        this.enrolledShop = shop;
    }

    public Shop getEnrolledShop() {
        return this.enrolledShop;
    }

    @Override
    public int compareTo(Object o) {
        Student otherStudent = (Student) o;
        if (exploratoryGrade > otherStudent.getExploratoryGrade()) return -1;
        if (exploratoryGrade < otherStudent.getExploratoryGrade()) return 1;
        return 0;
    }

}
