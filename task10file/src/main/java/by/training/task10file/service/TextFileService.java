package by.training.task10file.service;

import by.training.task10file.entity.AppFile;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileService {
    public boolean createFile(AppFile appFile) throws IOException {
        return appFile.getFile().createNewFile();
    }

    public boolean renameFile(AppFile appFile, String newName){
            java.io.File oldFile = appFile.getFile();
            java.io.File newFile = new java.io.File(oldFile.getParent(), newName);
            boolean res = oldFile.renameTo(newFile);
            if (res){
                appFile.setName(newName);
                appFile.setFile(newFile);
            }
            return res;
    }

    public List<String> readFile(AppFile appFile) throws IOException {
        FileReader reader = new FileReader(appFile.getFile());
        Scanner scanner = new Scanner(reader);
        List<String> res = new ArrayList<>();
        while (scanner.hasNextLine()){
            res.add(scanner.nextLine());
        }
        scanner.close();
        reader.close();
        return res;
    }

    public void addLineToFile(AppFile appFile, String line) throws IOException {
        try (FileWriter writer = new FileWriter(appFile.getFile(), true)) {
            writer.write(line);
        }
    }

    public boolean deleteFile(AppFile appFile){
        return appFile.getFile().delete();
    }
}
