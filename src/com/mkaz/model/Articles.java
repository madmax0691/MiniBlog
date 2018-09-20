package com.mkaz.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mkaz on 14.09.2018.
 */
public class Articles {
    private final Map<String, Article> articleMap = new HashMap<>();

    public void addArticle(Article article) {
        articleMap.put(article.getTitle(), article);
    }

    public void deleteArticle(String title) {
        articleMap.remove(title);
    }

    public List<Article> getArticles() {
        return new ArrayList<>(articleMap.values());
    }
}
