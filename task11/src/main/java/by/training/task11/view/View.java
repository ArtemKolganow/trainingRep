package by.training.task11.view;

import java.util.Scanner;

public class View implements Show {
    @Override
    public void showMenu(){
        System.out.println("Выберите действие:");
        System.out.println("read path  --  считать текст");
        System.out.println("show  --  показать текст");
        System.out.println("sort_paragraph  --  сотрировать абзацы по количеству предложений.");
        System.out.println("sort_sentence numberOfParagraph numberOfSentence  --  сортировать слова по длине.");
        System.out.println("sort_lexeme character  --  сортировать лексемы в тексте по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.");
        System.out.println("exit  --  Выход");
    }

    @Override
    public void showMessage(String msg){
        System.out.println(msg);
    }
    @Override
    public int readInt(String message) throws InputException {
        System.out.println(message);
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
        System.out.println(massage);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
