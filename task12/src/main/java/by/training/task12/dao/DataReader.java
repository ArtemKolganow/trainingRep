package by.training.task12.dao;

public interface DataReader {
    String[] readData(String path) throws DataException;
    void writeData(String path, String data) throws DataException;
    boolean createNewFile(String path) throws DataException;
}
