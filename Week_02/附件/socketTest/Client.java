import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;

public class Client {
    private static CloseableHttpClient httpClient = HttpClients.createDefault();
    public static void main(String[] args) throws IOException {
        //1.请求地址
        String url = "http://localhost:8801/";
        //2.创建get请求
        HttpGet httpGet = new HttpGet(url);
        //3.发送请求
        String result = httpClient.execute(httpGet,new BasicResponseHandler());
        System.out.println(result);
    }
}
