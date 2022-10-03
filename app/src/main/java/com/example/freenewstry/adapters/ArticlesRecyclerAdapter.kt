package com.example.freenewstry.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.freenewstry.R
import com.example.freenewstry.models.Article
import com.example.freenewstry.viewmodels.CustomViewModel

class ArticlesRecyclerAdapter(var articlesList : ArrayList<Article>, var myViewModel : CustomViewModel, var fragment: Fragment) : RecyclerView.Adapter<ArticlesRecyclerAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false))
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.articleTitle.setText(articlesList[position].title)
        holder.articleAuthor.setText(articlesList[position].author)
        holder.articleDate.setText(articlesList[position].publishedDate)
        holder.articleSummary.setText(articlesList[position].summary)
        Glide.with(holder.articleImage.context)
            .load(articlesList.get(position).media)
            .apply(RequestOptions().centerCrop())
            .into(holder.articleImage)
        holder.itemView.setOnClickListener {
            myViewModel.article.postValue(articlesList[position])
            fragment.findNavController().navigate(R.id.action_listFragment_to_detailFragment)
        }

    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

    class ArticleViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var articleTitle : TextView = itemView.findViewById(R.id.itemtitle)
        var articleAuthor : TextView = itemView.findViewById(R.id.itemauthor)
        var articleDate : TextView = itemView.findViewById(R.id.itemdate)
        var articleSummary : TextView = itemView.findViewById(R.id.itemsummary)
        var articleImage : ImageView = itemView.findViewById(R.id.itemimage)
    }

}