package pt.ipp.estg.recyclerview.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import pt.ipp.estg.recyclerview.ChatActivity
import pt.ipp.estg.recyclerview.Models.Contact
import pt.ipp.estg.recyclerview.R

class ContactAdapter(val context: Context, private val contacts: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contactName: TextView
        val isOnline: ImageView
        val btnMessage: Button

        init {
            contactName = view.findViewById(R.id.tvContactName)
            isOnline = view.findViewById(R.id.ivOnline)
            btnMessage = view.findViewById(R.id.btnMessage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]

        if (contact.online) {
            holder.isOnline.background =
                ContextCompat.getDrawable(this.context, R.drawable.green_circle)
        } else {
            holder.isOnline.background =
                ContextCompat.getDrawable(this.context, R.drawable.red_circle)
        }

        holder.contactName.text = contact.name
        holder.btnMessage.setOnClickListener {
            val openChat = Intent(context, ChatActivity::class.java).apply {
                putExtra("contactName", contact.name)
            }

            context.startActivity(openChat)
        }

    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}