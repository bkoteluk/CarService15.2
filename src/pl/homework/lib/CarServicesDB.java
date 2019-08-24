package pl.homework.lib;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class CarServicesDB {
    public static final String CARSERVICE_DB= "carservice.db";

    public Queue<Car> readDB() throws IOException {
        Queue<Car> cars = new LinkedList<>();

        File file = new File(CARSERVICE_DB);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            String[] array = line.split(";");
            cars.add(new Car(array[0], array[1], array[2],
                    Integer.parseInt(array[3]), Integer.parseInt(array[4]),Integer.parseInt(array[5])));
        }
        bufferedReader.close();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("");
        bufferedWriter.close();
        return cars;
    }

    public void writeDB(Queue<Car> queue) throws IOException {
        File file = new File(CARSERVICE_DB);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        do {
           bufferedWriter.write(queue.poll().toCSV());
        } while ( !queue.isEmpty());
        bufferedWriter.close();
    }
}
