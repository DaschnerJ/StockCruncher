package io.github.daschnerj;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class Config {

    public static ArrayList<Config> configs = new ArrayList<>();

    String id;
    Properties properties;

    public Config(String id)
    {
        properties = new Properties();
        this.id = id;
        load();
    }

    public void create()
    {
        File f = new File(id+Variables.configExtension);
        f.getParentFile().mkdirs();
        try {
            f.createNewFile(); // if file already exists will do nothing
            FileOutputStream oFile = new FileOutputStream(f, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void exit()
    {
        configs.forEach(x -> x.save());
    }

    public void save()
    {

        OutputStream output = null;
        try {

            output = new FileOutputStream(Variables.configPath + id + Variables.configExtension);

            // save properties to project root folder
            properties.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void load()
    {
        create();
        InputStream input = null;

        try {

            input = new FileInputStream(Variables.configPath + id + Variables.configExtension);

            // load a properties file
            properties.load(input);


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void add(String tag, String value)
    {
        properties.setProperty(tag, value);
    }

    public String get(String tag)
    {
        return properties.getProperty(tag);
    }

    public String getDefault(String tag, String def)
    {
        if(get(tag) != null)
            return tag;
        add(tag, def);
        return def;
    }

}

