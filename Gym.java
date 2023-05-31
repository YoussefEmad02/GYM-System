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

public class Gym {
   ArrayList<sessions> Session;
  ArrayList<member> members= new ArrayList<member>();
    private  ArrayList<member> memberOfpayg= new ArrayList<member>();;
    private ArrayList<member>  memberOfOpen= new ArrayList<member>();;
    private ArrayList<member> memberOfTerm= new ArrayList<member>();;
    private static ArrayList <trainer> trainers=new ArrayList<trainer>();
    public Gym(){
        this.Session= new ArrayList<sessions>();
        sessions s1 = new sessions();
        Session.add(s1);
        s1.setName("crossfit");
        s1.setDurationMin(60);
        s1.setDescription("CrossFit is a strength and conditioning workout that is made up of functional movement performed at a high intensity level. \"\n" +
                "These movements are actions that you perform in your day-to-day life, like squatting, pulling, pushing etc.");
        s1.setTime(10,4);
        s1.setDay("Saturday", "Saturday");
        s1.setNumOfMem(10);

        sessions s2 = new sessions();
        Session.add(s2);
        s2.setName("calisthenics");
        s2.setDurationMin(60);
        s2.setDescription("They are exercises that are often performed rhythmically and with minimal equipment, as bodyweight exercises. "
                + " They are intended to increase strength, fitness, and flexibility, through movements such as pulling, pushing, bending, jumping, or swinging, using one's body weight for resistance");
        s2.setTime(11,5);
        s2.setDay("Sunday", "Monday");
        s2.setNumOfMem(10);

        sessions s3 = new sessions();
        Session.add(s3);
        s3.setName("weightlifting");
        s3.setDurationMin(60);
        s3.setDescription("Weight Lifting builds lean, stronger muscles, strengthens your bones and joints, "
                + "and can help keep your metabolism in a healthy state");
        s3.setTime(12,4);
        s3.setDay("Sunday", "Monday");
        s3.setNumOfMem(15);

        sessions s4 = new sessions();
        Session.add(s4);
        s4.setName("yoga");
        s4.setDurationMin(60);
        s4.setDescription("Yoga is a group of physical, mental, and spiritual practices or disciplines "
                + "that aim to control and still the mind ");
        s4.setTime(9,1);
        s4.setDay("Tuesday","Tuesday");
        s4.setNumOfMem(15);

        sessions s5 = new sessions();
        Session.add(s5);
        s5.setName("hiit");
        s5.setDurationMin(15);
        s5.setDescription("High-intensity interval training is a training protocol alternating short periods of intense or explosive " +
                "anaerobic exercise with brief recovery periods until the point of exhaustion,"
                + "which thereby relies on the anaerobic energy releasing system almost maximally.");
        s5.setTime(5,7);
        s5.setDay("Wednesday", "Thursday");
        s5.setNumOfMem(10);

        sessions s6= new sessions();
        Session.add(s6);
        s6.setName("kickboxing");
        s6.setDurationMin(60);
        s6.setDescription("Kickboxing is a group of stand-up combat sports and "
                + "a form of boxing based on kicking and punching.");
        s6.setTime(6,8);
        s6.setDay("Wednesday", "Thursday");
        s6.setNumOfMem(10);



    }

    public void setMemberOfpayg(member mp) {
        memberOfpayg.add(mp);
    }

    public void setMemberOfOpen(member mo) {
        memberOfOpen.add(mo);
    }

    public void setMemberOfTerm(member mt) {
        memberOfOpen.add(mt);

    }

    public static ArrayList<trainer> getTrainers() {
        return trainers;
    }

    public ArrayList<member> getMembers() {
        return members;
    }
static member mem;
    protected int findMemberindex (String Name){
        for (int i=0;i<this.members.size();i++){
            mem= members.get(i);
            if(mem.getName().equalsIgnoreCase(Name))
                return i;
        }
        return -1;
    }


    protected member findMember (String Name){
        for (int i=0;i<this.members.size();i++){
            member mem= members.get(i);
            if(mem.getName().equalsIgnoreCase(Name))
                return mem;
        }
        return null;
    }

    public int findSessions(String name){
        for(int i=0;i<Session.size();i++){
            if(Session.get(i).getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }
   public int findtrainerindex (String Name){
        for (int i=0;i<trainers.size();i++){
            trainer t= trainers.get(i);
            if(t.getName().equalsIgnoreCase(Name))
                return i;
        }
        return -1;
    }
    public void addMember (String memberName,int gname){
        member mem = findMember(memberName);
        if(mem!= null){
            if(Session.get(gname).findMemberInSession(memberName)==null) {
                Session.get(gname).getMemberInSession().add(mem);
                System.out.println("Member " + memberName + " is added successfully to  the session " );
            }
            else{
                System.out.println("Member" + memberName + " is already in the session "  );
            }

        }
        else {
            System.out.println("Member " + memberName + " isn't added to list of members in gym ");
        }
    }
    public void removeMember(String memberName, int gname){
        member mem =findMember(memberName);
        if(mem!= null){
            if(Session.get(gname).findMemberInSession(memberName)!=null) {
                Session.get(gname).getMemberInSession().remove(mem);
                System.out.println("Member " + memberName + " is removed successfully from class ");
            }
            else{
                System.out.println("Member "+ memberName +" isn't found in the members of this session ");
            }
        }
        else{
            System.out.println("Member "+ memberName +" doesn't exist  in session "+ gname );
        }
    }

    public boolean checkAvailability ( String session,String day , String time ,String nameTrainer){
        int trainerindex = findtrainerindex(nameTrainer);
        if(trainerindex>=0){
            int s= findSessions(session);
            if(s>=0) {
                for (int i = 0; i < 2; i++) {
                        if (trainers.get(trainerindex).availableTime[i].equalsIgnoreCase(time) && trainers.get(trainerindex).availableDays[i].equalsIgnoreCase(day)) {
                            System.out.println(nameTrainer + " isn't available.");
                            return false;
                        }
                }
                System.out.println(nameTrainer + " is available.");
                return true;
            }else{
                System.out.println("session you entered is incorrect");
            }


        }
        System.out.println("The trainer "+ nameTrainer +"isn't found in the list.");
        return false;
    }
    public void printPaygMember (){
        for(int i=0;i<memberOfpayg.size();i++){
            System.out.println((i+1) +"- " + memberOfpayg.get(i).getName());
        }
    }
    public void printOpenMember (){
        for(int i=0;i<memberOfOpen.size();i++){
            System.out.println((i+1) +"- " + memberOfOpen.get(i).getName());
        }
    }
    public void printTermMember (){
        for(int i=0;i<memberOfTerm.size();i++){
            System.out.println((i+1) +"- " + memberOfTerm.get(i).getName());
        }
    }


}
