package com.mkaz.model.filein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Formatter {
    private final String format;
    private final String information;

    public Formatter(String format, String information) {
        this.format = format;
        this.information = information;
    }

    public List<String> getFormattedInfo() {
        if (format.equals("csv")) {
            List<String> tempList = new ArrayList<>(Arrays.asList(information.
                    replace("\"", "|").replace("|,", "#").
                    replace("|", "").split("#")));
            List<String> tempFormattedLis = new ArrayList<>();
            for (String s : tempList) {
                tempFormattedLis.add(s.trim());
            }
            return tempFormattedLis;
        }
        System.out.println("I can not format this type!");
        return new ArrayList<>();
    }
}
