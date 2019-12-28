package by.trainng.task08.controller;

import by.trainng.task08.entity.House;
import by.trainng.task08.service.HouseService;
import by.trainng.task08.view.InputException;
import by.trainng.task08.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteController {
    public void addNewHouses( View view, HouseService service) throws InputException, IOException {
        List<House> houses = new ArrayList<>();
        int number = view.readInt("Введите количество добавляемых домов: ");
        for(int i = 0; i<number;i++){
            houses.add(view.readHouse());
        }
        service.writeToFile(houses);
    }
}
