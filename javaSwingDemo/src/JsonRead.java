import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

class JsonRead {
    private String path;
    private StringBuilder content;
    JsonRead(String path){
        this.path=path;
    }
    String readContent(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
            content = new StringBuilder();
            String s;
            while ((s = br.readLine()) != null) {
                content.append(s);
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return content.toString();
    }
}
