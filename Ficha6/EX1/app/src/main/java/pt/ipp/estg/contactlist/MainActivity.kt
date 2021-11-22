package pt.ipp.estg.contactlist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.room.Room
import pt.ipp.estg.contactlist.data_base.ContactDataBase
import pt.ipp.estg.contactlist.fragments.ContactListFragment
import pt.ipp.estg.contactlist.fragments.CreateContactFragment

class MainActivity : AppCompatActivity(), ContactCommunication {

    private lateinit var db: ContactDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(
            this.applicationContext,
            ContactDataBase::class.java,
            "Contacts"
        )
            .allowMainThreadQueries()
            .build()

        val contactListFragment = ContactListFragment().apply {
            val bundle = Bundle()
            bundle.putSerializable("contactsDB", db)
            arguments = bundle
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flMain, contactListFragment)
            commit()
        }

        findViewById<AppCompatButton>(R.id.btnAddContact).setOnClickListener {
            val createContactFragment = CreateContactFragment().apply {
                val bundle = Bundle()
                bundle.putSerializable("contactsDB", db)
                arguments = bundle
            }

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flMain, createContactFragment)
                commit()
            }

            it.visibility = View.INVISIBLE
        }

    }

    override fun contactCreated() {
        val fragment = ContactListFragment().apply {
            val bundle = Bundle()
            bundle.putSerializable("contactsDB", db)
            arguments = bundle
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flMain, fragment)
            commit()
        }

        findViewById<AppCompatButton>(R.id.btnAddContact).visibility = View.VISIBLE
    }


}
