package com.Gettintogether.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Properties;

public class Utils {

    private static final Properties prop = new Properties();

    static {
        try {
            prop.load(new FileInputStream("src/main/resources/static/string.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getString(String key) {
        return prop.getProperty(key);
    }

    public static String getErrorMessage(String TAG, String message){
        return TAG + " : " + message;
    }

    public static String getErrorMessageFromKey(String TAG, String messageKey){
        return TAG + " : " + getString(messageKey);
    }

    public static void checBuildingkValidity(String TAG, String building){
        if(building == null || building.isBlank())
            throw new IllegalArgumentException(Utils.getErrorMessageFromKey(TAG, "buildingNullError"));
    }

    public static void checkDeskIDValidity(String TAG, Long deskId){
        if(deskId == null)
            throw new IllegalArgumentException(Utils.getErrorMessageFromKey(TAG, "deskIDNullError"));
    }

    public static void checkFloorValidity(String TAG, int floorNo){
        if(floorNo < 0 || floorNo > 200)
            throw new IllegalArgumentException(Utils.getErrorMessageFromKey(TAG, "floorNullError"));
    }

    public static void checkDeskNoValidity(String TAG, int deskNo){
        if(deskNo < 0)
            throw new IllegalArgumentException(Utils.getErrorMessageFromKey(TAG, "deskNoNullError"));
    }


    //DD-MM-YYYY
    public static Date dateFromString(String date){
        Calendar cal = Calendar.getInstance();
        String[] splits = date.split("-");
        cal.set(Integer.parseInt(splits[2]), Integer.parseInt(splits[1]), Integer.parseInt(splits[0]));
        return new Date(cal.getTimeInMillis());
    }
}
