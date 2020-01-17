package by.training.task10payment.dal;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    private File file;

    public Reader(String path) {
        this.file = new File(path);
    }

    public List<String> readData() throws IOException {
        FileReader reader = new FileReader(file);
        Scanner scanner = new Scanner(reader);
        List<String> res = new ArrayList<>();
        while(scanner.hasNextLine()){
            res.add(scanner.nextLine());
        }
        scanner.close();
        reader.close();
        return res;
    }

    public void writeData(String data) throws IOException {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(data + "\n");
        }

    }
}
