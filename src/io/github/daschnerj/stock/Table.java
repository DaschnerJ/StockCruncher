package io.github.daschnerj.stock;

import java.util.ArrayList;
import java.util.HashMap;

public class Table {

    String id;
    HashMap<Long, Day> days;

    public ArrayList<Long> orderedDays()
    {
        ArrayList<Long> dayList = new ArrayList<>();
        dayList.addAll(days.keySet());
        dayList.sort(Long::compareTo);
        return dayList;
    }

    public ArrayList<Long> days()
    {
        ArrayList<Long> dayList = new ArrayList<>();
        dayList.addAll(days.keySet());
        return dayList;
    }

    public Day getDay(Long day)
    {
        if(days.containsKey(day))
            return days.get(day);
        else
            return null;
    }

    public Day getIndexedDay(int index)
    {
        ArrayList<Long> dayList = orderedDays();
        if(dayList.size() > index)
            return days.get(orderedDays().get(index));
        else return null;
    }

}
