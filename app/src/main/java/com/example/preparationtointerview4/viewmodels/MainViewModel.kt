package com.example.preparationtointerview4.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.preparationtointerview4.model.MainRepository

class MainViewModel (
    private val liveDataForViewToObserve: MutableLiveData<MainRepository> = MutableLiveData()
        ): ViewModel() {

    fun getLiveData():MutableLiveData<MainRepository>{
        getData()
        return liveDataForViewToObserve
    }

    private fun getData(){
        liveDataForViewToObserve.value = MainRepository()
    }






}