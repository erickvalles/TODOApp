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


class MainActivity : AppCompatActivity() {
    lateinit var etTitulo: EditText
    lateinit var btnGuardar:Button
    lateinit var listaElementos:ListView

    private val tareasViewModel:TareasViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etTitulo = findViewById(R.id.etNombre)
        btnGuardar = findViewById(R.id.btnGuardar)
        listaElementos = findViewById(R.id.lvElementos)

        tareasViewModel.elementos.add("Hola")
        tareasViewModel.elementos.add("Mundo")
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,tareasViewModel.elementos)

        listaElementos.adapter = adapter
        btnGuardar.setOnClickListener {

            val contenido = etTitulo.text.toString()
            tareasViewModel.elementos.add(contenido)
            adapter.notifyDataSetChanged()
            Toast.makeText(this,"${tareasViewModel.elementos.size}",Toast.LENGTH_SHORT).show()
        }

    }
}