package pt.ipp.estg.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Log.d("SecondActivity","onCreate")

        val textView = findViewById<TextView>(R.id.textView)
        val text = intent.getStringExtra("userInput")

        textView.text = text
    }

    override fun onStart() {
        super.onStart()
        Log.d("SecondActivity","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SecondActivity","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SecondActivity","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SecondActivity","onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("SecondActivity","onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SecondActivity","onDestroy")
    }
}