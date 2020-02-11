package com.example.deepfruitlight;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.deepfruitlight.model.Pokemon;
import com.example.deepfruitlight.model.RestPokemonResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// C'est le controller qui sait quelle opération il faut effectuer

public class MainController {

    private final MainActivity mainActivity;
    private SharedPreferences sharedPreferences;

    public MainController(MainActivity mainActivity, SharedPreferences sharedPreferences) {
        this.mainActivity=mainActivity;
        this.sharedPreferences=sharedPreferences;
    }


    public void onCreate() {

        if(sharedPreferences.contains("donnee"))
        {
            mainActivity.showLoader();
            String liste = sharedPreferences.getString("donnee",null);
            Type listT = new TypeToken<List<Pokemon>>(){}.getType();
            List<Pokemon> listPok=new Gson().fromJson(liste,listT);
            mainActivity.showList(listPok);
            mainActivity.hideLoader();
        }


        else{
            mainActivity.showLoader();

            // Creation Objet GSON
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            // Création objet Retrofit
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://raw.githubusercontent.com/Biuni/PokemonGO-Pokedex/master/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            // Création interface PokemonRestApi
            PokemonRestAPI pokemonRestApi = retrofit.create(PokemonRestAPI.class);

            // Récupération objet call
            Call<RestPokemonResponse> call = pokemonRestApi.getListPokemon();
            call.enqueue(new Callback<RestPokemonResponse>() {
                @Override
                public void onResponse(Call<RestPokemonResponse> call, Response<RestPokemonResponse> response) {
                    RestPokemonResponse restPokemonResponse = response.body();
                    List<Pokemon> listPokemon = restPokemonResponse.getPokemon();
                    mainActivity.showList(listPokemon);
                    mainActivity.hideLoader();
                }

                @Override
                public void onFailure(Call<RestPokemonResponse> call, Throwable t) {
                    Log.d("Erreur", "API ERROR");
                }
            });
        }
    }
}
