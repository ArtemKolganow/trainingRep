package by.training.task10treasures.service;

import by.training.task10treasures.dal.Reader;
import by.training.task10treasures.entity.Treasure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TreasureService {
    private static String path = "treasures.txt";
    private static final String REG = "_";

    public List<Treasure> readAllTreasures() throws IOException {
        Reader reader = new Reader(path);
        Pattern pattern = Pattern.compile(REG);
        List<Treasure> treasures = new ArrayList<>();
        List<String> data = reader.readData();
        for(String i : data){
            String[] temp = pattern.split(i);
            Treasure product = new Treasure(temp[0],Integer.parseInt(temp[1]),Integer.parseInt(temp[2]));
            treasures.add(product);
        }
        return treasures;
    }

    public Treasure findHighestPrice() throws IOException {
        List<Treasure> treasures = readAllTreasures();
        Treasure highestPrice = treasures.get(0);
        for(Treasure i: treasures){
            if(i.getPrice()>highestPrice.getPrice()){
                highestPrice = i;
            }
        }
        return highestPrice;
    }

    public Treasure findTreasure(String name) throws IOException {
        List<Treasure> treasures = readAllTreasures();
        for(Treasure i: treasures){
            if(name.equals(i.getName())){
                return i;
            }
        }
        return null;
    }

    public static void generateNewTreasures(String path) throws IOException {
        TreasureService.path = path;
        Reader reader = new Reader(path);
        if(reader.createNewFile()){
            TreasureGenerator generator = new TreasureGenerator();
            generator.generate(reader);
        }
    }

    public static void changePath(String path){
        TreasureService.path = path;
    }
}
