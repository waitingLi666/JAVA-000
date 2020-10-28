import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//单线程
public class SocketServer01 {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(8801);
        while(true){
            Socket socket = serverSocket.accept();
            service(socket);
        }
    }

    private static void service(Socket socket) throws InterruptedException, IOException {
        Thread.sleep(20);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
        printWriter.println("HTTP/1.1 200 OK");
        printWriter.println("Content-Type:text/html;charset=utf-8");
        printWriter.println();
        printWriter.write("hello,nio");
        printWriter.close();
        socket.close();
    }
}
