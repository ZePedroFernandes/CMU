package pt.ipp.estg.simplefragment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), CommunicationProtocol {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment1 = InputFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flContainer, fragment1)
            commit()
        }


    }

    override fun sendText(text: String) {
        Log.d("lol", text)
        val fragment2 = TextFragment().apply {
            val args = Bundle()
            args.putString("text", text)
            arguments = args
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flContainer, fragment2)
            addToBackStack("SecondFragment")
            commit()
        }
    }
}

interface CommunicationProtocol {
    fun sendText(text: String)
}