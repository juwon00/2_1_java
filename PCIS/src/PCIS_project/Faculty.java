package PCIS_project;

class Faculty extends Employee{

    private String course;


    Faculty(){
        super();
        course = "Not yet";
    }
    Faculty(String name, int age, int salary, String position){
        super(name, age, salary, position);
        course = "Not yet";
    }
    Faculty(String name, int age, String address, int salary, String position){
        super(name, age, address, salary, position);
        course = "Not yet";
    }
    Faculty(String name, int age, int salary, String position, Employee supervisor){
        super(name, age, salary, position, supervisor);
        course = "Not yet";
    }
    Faculty(String name, int age, String address, int salary, String position,
            Employee supervisor){
        super(name, age, address, salary, position, supervisor);
        course = "Not yet";
    }

    Course coursev[] = new Course[6]; // 최대 6개의 과목 개설
    int nCourses = 0;


    public void setCourse(String course){
        this.course = course;
    }
    public String getCourse(){
        return course;
    }

    void openCourse(Course c) {
        if (check() == true) return; // 6개 이상의 강의개설은 무시
        coursev[nCourses++] = c;
    }

    boolean check() {
        if (nCourses >= 6) System.out.println("no more courses");
        return nCourses >= 6;
    }

    public void info(){
        super.info();
        System.out.println("강의 : " + course);
    }

}
