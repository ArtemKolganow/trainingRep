package by.training.task11.dal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader implements DataReader {
    @Override
    public String readData(String path) throws DataException {
        StringBuilder res = new StringBuilder();
        File file = new File(path);
        try(FileReader reader = new FileReader(file)) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                res.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
        } catch (IOException e) {
            throw new DataException(e);
        }
        return res.toString();
    }
    @Override
    public void writeData(String path, String data) throws DataException {
        File file = new File(path);
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(data + "\n");
        } catch (IOException e) {
            throw new DataException(e);
        }
    }
    @Override
    public boolean createNewFile(String path) throws DataException {
        try {
            File file = new File(path);
            return file.createNewFile();
        } catch (IOException e) {
            throw new DataException(e);
        }
    }
}
