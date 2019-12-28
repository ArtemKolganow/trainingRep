package by.trainng.task08.controller;

import by.trainng.task08.entity.House;
import by.trainng.task08.service.HouseService;
import by.trainng.task08.view.InputException;
import by.trainng.task08.view.View;

import java.io.FileNotFoundException;
import java.util.List;

public class ReadController {
    public void readAllHouses(View view, HouseService service) throws FileNotFoundException {
        List<House> res = service.readFromFile();
        for(House i: res){
            view.showHouse(i);
        }
    }
    public void readHousesByRooms(View view,HouseService service) throws FileNotFoundException, InputException {
        int numberOfRooms = view.readInt("Введите количество комнат: ");
        List<House> res = service.parseByRooms(numberOfRooms);
        for(House i: res) {
            view.showHouse(i);
        }
    }
    public void readHousesByRoomsAndFloor(View view, HouseService service) throws FileNotFoundException, InputException {
        int numberOfRooms = view.readInt("Введите количество комнат: ");
        int lowerFloor = view.readInt("Введите нижнюю границу диапазона этажей: ");
        int higherFloor = view.readInt("Введите верхнюю границу диапазона этажей: ");
        List<House> res = service.parseByRoomsAndFloor(numberOfRooms,lowerFloor,higherFloor);
        for(House i: res) {
            view.showHouse(i);
        }
    }
    public void readHousesByArea(View view, HouseService service) throws InputException, FileNotFoundException {
        int area = view.readInt("Введите площадь: ");
        List<House> res = service.parseByArea(area);
        for(House i: res) {
            view.showHouse(i);
        }
    }

    public void readHousesByAreaAndType(View view, HouseService service) throws InputException, FileNotFoundException {
        int area = view.readInt("Введите площадь: ");
        String type = view.readString("Введите тип здания: ");
        List<House> res = service.parseByAreaAndType(area,type);
        for(House i: res) {
            view.showHouse(i);
        }
    }
}
