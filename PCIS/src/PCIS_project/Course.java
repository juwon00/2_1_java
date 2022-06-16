package PCIS_project;

import java.util.*; // Vector 사용

public class Course {

    String title, time, room; // 강의 이름, 강의 시간, 강의실
    Faculty lecturer; // 담당교수
    Student regist[]; // 사용하지 않음
    Vector vregist; // 자료구조, 배열보다 신축성있는 리스트 사용, Vector<Student> regist;

    Course(){
        regist = new Student[10]; // 사용하지 않음
        vregist = new Vector(); // Vector<Student>
    }

    Course(String nam, Faculty prof, String tim, String rum){
        this(); // 나의 다른 생성자를 부름
        title = nam;
        time = tim;
        room = rum;
        lecturer = prof;
        prof.openCourse(this); //강의 개설
    }

    String getTitle() { return title; } // 과목 이름
    Faculty getLecturer() { return lecturer; } // Faculty는 객체, 담당 교수님
    String getTP() { return time + " #" + room; } // 강의 시간, 강의실 번호

    int numRegist() { return vregist.size(); } // 수강생 수 (v표시는 배열이나 벡터 표시)
    void register(Student st) { vregist.add(st); } // 수강생 본인을 등록
    void dropme(Student st) { vregist.removeElement(st); } // 출석부 명단 출력

    void listRegistrants() {
        for(int i = 0; i < vregist.size(); i++) { // 벡터의 사이즈
            Student st = (Student) vregist.elementAt(i);
            System.out.print(st.getName());
            System.out.print(" ");
            for(int j = 0; j < 16; j++) System.out.print("  ."); // 점을 16개 찍는다
            if ((i+1)%5 == 0) { // 다섯명마다 선을 넣어 보기 쉽게 만듬
                System.out.print("\n    ");
                for(int j = 0; j < 16; j++) System.out.print(" --");
            }
            System.out.println(""); // 다음줄로 내림
        }
    }

    void info() { // 출석부 명단 출력
        System.out.println( title +" 담당교수: "+lecturer.getName() +", 시간: "+time +" 강의실: "+ room);
    }

}
