package com.example.learnjava;

import java.util.ArrayList;

public class MyClass {

    public static void main(String[] args) {
//        Phone phone1 = new Phone("Apple", "Space Grey", 6 );
////        Phone phone2 = new Phone("Samsung", "Midnight Blue", 6.5f );
////        Phone phone3 = new Phone("YU",  6.0f );
////        phone.manufacturer = "Apple";
////        phone.color = "Space Grey";
////        phone.size = 6.1f;
//
//
//        Object obj = new Object("Apple", 10, "Phone");
//        System.out.println(obj.getSize());
//
////        System.out.println(phone1.getManufacturer() /*+ " "+ phone2.getManufacturer() + " " +phone3.getManufacturer()*/);

        ArrayList names = new ArrayList();
        names.add("Mohit");
        names.add("Pushkar");
        names.add("Suvarna");
        names.add("Just a name");


//        for(java.lang.Object name: names) {
//            System.out.println("Name: " + name);
//        }

        for(int i = 0; i < names.size(); i++){
            System.out.println(names.get(i));
        }



    }

}