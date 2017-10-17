package org.universaal.nativeandroid.lightserver;

import org.universaal.nativeandroid.lightserver.organizer.BusEvent;

/**
 * Created by Aleksandar Marinković on 17-Oct-17.
 */

public class EventClick extends BusEvent {
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EventClick(User user) {
        super("");
        this.user = user;
    }

    public EventClick(String id) {
        super(id);
    }
}
