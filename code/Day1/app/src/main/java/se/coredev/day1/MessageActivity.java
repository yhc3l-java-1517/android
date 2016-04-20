package se.coredev.day1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MessageActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "se.coredev.day1.EXTRA_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
    }

    public void sendMessage(View view) {
        EditText editText = (EditText) findViewById(R.id.edit_text);
        Intent intent = new Intent(this, ShowMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, editText.getText().toString());
        startActivity(intent);
    }
}
