package com.mkaz.controller;

import com.mkaz.model.Article;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mkaz on 15.09.2018.
 */
public class EditServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String title = req.getParameter("title");
        List<Article> articles = (ArrayList) session.getAttribute("articles");
        Article article = null;
        for (Article tempArticle : articles) {
            if (tempArticle.getTitle().equals(title)) {
                article = tempArticle;
            }
        }
        session.setAttribute("article", article);
        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }
}
