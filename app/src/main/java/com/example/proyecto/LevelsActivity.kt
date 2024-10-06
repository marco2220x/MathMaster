package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.ProgressBar
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class LevelsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_levels)

        // Recupera el tema seleccionado desde la intención
        val selectedTopic = intent.getStringExtra("SELECTED_TOPIC")

        // Ajusta el título de la pantalla según el tema seleccionado
        val titleTextView = findViewById<TextView>(R.id.tv_topic_title)
        titleTextView.text = selectedTopic

        // Referencias a las vistas
        val recyclerView = findViewById<RecyclerView>(R.id.rv_levels)
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val backButton = findViewById<Button>(R.id.btn_back)

        // Cargar los niveles según el tema seleccionado
        val levels = loadLevelsForTopic(selectedTopic)

        // Configuración del RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = LevelsAdapter(levels)

        // Actualizar la barra de progreso
        val completedLevels = levels.count { it.isCompleted }
        val progress = (completedLevels.toFloat() / levels.size) * 100
        progressBar.progress = progress.toInt()

        // Funcionalidad del botón de regresar
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()  // Cierra la actividad actual para que no quede en la pila
        }
    }

    // Método para cargar los niveles dependiendo del tema seleccionado
    private fun loadLevelsForTopic(topicName: String?): List<Level> {
        // Aquí podrías ajustar la lógica para cargar diferentes niveles
        // dependiendo del tema. Puedes tener diferentes listas o generar niveles dinámicamente.

        return when (topicName) {
            "Polinomios" -> listOf(
                Level("Nivel 1", isCompleted = true),
                Level("Nivel 2", isCompleted = false),
                Level("Nivel 3", isCompleted = false)
            )
            "Factorización" -> listOf(
                Level("Nivel 1", isCompleted = true),
                Level("Nivel 2", isCompleted = true),
                Level("Nivel 3", isCompleted = false),
                Level("Nivel 4", isCompleted = false)
            )
            else -> listOf(
                Level("Nivel 1", isCompleted = false),
                Level("Nivel 2", isCompleted = false)
            )
        }
    }
}
