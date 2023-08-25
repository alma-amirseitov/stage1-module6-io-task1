package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file){
        Profile profile = new Profile();
        StringBuilder fileData = new StringBuilder();
        try(FileInputStream fileInputStream = new FileInputStream(file)){
            int ch;
            while((ch=fileInputStream.read()) != -1) {
                fileData.append((char) ch);
            }
        } catch (IOException e) {
        }

        String[] keyValuePairs = fileData.toString().split("\n");
        Map<String, String> map = new HashMap<>();
        for (String pair : keyValuePairs)
        {
            String[] entry = pair.split(": ");
            map.put(entry[0].trim(), entry[1].trim());
        }
        profile.setAge(Integer.valueOf(map.get("Age")));
        profile.setName(map.get("Name"));
        profile.setEmail(map.get("Email"));
        profile.setPhone(Long.valueOf(map.get("Phone")));
        return profile;
    }
}
