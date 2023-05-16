package com.example.covidretrofit.repository

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apipost.Retrofit.RetrofitInstance
import com.example.apipost.Retrofit.responseImages
import com.example.apipost.Retrofit.responseImagesItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageRepository(var context: Context) {

    val RetroImage = MutableLiveData<List<responseImagesItem>>()

     fun getData() {
        RetrofitInstance.apiInterface.getData().enqueue(object : Callback<responseImages> {
            override fun onResponse(
                call: Call<responseImages>, response: Response<responseImages>
            ) {
                Toast.makeText(context, "Responded", Toast.LENGTH_SHORT).show()
                RetroImage.postValue(response.body())
            }

            override fun onFailure(call: Call<responseImages>, t: Throwable) {
                Toast.makeText(context, "${t.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun ImageLiveData() : LiveData<List<responseImagesItem>>{
        return RetroImage
    }
}