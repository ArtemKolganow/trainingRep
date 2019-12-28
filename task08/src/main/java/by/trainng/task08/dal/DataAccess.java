package by.trainng.task08.dal;

import by.trainng.task08.entity.House;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataAccess {
    private static final File FILE = new File("bin","data.txt");


    public void writeHouses(List<House> houses) throws IOException {
        try (FileWriter file = new FileWriter(FILE, true)) {
            file.write("\n");
            for (int i = 0; i < houses.size(); i++) {
                file.write(houses.get(i).getId() + "\n");
                file.write(houses.get(i).getArea() + "\n");
                file.write(houses.get(i).getFloor() + "\n");
                file.write(houses.get(i).getNumberOfRooms() + "\n");
                file.write(houses.get(i).getType() + "\n");
                file.write(houses.get(i).getLifetime() + "\n");
                file.write(houses.get(i).getFlatAddress() + "\n");
                file.write(houses.get(i).getFlatNumber()+"");
                if (i != houses.size() - 1) {
                    file.write("\n");
                }
            }
        }

    }

    public List<House> readHouses() throws FileNotFoundException {
        FileReader file = new FileReader(FILE);
        Scanner scanner = new Scanner(file);
        List<House> res = new ArrayList<>();
        if(scanner.hasNextLine()) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                int id = Integer.parseInt(scanner.nextLine());
                int area = Integer.parseInt(scanner.nextLine());
                int floor = Integer.parseInt(scanner.nextLine());
                int numberOfRooms = Integer.parseInt(scanner.nextLine());
                String houseType = scanner.nextLine();
                int lifetime = Integer.parseInt(scanner.nextLine());
                String flatAddress = scanner.nextLine();
                int flatNumber = Integer.parseInt(scanner.nextLine());
                res.add(new House(id, area, floor, numberOfRooms, houseType, lifetime, flatAddress, flatNumber));
            }
        }
        scanner.close();
        return res;
    }
}
