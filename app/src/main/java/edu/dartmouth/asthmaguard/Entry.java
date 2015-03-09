package edu.dartmouth.asthmaguard;

import java.util.Calendar;

/**
 * Created by menglingli on 2/21/15.
 */
public class Entry {

    // class members should include event type,
    // time, duration, degree, location

    //private variables
    private long id;
    private String mEventType;
    private String mDateTime;
    private String date;
    private double duration;
    private long degree;
    private double mLongitude;
    private double mLatitude;

    //Empty constructor
    public Entry(){
        Calendar mDateAndTime;
        mDateAndTime = Calendar.getInstance();

        //this.mDateTime = mDateAndTime.getTimeInMillis();
        this.mLatitude = 0;
        this.mLatitude = 0;
    }

    public long getId(){return id;}

    public void setId(long id){this.id = id;}

    public String getDateTime(){return mDateTime;}

    public void setDateTime(String mDateTime){this.mDateTime=mDateTime;}

    public double getLongitude(){return this.mLongitude;}

    public void setLongitude(double mLongitude){this.mLongitude=mLongitude;}

    public double getLatitude(){return this.mLatitude;}

    public void setLatitude(double mLatitude){this.mLatitude=mLatitude;}

    public long getDegree(){return this.degree;}

    public void setDegree(long degree){this.degree = degree;}

    public void setEventType(String eventtype){this.mEventType=eventtype;}

    public String getEventType(){return this.mEventType;}

    public void setDuration(double duration){this.duration=duration;}

    public double getDuration(){return this.duration;}

    public String getDate(){return date;}

    public void setDate(String mDateTime){this.date=mDateTime;}
}
