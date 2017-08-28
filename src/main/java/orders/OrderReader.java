package orders;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderReader {
    public List<Orders> fileReader(String path) {
        List<Orders> list = null;
        try (Scanner sc = new Scanner(new File(path))) {
            list = new ArrayList<>();
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}

