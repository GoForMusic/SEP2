import java.sql.Date;
import java.time.LocalDate;

public class test {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(Date.valueOf(localDate)) ;
    }
}
