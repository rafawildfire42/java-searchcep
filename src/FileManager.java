import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    public void saveData(String addressData) throws IOException {
        FileWriter escrita = new FileWriter("endereco" + ".json");
        escrita.write(addressData);
        escrita.close();
    }
}
