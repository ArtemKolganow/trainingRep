package by.training.task2.ex3;

public class FireDetector {
    private int temperature;
    public FireDetector() {
    }
    public String newTemperature(int temperature)
    {
        this.temperature = temperature;
        if(temperature>60)
            return "Пожароопасная ситуация";
        else return "Ситуация в норме";
    }

}
