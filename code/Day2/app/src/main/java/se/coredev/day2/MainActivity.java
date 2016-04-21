package se.coredev.day2;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP_MR1){
            TextView textView = new TextView(this);
            textView.setText("Time to upgrade!");
            setContentView(textView);
        } else {
            setContentView(R.layout.activity_main);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId()){
//            case R.id.refresh:
//                Log.d(TAG, "Refresh clicked!");
//                return true;
//            case R.id.settings:
//                Log.d(TAG, "Settings clicked!");
//                return true;
//            default: return super.onOptionsItemSelected(item);
//        }
//    }

    public void handleSettings(MenuItem item) {
        Log.d(TAG, "Settings clicked!!!");
    }

    public void handleRefresh(MenuItem item) {
        Log.d(TAG, "Refresh clicked!!!");
    }
}
