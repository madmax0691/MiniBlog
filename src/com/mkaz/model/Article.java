package com.mkaz.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author mkaz on 13.09.2018.
 */
public class Article {
    private final String title;
    private String text;
    private final LocalDate dateTime;
    private final User user;

    public Article(String title, String text, LocalDate dateTime, User user) {
        this.title = title;
        this.text = text;
        this.dateTime = dateTime;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return dateTime.toString();
    }

    public User getUser() {
        return user;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", dateTime=" + dateTime.toString() +
                ", user=" + user.getNickname() +
                '}';
    }
}
