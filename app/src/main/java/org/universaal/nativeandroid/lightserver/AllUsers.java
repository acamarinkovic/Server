package org.universaal.nativeandroid.lightserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandar Marinković on 17-Oct-17.
 */

public class AllUsers {
    List<User> events;
    List<User> users;

    public List<User> getEvents(String userid) {
        List<User> userList = new ArrayList<>();
        if (events != null)
            for (User user : events) {
                if (user.getUserId().equals(userid)) {
                    userList.add(user);
                }
            }
        return userList;
    }

    public void addEvent(User event) {
        if (events == null) {
            events = new ArrayList<>();
        }
        events.add(event);
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserrByEvent(User user) {
        for (User usersss : this.users) {
            if (user.getUserId().equals(usersss.getUserId())) {
                return usersss;
            }
        }
        return new User();
    }

    public void setUsers(User newUser) {

        for (User user : this.users) {
            if (user.getUserId().equals(newUser.getUserId())) {
                this.users.remove(user);
            }
        }
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
        users = new ArrayList<>();
        events = new ArrayList<>();
    }


}
