package se.coredev.day1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_message);

        TextView textView = (TextView) findViewById(R.id.show_message_text);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MessageActivity.EXTRA_MESSAGE);
        textView.setText(message);
    }
}
