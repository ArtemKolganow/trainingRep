package by.training.task10file.controller;

import by.training.task10file.data.File;
import by.training.task10file.data.TextFile;
import by.training.task10file.service.TextFileService;
import by.training.task10file.view.View;

import java.io.IOException;
import java.util.regex.Pattern;

class TextFileController {
    TextFile createObj(View view){
        String path = view.readString("Введите директорию: ");
        String name;
        while (true) {
            name = view.readString("Введите имя файла: ");
            if(!Pattern.matches(".+\\.txt", name)){
                view.showMassage("Ошибка в имени файла");
            }else {
                break;
            }
        }
        return new TextFile(path,name);
    }

    void changeDirectory(View view, File file){
        view.showBool(file.setDirectory(view.readString("Введите новый путь к директории: ")));
    }

    void changeName(View view, File file){
        view.showBool(file.setOtherFile(view.readString("Введите имя файла: ")));
    }

    void createObj(View view, TextFileService service, File file){
        try {
            view.showBool(service.createFile(file));
        } catch (IOException e) {
            view.showMassage(e.getMessage());
        }
    }
    void rename(View view, TextFileService service, File file){
        view.showBool(service.renameFile(file,view.readString("Введите новое имя файла: ")));
    }

    void show(View view, TextFileService service, File file){
        try {
            view.showList(service.readFile(file));
        } catch (IOException e) {
            view.showMassage(e.getMessage());
        }
    }

    void addLine(View view, TextFileService service, File file){
        try {
            service.addLineToFile(file,view.readString("Введить строку: "));
        } catch (IOException e) {
            view.showMassage(e.getMessage());
        }
    }

    void delete(View view, TextFileService service, File file){
        view.showBool(service.deleteFile(file));
    }
}
