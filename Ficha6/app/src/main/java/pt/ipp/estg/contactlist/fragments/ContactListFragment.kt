package pt.ipp.estg.contactlist.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pt.ipp.estg.contactlist.ContactCommunication
import pt.ipp.estg.contactlist.R
import pt.ipp.estg.contactlist.adapter.ContactAdapter
import pt.ipp.estg.contactlist.models.Contact

class ContactListFragment : Fragment(R.layout.contact_list) {
    private lateinit var communicator: ContactCommunication
    private lateinit var contacts: List<Contact>

    override fun onAttach(context: Context) {
        super.onAttach(context)

        this.communicator = context as ContactCommunication
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments.let {
            this.contacts = it!!.getSerializable("contactsList") as List<Contact>
        }

        view.findViewById<RecyclerView>(R.id.rvContactList).apply {
            adapter = ContactAdapter(
                this@ContactListFragment.communicator,
                this@ContactListFragment.contacts
            )
            layoutManager = LinearLayoutManager(this@ContactListFragment.requireContext())
        }
    }
}