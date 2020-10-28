import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//多线程
public class SocketServer03 {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(40);
        final ServerSocket serverSocket = new ServerSocket(8803);
        while(true){
            try {
                final Socket socket = serverSocket.accept();
                executorService.execute(()->service(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    private static void service(Socket socket) {
        try{
            Thread.sleep(20);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            printWriter.println();
            printWriter.write("hello,nio");
            printWriter.close();
            socket.close();
        }catch(InterruptedException|IOException e){
            e.printStackTrace();
        }

    }
}
