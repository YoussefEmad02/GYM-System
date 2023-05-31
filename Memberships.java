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

public class Memberships {

    private  double membership_price;
    Scanner input= new Scanner(System.in);


    public Memberships(String membership_type) {
        boolean s;
        do {
            switch (membership_type) {
                case "payg":
                    membership_price = 300;
                    System.out.println("The price of payg: " + membership_price);

                   s=false;
                    break;
                case "openmembership":
                    membership_price = 800;

                    System.out.println("The price of open membership: " + membership_price);
                    s=false;
                    break;

                case "termmembership":

                    s=false;
                    System.out.println("six months or a year?");
                    String period = input.nextLine().trim().replaceAll("\\s+", "");
                    boolean t;
                    do {
                        if (period.equalsIgnoreCase("sixmonths")) {
                            membership_price = 2500;
                            System.out.println("The price of term membership of six months : " + membership_price);
                            t = false;
                            break;
                        } else if (period.equalsIgnoreCase("year")) {
                            membership_price = 4200;
                            System.out.println("The price of term membership of one year : " + membership_price);
                            t = false;
                            break;
                        } else {
                            System.out.println("Error, Enter correct period of subscription");
                            period = input.nextLine().trim().replaceAll("\\s+", "");
                            t = true;
                        }
                    } while (t);
                    break;
                default:
                    System.out.println("Error, Enter correct membership");
                    membership_type = input.nextLine().trim().replaceAll("\\s+", "");
                    s=true;
                    break;
            }
        }while(s);
    }

}

