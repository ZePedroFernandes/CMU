package pt.ipp.estg.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity","onCreate")

        val input = findViewById<EditText>(R.id.editText)
        val toastButton = findViewById<Button>(R.id.toastButton)
        val activityButton = findViewById<Button>(R.id.activityButton)

        toastButton.setOnClickListener {
            Toast.makeText(applicationContext,input.text.toString(),Toast.LENGTH_SHORT).show()
        }

        activityButton.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("userInput",input.text.toString())
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity","onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity","onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity","onDestroy")
    }
}