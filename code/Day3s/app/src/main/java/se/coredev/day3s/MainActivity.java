package se.coredev.day3s;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.names_recycler_view);
        layoutManager = new LinearLayoutManager(this);

        List<NameData> data = new ArrayList<>();
        data.add(new NameData("Luke Skywalker", "A true Jedi Knight"));
        data.add(new NameData("Leia Skywalker", "Lukes Jedi sister"));
        data.add(new NameData("Master Yoda", "A funny little Jedi with great powers"));
        data.add(new NameData("Darth Vader", "Dark father with good inside"));
        data.add(new NameData("R2-D2", "Versatile robot and friend"));
        data.add(new NameData("C-3P0", "English speaking robot that knows everything"));
        data.add(new NameData("Han Solo", "Great pilot with a cool spaceship"));
        data.add(new NameData("Wookiee", "Big hairy friend to Han"));
        adapter = new NameAdapter(this, data);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
