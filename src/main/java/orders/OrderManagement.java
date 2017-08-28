package orders;

import jdk.nashorn.internal.ir.WhileNode;

import java.io.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderManagement {
    public static void main(String[] args) {

        // String path = args[0];//"C:\Users\prane\Downloads\data.txt";
        // String outputPath = args[1];
        List<Orders> ordersList = new ArrayList<>();
        String s = "C:\\Users\\prane\\Downloads\\data.txt";
        String s2 = "C:\\Users\\prane\\Downloads\\data2.txt";

        try (Scanner sc = new Scanner(new File(s))) {
            List<Orders> list = new ArrayList<>();
            sc.next();
            sc.next();
            while (sc.hasNext()) {
                Orders order = new Orders();
                order.setOrder(sc.next());
                    LocalDateTime date =
                            Instant.ofEpochMilli(Long.parseLong(sc.next()))
                                    .atZone(ZoneId.systemDefault())
                                    .toLocalDateTime();
                    order.setDate(date);
                list.add(order);
            }
            list.forEach(System.out::println);
            OrderWriter orderWriter = new OrderWriter();
            orderWriter.writeToFile(list, s2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}