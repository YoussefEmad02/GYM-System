/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym;

/**
 *
 * @author M A
 */
import java.util.Scanner;

public abstract class Person {
    Scanner input =new Scanner(System.in);
    private String name;
    private String gender;

    Gym gym = new Gym();

    public Person(String name, String gender) {
        this.name = name;
        boolean flag=true;
        while(flag) {
            if (gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("Male")) {
                flag=false;
                this.gender = gender;
            } else {
                System.out.println("Error! the input isn't comparable with the gender\nEnter thr gender again ");
                gender=input.nextLine().trim().replaceAll("\\s+","");
                flag=true;
            }
        }

    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public abstract boolean setsession(String name);
}

