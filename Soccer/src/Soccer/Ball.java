package Soccer;


import java.awt.*;

public class Ball {

    private int x, y, diameter;
    private double vx, vy;
    JField f;

    Ball(JField f) {
        x = 0; vx = 0; y = 0;
        this.f = f;
    }

    void draw(Graphics g){
        int radius = 5;
        g.setColor(Color.BLACK);
        g.fillOval(f.getCx() + x - radius, f.getCy() + y - radius, radius*2, radius*2);
    }

    boolean move() { // 공이 움직이는 함수
        x = x + (int)vx; y = y + (int)vy;
        System.out.println("공(" + x + ", " + y + ").");
        vx = vx * 0.8; vy = vy * 0.8; // 마찰로 감속*비율
        checkBounds();
        return (x > f.getRight()-1 || x < f.getLeft()+1); //골인?
    }

    void fly(double kx, double ky) {
        vx = vx+kx; vy += ky;
    }

    int getX() { return x; }
    int getY() { return y; }

    void checkBounds() {  // 볼이 라인 밖으로 나가지 않게 하는 함수
        if (x < f.getLeft()) {
            vx = -vx;
            x = 2*f.getLeft() - x;
        }
        if (x > f.getRight()) {
            vx = -vx;
            x = 2*f.getRight() - x;
        }
        if (y < f.getTop()) {
            vy = -vy;
            y = 2*f.getTop() - y;
        }
        if (y > f.getBottom()) {
            vy = -vy;
            y = 2*f.getBottom() - y;
        }
    }
}
