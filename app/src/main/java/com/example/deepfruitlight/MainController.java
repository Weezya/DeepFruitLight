package com.example.deepfruitlight;

import com.example.deepfruitlight.model.Pokemon;
import com.example.deepfruitlight.model.RestPokemonResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


// C'est le controller qui sait quelle opération il faut effectuer

public class MainController {

    private final MainActivity mainActivity;

    public MainController(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
    }

    public void onItemClicked(Pokemon itemClicked)
    {
        
    }

    public void onCreate() {
        mainActivity.showLoader();

        // Creation Objet GSON
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        // Création objet Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
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
                List<Pokemon> listPokemon = restPokemonResponse.getResults();
                mainActivity.showList(listPokemon);
            }

            @Override
            public void onFailure(Call<RestPokemonResponse> call, Throwable t) {
                System.out.println("API ERROR");

            }
        });


    }
}
