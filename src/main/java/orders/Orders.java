package orders;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Orders implements Comparable<Orders> {
    private String order;
    private LocalDateTime date;

    public Orders() {
    }

    public Orders(String order, LocalDateTime date) {
        this.order = order;
        this.date = date;
    }


    @Override
    public int compareTo(Orders o) {
        return getDate().compareTo(o.getDate());
    }
}
