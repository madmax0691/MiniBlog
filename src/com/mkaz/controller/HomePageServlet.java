package com.mkaz.controller;

import com.mkaz.model.Articles;
import com.mkaz.model.DateComparator;
import com.mkaz.model.Users;
import com.mkaz.model.filein.ArticlesFileIn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

/**
 * @author mkaz on 13.09.2018.
 */
public class HomePageServlet extends HttpServlet {
    private final ArticlesFileIn articlesFileIn;
    private final Articles articles;
    private final Users users;

    {
        //hardcode initialization
        articlesFileIn = new ArticlesFileIn();
        articles = articlesFileIn.getArticles();
        users = articlesFileIn.getUsers();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String nickname = req.getParameter("nickname");
        String password = req.getParameter("password");
        if (users.getUser(nickname) != null && users.checkPassword(nickname, password)) {
            session.setAttribute("articles", articles.getArticles());
            session.setAttribute("nickname", nickname);
            session.setAttribute("users",users);
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        } else {
            resp.getWriter().println("<html><body><center>Sorry, but nickname or password is not correct. " +
                    "Please, try again.</center></body></html>");
        }
    }
}
