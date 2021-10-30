package bigcalculator;
import java.io.*;

public class DataFile {


    private final static String FILE_URL = "C:/Users/DELL OS/Desktop/BigCalculator/src/bigcalculator/file/text1.txt";
 
    public static void main(String[] args) throws IOException {
        //đọc dữ liệu từ file
        File file1 = new File(FILE_URL);//lấy ra file dữ liệu, nếu không hợp lệ sẽ xảy ra ngoại lệ IO
        InputStream inputStream = new FileInputStream(file1);//khởi tạo một FileInputStream để chuẩn bị cho việc đọc file
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);//từ file inputStream tạo ra một đối tượng có thể đọc được (đọc từng kí tự)
        BufferedReader reader = new BufferedReader(inputStreamReader);//sử dụng để tăng hiệu suất đọc (nhờ readline())->đọc văn bản từ một input stream dựa trên các ký tự  
 
        String line = "";
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }
        
        //xuất dữ liệu ra file
        String[] data = {
                "Hello Java!",
                "Good bye!"
        };
        File file2 = new File(FILE_URL);
        OutputStream outputStream = new FileOutputStream(file2);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
 
        for (String item: data){
            outputStreamWriter.write(item);
            // Dùng để xuống hàng
            outputStreamWriter.write("\n");
        }
        // Đây là phương thức quan trọng!
        // Nó sẽ bắt chương trình chờ ghi dữ liệu xong thì mới kết thúc chương trình.
        outputStreamWriter.flush();
        
    }
}
