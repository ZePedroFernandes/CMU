package pt.ipp.estg.contactlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pt.ipp.estg.contactlist.ContactCommunication
import pt.ipp.estg.contactlist.R
import pt.ipp.estg.contactlist.models.Contact

class ContactAdapter(
    private val communicator: ContactCommunication,
    private val contacts: List<Contact>

) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvPhoneNumber: TextView = view.findViewById(R.id.tvPhone)
        val btnDelete: Button = view.findViewById(R.id.btnDeleteContact)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_details, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact: Contact = this.contacts[position]

        holder.apply {
            tvName.text = contact.name
            val phone = contact.phone.toString()
            val regex = Regex("^(?<a>[0-9]{3})(?<b>[0-9]{3})(?<c>[0-9]{3})\$")
            val group = regex.matchEntire(phone)?.groups

            if (group != null) {
                tvPhoneNumber.text =
                    (group[1]!!.value + " " + group[2]!!.value + " " + group[3]!!.value)
            } else {
                tvPhoneNumber.text = phone
            }


            btnDelete.setOnClickListener {
                communicator.deleteContact(contact)
                this@ContactAdapter.notifyItemRemoved(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}