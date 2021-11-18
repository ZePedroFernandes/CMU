package pt.ipp.estg.contactlist

import pt.ipp.estg.contactlist.models.Contact

interface ContactCommunication {

    fun deleteContact(contact: Contact)

    fun createContact(contact: Contact)
}