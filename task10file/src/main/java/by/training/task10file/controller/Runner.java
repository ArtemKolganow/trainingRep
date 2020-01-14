package by.training.task10file.controller;

import by.training.task10file.data.TextFile;
import by.training.task10file.service.TextFileService;
import by.training.task10file.view.InputException;
import by.training.task10file.view.View;

public class Runner {
    public static void main(String[] args) {
        View view = new View();
        TextFileService service = new TextFileService();
        TextFileController controller = new TextFileController();
        boolean exit = false;
        TextFile file = controller.createObj(view);
        while (!exit){
            try {
                view.showMenu();
                switch (view.readInt("Выберите пункт: ")){
                    case 0: //выход
                        exit = true;
                        break;
                    case 1:// изменение директории
                        controller.changeDirectory(view,file);
                        break;
                    case 2: // изменение имени
                        controller.changeName(view,file);
                        break;
                    case 3: // создать файл
                        controller.createObj(view,service,file);
                        break;
                    case 4: // переименовать файл
                        controller.rename(view,service,file);
                        break;
                    case 5: // вывод содержимоого на консоль
                        controller.show(view,service,file);
                        break;
                    case 6:// дополнить файл
                        controller.addLine(view,service,file);
                        break;
                    case 7: // удалить файл
                        controller.delete(view,service,file);
                        break;
                    default:
                        view.showMassage("Ошибка ввода.");
                }
            } catch (InputException e) {
                view.showMassage(e.getMessage());
            }
        }
    }

}
