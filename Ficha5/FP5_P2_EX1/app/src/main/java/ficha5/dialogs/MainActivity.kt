package ficha5.dialogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity(), LoginCommunicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginDialog = LoginDialog(this)
        loginDialog.show(supportFragmentManager, "login")
    }

    override fun login(username: String, password: String) {
        val infoView: TextView = findViewById(R.id.tvLoginInfo)
        infoView.text = ("$username: $password")
    }
}

interface LoginCommunicator{
    fun login(username: String, password: String)
}