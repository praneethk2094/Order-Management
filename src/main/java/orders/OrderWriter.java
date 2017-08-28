package orders;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

public class OrderWriter {
    public void writeToFile(List<Orders> ordersList, String path) {

        File file = new File(path);
        try (FileOutputStream fop = new FileOutputStream(file);
             BufferedWriter output = new BufferedWriter(new OutputStreamWriter(fop))) {
            if (!file.exists()) {
                file.createNewFile();
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            output.write(String.format("%-20s %-20s %n", "Orders", "Time"));
            Collections.sort(ordersList);
            System.out.println("about to write");
            for (Orders orders : ordersList) {
                String format = "%-20s %-20s %n";
                String print = String.format(format, orders.getOrder(), orders.getDate().format(formatter));
                output.write(print);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
