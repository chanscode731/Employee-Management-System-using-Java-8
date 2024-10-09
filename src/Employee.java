import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Employee {

    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", yearOfJoining=" + yearOfJoining +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args){

        Employee emp1 = new Employee(111, "Jennifer", 22, "Female", "HR", 2013, 55000.0);
        Employee emp2 = new Employee(112, "Rohit", 35, "Male", "Sales And Marketing", 2019, 23500.0);
        Employee emp3 = new Employee(113, "Shubman", 29, "Male", "Infrastructure", 2019, 28000.0);
        Employee emp4 = new Employee(114, "Rinku", 28, "Male", "Product Development", 2020, 62500.0);
        Employee emp5 = new Employee(115, "Aaditi", 41, "Female", "HR", 2022, 29700.0);
        Employee emp6 = new Employee(116, "Mahendra", 43, "Male", "Security And Transport", 2023, 20500.0);
        Employee emp7 = new Employee(117, "Nitish", 35, "Male", "Account And Finance", 2019, 37000.0);
        Employee emp8 = new Employee(118, "Aditya", 31, "Male", "Product Development", 2019, 34500.0);
        Employee emp9 = new Employee(119, "Monika", 24, "Female", "Sales And Marketing", 2021, 21500.0);
        Employee emp10 = new Employee(120, "Aman", 38, "Male", "Security And Transport", 2021, 31000.5);
        Employee emp11 = new Employee(121, "Sangeeta", 27, "Female", "Infrastructure", 2021, 35000.0);
        Employee emp12 = new Employee(122, "Joshi", 25, "Male", "Product Development", 2020, 29000.0);
        Employee emp13 = new Employee(123, "Jeddy", 27, "Female", "Account And Finance", 2020, 29000.0);
        Employee emp14 = new Employee(124, "Niden", 24, "Male", "Sales And Marketing", 2020, 30200.5);
        Employee emp15 = new Employee(125, "Saig", 23, "Male", "Infrastructure", 2019, 42700.0);
        Employee emp16 = new Employee(126, "Saey", 26, "Female", "Product Development", 2018, 38900.0);
        Employee emp17 = new Employee(127, "Shreyas", 25, "Male", "Product Development", 2018, 35700.0);

        List<Employee> employeeList = Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8, emp9, emp10, emp11, emp12, emp13, emp14, emp15, emp16, emp17);

        // employeeList.forEach(e -> System.out.println(e));

        // 1. How many employees are there in the organization?
        long count = employeeList.stream().count();
        System.out.println("Total no. of employees in the organization : " + count);


        // 2. Sort the List of Employee objects based on salary in Ascending order
        List<Employee> employeeSortedList = employeeList.stream()
                .sorted((o1, o2) -> (int)(o1.getSalary() - o2.getSalary()))
                .collect(Collectors.toList());
        System.out.println("Sorted list based on salary : " + employeeSortedList);


        // 3. How many male and female employees are there in the organization?
        Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("No. of male & female employees : " + noOfMaleAndFemaleEmployees);


        // 4. How many employees are there in each department?
        Map<String, Long> employeeCountByDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        Set<Map.Entry<String, Long>> entry = employeeCountByDept.entrySet();
        System.out.println("Employees by each department : ");
        for(Map.Entry<String, Long> me : entry){
            System.out.println("------------------------------------------");
            System.out.println(me.getKey() + " : " + me.getValue());
        }


        // 5. Print the names of all the departments
        List<String> departments = employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("List of all the departments : " + departments);



        // 6. Find the average salary of the male and female employee
        Map<String, Double> avgSal = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Average salary of male & female employees : " + avgSal);



        // 7. Fetch the highest-paid male and female employee
        Map<String, Optional<Employee>> highestPaidMaleAndFemale = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy((o1, o2) -> (int)(o1.getSalary() - o2.getSalary()))));
        System.out.println("Highest paid employee in each department : ");
        for(Map.Entry<String, Optional<Employee>> e : highestPaidMaleAndFemale.entrySet()){
            System.out.println("-------------------------------------------------------");
            System.out.println(e.getKey() + " : " + e.getValue().get());
        }



        // 8. Get the details of the highest paid employee in the organization?
        Optional<Employee> highestPaidEmployeeWrapper = employeeList.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        Employee highestPaidEmployee = highestPaidEmployeeWrapper.get();
        System.out.println("Details of the highest paid employee : ");
        System.out.println("-------------------------------------------------------");
        System.out.println("Name : " + highestPaidEmployee.getName());
        System.out.println("Age : " + highestPaidEmployee.getAge());
        System.out.println("Department : " + highestPaidEmployee.getDepartment());
        System.out.println("Gender : " + highestPaidEmployee.getGender());
        System.out.println("Salary : " + highestPaidEmployee.getSalary());



        // 9. Find the average salary of each department?
        Map<String, Double> avgSalByDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        Set<Map.Entry<String, Double>> ent = avgSalByDept.entrySet();
        System.out.println("Average salary of each department : \n");
        for(Map.Entry<String, Double> m1 : ent){
            System.out.println(m1.getKey() + " : " + m1.getValue());
        }


        // 10. Get the details of the youngest male employee in the product development department?
        Optional<Employee> youngestMaleProductDevelopmentWrapper = employeeList.stream()
                .filter(e -> e.getGender().equalsIgnoreCase("male") && e.getDepartment() == "Product Development")
                .min(Comparator.comparingInt(Employee::getAge));
        Employee youngestMaleProductDevelopment = youngestMaleProductDevelopmentWrapper.get();
        System.out.println("Details Of Youngest Male Employee In Product Development");
        System.out.println("----------------------------------------------");
        System.out.println("Name : " + youngestMaleProductDevelopment.getName());
        System.out.println("Age : " + youngestMaleProductDevelopment.getAge());
        System.out.println("Gender : " + youngestMaleProductDevelopment.getGender());
        System.out.println("Salary : " + youngestMaleProductDevelopment.getSalary());
        System.out.println("Year of Joining : " + youngestMaleProductDevelopment.getYearOfJoining());



        // 11. Who has the most working experience in the organization?
        Optional<Employee> seniorMostWrapper = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getYearOfJoining))
                .findFirst();
        Employee seniorMostEmployee = seniorMostWrapper.get();
        System.out.println("Senior most employee details : ");
        System.out.println("----------------------------------------------");
        System.out.println("Employee : " + seniorMostEmployee);



        // 12. Who is the oldest employee in the organization?
        Optional<Employee> oldestEmployeeWrapper = employeeList.stream()
                .max(Comparator.comparingInt(Employee::getAge));
        Employee oldestEmployee = oldestEmployeeWrapper.get();
        System.out.println("Oldest employee details : ");
        System.out.println("----------------------------------------------");
        System.out.println("Employee : " + oldestEmployee);



        // 13. What is the average salary and total salary of the whole organization?
        DoubleSummaryStatistics salaryStatistics = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Average salary : " + salaryStatistics.getAverage());
        System.out.println("Total salary : " + salaryStatistics.getSum());



        // 14. List down the names of all employees in each department?
        Map<String, List<Employee>> employeeListByDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        Set<Map.Entry<String, List<Employee>>> entry1 = employeeListByDept.entrySet();
        for(Map.Entry<String, List<Employee>> me1 : entry1){
            System.out.println("----------------------------------------------");
            System.out.println("Employees in " + me1.getKey() + " : ");
            System.out.println("----------------------------------------------");
            List<Employee> list1 = me1.getValue();
            for(Employee e : list1){
                System.out.println(e.getName());
            }
        }


        // 15. Separate the employees who are younger or equal to 30 years from those older than 30 years
        Map<Boolean, List<Employee>> partitionByAge = employeeList.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() > 30));
        Set<Map.Entry<Boolean, List<Employee>>> entryAge = partitionByAge.entrySet();
        for(Map.Entry<Boolean, List<Employee>> e1 : entryAge){
            System.out.println("----------------------------------------------");
            if(e1.getKey()){
                System.out.println("Employees older than 30 years : ");
            }
            else{
                System.out.println("Employees younger than or equal to 30 years : ");
            }
            System.out.println("----------------------------------------------");
            List<Employee> myList = e1.getValue();
            for(Employee e : myList){
                System.out.println(e.getName());
            }
        }



        // 16. Get the Names of employees who joined after 2015
        List<Employee> joinedAfter2015 = employeeList.stream()
                .filter(e -> e.getYearOfJoining() > 2015)
                .collect(Collectors.toList());
        System.out.println("-----------------------------------------");
        System.out.println("Employees joining after 2015 are : ");
        System.out.println("-----------------------------------------");

        for(Employee e2 : joinedAfter2015){
            System.out.println(e2.getName() + " --> " + e2.getYearOfJoining());
        }



        // 17. Find the youngest female employee in the organization
        Optional<Employee> youngestFemaleWrapper = employeeList.stream()
                .filter(e -> e.getGender().equalsIgnoreCase("female"))
                .min(Comparator.comparingInt(Employee::getAge));
        Employee youngestFemaleEmployee = youngestFemaleWrapper.get();
        System.out.println("-----------------------------------------");
        System.out.println("Details of the youngest female employee in the organization : ");
        System.out.println("-----------------------------------------");
        System.out.println("Name : " + youngestFemaleEmployee.getName());
        System.out.println("Age : " + youngestFemaleEmployee.getAge());
        System.out.println("Department : " + youngestFemaleEmployee.getDepartment());
        System.out.println("Year of Joining : " + youngestFemaleEmployee.getYearOfJoining());
        System.out.println("Salary : " + youngestFemaleEmployee.getSalary());



        // 18. Find if there any employees from HR Department
        Optional<Employee> employeesInHRDept = employeeList.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase("HR")).findAny();

        /*Employee employeesInHRDept = employeesInHRDeptWrapper.get();
        System.out.println(employeesInHRDept);*/

        employeesInHRDept.ifPresent(emp -> System.out.println("Found employees from HR department : " + emp.getName()));



        // 19. Find the department names that these employees work for, where the number of employees in the department is over 3
        System.out.println("Departments where there are more than 3 employees working are : ");
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 3).forEach(System.out::println);



        // 20. Find Second Highest salary in the organisation
        Optional<Employee> secondHighestSalWrapper = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst();
        Employee secondHighestSal = secondHighestSalWrapper.get();
        System.out.println("Employee with second highest salary is : " + secondHighestSal.getName() + " --> " + secondHighestSal.getSalary());




    }
}
