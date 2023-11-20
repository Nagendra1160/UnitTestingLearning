package com.learning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
class ContactManagerTest {

    @Test
    @DisplayName("Adding new contact")
    public void addingNewContact()
    {
        ContactManager cm=new ContactManager();
        cm.addContact("Nagendra","Thoram","0498765432");

        Assertions.assertEquals(1,cm.getAllContacts().size());
    }
}
