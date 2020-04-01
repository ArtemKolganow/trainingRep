package by.training.finalproject.entity;

public enum State {
    UNCHECKED("unchecked"),
    CHECKED("checked"),
    COMPLETED("completed"),
    REFUSED("refused");
    private String value;
    State(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
