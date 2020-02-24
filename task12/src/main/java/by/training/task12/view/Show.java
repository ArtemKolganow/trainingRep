package by.training.task12.view;

public interface Show {
    void showMenu();
    void showMessage(String msg);
    int readInt(String message) throws InputException ;
    int readInt() throws InputException ;
    String readString();
    String readString(String massage);

}
