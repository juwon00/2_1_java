package Soccer;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Soccer {

    JField field;
    Ball ball;
    Player p, q, r;
    boolean timeout, goal;
    int clock;

    public static void main(String[] a) { // 메인 함수
        Soccer sc =new Soccer();
        sc.start();
    }

    Soccer() { //Soccer 생성자
        field = new JField(640/2, 480/2, this);
        ball = new Ball(field);
        p = new Player("손흥민 ", "P", field, -50, 10);
        q = new Player("이강인 ", "Q", field, 50,-10);
        JPanel pan = new JPanel(null);
        pan.setBackground(Color.white);
        pan.add(field);
        field.setLocation(20, 10);
        JFrame f = new JFrame("핵심J: Soccer Graphical");
        f.getContentPane().add(pan);
        f.setSize(320+56, 240+60);
        f.setVisible(true);
        f.setResizable(false); // 윈도우 크기 조절을 못하게
        start();
    }

    void start() { // 시작하는 함수
        System.out.println("* START *");
        timeout = false;
        run();
    }

    void stop() { // 멈추는 함수
        timeout = true;
    }

    void run() {

        int clock = 0;
        while( !timeout ) {
            clock++;
            System.out.print ("[" + clock + "]"); // 시간을 측정하는 문장
            int dist = p.movep(ball); // 선수들 공 쪽 달려간다
            int distq = q.moveq(ball);
            r = p;
            if (distq < dist) {
                r = q;
                dist = distq;
            } //가까운 선수
            if (dist < 5) {
                r.kick(ball); // 5ft 이내면 공을 찬다
                System.out.print(" ->"+ r.name+"kicks-> ");
            }
            goal = ball.move(); // 골이 들어갔을 때
            if (goal) {
                System.out.println("*골인*");
            }
            //show();
            field.repaint();
            try {
                Thread.sleep(200);
            }
            catch(Exception e) {}
            if (clock >90) stop();
        }
        System.out.println(" * TIME OUT *");
    }

    void show() { // 경기장세로축과 선수들을 출력하는 함수
        int dH = 10, dW = 3;
        int bx = ball.getX() / dW, by = ball.getY() / dH;
        int px = p.getX() / dW, py = p.getY() / dH;
        int qx = q.getX() / dW, qy = q.getY() / dH;

        hline(field.getRight()/dW - field.getLeft()/dW + 1);
        for(int r = field.getTop()/dH; r <= field.getBottom()/dH; r ++) {
            tpr("|");
            for(int i = field.getLeft()/dW; i<= field.getRight()/dW; i ++) {
                if (r == by && i == bx) {
                    tpr("*");
                    if (r == py && i == px) {
                        tpr("p"); i++;
                        if (r == qy && i == qx) {
                            tpr("q");
                            i++;
                        }
                    }
                    else if (r == qy && i == qx) {
                        tpr("q");
                        i++;
                    }
                }
                else if (r == py && i == px) {
                    tpr("p");
                    if (r == qy && i == qx) {
                        tpr("q");
                        i++;
                    }
                }
                else if (r == qy && i == qx) {
                    tpr("q");
                }
                else {
                    tpr(" ");
                }
            }
            tprl("|"+r);
        }
        hline(field.getRight()/dW - field.getLeft()/dW + 1);

    }

    void hline(int n) {	//경기장 가로축을 출력하는 함수
        tpr("+");
        for(int i = 1; i<=n; i++)
            tpr("-");
        tprl("+");
    }

    void tpr(String s) {
        System.out.print(s);
    }

    void tprl(String s) {
        System.out.println(s);
    }
}


class JField extends JPanel { // 경기장 함수
    private int x0, x1, y0, y1, w, h;
    Soccer match;

    JField(int wide, int high, Soccer match) {
        w = wide; h = high;
        this.match = match;
        setSize(w, h);
        setBackground(Color.green);
        x1 = w/2; y1 = h/2;
        x0 = -x1; y0 = -y1;
        addKeyListener(new MyKeyListener(match));
        setFocusable(true);
    }

    class MyKeyListener extends KeyAdapter {
        Soccer match;
        int speed = 4;
        MyKeyListener(Soccer m){match = m;}

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                match.q.runtoward(3 * speed, 0);
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                match.q.runtoward(-(3 * speed), 0);
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                match.q.runtoward(0, -(3 * speed));
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                match.q.runtoward(0, 3 * speed);
            }
        }
//        public void KeyPressed(KeyEvent e){
//            switch (e.getKeyCode()){
//                case KeyEvent.VK_RIGHT:
//                    match.q.runtoward(5*speed,0);
//                    break;
//
//                case KeyEvent.VK_LEFT:
//                    match.q.runtoward(5*speed,0);
//                    break;
//
//                case KeyEvent.VK_UP:
//                    match.q.runtoward(0,5*speed);
//                    break;
//
//                case KeyEvent.VK_DOWN:
//                    match.q.runtoward(0,5*speed);
//                    break;
//            }
//        }
    }

    int getCx() { return x1; }
    int getCy() { return y1; }
    int getLeft() { return x0; }
    int getRight() { return x1; }
    int getTop() { return y0; }
    int getBottom() { return y1; }
    public void paint(Graphics g){
        super.paint(g);
        drawClock(g);
        g.setColor(Color.white);
        g.drawRect(0, 0 ,w, h);
        g.drawLine(getCx(),getCy()+y0, getCx(), getCy()+y1); // 시작점과 끝점
        g.drawOval(getCx()-40, getCy()-40, 80,80); // 중심으로 부터

        match.ball.draw(g);
        g.setColor(Color.red);
        match.p.draw(g);
        g.setColor(Color.blue);
        match.q.draw(g);
    }
    String info() { return "동네 축구장";}

    void drawClock(Graphics g){
        int r = 10, x = w - r - 10, y = r + 10;
        double a = Math.PI/180*(-90 + match.clock*(360/90));
        g.drawOval(x-r, y-r, 2*r, 2*r );
        g.drawLine(x, y, (int)(x+r*Math.cos(a)), (int)(y+r*Math.sin(a)));
    }

}




