package com.istg.bienestar_salud

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val btnEnviarCorreo = findViewById<Button>(R.id.btnEnviarCorreo)

        btnEnviarCorreo.setOnClickListener {
            enviarCorreoElectronico()
        }
    }

    private fun enviarCorreoElectronico() {
        val destinatario = "ejemplo@correo.com"  // Cambia por el correo real
        val asunto = "Consulta desde Bienestar Salud"
        val mensaje = "Hola, este es un mensaje de prueba enviado desde la aplicación Android."

        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "message/rfc822"  // Prioriza apps de correo como Gmail
            putExtra(Intent.EXTRA_EMAIL, arrayOf(destinatario))
            putExtra(Intent.EXTRA_SUBJECT, asunto)
            putExtra(Intent.EXTRA_TEXT, mensaje)
        }

        try {
            val chooser = Intent.createChooser(intent, "Enviar correo con...")
            startActivity(chooser)
        } catch (e: Exception) {
            Toast.makeText(this, "No hay apps de correo instaladas.", Toast.LENGTH_LONG).show()
        }
    }
}
