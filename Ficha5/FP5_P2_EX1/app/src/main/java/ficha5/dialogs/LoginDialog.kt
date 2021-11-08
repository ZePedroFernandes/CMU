package ficha5.dialogs

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class LoginDialog(private val loginCommunicator: LoginCommunicator) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val myView: View = requireActivity().layoutInflater.inflate(R.layout.dialog_login, null)
            builder.setView(myView)

                .setPositiveButton(R.string.sign_in,
                    DialogInterface.OnClickListener { dialog, id ->

                        val usernameInput = myView.findViewById<EditText>(R.id.username)
                        val passwordInput = myView.findViewById<EditText>(R.id.password)
                        val username : String = usernameInput.text.toString()
                        val password: String = passwordInput.text.toString()
                        loginCommunicator.login(username, password)

                    })
                .setNegativeButton(R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id ->
                        dialog.cancel()
                        loginCommunicator.login("username", "password")
                    })

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}