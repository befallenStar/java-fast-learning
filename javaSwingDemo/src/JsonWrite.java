import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

class JsonWrite {
    private String path;

    JsonWrite(String path) {
        this.path = path;
    }

    void writeContent(String content) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8));
            bw.write(new JsonFormat(content).toFormatString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
