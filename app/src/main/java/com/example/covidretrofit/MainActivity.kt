package com.example.covidretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.covidretrofit.Factory.RetroImageFactory
import com.example.covidretrofit.Viewmodel.ImageViewModel
import com.example.covidretrofit.adopter.DataAdopter
import com.example.covidretrofit.databinding.ActivityMainBinding
import com.example.covidretrofit.repository.ImageRepository

class MainActivity : AppCompatActivity() {
    private var binding : ActivityMainBinding? = null
    private var imageViewModel : ImageViewModel? = null
    private var recyclerview : RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        recyclerview = binding?.recyclerView
        recyclerview?.layoutManager = LinearLayoutManager(this)

        val imageRepository = ImageRepository(this)
        imageViewModel = ViewModelProvider(this,RetroImageFactory(applicationContext,imageRepository)).get(ImageViewModel::class.java)
        imageRepository.getData()
        imageViewModel?.getRetroImage()?.observe(this, Observer {
            recyclerview?.adapter = DataAdopter(this,it,imageViewModel!!)
        })

        setContentView(binding?.root
        )
    }
}