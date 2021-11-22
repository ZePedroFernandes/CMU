package pt.ipp.estg.contactlist.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import pt.ipp.estg.contactlist.ContactCommunication
import pt.ipp.estg.contactlist.R
import pt.ipp.estg.contactlist.data_base.ContactDataBase
import pt.ipp.estg.contactlist.models.Contact

class CreateContactFragment : Fragment(R.layout.contact_create) {

    private lateinit var contactsDB: ContactDataBase
    private lateinit var communication: ContactCommunication
    private lateinit var mContext: Context


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.communication = requireContext() as ContactCommunication

        this.mContext = requireContext()

        arguments?.let {
            this.contactsDB = it.getSerializable("contactsDB") as ContactDataBase
        }

        view.findViewById<Button>(R.id.btnCreateContact).setOnClickListener {
            val name = view.findViewById<EditText>(R.id.etContactName).text.toString()
            val phone = view.findViewById<EditText>(R.id.etContactPhoneNumber).text.toString()
            val regex = Regex("^[0-9]{9}")

            if (!regex.matches(phone)) {
                Toast.makeText(this.context, "Phone must have 9 numbers", Toast.LENGTH_SHORT).show()
            } else {
                if (name != "" && phone != "") {
                    if (contactsDB.getContactsDao().getOne(phone.toInt()) == null) {
                        val contact = Contact(phone.toInt(), name)
                        this.contactsDB.getContactsDao().insertContact(contact)
                        this.communication.contactCreated()
                    } else {
                        Toast.makeText(mContext, "Contact Already Exists", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}