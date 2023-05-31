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
public class sessions {
    private int NumOfMem;
    private int durationMin;
    private String name;
    private String description;

    private String [] day;
    private String []time;
    private ArrayList<trainer> trainerSession;
    private ArrayList<member> memberInSession;
    public sessions() {
        this.trainerSession=new ArrayList<trainer>();
        this.memberInSession=new ArrayList<member>();
        this.time = new String[2];
        this.day = new String[2];
    }
    public sessions(String name){
        this.name=name;
    }

    public void setMemberInSession(member m) {
        memberInSession.add(m);
    }

    public void setNumOfMem(int numOfMem) {
        NumOfMem = numOfMem;
    }

    public void setDurationMin(int durationMin) {
        this.durationMin = durationMin;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setTime (int time1, int time2){
        if(time1<=12 && time2<=12) {
            time[0] = Integer.toString(time1);
            if (time2 != -1)
                time[1] = Integer.toString(time2);
        }
        else {
            System.out.println("The time you entered is incorrect");
        }
    }
    public void setDay (String day1, String day2){
        if(( day1.equalsIgnoreCase("Sunday") || day1.equalsIgnoreCase("same")|| day1.equalsIgnoreCase("Monday") || day1.equalsIgnoreCase("Tuesday")
                || day1.equalsIgnoreCase("Wednesday")|| day1.equalsIgnoreCase("Thursday") || day1.equalsIgnoreCase("Saturday") || day1.equalsIgnoreCase("Friday")  )&&
                ( day2.equalsIgnoreCase("Sunday")) || day2.equalsIgnoreCase("Monday") || day2.equalsIgnoreCase("Tuesday")
                || day2.equalsIgnoreCase("Wednesday")|| day2.equalsIgnoreCase("Thursday") ||day2.equalsIgnoreCase("same")
                || day2.equalsIgnoreCase("Saturday") || day1.equalsIgnoreCase("Friday") ) {
           if(day1.equalsIgnoreCase("same")){
               day[1]=day2;
           }
            else if (day2.equalsIgnoreCase("same"))
                day[0] = day1;
            else {
               day[0] = day1;
               day[1] = day2;
           }
        }
        else{
            System.out.println("the day you  have entered is incorrect ");
        }
    }

    public String getName() {
        return name;
    }

    public int getNumOfMem() {
        return NumOfMem;
    }

    public int getDurationMin() {
        return durationMin;
    }

    public String getDescription() {
        return description;
    }

    public String[] getDay() {
        return day;
    }

    public String[] getTime() {
        return time;
    }

    public ArrayList<member> getMemberInSession() {
        return memberInSession;
    }

    public  member findMemberInSession (String memberName) {
        for (int i=0;i<memberInSession.size();i++){
            member mem= memberInSession.get(i);
            if(mem.getName().equalsIgnoreCase(memberName))
                return mem;
        }
        return null;
    }


}
