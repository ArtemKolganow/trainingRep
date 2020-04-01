package by.training.finalproject.entity;

public enum Status {
    DELIVERED("delivered"),
    ASSEMBLED("assembled"),
    CONFIRMED("confirmed"),
    COMPILATION("compilation");
    private String value;
    Status(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
