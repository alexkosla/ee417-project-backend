package com.ee417.groupf.service;

import com.ee417.groupf.model.MenuItem;
import com.ee417.groupf.model.MenuItemCategoryEnum;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MenuItemService {
    public List<MenuItem> listMenuItems()
    {
        try{
            // set the relative path of the location of the json file
            String fileLocation = "./src/main/resources/stats.json";
            // create a jackson object mapper to use for converting an object to a json file
            ObjectMapper mapper = new ObjectMapper();
            // tell the mapper to parse a single value as an array to avoid errors
            mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

            // check if the file already exists at the location specified
            File f = new File(fileLocation);
            if(f.isFile()) {
                // if the file does exist, use the mapper to read the value and parse it as an arraylist
                ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>(Arrays.asList(mapper.readValue(f, MenuItem[].class)));
                return menuItemList;
            }

        } catch (Exception ex)
        {
            // print the stack trace in case there's an error here reading/writing to file
            ex.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<MenuItem> getMenuItemsByCategory(MenuItemCategoryEnum category)
    {
        List<MenuItem> menuItemList = null;
        try
        {
            // set the relative path of the location of the json file
            String fileLocation = "./src/main/resources/stats.json";
            // create a jackson object mapper to use for converting an object to a json file
            ObjectMapper mapper = new ObjectMapper();
            // tell the mapper to parse a single value as an array to avoid errors
            mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

            // check if the file already exists at the location specified
            File f = new File(fileLocation);
            if(f.isFile()) {
                // if the file does exist, use the mapper to read the value and parse it as an arraylist
                menuItemList = new ArrayList<MenuItem>(Arrays.asList(mapper.readValue(f, MenuItem[].class)));
            }

            if(menuItemList != null)
            {
                // similar to a one-liner foreach loop that returns the list of all MenuItems in the list
                // where their category matches the category argument from the controller

                if(category != MenuItemCategoryEnum.ALL)
                {
                    menuItemList = menuItemList.stream()
                            .filter(item ->  item.getCategory() == category)
                            .collect(Collectors.toList());
                }


                return menuItemList;
            }
        }
        catch (Exception ex)
        {
            // print the stack trace in case there's an error here reading/writing to file
            ex.printStackTrace();
        }
        return Collections.emptyList();
    }

}
