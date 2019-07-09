package com.example.week4day1.HttpURLConnection;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnectionUrl {

    public static final String APIURL = "https://api.github.com/search/users?q=Arbellizon";
   private static URL urlObject;
   private static HttpURLConnection httpConnectionUrl;
   public static  final int EOF = -1;

   public static String talkNiceToMe()throws Exception{

       String result = "";

       //open the connection

       urlObject = new URL(APIURL);
       httpConnectionUrl = (HttpURLConnection) urlObject.openConnection();

       //Buffer the stream
       InputStream myInputStream = httpConnectionUrl.getInputStream();
       int getIntOfCurrentRead = myInputStream.read();

       while(getIntOfCurrentRead != -1){

           char convertedToChar = (char)getIntOfCurrentRead;
           result = result + convertedToChar;
           getIntOfCurrentRead = myInputStream.read();
       }
       return  result;
   }
}
