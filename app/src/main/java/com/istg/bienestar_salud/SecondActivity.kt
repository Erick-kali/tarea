package com.istg.bienestar_salud

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val txtDatoRecibido = findViewById<TextView>(R.id.txtDatoRecibido)
        val edtMensaje = findViewById<EditText>(R.id.edtMensaje)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)

        // Recibe el dato enviado desde MainActivity
        val datoRecibido = intent.getStringExtra("dato_main")
        txtDatoRecibido.text = "Dato recibido: $datoRecibido"

        // Al pulsar enviar, devuelve el mensaje a MainActivity
        btnEnviar.setOnClickListener {
            val mensajeDeVuelta = edtMensaje.text.toString()
            val intentDeVuelta = Intent()
            intentDeVuelta.putExtra("mensaje_de_vuelta", mensajeDeVuelta)
            setResult(Activity.RESULT_OK, intentDeVuelta)
            finish()
        }
    }
}
