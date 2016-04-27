package se.coredev.day4s;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "https://api.github.com/";
    public static final String TAG = MainActivity.class.getSimpleName();

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService gitHubService = retrofit.create(GitHubService.class);
        Call<User> result = gitHubService.getUser("RxFlow");

        result.enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d(TAG, "***************** " + response.body().getLogin());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d(TAG, "Could not fetch user: " + t.getMessage());
            }
        });


    }
}
