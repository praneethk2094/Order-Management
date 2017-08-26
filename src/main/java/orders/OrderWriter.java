package orders;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

public class OrderWriter {
    public void writeToFile(List<Orders> ordersList, String path) {
        //  String path = "C:\\Users\\prane\\Downloads\\data2.txt";

        File file = new File(path);
        try (FileOutputStream fop = new FileOutputStream(file);
             BufferedWriter output = new BufferedWriter(new OutputStreamWriter(fop))) {
            if (!file.exists()) {
                file.createNewFile();
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            output.write("Orders\t\t\tTime" + System.lineSeparator());
            Collections.sort(ordersList);
            for (Orders orders : ordersList) {
                String print = orders.getOrder() + "\t\t" + orders.getDate().format(formatter) + System.lineSeparator();
                output.write(print);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
