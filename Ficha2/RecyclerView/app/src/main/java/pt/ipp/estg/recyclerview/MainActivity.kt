package pt.ipp.estg.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pt.ipp.estg.recyclerview.Adapters.ContactAdapter
import pt.ipp.estg.recyclerview.Models.Contact

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contact = Contact("João", true)
        val contact2 = Contact("Zé", false)
        val contact3 = Contact("Joel", true)

        val contactList = listOf<Contact>(contact, contact2, contact3)

        val contactAdapter = ContactAdapter(this, contactList)

        val re = findViewById<RecyclerView>(R.id.rvContacts)
        re.adapter = contactAdapter
        re.layoutManager = LinearLayoutManager(this)
    }

}