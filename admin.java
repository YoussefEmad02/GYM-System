/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym;

/**
 *
 * @author M A
 */
import java.util.ArrayList;
import java.util.Arrays;

public class admin extends SystemAccess{
 private ArrayList <member> memberinAdmin=new ArrayList<member>();
  public static int xcheck=0;

    public admin(ArrayList<member> m) {
         this.memberinAdmin=m;
    }

    admin() {
        
    }


    protected int findMemberindex (String Name){
        for (int i=0;i<this.memberinAdmin.size();i++){
            member mem= memberinAdmin.get(i);
            if(mem.getName().equalsIgnoreCase(Name))
                return i;
        }
        return -1;
    }
    static  boolean trainercheck;
    public boolean assigntrainertomember(String Trainername, String membername)  ////edited 25/5
    {
    
        int index=g.findtrainerindex(Trainername);
        if (index>=0)
        {
             trainercheck=true;
            int position =findMemberindex(membername);
            if(position>=0)
            {
               
                memberinAdmin.get(position).setTrainerName(Trainername);
                System.out.println("Trainer "+ Trainername+ " is assigned to " + membername);
             //    return true;
             xcheck=1;
            }
            else {
                System.out.println (" Member is not found "); }
          // return false;
          xcheck=0;
        }
        else {
            System.out.println (" Trainer is not found ");
            trainercheck=false;
        }
    
    return trainercheck;
}

   public int findtrainer (String Name){
        for (int i=0;i<g.getTrainers().size();i++){
            trainer t= g.getTrainers().get(i);
            if(t.getName().equalsIgnoreCase(Name))
                return i;
        }
        return -1;
    }

    public void addtrainer(String name,String gender,String sessionname)
    {
        int  t = findtrainer (name);
        if (t<0){
            trainer t1 = new trainer(name,gender);
            g.getTrainers().add(t1);
            System.out.println("Enter the class held by trainer: ");
            t1.setsession(sessionname);
            System.out.println("trainer "+ name +" is added");
        }
    else {
            System.out.println("trainer " + name + " already exists.");
        }
    }


    public void deletetrainer (String deletename)
    {
        int t=g.findtrainerindex(deletename);
        if ( t >=0)
        {
            System.out.println("trainer "+ g.getTrainers().get(t).getName()+" is deleted.");
            g.getTrainers().remove(t);

        }
        else {
            System.out.println("trainer " + g.getTrainers().get(t).getName() + " is not found.");
        }
    }


    public void edittrainer(String name,String oldClassHeld,String newName,String newClassesHeld) {

        int position = g.findtrainerindex(name);
        if (position >= 0) {
           // System.out.println("Choose from the list what you want to update: \n" +
             //       "1- update Name \n" +
            //        "2-update classes held by the trainer");
       //     int ask = input.nextInt();
        //    boolean flag = true;
           // do {
               // switch (ask) {
               //     case 1:
                        //System.out.println("Enter the new name ");
                     //   input.nextLine();
                         //= input.next().trim().replaceAll("\\s+", "");
                        g.getTrainers().get(position).setName(newName);
                      System.out.println("The name " + newName + " is updated successfully.");
                       // System.out.println("Do you want to edit anything else? \nType 'yes' for new editing and 'no' to end editing. ");
                        //input.nextLine();
                      // String test=input.nextLine().trim().replaceAll("\\s+", "");
                     //   if (test.equalsIgnoreCase("yes")) {
                           // flag = true;
                          ////  System.out.println("Choose from the list what you want to update: \n" +
                              //      "1- update Name \n" +
                                //    "2-update classes held by the trainer");
                          //  ask = input.nextInt();
                         //   break;

                     //   } else if(test.equalsIgnoreCase("no")) {
                      //      System.out.println("edit successful");
                          //  flag=false;
                          //  break;
                       // }
                       // else{
                           // System.out.println("Error! what you have wrote was incorrect");
                           // flag = false;
                           // break;
                      //  }


                   // case 2:
                       // System.out.println("Enter the name of class you want to update: ");
                      //  String oldClassHeld = input.next().trim().replaceAll("\\s+","");
                        if (g.findSessions(oldClassHeld) >= 0) {
                            int indexClassesHeld = g.getTrainers().get(position).findClassesHeld(oldClassHeld);
                            if (indexClassesHeld >= 0) {
                              //  System.out.println("Enter the new classes held : ");
                              //  input.nextLine();
                             //   String newClassesHeld = input.nextLine().trim().replaceAll("\\s+","");
                                if (g.findSessions(newClassesHeld) >= 0) {
                                    g.getTrainers().get(position).getClassesHeld().get(indexClassesHeld).setName(newClassesHeld);
                                   // System.out.println("Classes held are updated sucessfully");
                                } else {
                                   // System.out.println(newClassesHeld + " isn't available in the gym, can't update");
                                }
                            } else {
                               // System.out.println(oldClassHeld + " isn't found in your classes that " + name + " has trained.");
                            }
                        } else {
                           // System.out.println(oldClassHeld + " isn't in the available classes that the gym offer.");
                        }
                       // System.out.println("Do you want to edit anything else? \nType 'yes' for new editing and 'no' to end editing. ");
                        if (input.nextLine().trim().replaceAll("\\s+", "").equalsIgnoreCase("yes")) {
                          //  flag=true;
                       //     System.out.println("Choose from the list what you want to update: \n" +
                          //          "1- update Name \n" +
                            //        "2-update classes held by the trainer");
                          //  ask = input.nextInt();
                           // break ;
                        } else {
                           // System.out.println("Error! what you have wrote was incorrect");
                           // flag=false;
                         //   break;
                        }
                 //   default:
                  //      System.out.println("The number entered is invalid.\n Please enter the number again:  ");
                   //     ask = input.nextInt();
                      //  flag=true;
                }
        ////    } while (flag);
        }
        //  else{
            //    System.out.println(name + " isn't found in trainer list.");
          //  }


   // }



    public void opensessions(String session)
    {
        int i = findsessionindex(session);
        if (i>=0)
        {
            System.out.println(session +" info is: ");
            System.out.println( "Name: "+ g.Session.get(i).getName());
            System.out.println("The description: "+g.Session.get(i).getDescription());
            System.out.println( "The duration that class takes :"+g.Session.get(i).getDurationMin());
            System.out.println( "The time class is available at: "+ Arrays.toString(g.Session.get(i).getTime()));
            System.out.println( "and at day: "+ Arrays.toString(g.Session.get(i).getDay()));
            System.out.println("and the limited number of members is: "+g.Session.get(i).getNumOfMem());
        }
        else {
            System.out.println("session"+ session +"not found at the gym");
        }

    }
   private boolean showList (){
       System.out.println("Do you want to edit anything else? \nType 'yes' for new editing and 'no' to end editing. ");
       input.nextLine();
       String h= input.nextLine().trim().replaceAll("\\s+","");
       if(h.equalsIgnoreCase( "yes")) {
           System.out.println("Choose from the list number of what you want to edit : \n" +
                   "1-edit Name \n" +
                   "2-edit duration in minutes\n" +
                   "3-edit session description \n" +
                   "4-edit Time of session\n" +
                   "5- edit the day of session ");
           return true;
       }
       else{
           return false;
       }
   }

    public void editsession(String session)
    {
        int i =findsessionindex(session);
        boolean ask;
        boolean f =true;
        if (i>=0) {
            System.out.println("Choose from the list number of what you want to edit : \n" +
                    "1-edit Name \n" +
                    "2-edit duration in minutes\n" +
                    "3-edit session description \n" +
                    "4-edit Time of session\n" +
                    "5-edit the day of session ");
            int y = input.nextInt();
            while (f) {
                switch (y) {
                    case 1:
                        System.out.println("Enter the new name ");
                        input.nextLine();
                        String newname = input.nextLine().trim().replaceAll("\\s+", "");
                        g.Session.get(i).setName(newname);
                        System.out.println("name " + newname + " updated successfully.");
                        ask = showList();
                        if (ask) {
                            f=true;
                            y = input.nextInt();
                            break ;
                        } else {
                            f=false;
                            break;
                        }

                    case 2:

                        System.out.println("Enter the new duration in minutes ");
                        int durationmin = input.nextInt();
                        g.Session.get(i).setDurationMin(durationmin);
                        System.out.println("Duration " + durationmin + " is updated successfully.");
                        ask = showList();
                        if (ask) {
                            f=true;
                            y = input.nextInt();
                            break ;
                        } else {
                            f=false;
                            break;
                        }


                    case 3:
                        System.out.println("Enter the new description ");
                        String description = input.nextLine().trim().replaceAll("\\s+", "");
                        g.Session.get(i).setDescription(description);
                        System.out.println("Description " + "\"" + description + "\"" + " updated successfully.");
                        ask = showList();
                        if (ask) {
                            f=true;
                            y = input.nextInt();
                            break ;
                        } else {
                            f=false;
                            break;
                        }


                    case 4:
                        System.out.println("Enter 'time1' for edit of time 1 only and 'time2' for time 2 only and 'both' for editing both");
                        input.nextLine();
                        String n=input.nextLine().trim().replaceAll("\\s+","");
                        if (n.equalsIgnoreCase("time1")) {
                            System.out.println("Enter the new time of session ");
                             int t1=input.nextInt();
                            g.Session.get(i).setTime(t1, -1);
                        } else if (n.equalsIgnoreCase("time2")) {
                            System.out.println("Enter the new time of session ");
                            int t1=input.nextInt();
                            g.Session.get(i).setTime(-1, t1);
                        } else if (n.equalsIgnoreCase("both")) {
                            System.out.println("Enter the new time of session ");
                            int t1=input.nextInt();
                            System.out.println("Enter the second time: ");
                            int t2=input.nextInt();
                            g.Session.get(i).setTime(t1,t2);
                        }
                        System.out.println("Time is updated successfully.");
                        ask = showList();
                        if (ask) {
                            f=true;
                            y = input.nextInt();
                            break;
                        } else {
                            f=false;
                            break;
                        }


                    case 5:
                        System.out.println(" Enter 'day1' for edit of day 1 only and 'day2' for day2 only and 'both' for editing both");
                        input.nextLine();
                        String b=input.nextLine().trim().replaceAll("\\s+","");
                        if (b.equalsIgnoreCase("day1")) {
                            System.out.println("Enter the new day of session ");
                            String d1=input.nextLine().trim().replaceAll("\\s+","");
                            g.Session.get(i).setDay(d1, "same");
                        } else if (b.equalsIgnoreCase("day2")) {
                            System.out.println("Enter the new day of session ");
                            String d1=input.nextLine().trim().replaceAll("\\s+","");
                            g.Session.get(i).setDay("same", d1);
                        } else if (b.equalsIgnoreCase("both")) {
                            System.out.println("Enter the new day of session ");
                            String day1 = input.nextLine().trim().replaceAll("\\s+", "");
                            System.out.println("Enter the second day: ");
                            String d1=input.nextLine().trim().replaceAll("\\s+","");
                            g.Session.get(y).setDay(day1, d1);
                        }
                        System.out.println("Day updated successfully.");
                        ask = showList();
                        if (ask) {
                            f=true;
                            y = input.nextInt();
                            break;
                        } else {
                            f=false;
                            break;
                        }
                    default:
                        System.out.println("The number entered is invalid.\n Please enter the number again:  ");
                        y = input.nextInt();
                        f=true;
                        break ;
                }

            }
        }
    }


    public void deletesession(String session )
    {
        int i =findsessionindex(session);
        if (i>=0)
        {
            g.Session.remove(i);
            System.out.println(session + " is deleted successfully.");
        }
else {
            System.out.println(session + " is not found");
        }
    }


   
@Override
    public boolean signIn(String inputun,String inputpw){
     
        if(inputun.equalsIgnoreCase("admin")&&inputpw.equals("admin123"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void checkAvailabilityTrainer()
    {
        System.out.println("Enter session name ");
        String SName=input.nextLine().trim().toLowerCase().replaceAll("\\s+","");
        System.out.println("Enter trainer name ");
        String TName=input.nextLine().trim().toLowerCase().replaceAll("\\s+","");
        System.out.println("Enter time ");
        String TTime=input.nextLine().trim().toLowerCase().replaceAll("\\s+","");
        System.out.println("Enter day ");
        String TDay=input.nextLine().trim().toLowerCase().replaceAll("\\s+","");
        if(g.checkAvailability(SName,TDay,TTime,TName)){
            System.out.println("Available!");
        }
        else{
            System.out.println("Unavailable");
        }

    }

    void signIn() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
