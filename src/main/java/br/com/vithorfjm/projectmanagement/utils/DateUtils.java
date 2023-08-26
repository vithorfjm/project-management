package br.com.vithorfjm.projectmanagement.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {
    public static LocalDate convertStringToLocalDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                return LocalDate.parse(dateString, formatter);
            } catch (DateTimeParseException e) {
                e.printStackTrace();
                return null;
            }
    }
}
