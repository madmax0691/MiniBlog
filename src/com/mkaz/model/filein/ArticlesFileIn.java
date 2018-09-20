package com.mkaz.model.filein;

import com.mkaz.model.Article;
import com.mkaz.model.Articles;
import com.mkaz.model.Users;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author mkaz on 14.09.2018.
 */
public class ArticlesFileIn {
    private static final int NUMBER_OF_COLUMNS = 4;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
    private final List<String> formattedData;
    private final Articles articles = new Articles();
    private final Users users = new Users();

    private static String read(String fileName, String splitter) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                new File(fileName).getAbsoluteFile()))) {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                stringBuilder.append(s);
                stringBuilder.append(splitter);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    public ArticlesFileIn() {
        formattedData = new Formatter("csv", read("articles.csv", ",")).getFormattedInfo();
        removeTitles();
        addAllArticles();
    }

    private void removeTitles() {
        for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
            formattedData.remove(0);
        }
    }

    private void addAllArticles() {
        for (int i = 0; i < formattedData.size() / NUMBER_OF_COLUMNS; i++) {
            articles.addArticle(new Article(formattedData.get(i * NUMBER_OF_COLUMNS),
                    formattedData.get(1 + i * NUMBER_OF_COLUMNS),
                    LocalDate.parse(formattedData.get(2 + i * NUMBER_OF_COLUMNS), dateTimeFormatter),
                    users.getUser(formattedData.get(3 + i * NUMBER_OF_COLUMNS))));
        }
    }

    public Articles getArticles() {
        return articles;
    }

    public Users getUsers() {
        return users;
    }
}
