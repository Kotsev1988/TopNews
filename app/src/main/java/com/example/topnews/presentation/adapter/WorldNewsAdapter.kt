package com.example.topnews.presentation.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.topnews.databinding.NewsItemBinding
import com.example.topnews.presentation.list.NewsList
import com.example.topnews.presentation.list.NewsView
import com.example.topnews.presentation.loadImage.IImageLoader
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject


const val DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm"

class WorldNewsAdapter(private val newsList: NewsList) :
    RecyclerView.Adapter<WorldNewsAdapter.NewsViewHolder>() {

    @Inject
    lateinit var imageLoader: IImageLoader<AppCompatImageView>
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): WorldNewsAdapter.NewsViewHolder {
        return NewsViewHolder(
            NewsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            newsList.onItemClickListener?.invoke(this)
        }
    }

    override fun onBindViewHolder(holder: WorldNewsAdapter.NewsViewHolder, position: Int) {
        newsList.bindView(holder.apply {
            pos = position
        })
    }

    override fun getItemCount(): Int = newsList.getCount()

    inner class NewsViewHolder(private val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root),
        NewsView {
        override fun setTitle(title: String) {
            binding.newsTitle.text = title
        }

        override fun setImage(url: String) {
            imageLoader.loadAvatar(url, binding.newsImage)
        }

        override fun setDescription(desc: String) {

            binding.description.text = desc
        }

        @RequiresApi(Build.VERSION_CODES.O)
        override fun setCreatedDate(date: String) {

            val dt = OffsetDateTime.parse(date)
            val formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)
            val data = formatter.format(dt)

            binding.createdDate.text = data
        }

        override var pos: Int = -1

    }
}