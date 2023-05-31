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
import java.util.Scanner;

public class SystemAccess {
    static Gym g= new Gym();
    protected ArrayList <String> Account= new ArrayList<String>();

    Scanner input = new Scanner(System.in);
    public SystemAccess() {
        member m = new member("ahmed","male",234,"01112344","payg","0259874561235");
        g.members.add(m);
        g.Session.get(0).setMemberInSession(m);
        g.Session.get(5).setMemberInSession(m);
        g.Session.get(2).setMemberInSession(m);
        m.setClassesAttended(g.Session.get(0));
        m.setClassesAttended(g.Session.get(5));
        m.setClassesAttended(g.Session.get(2));
        g.setMemberOfpayg(m);

        member m1 = new member("shahd","female",345,"011225544","open membership","0021530860014");
        g.members.add(m1);
        g.Session.get(2).setMemberInSession(m1);
        g.Session.get(1).setMemberInSession(m1);
        g.Session.get(5).setMemberInSession(m1);
        m1.setClassesAttended(g.Session.get(2));
        m1.setClassesAttended(g.Session.get(1));
        m1.setClassesAttended(g.Session.get(5));
        g.setMemberOfOpen(m1);


        member m2 = new member("salma","female",324,"01112377","term membership","0125784500698");
        g.members.add(m2);
        g.Session.get(3).setMemberInSession(m2);
        g.Session.get(1).setMemberInSession(m2);
        g.Session.get(4).setMemberInSession(m2);
        m2.setClassesAttended(g.Session.get(3));
        m2.setClassesAttended(g.Session.get(1));
        m2.setClassesAttended(g.Session.get(4));
        g.setMemberOfTerm(m2);

        member m3 = new member("mohammed","male",124,"01112344656","payg","5698700225471");
        g.members.add(m3);
        g.Session.get(4).setMemberInSession(m3);
        g.Session.get(0).setMemberInSession(m3);
        g.Session.get(3).setMemberInSession(m3);
        m3.setClassesAttended(g.Session.get(4));
        m3.setClassesAttended(g.Session.get(0));
        m3.setClassesAttended(g.Session.get(3));
        g.setMemberOfpayg(m3);
    }



    protected int findsessionindex (String session) {
        for (int i=0;i<g.Session.size();i++){
            sessions s= g.Session.get(i);
            if(s.getName().equalsIgnoreCase(session))
                return i;
        }
        return -1;
    }

    protected void ViewMemberInSession(String nameSesseion){
        int inSession=g.findSessions(nameSesseion);
        if(inSession>=0){
            System.out.println("Members in "+ nameSesseion+ ":");
            ArrayList<member>  mem = g.Session.get(inSession).getMemberInSession();
            for(int i=0;i<mem.size();i++){
                System.out.println((i+1) + "- "+ mem.get(i).getName());
            }
        }
    }

    protected void ViewMemberInfo(){

        for(int i=0;i<g.members.size();i++){
            member M = g.members.get(i);
            System.out.println("Name: " +M.getName()+"\n"+
                    "gender: "+M.getGender()+"\n"+
                    "Serial number: "+M.getMember_id()+"\n"+
                    "National id: "+M.getNationalId()+"\n"+
                    "mobile: "+M.getMobile()+"\n"+
                    "membership: "+M.getMembership());
            System.out.println("classes attended:");
            M.PrintClassesAttended();
        }
    }


    protected void ViewMemberInMembership (String membership){

        System.out.println("The member list in "+membership +":");
        if(membership.equalsIgnoreCase("payg") ){
            g.printPaygMember();
        }
         else if(membership.equalsIgnoreCase("open membership") ){
             g.printOpenMember();
        }
        else if (membership.equalsIgnoreCase("Term membership")) {
            g.printTermMember();
        }
        else {
            System.out.println(membership +" isn't available in the gym.");
        }
    }

     public void addacount (String userName,String password)
    {
    Account.add(userName);
    Account.add(password);
    }
    public boolean signIn (String inputun,String inputpw){
        return false;
    }
        
    

    public void signOut (){
        System.out.println("You Are Signed Out.\nGoodBye");
    }

}

