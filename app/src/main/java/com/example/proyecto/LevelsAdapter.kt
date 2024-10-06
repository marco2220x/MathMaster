package com.example.proyecto

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Clase para representar un nivel
data class Level(val name: String, val isCompleted: Boolean)

class LevelsAdapter(private val levels: List<Level>) : RecyclerView.Adapter<LevelsAdapter.LevelViewHolder>() {

    class LevelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val levelName: TextView = itemView.findViewById(R.id.tv_level_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_level, parent, false)
        return LevelViewHolder(view)
    }

    override fun onBindViewHolder(holder: LevelViewHolder, position: Int) {
        val level = levels[position]
        holder.levelName.text = level.name

        // Cambiar el fondo y el estado habilitado según si el nivel está completado o no
        if (level.isCompleted) {
            holder.itemView.setBackgroundResource(R.drawable.level_background) // Fondo azul con palomita
            holder.itemView.isEnabled = true // Habilitar el elemento
            holder.levelName.setTextColor(Color.WHITE) // Cambiar color de texto a blanco si está completado
        } else {
            holder.itemView.setBackgroundResource(R.drawable.level_background) // Fondo gris con candado
            holder.itemView.isEnabled = false // Deshabilitar el elemento
            holder.levelName.setTextColor(Color.BLACK) // Cambiar color de texto a negro si no está completado
        }
    }

    override fun getItemCount(): Int {
        return levels.size
    }
}
