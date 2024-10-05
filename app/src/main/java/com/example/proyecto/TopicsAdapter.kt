package com.example.proyecto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Data class que representa un tema
data class Topic(val name: String, val imageResId: Int)

// Adaptador para el RecyclerView
class TopicsAdapter(private val topics: List<Topic>) : RecyclerView.Adapter<TopicsAdapter.TopicViewHolder>() {

    // ViewHolder para cada item del RecyclerView
    class TopicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val topicImage: ImageView = itemView.findViewById(R.id.topicImage)
        val topicTitle: TextView = itemView.findViewById(R.id.topicTitle)
    }

    // Crear el ViewHolder y asignar el layout para cada item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_topic_card, parent, false)
        return TopicViewHolder(itemView)
    }

    // Llenar los datos de cada item con el tema correspondiente
    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val topic = topics[position]
        holder.topicTitle.text = topic.name
        holder.topicImage.setImageResource(topic.imageResId)
    }

    // Número total de elementos en la lista
    override fun getItemCount(): Int {
        return topics.size
    }
}
