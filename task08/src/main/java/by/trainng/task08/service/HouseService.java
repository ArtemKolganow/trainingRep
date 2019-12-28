package by.trainng.task08.service;

import by.trainng.task08.dal.DataAccess;
import by.trainng.task08.entity.House;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class HouseService {
    public void writeToFile(List<House> houses) throws IOException {
        DataAccess data = new DataAccess();
        data.writeHouses(houses);
    }

    public List<House> readFromFile() throws FileNotFoundException {
        DataAccess data = new DataAccess();
        return data.readHouses();
    }

    public List<House> parseByRooms(int numberOfRooms) throws FileNotFoundException {
        List<House> houses = readFromFile();
        for(int i =0; i<houses.size();i++){
            if(houses.get(i).getNumberOfRooms()!=numberOfRooms){
                houses.remove(i);
            }
        }
        return houses;
    }

    public List<House> parseByRoomsAndFloor(int numberOfRooms, int low, int high) throws FileNotFoundException {
        List<House> houses = readFromFile();
        for(int i =0; i<houses.size();i++){
            if(houses.get(i).getNumberOfRooms()!=numberOfRooms){
                houses.remove(i);
            }
            if(houses.get(i).getFloor()<low||houses.get(i).getFloor()>high){
                houses.remove(i);
            }
        }
        return houses;
    }

    public List<House> parseByArea(int area) throws FileNotFoundException {
        List<House> houses = readFromFile();
        for(int i =0; i<houses.size();i++){
            if(houses.get(i).getArea()<area){
                houses.remove(i);
            }
        }
        return houses;
    }

    public List<House> parseByAreaAndType(int area,String type) throws FileNotFoundException {
        List<House> houses = readFromFile();
        for(int i =0; i<houses.size();i++){
            if(houses.get(i).getArea()<area){
                houses.remove(i);
            }
            if(!houses.get(i).getType().equals(type)){
                houses.remove(i);
            }
        }
        return houses;
    }
}
