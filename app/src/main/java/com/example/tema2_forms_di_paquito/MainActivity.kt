package com.example.tema2_forms_di_paquito;

import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var nombre:TextInputEditText
    private lateinit var edad:TextInputEditText
    private lateinit var boton:Button
    private lateinit var layoutNombre:TextInputLayout
    private lateinit var layoutEdad:TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Seteo las variables
        nombre=findViewById(R.id.Campoobli)
        edad=findViewById(R.id.edad18)
        layoutNombre = findViewById(R.id.nombreobligatorio)
        layoutEdad=findViewById(R.id.edad)

        boton = findViewById(R.id.boton)
        boton.setOnClickListener {
            Log.d("MainActivity", "Boton pulsado")
            if (nombre.text.toString().isEmpty()){
                layoutNombre.error = "Campo Obligatorio"
        }else{
            layoutNombre.error=null
        }
            if(nombre.text.toString().isEmpty() || nombre.text.toString().length<2){
                layoutNombre.error="Imposible Mandril"
            }else
                layoutNombre.error=null

            if(edad.text.toString().toInt()<18){
                layoutEdad.error="tienes que ser mayor de edad"
            }else
                layoutEdad.error=null

        }

    }




}