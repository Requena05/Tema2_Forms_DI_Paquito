package com.example.tema2_forms_di_paquito

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class E3Activity : AppCompatActivity() {
    private lateinit var nombre: TextInputEditText
    private lateinit var layoutNombre: TextInputLayout
    private lateinit var boton: Button
    private lateinit var campocorreo: TextInputLayout
    private lateinit var correo: TextInputEditText
    private lateinit var campocontraseña: TextInputLayout
    private lateinit var contraseña: TextInputEditText
    private var esnombrevalid : Boolean=false
    private var escorreovalid : Boolean=false
    private var escontraseñavalid : Boolean=false
    private lateinit var fecha: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_e3)
        layoutNombre=findViewById(R.id.camponombre)
        nombre=findViewById(R.id.nombre)
        correo=findViewById(R.id.correo)
        campocorreo=findViewById(R.id.campocorreo)
        boton = findViewById(R.id.insertar)
        campocontraseña=findViewById(R.id.campocontraseña)
        contraseña=findViewById(R.id.contraseña)
        fecha=findViewById(R.id.fecha)

        fecha.setOnClickListener{
            val buider= MaterialDatePicker.Builder.datePicker()
            val modalQueSeAbre=buider.build()
            modalQueSeAbre.show(supportFragmentManager,"DATE_PICKER")
            modalQueSeAbre.addOnPositiveButtonClickListener {
                fecha.setText(modalQueSeAbre.headerText)

                //el usuario no puede ser menor de edad
            if(modalQueSeAbre.selection!! > System.currentTimeMillis() - 315360000000  ){
                fecha.error="Fecha no valida"
            }else{
                fecha.error=null
            }
            }

        }



        nombre.doOnTextChanged { text, start, count, after ->


            if (nombre.text.toString().length < 2) {
                layoutNombre.error = "Nombre no permitido"
                esnombrevalid=false
                comprobarForm()

            }else{
                layoutNombre.boxStrokeColor = getColor(R.color.verde)
                layoutNombre.helperText="Nombre correcto"
                layoutNombre.hintTextColor=getColorStateList(R.color.verde)
                layoutNombre.setHelperTextColor(getColorStateList(R.color.verde))
                layoutNombre.setEndIconActivated(true)
                layoutNombre.setEndIconDrawable(R.drawable.baseline_check_box_24)
                layoutNombre.setEndIconTintList(getColorStateList(R.color.verde))
                esnombrevalid=true
                comprobarForm()
            }
        }


        correo.doOnTextChanged { text, start, count, after ->


            //si no contiene @ o .
            if (correo.text.toString().contains("@") &&
                correo.text.toString().contains(".")
            ) {
                escorreovalid=true
                campocorreo.boxStrokeColor = getColor(R.color.verde)
                campocorreo.hintTextColor = getColorStateList(R.color.verde)
                campocorreo.helperText = "Correo correcto"
                campocorreo.hintTextColor = getColorStateList(R.color.verde)
                campocorreo.setHelperTextColor(getColorStateList(R.color.verde))
                campocorreo.setEndIconActivated(true)
                campocorreo.setEndIconDrawable(R.drawable.baseline_check_box_24)
                campocorreo.setEndIconTintList(getColorStateList(R.color.verde))
                comprobarForm()
            } else {
                escorreovalid=false
                campocorreo.error = "Correo no permitido"
                comprobarForm()
            }
        }
        contraseña.doOnTextChanged { text, start, count, after ->
            if (contraseña.text.toString().length > 6) {
                escontraseñavalid=true
                campocontraseña.boxStrokeColor = getColor(R.color.verde)
                campocontraseña.hintTextColor = getColorStateList(R.color.verde)
                campocontraseña.helperText = "contraseña valida"
                campocontraseña.hintTextColor = getColorStateList(R.color.verde)
                campocontraseña.setHelperTextColor(getColorStateList(R.color.verde))
                campocontraseña.setEndIconActivated(true)
                campocontraseña.setEndIconDrawable(R.drawable.baseline_check_box_24)
                campocontraseña.setEndIconTintList(getColorStateList(R.color.verde))
                comprobarForm()



            } else {
                campocontraseña.error = "Contraseña no permitida"
                escontraseñavalid=false
                comprobarForm()
            }
        }


    }
    private fun comprobarForm() {
        if (escorreovalid && esnombrevalid && escontraseñavalid) {
            boton.visibility = View.VISIBLE
        }else
            boton.visibility= View.GONE
    }
}