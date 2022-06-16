package PCIS_project;

public class InheritanceDemo {

    int npp = 0;
    Person[] ppv; // 부경대 구성원
    Student[] stv;
    Faculty[] profv;
    Staff jigwon;
    Course[] crsv;

    public static void main(String[] args) {
        InheritanceDemo pcis = new InheritanceDemo();
        pcis.recruit_employees(); // 직원 뽑기
        pcis.report(); // 보고서 출력
        pcis.run_school(); // 학생 뽑기
    }

    InheritanceDemo() {
        ppv = new Person[100];
        npp = 0;
    }

    void recruit_employees() { // 직원 채용
        profv = new Faculty[4]; // 3명의 교수님과 한명의 직원을 뽑는다
        profv[0] = new Faculty("신교수", 49, "부산시 남구", 5000000, "정보융합대학");
        profv[1] = new Faculty("이교수", 54, "부산시 해운대구", 6000000, "정보융합대학");
        profv[2] = new Faculty("최교수", 45, "부산시 북구", 4000000, "정보융합대학");
        jigwon = new Staff("박과장", 42, 35000000, "단과대학 사무실");
        jigwon.setDepartment("서무과");
        profv[0].setCourse("프로그래밍자바, 인공지능입문, 이산수학");
        profv[1].setCourse("데이터통신, 인공지능수학");
        profv[2].setCourse("기초전기전자회로");
        ppv[npp++] = profv[0];
        ppv[npp++] = profv[1];
        ppv[npp++] = profv[2];
        ppv[npp++] = jigwon;
    }

    void report() {    // 구성원 소개, 수강편람, 과목출석부, 개인 시간표
        recruit_학생();
        print_people();
        print_수강편람();
        register_수강과목();
        for (int i = 0; i < crsv.length; i++) {
            print_출석부(crsv[i]);
        }
        for (int i = 0; i < stv.length; i++) {
            print_학생시간표(stv[i]);
        }
    }

    void run_school() {
        recruit_학생(); // 학생 뽑기
        open_강좌();
        register_수강과목();

    }

    void recruit_학생() {
        String namev[] = {"주원", "재연", "민준", "서윤", "예준", "시우", "민서", "도윤", "지민", "서현"};
        int agev[] = {21, 24, 22, 19, 21, 21, 21, 21, 23, 21};

        stv = new Student[namev.length]; // 학생부

        for (int i = 0; i < namev.length; i++) { // 학생 뽑기
            stv[i] = new Student(namev[i], agev[i], 2, 201612345 + i, "인공지능 소프트웨어");
            ppv[npp++] = stv[i]; // npp는 이미 3 교수와 직원이 있기 때문
        }
    }

    void open_강좌() {
        crsv = new Course[6]; // 여섯 과목 개설
        crsv[0] = new Course("프로그래밍자바  ", profv[0], "Thu 2-4, Fri 2-3", "1325");
        crsv[1] = new Course("인공지능입문   ", profv[0], "Tue 6-7, Wed 6-7", "1325");
        crsv[2] = new Course("데이터통신     ", profv[1], "Mon 5-7", "Online");
        crsv[3] = new Course("이산수학      ", profv[0], "Wed 2-4", "Online");
        crsv[4] = new Course("기초전기전자회로", profv[2], "Fri 7-9", "Online");
        crsv[5] = new Course("인공지능수학   ", profv[1], "Mon 1-3", "Online");
    }

    void register_수강과목() {
        Course oo = crsv[0];
        Course cg = crsv[1];
        Course ab = crsv[2];
        Course cd = crsv[3];
        Course ef = crsv[4];
        Course gh = crsv[5];
        int oo_list[] = {0, 1, 3, 4, 5, 8, 7, 9}; // 8명학생 신청
        int cg_list[] = {0, 3, 5, 6}; // 4명학생 신청
        int ab_list[] = {0, 2, 5, 6, 7}; // 5명학생 신청
        int cd_list[] = {0, 1, 3, 4, 8}; // 5명학생 신청
        int ef_list[] = {0, 2, 4, 6, 7, 8}; // 6명학생 신청
        int gh_list[] = {0, 4, 6, 9}; // 4명학생 신청
        for (int i = 0; i < oo_list.length; i++) { // 신청한 학생 수 만큼 과목에 등록
            stv[oo_list[i]].registerCourse(oo);
        }
        for (int i = 0; i < cg_list.length; i++) {
            stv[cg_list[i]].registerCourse(cg);
        }
        for (int i = 0; i < ab_list.length; i++) {
            stv[ab_list[i]].registerCourse(ab);
        }
        for (int i = 0; i < cd_list.length; i++) {
            stv[cd_list[i]].registerCourse(cd);
        }
        for (int i = 0; i < ef_list.length; i++) {
            stv[ef_list[i]].registerCourse(ef);
        }
        for (int i = 0; i < gh_list.length; i++) {
            stv[gh_list[i]].registerCourse(gh);
        }
        System.out.println("수강신청: " +
                (oo_list.length + cg_list.length + ab_list.length + cd_list.length + ef_list.length + gh_list.length)
                                            + "명 - 성공."); // 수강신청 성공한 사람의 수
    }

    void print_people() {
        for (int i = 0; i < npp; i++) {
            System.out.println("<" + (i + 1) + ">---------------------------");
            ppv[i].info();
        }
    }

    void print_수강편람() {
        open_강좌();
        System.out.println("\n- 수강 편람 -");
        for (int i = 0; i < crsv.length; i++) {
            crsv[i].info();
        }
    }

    void print_출석부(Course cs) {
        System.out.println("--------------------------------------------------------");
        System.out.println("과목: " + cs.getTitle() + "(" + cs.getTP() + ")" + "  담당교수: " + cs.lecturer.getName());
        System.out.print("    "); // 공백 조정
        for (int n = 1; n <= 16; n++) {
            System.out.printf("%3d", n); // 3칸에 숫자를 집어넣어라 오른쪽 맞춤 (%3d)
        }
        System.out.println("");
        cs.listRegistrants(); // 등록 학생출력
    }

    void print_학생시간표(Student st) {
        System.out.println("\n<< 수강과목/시간표 >>");
        System.out.println("이름: " + st.getName());
        for (int i = 0; i < st.nCourses; i++) {
            Course c = st.getCourse(i); // 학생이 신창한 i번째 과목
            System.out.println(c.getTitle() + " (" + c.getTP() + ") by " + c.lecturer.getName());
        }
    }

}



