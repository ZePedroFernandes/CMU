package pt.ipp.estg.contactlist.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pt.ipp.estg.contactlist.R
import pt.ipp.estg.contactlist.adapter.ContactAdapter
import pt.ipp.estg.contactlist.data_base.ContactDataBase
import pt.ipp.estg.contactlist.models.Contact

class ContactListFragment : Fragment(R.layout.contact_list) {
    private lateinit var contacts: ArrayList<Contact>
    private lateinit var contactsDB: ContactDataBase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            this.contactsDB = it.getSerializable("contactsDB") as ContactDataBase
        }

        this.contacts = this.contactsDB.getContactsDao().getAll() as ArrayList

        view.findViewById<RecyclerView>(R.id.rvContactList).apply {
            adapter = ContactAdapter(
                this@ContactListFragment.contactsDB,
                this@ContactListFragment.contacts
            )
            layoutManager = LinearLayoutManager(this@ContactListFragment.context)
        }
    }
}