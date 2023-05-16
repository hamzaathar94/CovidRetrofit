package com.example.covidretrofit.Factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.covidretrofit.Viewmodel.ImageViewModel
import com.example.covidretrofit.repository.ImageRepository

class RetroImageFactory(val context: Context, private val imageRepository: ImageRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ImageViewModel(context ,imageRepository) as T
    }
}