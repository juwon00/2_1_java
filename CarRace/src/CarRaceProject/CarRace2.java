package CarRaceProject;

import java.util.Scanner;

public class CarRace2 {

    Car one, two, three, four, five, six, seven, eight, nine, ten; // 배열로 10개의 차량 만들기
    Car[] number = new Car[] {one, two, three, four, five, six, seven, eight, nine, ten };

    Scanner scanner = new Scanner(System.in); // 차의 이름을 스캔하여 출력하기
    String s = scanner.nextLine();

    CarRace2() {
        for(int i = 0; i < number.length; i++) { // 반복문인 for문을 써서 10개의 차를 쉽게 만들기
            number[i] = new Car(s, 2000, 4, 0, i*10);
        }
    }

    void rollcall() {
        for(int i = 0; i < number.length; i++) {
            number[i].info();
        }
    }

    void start() {
        for(int i = 0; i < number.length; i++) {
            number[i].start();
        }
    }

    void run() {
        Car winner = null;
        int t = 0;
        do {
            System.out.println(++t); //
            for(int i = 0; i < number.length; i++) {
                if(number[i].move() == true) winner = number[i];
            }
            try { Thread.sleep(400); }
            catch(Exception e) {}
        }while(winner == null); // 승자를 만드는 방식

        System.out.println("축! 오늘의 승자");
        winner.info();
    }

    public static void main(String a[]){ // 메인 함수
        CarRace2 cr = new CarRace2();
        cr.rollcall();
        cr.start();
        cr.run();
    }

}
