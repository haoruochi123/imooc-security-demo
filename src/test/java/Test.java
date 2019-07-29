import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {

        File file = new File("E:/test/test.txt");
        InputStream inputStream = new FileInputStream(file);
        File file1 = new File("E:/test/test1.txt");
        OutputStream outputStream = new FileOutputStream(file1);
//        byte[] bytes = new byte[1024];
//        int l ;
//        while ((l =inputStream.read(bytes))>0){
//            outputStream.write(bytes,0,l);
//        }
//
//        inputStream.close();
//        outputStream.close();

        List<String> strings = FileUtils.readLines(file, "UTF-8");
        for (String a : strings) {
            System.out.println(a);
        }

    }
}
