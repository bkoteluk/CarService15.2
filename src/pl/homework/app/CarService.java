package pl.homework.app;

import pl.homework.lib.Car;
import pl.homework.lib.CarServicesDB;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CarService {
    public static Queue<Car> serviceQueue = new LinkedList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)  {
        CarServicesDB carServicesDB = new CarServicesDB();
        try {
            serviceQueue = carServicesDB.readDB();
            System.out.println(serviceQueue);
            menu();
            if (!serviceQueue.isEmpty()) {
                carServicesDB.writeDB(serviceQueue);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void menu() {
        int choice;
        try {
            while ((choice = displayMenu()) != 0) {
                if (choice == 1) {
                    serviceQueue.offer(newCarData());
                } else if (choice == 2) {
                    carToService();
                } else {
                    System.out.println("Wybierz poprawną opcję programu (0, 1 lub 2)");;
                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("Wprowadzono niepoprawną wartość");
        }
    }

    private static void carToService(){
        Car car = serviceQueue.poll();
        if ( car != null) {
            System.out.println("Serwisowany pojazd: " + car);
        } else {
            System.out.println("Brak pojazdów oczekujących na serwis w kolejce");
        }
    }

    private static int displayMenu() throws InputMismatchException {
//        Scanner sc = new Scanner(System.in);
        System.out.println(" 0 - wyjście z programu");
        System.out.println(" 1 - przyjęcie samochodu do serwisu (do kolejki)");
        System.out.println(" 2 - pobranie samochodu z kolejki do serwisu");
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    private static Car newCarData() throws InputMismatchException {
        Car car = new Car();
//        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj typ pojazdu: ");
        car.setType(sc.nextLine());
        System.out.print("Podaj model :");
        car.setModel(sc.nextLine());
        System.out.print("Podaj producenta :");
        car.setBrand(sc.nextLine());
        System.out.print("Podaj rocznik: ");
        car.setAnnual(sc.nextInt());
        sc.nextLine();
        System.out.print("Podaj przebieg pojazdu: ");
        car.setMileage(sc.nextInt());
        sc.nextLine();
        System.out.print("Podaj numer vin: ");
        car.setVinNumber(sc.nextInt());
        sc.nextLine();
        return car;
    }
}
