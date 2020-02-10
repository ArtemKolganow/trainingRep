package by.training.task11.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;



public class View implements Show {
    private static final Logger logger = LogManager.getLogger(View.class);
    @Override
    public void showMenu(){
        logger.trace("Выберите действие:");
        logger.trace("read path  --  считать текст");
        logger.trace("show  --  показать текст");
        logger.trace("sort_paragraph  --  сотрировать абзацы по количеству предложений.");
        logger.trace("sort_sentence numberOfParagraph numberOfSentence  --  сортировать слова по длине.");
        logger.trace("exit  --  Выход");
    }

    @Override
    public void showMessage(String msg){
        logger.trace(msg);
    }
    @Override
    public int readInt(String message) throws InputException {
        logger.trace(message);
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            throw new InputException("Ошибка при вводе.");
        }
    }
    @Override
    public int readInt() throws InputException {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            throw new InputException("Ошибка при вводе.");
        }
    }
    @Override
    public String readString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    @Override
    public String readString(String massage){
        logger.trace(massage);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
