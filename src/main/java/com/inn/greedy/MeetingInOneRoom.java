package com.inn.greedy;

/*
https://www.geeksforgeeks.org/find-maximum-meetings-in-one-room/
https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
 */


import java.util.ArrayList;
import java.util.List;

class Meeting{

    // start time of the meeting
    int start;

    // end time of the meeting
    int end;

    // position of the meeting
    int position;

    public Meeting(int start, int end, int position) {
        this.start = start;
        this.end = end;
        this.position = position;
    }

    public Meeting(){}
}

public class MeetingInOneRoom {


    public static void main(String[] args) {
        int[] start = {0,3,1,5,5,8};
        int[] end = {5,4,2,9,7,9};

        System.out.println(maxMeetings(start.length, start, end));
    }

    private static int maxMeetings(int n, int start[], int end[]) {

        // this list will store meeting sequence based on position
        List<Integer> meetingSequence = new ArrayList<>();

        List<Meeting> meetings = new ArrayList<>();
        for(int i=0;i<n;i++){
            meetings.add(new Meeting(start[i], end[i], i+1));
        }

        meetings.sort((meeting1, meeting2) -> meeting1.end - meeting2.end);

        int totalMeetingsPossible = 0;

        int endTime = -1;
        for(Meeting meeting : meetings){
            if(meeting.start > endTime){
                meetingSequence.add(meeting.position);
                totalMeetingsPossible++;
                endTime = meeting.end;
            }
        }

        System.out.println(meetingSequence);

        return totalMeetingsPossible;
    }
}
