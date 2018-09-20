package com.mkaz.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mkaz on 14.09.2018.
 */
public class Users {
    private final Map<String, User> users = new HashMap<>();

    //hardcode users
    public Users() {
        users.put("admin", new User("admin", "admin", "admin"));
        users.put("user", new User("user", "user", "user"));
    }

    public User getUser(String nickname) {
        return users.get(nickname);
    }

    public boolean checkPassword(String nickname, String password) {
        return users.get(nickname).checkPassword(password);
    }
}
