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
import java.util.Random;
public class Employee extends SystemAccess{
    public static boolean check1111;
    public static Scanner input=new Scanner(System.in);
    public void register (String userName, String password)
    {
        super.addacount(userName, password);
        System.out.println("Name and Password entered successfully ");
    }

    public Employee() {
    }

public static int membercheck=0;

   public boolean addMember (String memberName,String sessionname,String gender, String mobile,String nationalId,String membership) { //added string session name
        member mem = g.findMember(memberName);
        if (g.findMember(memberName) == null) {
            
           // System.out.println("Enter the gender: ");
           // String gender = input.nextLine().trim().replaceAll("\\s+", "");
           // System.out.println("Enter the mobile: ");
          //  String mobile = input.nextLine().trim().replaceAll("\\s+", "");
          //  System.out.println("Enter the national Id: ");
           // String nationalId = input.nextLine().trim().replaceAll("\\s+", "");
            boolean flag;
            //System.out.println(" type a membership type form the following (open membership - payg - term membership) ");
           // String membership = input.nextLine().trim().toLowerCase().replaceAll("\\s+", "");
            do {
                if (membership.equalsIgnoreCase("payg") || membership.equalsIgnoreCase("openmembership")
                        || membership.equalsIgnoreCase("termmembership")) {
                    flag = false;
                    Memberships mShips = new Memberships(membership);
                    
                } else {
                    System.out.println(membership + " isn't available enter correct one from=");
             //       membership = input.nextLine().trim().replaceAll("\\s+", "");
                    flag = true;
                   
                }
            } while (flag);
            Random rand = new Random();
            int upperbound = 500;
            int int_random = rand.nextInt(upperbound);
            member MeM = new member(memberName, gender,int_random, mobile, membership, nationalId);
            g.members.add(MeM);
            g.findMemberindex(memberName);
         //   System.out.println("Enter the class attended by " + memberName);
            MeM.setsession(sessionname);
        //    System.out.println("member is added successfully");
            return true;
        } else {
            System.out.println("Member " + memberName + " is already in the list.");
            return false;
        }
    }



    private boolean showList(){
        System.out.println("Do you want to edit anything else? \n Type 'yes' for new editing and 'no' to end editing. ");
        if(input.nextLine().trim().replaceAll("\\s+", "").equalsIgnoreCase( "yes")) {
            System.out.println("Choose from the list what you want to update: \n" +
                    "1- update Name \n"+
                    "2- update mobile \n"+
                    "3- update membership \n"+
                    "4- update the sessions attended \n");
            return true ;
        }
        else{
            return false;
        }
    }
   public void editMember (String oldMember, String name,String mobilenumber,String newmembership,  String oldClassAttended,String newClassesHeld) {
        int position =g.findMemberindex(oldMember);
        boolean a;
        
        if (position >= 0) {
            //System.out.println("Choose from the list what you want to update: \n" +
             //       "1- update Name \n" +
               //     "2- update mobile \n" +
                  //  "3- update membership \n" +
                   // "4- update the sessions attended \n");
           // int ask = input.nextInt();
           /// boolean fg=true;
          //  do {
               // switch (ask) {
                  //  case 1:
                        System.out.println("Enter the new name ");
                       // input.nextLine();
                       // String name = input.nextLine().trim().replaceAll("\\s+", "");
                        g.members.get(position).setName(name);
                        System.out.println("The name " + name + " is added successfully.");
                        a = showList();
                  //  if (a)
                  //  {
                       // fg=true;
                       // ask=input.nextInt();
                      //  break ;
                   // }
                   // else {
                    //    fg=false;
                    //    break;
                    //    }
                //    case 2:
                  //      System.out.println("Enter the new mobile: ");
                  //      input.nextLine();
                        g.members.get(position).setMobile(mobilenumber);
                        System.out.println("Mobile is updated sucessfully");
                    a=showList();
                  //  if (a)
                   // {
                    //    fg=true;
                    //    ask=input.nextInt();
                    //    break ;
                 //   }
                 //   else {
                   //     fg=false;
                  //      break;
                    }
                  //  case 3:
                    //    System.out.println("Enter the new membership: ");
                    //    input.nextLine();
                        g.members.get(position).setMembership(newmembership);
                        System.out.println("Membership is updated sucessfully");
                        a = showList();
//                    if (a)
//                    {
//                        ask=input.nextInt();
//                        fg=true;
//                        break ;
//                    }
//                    else {
//                        fg=false;
//                        break;
//                    }
            //        case 4:
                       // System.out.println("Enter the name of session you want to update: ");
                       // String oldClassAttended = input.next().trim().replaceAll("\\s+","");

                        if (g.findSessions(oldClassAttended)>=0) {
                            int indexClassesHeld = g.members.get(position).findClassAttended(oldClassAttended);
                            if(indexClassesHeld>=0){
                           // System.out.println("Enter the new classes attended  : ");
                           // input.nextLine();
                           // String newClassesHeld = input.nextLine().trim().replaceAll("\\s+","");
                            if(g.findSessions(newClassesHeld)>=0){
                                g.members.get(position).getClassesAttended().get(indexClassesHeld).setName(newClassesHeld);
                                System.out.println("Classes are updated successfully");
                            } else {
                                System.out.println(newClassesHeld + "isn't available at the gym, can't update");
                            }
                            }
                            else{
                                System.out.println(oldClassAttended + " isn't found in your classes that member trains " );
                            }
                        }else {
                            System.out.println(oldClassAttended+ " isn't in the available classes that the gym offer.");
                        }
                        a = showList();
                        check1111=true;
//                    if (a)
//                    {
//                        fg= true;
//                        ask=input.nextInt();
//                        break ;
//                    }
//                    else {
//                        fg=false;
//                        break;
//                   // }
                //default:
                  //  System.out.println("The number entered is invalid.\n Please enter the number again: ");
                  //  ask=input.nextInt();
                   // fg=true;
                  //  break ;
              //  }
           // } while (fg);
        }
    
       // else {
         //   System.out.println("Member "+ oldMember +" isn't found in the list og gym members. ");
          //      }
           // }

    public boolean deleteMember (String removeMember){
        member mem = g.findMember(removeMember);
        if(mem!=null) {
            g.members.remove(mem);
            System.out.println(mem.getName()+" was deleted");
            return true;
        }
        else {
            System.out.println(mem.getName() + " isn't found on the list.");
            return false;
        }
    }
    public boolean addMemberSessions (String nameSession, String nameMember){
        int findSessions =g.findSessions(nameSession);
        if(findSessions>=0 ){
            g.addMember(nameMember,findSessions);
            return true;
        }
        else {
            System.out.println("The "+ nameSession +" isn't found.");
            return false;
        }
    }
    public boolean removeMemberSessions (String nameSession, String nameMember){
      int findSessions =g.findSessions(nameSession);
        if(findSessions>=0 ){
            g.removeMember(nameMember,findSessions);
            return true;
        }
        else {
            System.out.println("The "+ nameSession +" isn't found.");
            return false;
        }
    }
    @Override
    public boolean signIn(String inputun,String inputpw){
      
        if (super.Account.contains(inputun)&& super.Account.contains(inputpw)){
            return true;
        }
        else{
            return false;
        }

    }
}


