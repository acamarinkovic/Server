package org.universaal.nativeandroid.lightserver;

import org.greenrobot.eventbus.EventBus;
import org.universaal.nativeandroid.lightserver.organizer.BusEvent;

/**
 * Created by Aleksandar Marinković on 17-Oct-17.
 */

public class Event extends BusEvent {
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event(User user) {
        super("");
        this.user = user;
    }

    public Event(String id) {
        super(id);
    }
}
