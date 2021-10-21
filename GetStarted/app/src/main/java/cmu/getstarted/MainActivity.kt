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

        val mResultado = findViewById<TextView>(R.id.textView3)
        val mEditText = findViewById<EditText>(R.id.editTextNumber)
        val mButton = findViewById<Button>(R.id.button)

        mButton.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {

                if(mEditText.text.toString() == "5") {
                    mResultado.text = "O resultado está certo"
                } else {
                    mResultado.text = "O resultado está errado"
                }
            }
        })
    }
}