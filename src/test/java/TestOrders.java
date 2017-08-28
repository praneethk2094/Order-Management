import orders.OrderReader;
import orders.OrderWriter;
import orders.Orders;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

import static org.junit.Assert.*;

public class TestOrders {

    @Test
    public void testReaderReadsAllObjects() {
        OrderReader orderReader = new OrderReader();
        assertEquals(9, orderReader.fileReader("src/test/resources/data.txt").size());
    }

    @Test
    public void testWriterWritesAllObjects() {
        OrderWriter orderWriter = new OrderWriter();
        List<Orders> ordersList = Arrays.asList(new Orders("Meat", LocalDateTime.now()));
        orderWriter.writeToFile(ordersList, "src/test/resources/data2.txt");
        File file = new File("src/test/resources/data2.txt");
        try {
            assertNotNull(FileUtils.readFileToString(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
