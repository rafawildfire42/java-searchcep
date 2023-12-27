import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Searcher searcher = new Searcher();
        FileManager fileManager = new FileManager();
        ArrayList<String> addresses = new ArrayList<>();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o CEP (0 para sair): ");

            String cep = scanner.nextLine();

            if (cep.equals("0")) {
                break;
            }
            String cepInfo = searcher.lookForCep(cep);
            addresses.add(cepInfo);
        }

        fileManager.saveData(addresses.toString());
        System.out.println(addresses);

    }
}