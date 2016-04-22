package se.coredev.day3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() + "-Lifecycle";
    private static final String MESSAGE_KEY = "se.coredev.day3.MESSAGE_KEY";
    private String currentMessage;
    private TextView messageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate(). Bundle is null: " + (savedInstanceState == null));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageText = (TextView) findViewById(R.id.message_text);
        currentMessage = "No message";

        messageText.setText(currentMessage);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(MESSAGE_KEY, messageText.getText().toString() + " (saved)");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currentMessage = savedInstanceState.getString(MESSAGE_KEY);
        messageText.setText(currentMessage);
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause()");
        super.onPause();
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart()");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop()");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume()");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart()");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy()");
        super.onDestroy();
    }
}
