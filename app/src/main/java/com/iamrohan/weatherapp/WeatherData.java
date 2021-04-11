package com.iamrohan.weatherapp;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherData {

    private String mTemp , mImg,mWeatherType,mCity;
    private int mCondition;

    public static WeatherData fromJson(JSONObject jsonObject){
        try{
            WeatherData weatherData = new WeatherData();
            weatherData.mCity = jsonObject.getString("name");
            weatherData.mCondition = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherData.mWeatherType = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            weatherData.mImg = updateWeatherImage(weatherData.mCondition);
            double temp = jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int tempValue = (int) Math.rint(temp);
            weatherData.mTemp = Integer.toString(tempValue);

            return weatherData;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String updateWeatherImage(int mCondition){
        if(mCondition >= 0 && mCondition <=300){
            return "thunderstorm1";
        }else if(mCondition >= 301 && mCondition <=500){
            return "lightrain";
        }else if(mCondition >= 501 && mCondition <=600){
            return "shower";
        }else if(mCondition >= 601 && mCondition <=700){
            return "snow2";
        }else if(mCondition >= 701 && mCondition <=771){
            return "fog";
        }else if(mCondition >= 772 && mCondition <=799){
            return "overcast";
        }else if(mCondition == 800){
            return "sunny";
        }else if(mCondition >= 801 && mCondition <=804){
            return "cloudy";
        }else if(mCondition >= 900 && mCondition <=902){
            return "thunderstorm1";
        }else if(mCondition == 903){
            return "snow1";
        }else if(mCondition == 904){
            return "sunny";
        }else if(mCondition >= 905 && mCondition <=1000){
            return "thunderstorm2";
        }
        return "finding";
    }

    public String getmTemp() {
        return mTemp + "°C";
    }

    public String getmImg() {
        return mImg;
    }

    public String getmWeatherType() {
        return mWeatherType;
    }

    public String getmCity() {
        return mCity;
    }
}
