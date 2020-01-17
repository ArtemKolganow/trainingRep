package by.training.task10file.controller;

import by.training.task10file.entity.AppFile;
import by.training.task10file.entity.TextFile;
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
                view.showMessage("Ошибка в имени файла");
            }else {
                break;
            }
        }
        return new TextFile(path,name);
    }

    void changeDirectory(View view, AppFile appFile){
        view.showBool(appFile.setDirectory(view.readString("Введите новый путь к директории: ")));
    }

    void changeName(View view, AppFile appFile){
        view.showBool(appFile.setOtherFile(view.readString("Введите имя файла: ")));
    }

    void createObj(View view, TextFileService service, AppFile appFile){
        try {
            view.showBool(service.createFile(appFile));
        } catch (IOException e) {
            view.showMessage(e.getMessage());
        }
    }
    void rename(View view, TextFileService service, AppFile appFile){
        view.showBool(service.renameFile(appFile,view.readString("Введите новое имя файла: ")));
    }

    void show(View view, TextFileService service, AppFile appFile){
        try {
            view.showList(service.readFile(appFile));
        } catch (IOException e) {
            view.showMessage(e.getMessage());
        }
    }

    void addLine(View view, TextFileService service, AppFile appFile){
        try {
            service.addLineToFile(appFile,view.readString("Введить строку: "));
        } catch (IOException e) {
            view.showMessage(e.getMessage());
        }
    }

    void delete(View view, TextFileService service, AppFile appFile){
        view.showBool(service.deleteFile(appFile));
    }
}
