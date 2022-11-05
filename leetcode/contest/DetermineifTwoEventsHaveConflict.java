/*
You are given two arrays of strings that represent two inclusive events that happened on the same day,
 event1 and event2, where:

event1 = [startTime1, endTime1] and
event2 = [startTime2, endTime2].
Event times are valid 24 hours format in the form of HH:MM.

A conflict happens when two events have some non-empty intersection (i.e., some moment is common to both events).

Return true if there is a conflict between two events. Otherwise, return false.
 */

class DetermineifTwoEventsHaveConflict{
    /*
    using split
    auxiliary memory o(2n)
    time complexity 0(n)
     */
    public boolean haveConflict(String[] event1, String[] event2) {
        List<Integer> time1 = new ArrayList<Integer>();
        List<Integer> time2 = new ArrayList<Integer>();

        for(String s:event1){
            String[] timeSplit = s.split(":");
            time1.add(Integer.valueOf(timeSplit[0])*60 + Integer.valueOf(timeSplit[1]));
        }

        for(String s:event2){
            String[] timeSplit = s.split(":");
            time2.add(Integer.valueOf(timeSplit[0])*60 + Integer.valueOf(timeSplit[1]));
        }

        if(time1.get(0) <= time2.get(0) && time2.get(0) <= time1.get(1))
            return true;
        else if(time2.get(0) <= time1.get(0) && time1.get(0) <= time2.get(1))
            return true;
        return false;
    }

    /*
    Substring approach
     */
    public boolean haveConflict(String[] event1, String[] event2) {
        int event1Start;
        int event2Start;
        int enent1End;
        int event2End;

        event1Start = getTime(event1[0]);
        event2Start = getTime(event2[0]);
        enent1End = getTime(event1[1]);
        event2End = getTime(event2[1]);

        if((event1Start <=  event2Start && event2Start <= enent1End)||
                (event2Start <= event1Start && event1Start<=event2End)
        )
            return true;
        return false;
    }

    private int getTime(String time){
        int h = Integer.valueOf(time.substring(0,2));
        int m = Integer.valueOf(time.substring(3,5));
        return h*60 + m;

    }
}