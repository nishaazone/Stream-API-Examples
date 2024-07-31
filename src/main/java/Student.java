import java.util.*;
import java.util.stream.Collectors;


public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String departmantName;
    private int joinedYear;
    private String city;
    private int rank;

    public Student(int id, String firstName, String lastName, int age, String gender, String departmantName,
                   int joinedYear, String city, int rank) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.departmantName = departmantName;
        this.joinedYear = joinedYear;
        this.city = city;
        this.rank = rank;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getDepartmantName() {
        return departmantName;
    }

    public void setDepartmantName(String departmantName) {
        this.departmantName = departmantName;
    }

    public int getJoinedYear() {
        return joinedYear;
    }

    public void setJoinedYear(int joinedYear) {
        this.joinedYear = joinedYear;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
                + ", gender=" + gender + ", departmantName=" + departmantName + ", joinedYear=" + joinedYear + ", city="
                + city + ", rank=" + rank + "]";
    }


    static List<Student> list = Arrays.asList(
            new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
            new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
            new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
            new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
            new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
            new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
            new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
            new Student(8, "Anuj", "Dev", 31, "Male", "Computer Engineering", 2014, "Delhi", 433),
            new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
            new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));


    public static void main(String[] args) {

//        Find list of students whose first name starts with alphabet A
        List<Student> listStu = Student.list.stream().filter(dt -> dt.getFirstName().startsWith("A")).collect(Collectors.toList());
        System.out.println(listStu);

//        Group The Student By Department Names
        Map<String, List<Student>> mapdata = Student.list.stream().collect(Collectors.groupingBy(Student::getDepartmantName));
        System.out.println(mapdata);

//        Find the total count of student using stream
        Long StudCount = Student.list.stream().count();
        System.out.println(StudCount);

//        Find the max age of student
        OptionalInt MmaxAge = Student.list.stream().mapToInt(dt -> dt.getAge()).max();
        System.out.println(MmaxAge);

//        Find all departments names
        List<String> lstDepartmenst = Student.list.stream().map(dt -> dt.getDepartmantName()).distinct().collect(Collectors.toList());
        System.out.println(lstDepartmenst);

//        Find the count of student in each department
        Map<String, Long> stuCountDepartment = Student.list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
        System.out.println(stuCountDepartment);

//        Find the list of students whose age is less than 30
        List<Student> listStudent = Student.list.stream().filter(dt-> dt.getAge() < 30).collect(Collectors.toList());
        System.out.println(listStudent);

//        Find the list of students whose rank is in between 50 and 100
        List<Student> lstStu = list.stream().filter(dt -> dt.getRank() > 50 && dt.getRank() < 100)
                .collect(Collectors.toList());
        System.out.println(lstStu);

//        Find the average age of male and female students
        Map<String, Double> mapGenderAge = Student.list.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        System.out.println(mapGenderAge);

//        Find the department who is having maximum number of students
        Map.Entry<String, Long> maxStudDepart = Student.list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting())).entrySet()
                .stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(maxStudDepart);

//        Find the Students who stays in Delhi and sort them by their names
        List<Student> lstDelhistudent = Student.list.stream().filter(dt -> dt.getCity().equals("Delhi")).sorted(Comparator.comparing(Student::getFirstName))
                 .collect(Collectors.toList());
        System.out.println(lstDelhistudent);

//        Find the average rank in all departments
        Map<String, Double> avgRank = Student.list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getRank)));
        System.out.println(avgRank);

//        Find the highest rank in each department
        Map<String, Optional<Student>> highestRank = Student.list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.minBy(Comparator.comparing(Student::getRank))));
        System.out.println(highestRank);

//        Find the list of students and sort them by their rank
        List<Student> stuRankSorted = Student.list.stream().sorted(Comparator.comparing(Student::getRank)).collect(Collectors.toList());
        System.out.println(stuRankSorted);

//        Find the student who has second rank
        Student stuSecondRank = Student.list.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst().get();
        System.out.println(stuSecondRank);



        // Find the list of students whose last name starts with the letter "S".
        List<Student> listStudentsWithS = Student.list.stream().filter(dt -> dt.getLastName().startsWith("S")).collect(Collectors.toList());
        System.out.println(listStudentsWithS);

       // Group the students by their city and find the count of students in each city.
        Map<String, Long> studentInCityCount = Student.list.stream().collect(Collectors.groupingBy(Student::getCity, Collectors.counting()));
        System.out.println(studentInCityCount);

//        Find the total sum of ranks of all students.
        int sumRanks = Student.list.stream().mapToInt(Student::getRank).sum();
        System.out.println(sumRanks);

//        Find the list of students who joined in the year 2015 or later.
        List<Student> listStudentYear = Student.list.stream().filter(dt -> dt.getJoinedYear() >= 2015).collect(Collectors.toList());
        System.out.println(listStudentYear);

//        Find the average age of students in each department.
        Map<String, Double> avgAgeDepart = Student.list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getAge)));
        System.out.println(avgAgeDepart);

//        Find the list of students whose gender is female and sort them by their last name.
        List<Student> genderSort = Student.list.stream().filter(dt -> dt.getGender().equals("Female")).sorted(Comparator.comparing(Student::getLastName)).collect(Collectors.toList());
        System.out.println(genderSort);

//        Find the department with the highest average rank.
        Map.Entry<String, Double> departHighAvgRank = Student.list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getRank))).entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(departHighAvgRank);

//        Find the list of students who are from Mumbai and have a rank greater than 50.
        List<Student> stuHighRank = Student.list.stream().filter(dt->dt.getCity().equals("Mumbai") && dt.getRank() > 50).collect(Collectors.toList());
        System.out.println(stuHighRank);

//        Find the total count of male and female students.
        Map<String, Long> maleFemaleCount = Student.list.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
        System.out.println(maleFemaleCount);

//        Find the list of students whose age is greater than 25 and sort them by their first name.
        List<Student> sortStudentAge = Student.list.stream().filter(dt -> dt.getAge() > 25).sorted(Comparator.comparing(Student::getLastName)).collect(Collectors.toList());
        System.out.println(sortStudentAge);

//        Find the department with the lowest average age.
        Map.Entry<String, Double> lowAvgDepartment = Student.list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getRank))).entrySet().stream().min(Map.Entry.comparingByValue()).get();
        System.out.println(lowAvgDepartment);

//        Find the list of students who are from Karnataka and have a rank less than 100.
        List<Student> stuKarnataka = Student.list.stream().filter(dt -> dt.getCity().equals("Karnataka") && dt.getRank() < 100).collect(Collectors.toList());
        System.out.println(stuKarnataka);

//        Find the total sum of ages of all male students.
        int sumMaleStud = Student.list.stream().filter(dt -> dt.getGender().equals("Male")).mapToInt(Student::getAge).sum();
        System.out.println(sumMaleStud);

//        Find the list of students whose first name starts with the letter "R" and sort them by their last name.
        List<Student> firstnameRsortbyLast = Student.list.stream().filter(dt -> dt.getFirstName().startsWith("R")).sorted(Comparator.comparing(Student::getLastName)).collect(Collectors.toList());
        System.out.println(firstnameRsortbyLast);

//        Find the student who has the highest rank in the Mechanical Engineering department.
        Student highestRankME = Student.list.stream().filter(dt -> dt.getDepartmantName().equals("Mechanical Engineering")).max(Comparator.comparing(Student::getRank)).get();
        System.out.println(highestRankME);


    }


}