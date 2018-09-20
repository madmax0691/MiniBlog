package com.mkaz.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

/**
 * @author mkaz on 19.09.2018.
 */
public class DateComparator implements Comparator<Article> {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");

    @Override
    public int compare(Article o1, Article o2) {
        return LocalDate.parse(o1.getDate()).
                compareTo(LocalDate.parse(o2.getDate()));
    }
}
