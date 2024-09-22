package com.app.listview_adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

data class ItemData(val nombre: String, val apellido: String, val nota1: String, val nota2: String, val notafinal: String)


class CustomAdapter(context: Context, private val dataList: List<ItemData>) : ArrayAdapter<ItemData>(context, R.layout.list_item, dataList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        val textViewNombre: TextView = view.findViewById(R.id.textViewNombre)
        val textViewApellido: TextView = view.findViewById(R.id.textViewApellido)
        val textViewNota1: TextView = view.findViewById(R.id.textViewNota1)
        val textViewNota2: TextView = view.findViewById(R.id.textViewNota2)
        val textViewNotafinal: TextView = view.findViewById(R.id.textViewNotaFinal)

        val item = getItem(position)

        textViewNombre.text = item?.nombre
        textViewApellido.text = item?.apellido
        textViewNota1.text = item?.nota1
        textViewNota2.text = item?.nota2
        textViewNotafinal.text = item?.notafinal

        return view
    }
}