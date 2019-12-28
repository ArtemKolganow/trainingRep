package by.trainng.task08.entity;


import java.util.Objects;


public class House {

    private int id;
    private int area;
    private int floor;
    private int numberOfRooms;
    private String type;
    private int lifetime;
    Address address;
    static class Address{
        private String flatAddress;
        private int flatNumber;

        public Address() {
        }

        public Address(String flatAddress, int flatNumber) {
            this.flatAddress = flatAddress;
            this.flatNumber = flatNumber;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Address address = (Address) o;
            return flatNumber == address.flatNumber &&
                    Objects.equals(flatAddress, address.flatAddress);
        }

        @Override
        public int hashCode() {
            return Objects.hash(flatAddress, flatNumber);
        }

        @Override
        public String toString() {
            return "Address{" +
                    "flatAddress='" + flatAddress + '\'' +
                    ", flatNumber=" + flatNumber +
                    '}';
        }


    }

    public House() {
    }

    public House(int id, int area, int floor, int numberOfRooms, String type, int lifetime, String flatAddress, int flatNumber) {
        this.id = id;
        this.area = area;
        this.floor = floor;
        this.numberOfRooms = numberOfRooms;
        this.type = type;
        this.lifetime = lifetime;
        this.address = new Address(flatAddress,flatNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return id == house.id &&
                area == house.area &&
                floor == house.floor &&
                numberOfRooms == house.numberOfRooms &&
                lifetime == house.lifetime &&
                type == house.type &&
                Objects.equals(address, house.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, area, floor, numberOfRooms, type, lifetime, address);
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", area=" + area +
                ", floor=" + floor +
                ", numberOfRooms=" + numberOfRooms +
                ", type=" + type +
                ", lifetime=" + lifetime +
                address.toString() +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLifetime() {
        return lifetime;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }
    public String getFlatAddress() {
        return address.flatAddress;
    }

    public void setFlatAddress(String flatAddress) {
        address.flatAddress = flatAddress;
    }

    public int getFlatNumber() {
        return address.flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        address.flatNumber = flatNumber;
    }

}
