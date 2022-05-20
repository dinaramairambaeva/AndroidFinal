package com.example.finalproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.finalproject.models.Countries
import com.example.finalproject.models.CountriesRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountriesViewModel (application: Application) : AndroidViewModel(application){
    private val repository: CountriesRepository = CountriesRepository()

    val countriesList = MutableLiveData<List<Countries>>()

    init {
        getAllCountries()
    }

    private fun getAllCountries(){
        val response = repository.getAllCountries()
        response.enqueue(object: Callback<List<Countries>>{
            override fun onResponse(call: Call<List<Countries>>, response: Response<List<Countries>>){
                countriesList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Countries>>, t: Throwable) {

            }
        })
    }
}