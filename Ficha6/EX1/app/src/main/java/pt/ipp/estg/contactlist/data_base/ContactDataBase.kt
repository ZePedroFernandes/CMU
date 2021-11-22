package pt.ipp.estg.contactlist.data_base

import androidx.room.Database
import androidx.room.RoomDatabase
import pt.ipp.estg.contactlist.models.Contact
import java.io.Serializable


@Database(entities = [Contact::class], version = 1)
abstract class ContactDataBase : RoomDatabase(), Serializable {

    abstract fun getContactsDao(): ContactsDao

}