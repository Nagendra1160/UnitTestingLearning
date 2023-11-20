package com.learning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
class ContactManagerTest {

    private ContactManager cm;

    @BeforeEach
    public void setData()
    {
      //  System.out.println("Before executing  each test method...this method will execute ");
         cm=new ContactManager();
    }
    @Test
    @DisplayName("Adding new contact")
    public void addingNewContact()
    {
        //ContactManager cm=new ContactManager();
        cm.addContact("Nagendra","Thoram","0498765432");

        Assertions.assertEquals(1,cm.getAllContacts().size());
    }

    @Test
    @DisplayName("Adding new contact with null value")
    public void addingNewContactWithMissingFirstName()
    {
        //ContactManager cm=new ContactManager();
        Assertions.assertThrows(RuntimeException.class,()->cm.addContact(null,"Thoram","0498765432"));

        //Assertions.assertEquals(1,cm.getAllContacts().size());
    }

    @Test
    @DisplayName("validating contact number length")
    public void validateContactNoLength()
    {
        //ContactManager cm=new ContactManager();


        Assertions.assertThrows(RuntimeException.class,()->cm.addContact("Nagendra","Thoram","0498865432933"));
    }



    @Test
    @DisplayName("validating contact number ends with")
    public void validateContactNoLengthEndsWith()
    {
        //ContactManager cm=new ContactManager();


        Assertions.assertThrows(RuntimeException.class,()->cm.addContact("Nagendra","Thoram","0498688954329"));
    }
    @Test
    @DisplayName("validating contact number starts with")
    public void validateContactNoLengthStartsWith()
    {
        //ContactManager cm=new ContactManager();


        Assertions.assertThrows(RuntimeException.class,()->cm.addContact("Nagendra","Thoram","498654329"));
    }
}
