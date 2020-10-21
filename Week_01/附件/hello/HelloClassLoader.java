import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            Class<?> helloClass=new HelloClassLoader().findClass("Hello");
            Method method = helloClass.getMethod("hello");
            method.invoke(helloClass.newInstance());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    protected Class<?> findClass(String name) throws ClassNotFoundException{
        String path = HelloClassLoader.class.getResource("Hello.xlass").getPath();
        File file = new File(path);
        byte[] bytes = new byte[(int)file.length()];
        int n=0;
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            while(n!=-1){
                n=fileInputStream.read(bytes);
            };
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        for(int i=0;i<bytes.length;i++){
            bytes[i]=(byte)((byte)255-bytes[i]);
        }
        return defineClass(name,bytes,0,bytes.length);
    }
}
