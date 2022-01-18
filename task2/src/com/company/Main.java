package com.company;
import java.util.Scanner;
public class Main {
    static Car[] car = new Car[20];
    public static void main(String[] args) {
        for(int i = 0; i < 20; i++) {
            car[i] = new Car();
        }
        int act;
        Scanner scanner = new Scanner(System.in);
        while (1 == 1) {
            System.out.println("Hello! What you want to do?\n" +
                               "1. Buy seat\n" +
                               "2. Check seat\n" +
                               "3. Remove passenger");
            act = scanner.nextInt(); // Choosing action //
            int n, m;
            switch (act) { // Switch case for different actions //
                case 1:
                    String name = scanner.next();
                    n = scanner.nextInt();
                    m = scanner.nextInt();
                    if(car[n-1].seats[m-1].isOccupy() != true) {
                        car[n-1].seats[m-1].setName(name);
                        car[n-1].seats[m-1].setOccupy(true);
                        car[n-1].addOccupied_seats();
                    }
                    else{
                        System.out.println("Occupied, try again");
                        break;
                    }
                    System.out.println("Cars Passengers");
                    for(int i = 0; i < 10; i++) {
                        if(i == n-1) {
                            continue;
                        }
                        if(car[i].getOccupied_seats() == 20) {
                            System.out.println(car[i].getId() + " " + "full");
                        }
                        System.out.println(car[i].getId() + " " + car[i].getOccupied_seats());
                    }
                    System.out.println(car[n-1].getId() + " +1 (" + m + ")");
                    break;
                case 2:
                    System.out.println("Enter car and seat to search.");
                    n = scanner.nextInt();
                    m = scanner.nextInt();
                    System.out.println(car[n-1].seats[m-1].getName());
                    break;
                case 3:
                    System.out.println("Enter car and seat to delete.");
                    n = scanner.nextInt();
                    m = scanner.nextInt();
                    car[n-1].seats[m-1].setName("Free");
                    car[n-1].seats[m-1].setOccupy(false);
                    car[n-1].remOccupied_seats();
                    break;
                default:
                    break;
            }
        }


    }

}
class Car{ // Class for car with id and seats //
    private static int id_gen = 1;
    private static final int max_seat = 20;
    private int occupied_seats = 0;
    private int id;
    public Seats seats[] = new Seats[20];
    public Car() {
        id = id_gen;
        id_gen++;
        this.occupied_seats = 0;
        for(int i = 0; i < 20; i++) {
            seats[i] = new Seats("Free", false);
        }
    }

    public int getOccupied_seats() {
        return occupied_seats;
    }

    public int getId() {
        return id;
    }

    public void addOccupied_seats() {
        this.occupied_seats++;
    }
    public void remOccupied_seats() {
        this.occupied_seats--;
    }
}
class Seats { // Class for seats with name and status of occupy //
    private String name;
    private boolean occupy;
    public Seats(String name, boolean occupy) {
        this.name = name;
        this.occupy = occupy;
    }

    public String getName() {
        return name;
    }

    public boolean isOccupy() {
        return occupy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOccupy(boolean occupy) {
        this.occupy = occupy;
    }
}