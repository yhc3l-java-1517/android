package se.coredev.day4;

import io.realm.RealmObject;

public class Message extends RealmObject {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
