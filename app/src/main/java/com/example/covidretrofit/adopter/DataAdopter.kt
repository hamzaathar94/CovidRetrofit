package com.example.covidretrofit.adopter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apipost.Retrofit.responseImages
import com.example.apipost.Retrofit.responseImagesItem
import com.example.covidretrofit.Viewmodel.ImageViewModel
import com.example.covidretrofit.databinding.DesignLayoutBinding

class DataAdopter(val context: Context,var data : List<responseImagesItem>,val imageViewModel: ImageViewModel) : RecyclerView.Adapter<DataAdopter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = DesignLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = data[position]
        holder.binding.title.text = data.title
        Glide.with(context).load(data.thumbnailUrl).into(holder.binding.imageView)
    }

    class MyViewHolder(var binding: DesignLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    }

}