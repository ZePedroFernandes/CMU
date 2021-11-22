package pt.ipp.estg.contactlist.data_base

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import pt.ipp.estg.contactlist.models.Contact

@Dao
interface ContactsDao {
    @Insert
    fun insertContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)

    @Query("SELECT * FROM Contact")
    fun getAll(): List<Contact>

    @Query("SELECT * FROM Contact WHERE phone=:phone")
    fun getOne(phone: Int): Contact?

}