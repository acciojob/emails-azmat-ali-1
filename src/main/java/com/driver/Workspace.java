package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings
    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
       super(emailId,Integer.MAX_VALUE);
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        if(calendar==null){
            calendar=new ArrayList<>();
            calendar.add(meeting);
        }
        else{
            calendar.add(meeting);
        }
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        int count=0;
        if(calendar.size()!=0) {
           count=1;

            for (int j=0;j<calendar.size();j++) {
                Meeting m = calendar.get(j);
                LocalTime start = m.getStartTime();
                LocalTime end = m.getEndTime();
                int ans=1;
                for (int i=j;i<calendar.size();i++) {
                    Meeting m1  = calendar.get(i);
                    LocalTime s = m1.getStartTime();
                    LocalTime e = m1.getEndTime();
                    if (!s.equals(start) && !e.equals(end) && (e.isAfter(start)&&s.isAfter(start))) {
                        start = s;
                        end = e;
                        ans++;
                    }
                }
                count=Math.max(count,ans);
            }
        }
        return count;
    }
}
