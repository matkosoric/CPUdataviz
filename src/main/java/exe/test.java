package exe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class test {

    public static void main(String[] args) {

//        try {

            String date1 = "29-May-2014";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy").withLocale(Locale.ENGLISH);
            LocalDate dateTime = LocalDate.parse(date1, formatter);

//            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
//            Date dateProper = formatter.parse(date1);
            System.out.println(dateTime);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

    }
}
