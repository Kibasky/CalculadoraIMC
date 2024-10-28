package com.example.androidejercicio1

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractica.R
import java.util.Locale
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    lateinit var heightEditText: EditText
    lateinit var weightEditText: EditText
    lateinit var calculateButton: Button
    lateinit var resultTextView : TextView
    lateinit var imageView1: ImageView
    lateinit var imageView2: ImageView
    lateinit var imageView3: ImageView
    lateinit var imageView4: ImageView
    lateinit var imageView5: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        heightEditText = findViewById(R.id.heightEditText)
        weightEditText = findViewById(R.id.weightEditText)
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTestView)
        imageView1 = this.findViewById(R.id.imageView1)
        imageView2 = this.findViewById(R.id.imageView2)
        imageView3 = this.findViewById(R.id.imageView3)
        imageView4 = this.findViewById(R.id.imageView4)
        imageView5 = this.findViewById(R.id.imageView5)

        //imageView.setImageResource(R.drawable.imc1)
        //getDrawable(R.drawable.imc1)
        calculateButton.setOnClickListener {
            // hacemos que al pulsar el boton, desaparezca el teclado virtual. este aparece
            // de nuevo al pulsar el input:
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)

            //Log.i ("MainActivity", "He pulsado el boton calcular")
            //Log.i("MainActivity", "La altura es: $height y el peso es: $weight")
            val height = heightEditText.text.toString().toFloat()
            val weight = weightEditText.text.toString().toFloat()
            val result = weight / (height / 100).pow(2)

            resultTextView.text = String.format(Locale.getDefault(), "%.2f", result)

            when (result) {
                in (0.0..18.5) -> { imageView1.visibility = View.VISIBLE }
                in (18.5..25.0) -> { imageView2.visibility = View.VISIBLE }
                in (25.0..30.0) -> { imageView3.visibility = View.VISIBLE}
                in (30.0..35.0) -> { imageView4.visibility = View.VISIBLE}
                in (35.0..300.0) -> { imageView5.visibility = View.VISIBLE }
                else -> { imageView1.visibility = View.GONE}


                }



            }
        }

}