package pt.ipp.estg.contactlist.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import pt.ipp.estg.contactlist.ContactCommunication
import pt.ipp.estg.contactlist.R
import pt.ipp.estg.contactlist.models.Contact

class CreateContactFragment : Fragment(R.layout.contact_create) {

    private lateinit var communicator: ContactCommunication

    override fun onAttach(context: Context) {
        super.onAttach(context)

        this.communicator = context as ContactCommunication
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btnCreateContact).setOnClickListener {
            val name = view.findViewById<EditText>(R.id.etContactName).text.toString()
            val phone = view.findViewById<EditText>(R.id.etContactPhoneNumber).text.toString()
            val regex = Regex("^[0-9]{9}")


            if (!regex.matches(phone)) {
                Toast.makeText(this.context, "Phone must have 9 numbers", Toast.LENGTH_LONG).show()
            } else {
                if (name != "" && phone != "") {
                    val contact = Contact(name, phone.toInt())
                    this.communicator.createContact(contact)
                }
            }
        }
    }
}