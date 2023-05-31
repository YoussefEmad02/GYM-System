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
public class trainer extends Person{
    private ArrayList<sessions>  classesHeld;
    String [] availableDays=new String[7];

    String[] availableTime=new String[12];

    public trainer (String name,String gender ){
        super (name,gender);
        this. classesHeld = new ArrayList<sessions>();
        availableDays[0]="Tuesday";
        availableTime[0]="9";
        availableDays[1]="Saturday";
        availableTime[1]="7";
        availableDays[2]="Sunday";
        availableTime[2]="12";

    }

    public ArrayList<sessions> getClassesHeld() {
        return classesHeld;
    }


    public int findClassesHeld (String name ){
        for (int i=0;i<classesHeld.size();i++){
            if(classesHeld.get(i).getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }
@Override
    public boolean setsession(String sessionname) {
        
  
            int  s = gym.findSessions(sessionname);
            if (s >=0) {
                    classesHeld.add(new sessions(sessionname));
                     return true;
                }
            else {
                    return false;
                }
            //System.out.println("Do you want to add another class? \nEnter 'true' for yes and 'false' for no ");
 

   }



}
