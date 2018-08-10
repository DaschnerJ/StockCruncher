package io.github.daschnerj.stock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Day {

    long day;
    HashMap<String, Object> data;

    public Day(long day)
    {
        this.day = day;
        data = new HashMap<>();
    }

    public void addData(String key, Object val)
    {
        data.put(key, val);
    }

    public Object getData(String key)
    {
        if(data.containsKey(key))
            return data.get(key);
        else
            return null;
    }

    public Integer getInt(String key)
    {
        try
        {
            Object data = getData(key);
            if(data == null)
                return 0;
            return (Integer)data;
        }
        catch(ClassCastException e)
        {
            return 0;
        }
    }

    public String getString(String key)
    {
        try
        {
            Object data = getData(key);
            if(data == null)
                return "";
            return (String)data;
        }
        catch(ClassCastException e)
        {
            return "";
        }
    }

    public Long getLong(String key)
    {
        try
        {
            Object data = getData(key);
            if(data == null)
                return 0L;
            return (Long)data;
        }
        catch(ClassCastException e)
        {
            return 0L;
        }
    }

    public Short getShort(String key)
    {
        try
        {
            Object data = getData(key);
            if(data == null)
                return 0;
            return (Short)data;
        }
        catch(ClassCastException e)
        {
            return 0;
        }
    }

    public Double getDouble(String key)
    {
        try
        {
            Object data = getData(key);
            if(data == null)
                return 0.0;
            return (Double)data;
        }
        catch(ClassCastException e)
        {
            return 0.0;
        }
    }

    public Float getFloat(String key)
    {
        try
        {
            Object data = getData(key);
            if(data == null)
                return 0f;
            return (Float)data;
        }
        catch(ClassCastException e)
        {
            return 0f;
        }
    }

    public static long getEpochTime(int day, int month, int year)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = null;
        try {
            String da = day + "";
            if(day < 10)
                da = "0"+da;
            String mon = month + "";
            if(month < 10)
                mon = "0"+mon;
            d = sdf.parse(da+"/"+mon+"/"+year);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(d == null)
            return 0;
        else
            return d.getTime();
    }

}
