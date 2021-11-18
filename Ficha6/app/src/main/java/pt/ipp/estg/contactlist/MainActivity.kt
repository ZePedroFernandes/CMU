package pt.ipp.estg.contactlist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import pt.ipp.estg.contactlist.fragments.CreateContactFragment
import pt.ipp.estg.contactlist.fragments.ContactListFragment
import pt.ipp.estg.contactlist.models.Contact
import java.io.Serializable

class MainActivity : AppCompatActivity(), ContactCommunication {

    private val contacts = contactList<Contact>()

    inner class contactList<Contact>() : ArrayList<Contact>(), Serializable {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contactListFragment = ContactListFragment().apply {
            val bundle = Bundle()
            bundle.putSerializable("contactsList", this@MainActivity.contacts)
            arguments = bundle
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flMain, contactListFragment)
            commit()
        }

        findViewById<AppCompatButton>(R.id.btnAddContact).setOnClickListener{
            val createContactFragment = CreateContactFragment()

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flMain, createContactFragment)
                commit()
            }

            it.visibility = View.INVISIBLE
        }

    }

    override fun deleteContact(contact: Contact) {
        this.contacts.remove(contact)

    }

    override fun createContact(contact: Contact) {
        this.contacts.add(contact)

        val fragment = ContactListFragment().apply {
            val bundle = Bundle()
            bundle.putSerializable("contactsList", this@MainActivity.contacts)
            arguments = bundle
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flMain, fragment)
            commit()
        }

        findViewById<AppCompatButton>(R.id.btnAddContact).visibility = View.VISIBLE
    }


}
