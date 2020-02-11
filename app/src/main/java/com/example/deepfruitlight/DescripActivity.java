package com.example.deepfruitlight;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DescripActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_item);

        getIncommingIntent();
    }

    private void getIncommingIntent()
    {
        if(getIntent().hasExtra("item"))
        {
            String nameString = getIntent().getStringExtra("item");
            String imgString = getIntent().getStringExtra("icon");
            setTxt(nameString,imgString);
        }
    }

    private void setTxt(String name,String img) {
        TextView nameTxtVw = findViewById(R.id.item);
        nameTxtVw.setText(name);

        // Les codes codées suivantes servent normalement à afficher une image de chaque Pokemon
        // dans la liste mais cela ne marche pas, impossible à régler même en changeant d'API
        // Il est possible que ce soit à cause de l'Android Virtual Device Manager

        //ImageView imageView = findViewById(R.id.item_icon);
    }

}
