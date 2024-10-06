package com.example.proyecto

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Clase para representar un nivel
data class Level(val name: String, val isCompleted: Boolean)

// Adapter para el RecyclerView que mostrará los niveles
class LevelsAdapter(private val levels: List<Level>) : RecyclerView.Adapter<LevelsAdapter.LevelViewHolder>() {

    // ViewHolder para representar cada nivel en la lista
    class LevelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val levelName: TextView = itemView.findViewById(R.id.tv_level_name)  // Aquí enlazas el TextView del item_level.xml
    }

    // Inflar el layout para cada item de la lista de niveles
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_level, parent, false)  // Infla el layout del ítem de nivel
        return LevelViewHolder(view)
    }

    // Configurar los datos del nivel y cambiar colores según si fue completado o no
    override fun onBindViewHolder(holder: LevelViewHolder, position: Int) {
        val level = levels[position]
        holder.levelName.text = level.name

        // Cambiar el color del texto dependiendo si el nivel está completado o no
        if (level.isCompleted) {
            holder.levelName.setTextColor(Color.BLUE)  // Nivel completado (azul)
        } else {
            holder.levelName.setTextColor(Color.GRAY)  // Nivel no completado (gris)
        }
    }

    // Número de ítems en la lista
    override fun getItemCount(): Int {
        return levels.size
    }
}
