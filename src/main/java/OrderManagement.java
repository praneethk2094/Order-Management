import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderManagement {
    public static void main(String[] args) {

        String path = "C:\\Users\\prane\\Downloads\\data.txt";
        List<Orders> ordersList = new ArrayList<>();
        String s;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.readLine();
            while ((s = reader.readLine()) != null) {
                String[] split = s.split("\t\t");
                if (split.length == 2) {
                    Orders order = new Orders();
                    LocalDateTime date =
                            Instant.ofEpochMilli(Long.parseLong(split[1]))
                                    .atZone(ZoneId.systemDefault())
                                    .toLocalDateTime();

                    order.setDate(date);
                    order.setOrder(split[0]);
                    ordersList.add(order);
                    System.out.println(order);
                }

            }

            OrderWriter orderWriter = new OrderWriter();
            orderWriter.writeToFile(ordersList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}