package com.mkaz.controller;

import com.mkaz.model.Article;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author mkaz on 20.09.2018.
 */
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String title = req.getParameter("title");
        ArrayList<Article> articles = (ArrayList) session.getAttribute("articles");
        Article article = null;
        for (Article tempArticle : articles) {
            if (tempArticle.getTitle().equals(title)) {
                article = tempArticle;
            }
        }
        articles.remove(article);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}