package taskManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

/**
 * Created by Aldres on 13.10.17.
 */
public class Task {
    private String title;
    private String description;
    private LocalDate dateFormat;


    public Task(String title, String description, String date ) {
        this.title = title;
        this.description = description;
        this.dateFormat = setDate(date);
    }



    public LocalDate setDate(String inputDate) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("MMM d yyyy")
                .toFormatter(Locale.ENGLISH);
        formatter = formatter.withLocale(Locale.ENGLISH);
        LocalDate outputDate = LocalDate.parse(inputDate, formatter);
        return outputDate;

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    public LocalDate getDateFormat() {
        return dateFormat;
    }

    public static void main(String[] args) {
    }


}
