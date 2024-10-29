package com.example.tema2_forms_di_paquito;

import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class E2Activity : AppCompatActivity() {

    private lateinit var nombre: TextInputEditText
    private lateinit var layoutNombre: TextInputLayout
    private lateinit var boton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_e2)
        layoutNombre=findViewById(R.id.camponombre)
        nombre=findViewById(R.id.nombre)

        nombre.doOnTextChanged { text, start, count, after ->

            Log.v("prueba", text.toString())

        }
        boton = findViewById(R.id.insertar)
        boton.setOnClickListener{Log.d("E2Activity", "Boton pulsado")
            if (nombre.text.toString().isEmpty()){
                layoutNombre.error = "Campo Obligatorio"
            }else{
                layoutNombre.error=null
            }
            if(nombre.text.toString().isEmpty() || nombre.text.toString().length<2){
                layoutNombre.error="Nombre no permitida"
            }else
                layoutNombre.boxStrokeColor=getColor(R.color.verde)


        }



    }
}