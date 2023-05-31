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

public class member extends Person {

    private String mobile;
    private String membership;
    private ArrayList<sessions> classesAttended;
    private String nationalId;
    private  int member_id ;
    private String trainerName;

    public member(String name, String gender, int member_id,String mobile, String membership, String nationalId) {
        super(name, gender);
        this.mobile = mobile;
        this.membership = membership;
        this.nationalId=nationalId;
        this.classesAttended = new ArrayList<sessions>();
        this.member_id=member_id;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public ArrayList<sessions> getClassesAttended() {
        return classesAttended;
    }

    public String getMobile() {
        return mobile;
    }

    public String getMembership() {
        return membership;
    }

    public String getNationalId() {
        return nationalId;
    }


    public  int getMember_id() {
        return member_id;
    }

    public void PrintClassesAttended(){

        for(int i=0;i<classesAttended.size();i++){
            System.out.println((i+1)+"- "+ classesAttended.get(i).getName());
        }
    }

    public void setClassesAttended(sessions s) {
        this.classesAttended.add(s);
    }

   @Override
    public boolean setsession(String name)
    {
        int i = 0;
      //  do {
           // System.out.println("Enter the name:");
            //if(i>0)
            //    input.nextLine();
           // name=input.nextLine().trim().toLowerCase().replaceAll("\\s+","");
            int s = gym.findSessions(name);
            if (s >=0) {
                classesAttended.add(new sessions(name));
            } else {
                System.out.println("Session " + name + " isn't found");

            }
            System.out.println("Do you want to add another class? \n Enter 'true' for yes and 'false' for no ");
          //  ask = input.nextBoolean();
          //  if (ask) i++;
       // } while (ask);
return false;
    }
public   int findClassAttended(String name){
        for (int i=0;i<classesAttended.size();i++){
            if(classesAttended.get(i).getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }


}
