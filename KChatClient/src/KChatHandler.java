import java.io.*;
import java.net.Socket;
import java.util.Enumeration;




public class KChatHandler  extends Thread{

    protected KChatServer server;
    protected Socket sock;
    protected DataInputStream is;
    protected DataOutputStream os;


    KChatHandler (KChatServer server, Socket sock) throws IOException{
        this.server = server;
        this.sock = sock;
        // create I/O streasm to send & receive messags :
        is = new DataInputStream(new BufferedInputStream(sock.getInputStream()));
        os = new DataOutputStream(new BufferedOutputStream(sock.getOutputStream()));
    }

    public void run(){
        String name = "";
        try{
            // (1) receive login name:
            name = is.readUTF();
            if(name.equals(""))
                name = "나몰라";

            // (2) 방송한다 - "누구 입장":
            broadcast(name + "님 입장!");

            // (3) 반복한다: 이후 담당 고객의 모든 언행을 전달 방송한다:
            while (true){ broadcast(name + ": " + is.readUTF()); }
        }catch (IOException e){
            System.out.println(" ...???... ");
        }finally {
            // -사용자 연결이 끊긴 모양 - 뒷정리를 한다 -
            System.out.println(name + "퇴장.");
            server.vhandler.removeElement(this);
        }
    }

    protected void broadcast(String message){
        synchronized (server.vhandler){ // Vector 등록자
            Enumeration en = server.vhandler.elements(); // '순회' 지원 객체
            while (en.hasMoreElements()){
                KChatHandler c = (KChatHandler) en.nextElement();
                // 각 고객담당 KChatHandler 가 열어 놓은 소켓으로 msg 전달.
                try {
                    c.os.writeUTF(message);
                    c.os.flush();
                }catch (IOException e){}
            }
        }
    }
}
