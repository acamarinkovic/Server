package org.universaal.nativeandroid.lightserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandar Marinković on 17-Oct-17.
 */

public class activeUser {

    User users;

    public User getUsers() {
        if (users == null)
            return new User();
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    private static activeUser allUsers;

    public static activeUser getInstance() {
        if (allUsers == null) {
            allUsers = new activeUser();
        }
        return allUsers;
    }


}
