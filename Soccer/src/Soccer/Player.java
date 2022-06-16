package Soccer;

import java.awt.*;

public class Player {

    JField f;
    int x, y;
    double dx, dy, speed;
    String name, team;

    Player(String 이름, String tm, JField f, int x0, int y0) {
        name = 이름; x = x0; y = y0;
        team = tm; this.f = f;
    } // 선수들 생성자

    void draw(Graphics g){
        g.drawRect(f.getCx() + x - 5, f.getCy() + y - 20, 10, 20);
    }

    int movep(Ball b) { // 선수들이 공을 향해 움직이는 함수
        x = x + (int)dx; y = y + (int)dy; //dx = ? dy = ? 공을 향해 dash
        dash(b);
        int dist = (int) distance(b);
        System.out.print (name + "" + dist + "    ");
        return dist;
    }

    int moveq(Ball b) { // 선수들이 공을 향해 움직이는 함수
        x = x + (int)dx; y = y + (int)dy; //dx = ? dy = ? 공을 향해 dash
        //dash(b);
        int dist = (int) distance(b);
        System.out.print (name + "" + dist + "    ");
        return dist;
    }

    double distance(Ball b) {
        double x2x = x - b.getX();
        double y2y = y - b.getY();
        return Math.sqrt(x2x*x2x + y2y*y2y);
    }

    void kick(Ball b) {  // 공을 발로차게하는 함수
        double kx = dx*2 + randM(10) - 5;
        double ky = dy*2 + randM(8) - 5;
        b.fly(kx, ky);
        speed = speed / 1.5;
    }

    double randM(int M) {
        return Math.random() * M;
    }

    void dash (Ball b) {
        double dist = distance(b) + 1;
        speed = speed*0.9 + randM(3); // 질주 속도 조절
        dx = (b.getX() - x)/dist * speed;
        dy = (b.getY() - y)/dist * speed;
    }

    public int getX() { return x; }
    public int getY() { return x; }

    void runtoward(int dx, int dy){ x += dx; y += dy;}

}
