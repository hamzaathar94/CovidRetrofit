package com.example.covidretrofit.Viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apipost.Retrofit.responseImages
import com.example.apipost.Retrofit.responseImagesItem
import com.example.covidretrofit.repository.ImageRepository

class ImageViewModel(val context: Context,private val imageRepository: ImageRepository) : ViewModel() {
    val data : MutableLiveData<List<responseImagesItem>> = imageRepository.RetroImage

    fun getRetroImage() : LiveData<List<responseImagesItem>> {
        imageRepository.ImageLiveData()
        return data
    }
}