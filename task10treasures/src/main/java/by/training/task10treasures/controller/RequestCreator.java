package by.training.task10treasures.controller;

import by.training.task10treasures.entity.Backpack;
import by.training.task10treasures.entity.Treasure;

import java.util.ArrayList;

public class RequestCreator {
    private static final String DELIMITER = "_";

    public String backpackToRequest(Backpack backpack){
        StringBuilder request = new StringBuilder(backpack.getPriceLimit() + DELIMITER + backpack.getTreasures().size());
        int size = backpack.getTreasures().size();
        if(size>0){
            request.append(DELIMITER);
            ArrayList<Treasure> arrayList = new ArrayList<>(backpack.getTreasures());
            for(int i = 0; i< size-1;i++){
                request.append(arrayList.get(i).getName())
                        .append(DELIMITER).append(arrayList.get(i).getPrice())
                        .append(DELIMITER).append(arrayList.get(i).getWeight()).append(DELIMITER);
            }
            request.append(arrayList.get(size-1).getName())
                    .append(DELIMITER).append(arrayList.get(size-1).getPrice())
                    .append(DELIMITER).append(arrayList.get(size-1).getWeight());
        }
        return request.toString();
    }

    public Backpack requestToBackpack(String request){
        String[] req = request.split(DELIMITER);
        Backpack backpack = new Backpack(Integer.parseInt(req[0]));
        for(int i = 2; i<Integer.parseInt(req[1])*3;i+=3){
            backpack.addTreasure(new Treasure(req[i],Integer.parseInt(req[i+1]),Integer.parseInt(req[i+2])));
        }
        return backpack;
    }
}
