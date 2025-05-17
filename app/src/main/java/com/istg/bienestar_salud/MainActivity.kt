package com.istg.bienestar_salud

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.istg.bienestar_salud.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Botón 1: Segunda pantalla
        binding.btnSegundaPantalla.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("mensajeInicial", "¡Hola desde MainActivity!")
            startActivityForResult(intent, 1)
        }

        // Botón 2: Navegador
        binding.btnAbrirNavegador.setOnClickListener {
            val url = "https://www.google.com"
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }

        // Botón 3: Tercera pantalla
        binding.btnTerceraPantalla.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            // Aquí usamos el TextView con id textResultado
            val respuesta = data?.getStringExtra("mensajeDeVuelta")
            binding.textResultado.text = respuesta
        }
    }
}
