package by.training.task10file.service;

import by.training.task10file.data.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileService {
    public boolean createFile(File file) throws IOException {
        return file.getFile().createNewFile();
    }

    public boolean renameFile(File file, String newName){
            java.io.File oldFile = file.getFile();
            java.io.File newFile = new java.io.File(oldFile.getParent(), newName);
            boolean res = oldFile.renameTo(newFile);
            if (res){
                file.setName(newName);
                file.setFile(newFile);
            }
            return res;
    }

    public List<String> readFile(File file) throws IOException {
        FileReader reader = new FileReader(file.getFile());
        Scanner scanner = new Scanner(reader);
        List<String> res = new ArrayList<>();
        while (scanner.hasNextLine()){
            res.add(scanner.nextLine());
        }
        scanner.close();
        reader.close();
        return res;
    }

    public void addLineToFile(File file,String line) throws IOException {
        try (FileWriter writer = new FileWriter(file.getFile(), true)) {
            writer.write(line);
        }
    }

    public boolean deleteFile(File file){
        return file.getFile().delete();
    }
}
