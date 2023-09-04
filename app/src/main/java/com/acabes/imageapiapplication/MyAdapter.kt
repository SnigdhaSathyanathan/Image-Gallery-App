package com.acabes.imageapiapplication

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(private val items: List<Results>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val context=itemView.context
        val downloadButton=itemView.findViewById<Button>(R.id.downloadBtn)
        val imageView=itemView.findViewById<ImageView>(R.id.img)
        val imgTitleTextView=itemView.findViewById<TextView>(R.id.imgTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.list_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=items[position]
        holder.imgTitleTextView.text=item.title
//        Picasso.get()
//            .load(item.url)
//            .into(holder.image)
        holder.imageView.let { it.loadImage(item.url) }
        holder.downloadButton.setOnClickListener {
            val request= DownloadManager.Request(Uri.parse(item.url))
                .setTitle("Image")
                .setDescription("Downloading Image...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"Image.jpg")
            val downloadManager = holder.context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            downloadManager.enqueue(request)
        }
    }

    override fun getItemCount(): Int =items.size
}
