package com.example.deepfruitlight;

import com.example.deepfruitlight.model.RestPokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonRestAPI {



    @GET("pokemon")
    Call<RestPokemonResponse> getListPokemon();

}
