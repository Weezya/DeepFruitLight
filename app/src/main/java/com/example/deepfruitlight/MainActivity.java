package com.example.deepfruitlight;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import com.example.deepfruitlight.model.Pokemon;

import java.util.List;

public class MainActivity extends Activity {

    // Variables de class

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar loader;
    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        loader = findViewById(R.id.loader_main_activity);

        controller = new MainController(this);
        controller.onCreate();
    }

    public void showLoader(){
        loader.setVisibility(View.VISIBLE);
    }

    public void hideLoader(){
        loader.setVisibility(View.GONE);
    }

    public void showList(List<Pokemon> list)
    {
        recyclerView.setHasFixedSize(true);
        // Gestionnaire de Layout
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Définir un adaptateur
        mAdapter = new MyAdapter(list, getApplicationContext());
        recyclerView.setAdapter(mAdapter);
    }
}