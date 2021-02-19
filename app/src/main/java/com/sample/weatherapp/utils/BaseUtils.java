package com.sample.weatherapp.utils;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sample.weatherapp.model.Weather.CurrentWeather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class BaseUtils {

    public static String getJSONStringFromRaw(Context context, int rawId) {

        InputStream content = context.getResources().openRawResource(rawId);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
        String respString = "";
        try {
            String s = "";
            while ((s = buffer.readLine()) != null) {
                respString += s;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respString;
    }

    public static int dpToPx(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }

    public static float dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return dpValue * scale;
    }

    public static String getFormattedDate(String dateString) {
        Date date = getDate(dateString);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int day = cal.get(Calendar.DATE);
        switch (day % 10) {
            case 1:
                return new SimpleDateFormat("MMMM d'st', yyyy").format(date);
            case 2:
                return new SimpleDateFormat("MMMM d'nd', yyyy").format(date);
            case 3:
                return new SimpleDateFormat("MMMM d'rd', yyyy").format(date);
            default:
                return new SimpleDateFormat("MMMM d'th', yyyy").format(date);
        }
    }

    private static Date getDate(String aDate) {
        ParsePosition pos = new ParsePosition(0);
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date stringDate = simpledateformat.parse(aDate, pos);
        return stringDate;

    }

    public static CurrentWeather getWeather(String jsonString) {
        Type listType = new TypeToken<CurrentWeather>() {}.getType();
        CurrentWeather apiResponseMessage = new Gson().fromJson(jsonString, listType);
        return apiResponseMessage;
    }

//    public static List<Video> getMovieVideos(String jsonString) {
//        Type listType = new TypeToken<APIResponse>() {}.getType();
//        APIResponse apiResponse = new Gson().fromJson(jsonString, listType);
//        List<Video> videos = apiResponse.getResults();
//        return videos;
//    }
//
//    public static List<CommonFragment> getFragments(List<Movie> movies) {
//        List<CommonFragment> commonFragments = new ArrayList<>();
//        for (Movie movie : movies) {
//            if(movie.getPosterPath() != null)
//                commonFragments.add(CommonFragment.newInstance(movie));
//        }
//        return commonFragments;
//    }
}
