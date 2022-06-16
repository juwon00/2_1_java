package PCIS_project;


class Student extends Person {

    private int grade;
    private int studentNo;
    private String major;


    Student(){
        super();
        grade = 0;
        studentNo = 0;
        major = "Not yet";
    }
    Student(String name, int age, int grade, int studentNo, String major){
        super(name, age);
        this.grade = grade;
        this.studentNo = studentNo;
        this.major = major;
    }
    Student(String name, int age, String address, int grade, int studentNo, String major){
        super(name, age, address);
        this.grade = grade;
        this.studentNo = studentNo;
        this.major = major;
    }

    Course myCoursev[] = new Course[6]; //배열 참조변수 6개
    int nCourses = 0; // 아직 신청과목은 0개


    public void setGrade(int grade){
        this.grade = grade;
    }
    public int getGrade(){
        return grade;
    }
    public void setStudentNo(int studentNo){
        this.studentNo = studentNo;
    }
    public int getStudentNo(){
        return studentNo;
    }
    public void setMajor(String major){
        this.major = major;
    }
    public String getMajor(){
        return major;
    }

    void registerCourse(Course c) { //수강신청, 객체 Course에 학생을 추가
        if (check() == true) return; // 6개이상 수강신청은 무시
        myCoursev[nCourses++] = c;
        c.register(this);
    }

    boolean check() {
        if (nCourses >= 6) System.out.println("no more courses");
        return nCourses >= 6;
    }

    Course getCourse(int i) { return myCoursev[i]; }


    public void info(){
        super.info();
        System.out.println("학년 : " + grade);
        System.out.println("학번 : " + studentNo);
        System.out.println("전공 : " + major);
    }

}
