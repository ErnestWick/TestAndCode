package org.example;

import net.datafaker.Faker;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
import net.datafaker.providers.entertainment.SouthPark;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome to create data Fake.!!");

        Faker faker = new Faker();
        for (int i=0; i<=3; i++)
        {
            System.out.println("First Name: " + faker.name().firstName());
            System.out.println("Last Name: " + faker.name().lastName());
            System.out.println("Age:"+ faker.date().birthday(18,75, "yyyy-mm-dd"));
            System.out.println("City: " + faker.address().city());
            System.out.println("Country:"+faker.address().country());
            System.out.println("Phone:"+ faker.phoneNumber().phoneNumber());
            System.out.println();
        }


    }
}
