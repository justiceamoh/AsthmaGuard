package edu.dartmouth.asthmaguard;

/**
 * Created by Junior on 3/8/15.
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Greetings {
    static String[] hiStatic={"Hi","Hello","Hey"};
    static String[] timeOfDayStatic={"Good Morning", "Good Afternoon", "Good Evening"};
    static String[] dayOfWeekStatic={"","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

    public static String getGreeting(){

        int randomInt= (int) (1+(Math.random()*3));
        String finalGreeting = null;
        //System.out.println(randomInt);
        switch(randomInt) {
            case 1:

                finalGreeting=getTOD();
                break;
            case 2:
                finalGreeting=getHi();
                break;
            case 3:
                String temp2=getDOW();
                finalGreeting="Happy "+temp2;

                break;
        }


        return finalGreeting;
    }

    public static String getTOD(){
        int TOD = 0;

        SimpleDateFormat parser= new SimpleDateFormat("HH:mm");
        try{
            Date timeOfDayDate= new Date();
            String tempTime= ""+timeOfDayDate.getHours()+":"+timeOfDayDate.getMinutes();
            //System.out.println(tempTime);
            Date userTime= parser.parse(tempTime);
            Date noon=parser.parse("12:00");
            Date afternoon=parser.parse("18:00");
            Date evening= parser.parse("03:00");
            //Date timeOfDayDate= new Date();



            if(userTime.after(noon) && userTime.before(afternoon)){
                TOD=1;
            }
            else if(userTime.after(afternoon) && userTime.before(evening)){
                TOD=2;
            }
            else{
                TOD=0;
            }
        }
        catch(Exception e){

        }





        return timeOfDayStatic[TOD];

    }

    public static String getHi(){

        int randomHi= (int) (1+(Math.random()*hiStatic.length));

        return hiStatic[randomHi-1];

    }

    public static String getDOW(){
        Calendar c=Calendar.getInstance();
        Date date= new Date();
        c.setTime(date);
        //System.out.println(date);
        int dayOfWeek=c.get(Calendar.DAY_OF_WEEK);
        //System.out.println(dayOfWeek);
        return dayOfWeekStatic[dayOfWeek];

    }

    public static void main(String[] args){
        System.out.println(getGreeting());
    }
}

