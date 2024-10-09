import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Student {

    int rollNo;
    int standard;
    String name;
    int marks;

    public Student(int rollNo, int standard, String name, int marks) {
        this.rollNo = rollNo;
        this.standard = standard;
        this.name = name;
        this.marks = marks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks(){
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", standard=" + standard +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }

    public static void main(String[] args) {

        Student stu1 = new Student(101, 1, "Ramesh", 87);
        Student stu2 = new Student(102, 2, "Raju", 63);
        Student stu3 = new Student(103, 3, "Golem", 95);
        Student stu4 = new Student(104, 3, "Pekka", 56);
        Student stu5 = new Student(106, 2, "Wizard", 82);
        Student stu6 = new Student(107, 1, "Minion", 78);
        Student stu7 = new Student(109, 2, "Ryder", 99);

        List<Student> studentList = Arrays.asList(stu1, stu2, stu3, stu4, stu5, stu6, stu7);

        // return the students which are having marks greater than 80 in each department
        Map<Integer, Long> students = studentList.stream()
                .filter(e -> e.getMarks() > 80)
                .collect(Collectors.groupingBy(Student::getStandard, Collectors.counting()));
        Set<Map.Entry<Integer, Long>> entry = students.entrySet();
        System.out.println("Students having marks greater than 80 in each standard : \n");
        for(Map.Entry<Integer, Long> me1 : entry){
            System.out.println("-----------------------------------------------");
            System.out.println("Students in standard " + me1.getKey() + " : ");
            System.out.println("-----------------------------------------------");
            Long list2 = me1.getValue();
            System.out.println(list2);
        }
    }
}


