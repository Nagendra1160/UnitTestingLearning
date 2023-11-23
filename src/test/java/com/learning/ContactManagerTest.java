package com.learning;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class ContactManagerTest {

    private ContactManager cm;

    @BeforeAll
    public static void BeforeAllMethod()
    {
        System.out.println("Hi before all method should be static as it executed only once");
    }

    @Test
    @RepeatedTest(value = 3)
    public void repeatedTest()
    {
        System.out.println("This method is being executed for 5 times");
    }

    @Disabled //it is both method level & class level
    @Test
    public void findMember()
    {
        System.out.println("This test case is excluded from being executed");
    }
    @AfterAll
    public static void AfterAllMethod1()
    {
        System.out.println("Hi after all method should be static as it executed only once");
    }
    @BeforeEach
    public void setData()
    {
      System.out.println("After executing  each test method...this method will execute ");
         //cm=new ContactManager();
    }

    @AfterEach
    public void afterEachTest()
    {
        System.out.println("After each test case it will be executed");
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


        Assertions.assertThrows(RuntimeException.class,()->cm.addContact("Nagendra","Thoram","0987654321"));
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

    @Test
    @DisplayName("Checking contact exist or not")
    public void checkContactExitOrNot()
    {
        //ContactManager cm=new ContactManager();

        cm.addContact("Nagendra","Thoram","0987654321");
        Assertions.assertThrows(RuntimeException.class,()->cm.addContact("Nagendra","Thoram","0987654321"));
    }

    public static List<Integer> intStreamOfEven()
    {
        return IntStream.range(1,100).filter(i->i%2==0).boxed().collect(Collectors.toList());
    }

    @ParameterizedTest
    @MethodSource("intStreamOfEven")
    public void findTestOnEven(List<Integer> in)
    {
        boolean b=in.stream().allMatch(i->i%2==0);
      Assertions.assertTrue(b,"valid all");
    }

    @ParameterizedTest
    @DisplayName("Value Source is used to provide a simple source of values for parameterized tests")
    @ValueSource(strings ={"aaa","bbdb","ccc"})
    public void allStringLenSame(String s)
    {
        Assertions.assertEquals(3,s.length());
    }


    @ParameterizedTest
    @DisplayName("Value Source is used to provide a simple source of values for parameterized tests")
    @CsvSource({"aaa","bbdb","ccc"})
    public void allStringLenSameCSV(String s)
    {
        Assertions.assertTrue(s.startsWith("a"));
    }


    @ParameterizedTest
    @DisplayName("Value Source is used to provide a simple source of values for parameterized tests")
    @CsvFileSource(resources = "/Data.csv")
    public void csvSourceFile(String s)
    {
        //System.out.println(s.charAt(0));
        Assertions.assertTrue(Character.isUpperCase(s.charAt(0)));
    }



}
