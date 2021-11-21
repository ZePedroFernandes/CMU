package pt.ipp.estg.contactlist.models

import androidx.room.*

@Entity
data class Contact(
    @PrimaryKey val phone: Int,
    val name: String
) {
}