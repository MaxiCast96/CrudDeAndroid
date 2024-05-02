package josue.a.crud_uwu

import Modelo.ClaseConexión
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtPrecio = findViewById<EditText>(R.id.txtPrecio)
        val txtCantidad = findViewById<EditText>(R.id.txtCantidad)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)

        btnAgregar.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO){
                 //Guardar datos
                //Crear un objeto en la clase de conexion
                val objConexion = ClaseConexión().cadenaConexion()

                //2. Crear una variable que sea igual a un PrepareStatement
                val addPrducto = objConexion?.prepareStatement("insert into tbProductos1 values(?, ?, ?)")!!
                addPrducto.setString(1, txtNombre.text.toString())
                addPrducto.setInt(2, txtPrecio.text.toString().toInt())
                addPrducto.setInt(3, txtCantidad.text.toString().toInt())
                addPrducto.executeUpdate()
            }
        }
    }
}