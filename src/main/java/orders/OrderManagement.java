package orders;


public class OrderManagement {
    public static void main(String[] args) {

        String input = args[0];
        String output = args[1];
        OrderReader orderReader = new OrderReader();
            OrderWriter orderWriter = new OrderWriter();
        orderWriter.writeToFile(orderReader.fileReader(input), output);


    }
}