package cmu.getstarted

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var counter = 0

        val mResultado = findViewById<TextView>(R.id.textView3)
        val equation = findViewById<TextView>(R.id.textView2)
        val mEditText = findViewById<EditText>(R.id.editTextNumber)
        val mButton = findViewById<Button>(R.id.button)
        val counterText = findViewById<TextView>(R.id.correctCounter)
        counterText.text = "Repostas certas: " + counter

        var a = (Math.random() * 10).toInt()
        var b = (Math.random() * 10).toInt()
        equation.text = "" + a + " + " + b + " = x"

        mButton.setOnClickListener { v ->
            val response = mEditText.text.toString().toInt()
            Log.d("Response", response.toString())
            if ( response == (a+b)) {
                mResultado.text = "O resultado está certo"
                counter++
                counterText.text = "Repostas certas: " + counter
            } else {
                mResultado.text = "O resultado está errado"
                counter = 0
                counterText.text = "Repostas certas: " + counter
            }
            a = (Math.random() * 10).toInt()
            b = (Math.random() * 10).toInt()
            equation.text = "" + a + " + " + b + " = x"

        }
    }
}
