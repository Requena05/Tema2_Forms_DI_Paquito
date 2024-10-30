package com.example.tema2_forms_di_paquito;

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class E2Activity : AppCompatActivity() {

    private lateinit var nombre: TextInputEditText
    private lateinit var layoutNombre: TextInputLayout
    private lateinit var boton: Button
    private lateinit var campocorreo: TextInputLayout
    private lateinit var correo: TextInputEditText
    @SuppressLint("UseCompatLoadingForDrawables", "NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContentView(R.layout.activity_e2)
        layoutNombre=findViewById(R.id.camponombre)
        nombre=findViewById(R.id.nombre)
        correo=findViewById(R.id.correo)
        campocorreo=findViewById(R.id.campocorreo)

        nombre.doOnTextChanged { text, start, count, after ->

            Log.v("prueba", text.toString())
            if (nombre.text.toString().length < 2) {
                layoutNombre.boxStrokeColor = getColor(R.color.rojo)
                layoutNombre.error = "Nombre no permitido"

            }else{
                layoutNombre.boxStrokeColor = getColor(R.color.verde)
                layoutNombre.helperText="Nombre correcto"
                layoutNombre.hintTextColor=getColorStateList(R.color.verde)

            }
        }
        correo.doOnTextChanged { text, start, count, after ->
            Log.v("prueba", text.toString())

                //si no contiene @ o .
             if (correo.text.toString().contains("@") &&
                 correo.text.toString().contains(".")){
                campocorreo.boxStrokeColor=getColor(R.color.verde)
                 campocorreo.hintTextColor=getColorStateList(R.color.verde)
                 campocorreo.helperText="Correo correcto"
            }else{
                campocorreo.error="Correo no permitido"
            }

        }
        boton = findViewById(R.id.insertar)
        boton.setOnClickListener{Log.d("E2Activity", "Boton pulsado")
            if (nombre.text.toString().isEmpty()){
                layoutNombre.error = "Campo Obligatorio"
            }else{
                layoutNombre.error=null
            }
            if(nombre.text.toString().isEmpty() && nombre.text.toString().length<2){
                layoutNombre.error="Nombre no permitida"
            }else
                layoutNombre.boxStrokeColor=getColor(R.color.verde)

           if (correo.text.toString().isEmpty()){
               campocorreo.error="Campo Obligatorio"
            //si no contiene @ o .
           }else if (correo.text.toString().contains("@") && correo.text.toString().contains(".")){
               campocorreo.error=null
           }else{
               campocorreo.error="Correo no permitido"
           }

        }



    }
}