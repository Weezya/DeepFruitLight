package com.example.deepfruitlight;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.deepfruitlight.model.OnPoketClick;
import com.example.deepfruitlight.model.Pokemon;

import java.util.List;

public class MainActivity extends AppCompatActivity {

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

        controller = new MainController(this, getSharedPreferences("donnee", Context.MODE_PRIVATE));
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
        mAdapter = new MyAdapter(list, getApplicationContext(), new OnPoketClick() {
            @Override
            public void onPoketClick(Pokemon poke) {
                Toast.makeText(getApplicationContext(),poke.getName(),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),DescripActivity.class);
                intent.putExtra("item",poke.getName());
                //intent.putExtra("icon",poke.getImg());
                MainActivity.this.startActivity(intent);
            }
        });
        recyclerView.setAdapter(mAdapter);
    }
}