package se.coredev.day4;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public final class MessageFragment extends Fragment {

    private static final String TAG = MessageFragment.class.getSimpleName();
    private static final String MESSAGE_KEY = "se.coredev.day4.MESSAGE_KEY";
    private static final String DATE_KEY = "se.coredev.day4.DATE_KEY";
    ;

    private TextView messageText;
    private TextView lastDateText;
    private Button changeMessageButton;

    // Factory method
    public static MessageFragment newInstance(String message) {

        MessageFragment fragment = new MessageFragment();

        Bundle bundle = new Bundle();
        bundle.putString(MESSAGE_KEY, message);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_message, container, false);
        messageText = (TextView) view.findViewById(R.id.message_text);
        messageText.setText(getArguments().getString(MESSAGE_KEY));

        lastDateText = (TextView) view.findViewById(R.id.last_date_text);
        lastDateText.setText(readDate());

        changeMessageButton = (Button) view.findViewById(R.id.change_message_button);

        changeMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = new Date().toString();
                saveDate(date);
                messageText.setText("World!");
                lastDateText.setText(date);
            }
        });

        return view;
    }

    private void saveDate(String date) {

        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(DATE_KEY, date);
        editor.commit();
    }


    private String readDate() {
        return getActivity().getPreferences(Context.MODE_PRIVATE).getString(DATE_KEY, "No value");
    }

}
