package guerrero.erick.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    lateinit var etTitulo: EditText
    lateinit var btnGuardar:Button
    lateinit var listaTareas:RecyclerView
    lateinit var adapter:TareasAdapter

    private val tareasViewModel:TareasViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etTitulo = findViewById(R.id.etNombre)
        btnGuardar = findViewById(R.id.btnGuardar)
        listaTareas = findViewById(R.id.rvTareas)



        //lo que sea
        tareasViewModel.elementos.add(
            Tarea("Dar mi clase",
                "Es la de android",
            false)
        )

        adapter = TareasAdapter(tareasViewModel.elementos)

        listaTareas.adapter = adapter
        listaTareas.layoutManager = GridLayoutManager(this,
            1)

        btnGuardar.setOnClickListener {

            val titulo = etTitulo.text.toString()
            tareasViewModel.elementos.add(Tarea(titulo,"Una descripción",false))

            adapter.notifyDataSetChanged()
            Toast.makeText(this,"${tareasViewModel.elementos.size}",Toast.LENGTH_SHORT).show()
        }

    }
}