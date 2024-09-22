package com.app.listview_adapters

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import java.io.InputStream
import android.view.LayoutInflater
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)

        // Agregar la cabecera
        val headerView = LayoutInflater.from(this).inflate(R.layout.list_header, listView, false)
        listView.addHeaderView(headerView)

        // Leer archivo CSV desde assets
        val inputStream: InputStream = assets.open("Notas.csv")
        val dataList = mutableListOf<ItemData>()

        csvReader().open(inputStream) {
            readAllAsSequence().forEach { row ->
                val nombre = row[0] // Cambia los índices según tu estructura
                val materia = row[1]
                val nota1 = row[2]
                val nota2 = row[3]
                val notaFinal = row[4]
                dataList.add(ItemData(nombre, materia, nota1, nota2, notaFinal))
            }
        }
        // Configurar ListView con el adaptador personalizado
        val adapter = CustomAdapter(this, dataList)
        listView.adapter = adapter
    }
}