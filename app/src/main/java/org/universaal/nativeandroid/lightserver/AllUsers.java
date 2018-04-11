package org.universaal.nativeandroid.lightserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandar Marinković on 17-Oct-17.
 */

public class AllUsers {
    List<User> users;


    public List<User> getUsers() {
        return users;
    }

    public User getUserByName(String name) {
        for (User user : this.users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User newUser) {
        this.users.add(newUser);
    }

    private static AllUsers allUsers;

    public static AllUsers getInstance() {
        if (allUsers == null) {
            allUsers = new AllUsers();
        }
        return allUsers;
    }

    public static AllUsers getInstance(AllUsers auser) {
            allUsers = auser;
        return allUsers;
    }

    private AllUsers() {
        users = new ArrayList<>();;
    }
}
