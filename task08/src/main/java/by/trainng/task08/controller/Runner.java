package by.trainng.task08.controller;

import by.trainng.task08.service.HouseService;
import by.trainng.task08.view.InputException;
import by.trainng.task08.view.View;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        View view = new View();
        HouseService service = new HouseService();
        boolean exit = false;
        while (!exit){
            view.menu();
            try {
                switch (view.readInt("Сделайте выбор: ")) {
                    case 1:{
                        WriteController add = new WriteController();
                        try {
                            add.addNewHouses(view,service);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case 2:{
                        ReadController read = new ReadController();
                        try{
                            read.readAllHouses(view,service);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case 3:{
                        ReadController read = new ReadController();
                        try{
                            read.readHousesByRooms(view,service);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case 4:{
                        ReadController read = new ReadController();
                        try{
                            read.readHousesByRoomsAndFloor(view,service);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case 5:{
                        ReadController read = new ReadController();
                        try{
                            read.readHousesByArea(view,service);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case 6:{
                        ReadController read = new ReadController();
                        try{
                            read.readHousesByAreaAndType(view,service);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case 0:{
                        exit = true;
                        break;
                    }
                    default:{}
                }
            }catch (InputException e) {
                e.printStackTrace();
            }
        }
    }
}
