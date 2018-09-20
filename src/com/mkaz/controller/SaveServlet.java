package com.mkaz.controller;

import com.mkaz.model.Article;
import com.mkaz.model.User;
import com.mkaz.model.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author mkaz on 19.09.2018.
 */
public class SaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int marker = 0;
        HttpSession session = req.getSession();
        ArrayList<Article> articles = (ArrayList) session.getAttribute("articles");
        Users users = (Users) session.getAttribute("users");
        String title = req.getParameter("title");
        String text = req.getParameter("text");
        for (Article tempArticle : articles) {
            if (tempArticle.getTitle().equals(title)) {
                tempArticle.setText(text);
                marker = 1;
            }
        }
        if (marker == 0) {
            articles.add(new Article(title, text, LocalDate.now(),
                    users.getUser((String) session.getAttribute("nickname"))));
        }
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
