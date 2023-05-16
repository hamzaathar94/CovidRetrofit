package com.example.apipost.Retrofit


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
    @GET("photos")
    fun getData(): Call<responseImages>
    @POST("photos")
    fun  postData(@Body responseImagesItem: responseImagesItem) : Call<responseImagesItem>
    @GET("photos/{id}")
    fun getOneData(@Path("id") id : Int) : Call<responseImagesItem>

}