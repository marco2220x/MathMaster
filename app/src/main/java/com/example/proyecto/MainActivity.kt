package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Crear una lista de temas
        val topicsList = listOf(
            Topic("Polinomios", R.drawable.ic_polinomios),
            Topic("Factorización", R.drawable.ic_polinomios)
            // Agrega más temas según sea necesario
        )

        // Inicializar el RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.rv_topics)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Pasar la función onTopicClick al adaptador
        recyclerView.adapter = TopicsAdapter(topicsList) { selectedTopic ->
            // Aquí manejamos el clic sobre un tema
            val intent = Intent(this, LevelsActivity::class.java)
            intent.putExtra("SELECTED_TOPIC", selectedTopic)  // Pasar el tema seleccionado
            startActivity(intent)
        }
    }
}
