package se.coredev.day4;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import io.realm.Realm;

public class MainActivity extends SingleFragmentActivity {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Message message = realm.createObject(Message.class);
        message.setText("Lunch!");
        realm.commitTransaction();

        super.onCreate(savedInstanceState);
    }

    @Override
    protected Fragment getFragment() {

        Message message = realm.where(Message.class).findFirst();

        return message == null ?
                MessageFragment.newInstance("No value") :
                MessageFragment.newInstance(message.getText());

    }
}
