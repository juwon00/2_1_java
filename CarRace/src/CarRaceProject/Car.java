package CarRaceProject;

class Car {
    int nDoors = 4, nSeats = 5, cc;
    double x, y, vx, vy; //위치 좌표, 속도
    String model, 제조사;
    boolean ngin = false;

    Car(String 모델명, int 배기량, int 문짝수, float x0, float y0) { // 자동차 기본 정보
        model = 모델명;
        cc = 배기량;
        nDoors = 문짝수;
        x = x0;
        y = y0;
    }

    void info() {
        System.out.println(model+"입니다."); // 자동차 소개
    }

    void start() {
        ngin = true;
        System.out.println("~부릉~"); // 출발 준비
    }

    boolean move() {
        vx = spurt();
        x = x + vx;
        display();
        System.out.println(model + "at" + (int)x); //얼마나 이동했는지 숫자로 나타냄
        return ingoal();
    }

    double spurt() {
        return (Math.random() - 0.3) * 30; // 가속도 함수
    }

    void display() {
        for(int i = 0; i < x; i += 5)
            System.out.print("-"); // 자동차가 지나간 흔적
        System.out.print(":=:-"); //자동차 모형
    }

    boolean ingoal() {
        return x > 200; // 200을 넘기면 종료
    }

}



