package com.example.finalproject.models

import retrofit2.Call

class CountriesRepository() {
    fun getAllCountries() : Call<List<Countries>> = ApiInterface.create().getCountries()
}