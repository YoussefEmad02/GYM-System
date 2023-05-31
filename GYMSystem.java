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

public class GYMSystem {
      static SystemAccess sa = new SystemAccess();
      static Employee e = new Employee();
      static admin a = new admin(sa.g.getMembers());
    public static void main(String[] args) {
        
       Scanner s = new Scanner(System.in);
        System.out.println("welcome to GYM");
        System.out.println("get started!");
        
        System.out.println("The available sessions in the gym is:\n" +
                "1-crossfit\n2-calisthenics\n3-weightlifting\n4-yoga\n5-hiit\n6-kickboxing");
        System.out.println("type admin to sign in as admin, or employee to register as employee ");
        String c = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");



        switch(c)
        {
            case "admin" :
            String ans;
            a.signIn();
                System.out.println("Start by Type class to view members in a class "
                        + "or membership to view members of a specific type of membership or info to view member info");
                String u = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
                switch (u)
                { case "class":
                    System.out.println("enter name of class ");
                    String sessionname1 = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
                    a.ViewMemberInSession(sessionname1);;
                    break;

                    case"membership":
                        System.out.println("enter name of membership ");
                        String membershipname = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
                         a.ViewMemberInMembership(membershipname);

                        break;

                    case "info":
                        a.ViewMemberInfo();
                        break;
                }
            System.out.println("For adding a trainer \nenter the following requirements");
            System.out.println("enter name of trainer ");
            String trainername = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
            a.addtrainer(trainername);
            boolean flag;
            do {
                System.out.println("do you want to add another trainer? (yes-no) ");
                ans = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
                if (ans.equalsIgnoreCase("yes")) {
                    flag=true;
                    System.out.println("enter name of trainer ");
                    String trainername1 = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
                    a.addtrainer(trainername1);
                }
                else {
                    flag=false;
                }


            } while(flag );


            System.out.println("Type edit to edit added trainers or delete to delete a trainer");
            String k = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");

            switch (k)
            { case "edit":
                System.out.println("enter name of trainer ");
                String trainername2 = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
                a.edittrainer(trainername2);
                break;

                case"delete":
                    System.out.println("enter name of trainer ");
                    String trainername3 = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
                    a.deletetrainer(trainername3);

                    break;

            }


            System.out.println("Choose from the following operations to do on classes:\noType open to view class details\ntype edit to edit a class\ntype Delete to delete a class ");
            String p = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");

            switch (p)
            { case "open":
                System.out.println("enter name of class ");
                String session0 = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
                a.opensessions(session0);
                break;

                case"delete":
                    System.out.println("enter name of class ");
                    String session1 = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
                    a.deletesession(session1);
                    break;

                case "edit":
                    System.out.println("enter name of class ");
                    String session2 = s.nextLine();
                    a.editsession(session2);
                    break;

            }




            System.out.println("Do yo want to assign member to trainer? (yes/no)");
            String anstoq = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
            if(anstoq.equalsIgnoreCase("yes"))
            {
                System.out.println("enter name of trainer ");
                String trainername4 = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
                System.out.println("enter name of member ");
                String membername4 = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
                a.assigntrainertomember(trainername4, membername4);
            }



            System.out.println("Do you want to check trainer availability? (yes/no)");
            String anstoques = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
            if(anstoques.equalsIgnoreCase("yes"))
            {

                a.checkAvailabilityTrainer();
            }
            else {break;}




            System.out.println("Do yo want to sign out? (yes/no)");
            String anstoq4 = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
            if(anstoq4.equalsIgnoreCase("yes"))
            {
                a.signOut();
            }
            else {break;}

            break;


            case "employee" :


                System.out.println("enter employee username ");
                String username = s.nextLine();
                System.out.println("enter employee password ");
                String password = s.nextLine();
                e.register(username, password);
                System.out.println("CONGRATS!you have created account as employee succesffuly \nnow you can sign in:");
                e.signIn();
                System.out.println("start by viewing --> type class to view members in a class "
                        + "or membership to view members of a specific type of membership or info to view member info");
                String l = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");

                switch (l)
                { case "class":
                    System.out.println("enter name of class ");
                    String sessionname1 = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
                    e.ViewMemberInSession(sessionname1);
                    break;

                    case"membership":
                        System.out.println("enter name of membership ");
                        String membershipname = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
                        e.ViewMemberInMembership(membershipname);

                        break;

                    case "info":
                        e.ViewMemberInfo();
                        break;
                }

                System.out.println("for adding a member \nenter the following requirements");
                System.out.println("enter name of members ");
                String membernaem = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
                e.addMember(membernaem);
                boolean flag1;
                do {
                    System.out.println("do you want to add another member? (yes-no) ");
                    ans = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
                    if (ans.equalsIgnoreCase("yes"))
                    {flag1=true;}
                    else {
                        flag1=false;
                    break;}
                    System.out.println("enter name of member ");
                    String membername1 = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
                    e.addMember(membername1);

                } while(flag1 );


                System.out.println("Type edit to edit added members or delete to delete a member");
                String o = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");

                switch (o)
                { case "edit":
                    System.out.println("enter name of member ");
                    String membername2 = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
                    e.editMember(membername2);
                    break;

                    case"delete":
                        System.out.println("enter name of member ");
                        String membername3 = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
                        e.deleteMember(membername3);

                        break;
                }




                System.out.println("Do you want to add  member in session? (yes/no)");
                String anstoq2 = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");

                if(anstoq2.equalsIgnoreCase("yes")) {

                    System.out.println("Enter name of session ");
                    String nameofsession = s.nextLine().trim().toLowerCase().replaceAll("\\s+", "");
                    System.out.println("Enter name of member ");
                    String nameofmember = s.nextLine().trim().toLowerCase().replaceAll("\\s+", "");
                    e.addMemberSessions(nameofsession, nameofmember);
                    System.out.println("Do you want to remove member in session(yes/no)?");
                    String t = s.nextLine().trim().toLowerCase().replaceAll("\\s+", "");
                    if (t.equalsIgnoreCase("yes")) {
                        System.out.println("Enter name of session ");
                        String nameofsession1 = s.nextLine().trim().toLowerCase().replaceAll("\\s+", "");
                        System.out.println("Enter name of member ");
                        String nameofmember1 = s.nextLine().trim().toLowerCase().replaceAll("\\s+", "");
                        e.removeMemberSessions(nameofsession1, nameofmember1);
                    }

                }


                    System.out.println("Do yo want to sign out? (yes/no)");
                    String anstoq5 = s.nextLine().trim().toLowerCase().replaceAll("\\s+","");
                    if(anstoq5.equalsIgnoreCase("yes"))
                    {
                        e.signOut();
                    }
                    else {break;}
                    break;


                }
           }


    }


