package by.training.task11.controller;


import by.training.task11.entity.Text;
import by.training.task11.view.Show;
import by.training.task11.view.View;

public class Runner {
    public static void main(String[] args) {
        Show show = new View();
        Controller controller = new Controller();
        boolean isExit = false;
        Text text = new Text();
        while (!isExit){
            show.showMenu();
            String request = show.readString();
            String response = controller.execute(request,text);
            show.showMessage(response);
            if(response.equals("Exit.")){
                isExit = true;
            }
        }

    }

}
