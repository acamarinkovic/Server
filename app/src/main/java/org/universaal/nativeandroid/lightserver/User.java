package org.universaal.nativeandroid.lightserver;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.pixplicity.easyprefs.library.Prefs;

import org.universaal.nativeandroid.lightserver.organizer.UserEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandar Marinković on 16-Oct-17.
 */

public class User {
    String name;
    String image;
    String address;
    List<UserEvent> events;


    public User(String name, String picture, String address) {
        if(picture!=null) {
            image=picture;
            this.address=address;
            this.name = name;
            events = new ArrayList<>();
        }
    }

    public Bitmap getImage() {
        byte[] decodedString = Base64.decode(image, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<UserEvent> getEvents() {
        return events;
    }

    public void addEvent(UserEvent event) {
        events.add(event);
    }
}
