package pt.ipp.estg.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pt.ipp.estg.recyclerview.Adapters.ContactAdapter
import pt.ipp.estg.recyclerview.Models.Contact

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contactList = mutableListOf<Contact>()

        for (i in 0..200) {
            contactList.add(Contact("name $i", true))
        }

        val contactAdapter = ContactAdapter(this, contactList)

        val re = findViewById<RecyclerView>(R.id.rvContacts)
        re.adapter = contactAdapter
        re.layoutManager = LinearLayoutManager(this)
    }

}