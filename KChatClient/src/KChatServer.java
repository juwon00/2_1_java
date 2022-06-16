import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class KChatServer {
    protected Vector vhandler; // 사용자 등록 장부 (Vector)
    int id = 0;

    KChatServer(int port) throws IOException{
        // --서버소켓 생성 (챗방 오픈) --
        ServerSocket server = new ServerSocket(port);
        vhandler = new Vector(2, 5);
        System.out.println("KChatRoom@" + port + "ready...");
        while (true){
            Socket csock = server.accept();
            // + 손님 도착 -> KChatHandler 생성&응대 시작 +
            KChatHandler c = new KChatHandler (this, csock);
            vhandler.addElement(c);
            System.out.println( ++id + "번 손님 받아라 ( 현재" + vhandler.size() + "명");
            c.start();
        }
    }

    public int numChatters(){
        return vhandler.size();
    }

    public static void main (String args[]) throws IOException{
        if(args.length != 1)
            throw new RuntimeException ("Syntax: KChatServer port");
        new KChatServer(Integer.parseInt(args[0]));
    }
}
