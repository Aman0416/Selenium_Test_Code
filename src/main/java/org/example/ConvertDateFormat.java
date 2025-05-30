package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDateFormat {
    public static void main(String[] args) throws ParseException {
        String originalFormat = "2025-04-25";

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateOutput = new SimpleDateFormat("ddMMyyyy");

        Date date2 = date.parse(originalFormat);

        String formattedDate = dateOutput.format(date2);

        System.out.println(formattedDate);
    }
}
