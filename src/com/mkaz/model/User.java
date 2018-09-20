package com.mkaz.model;

/**
 * @author mkaz on 13.09.2018.
 */
public class User {
    private final String name;
    private final String nickname;
    private final String password;

    public User(String name, String nickname, String password) {
        this.name = name;
        this.nickname = nickname;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
