import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Orders implements Serializable {
    private String order;
    private LocalDateTime date;

    @Override
    public String toString() {
        return "Orders{" +
                "order='" + order + '\'' +
                ", date=" + date +
                '}';
    }
}
