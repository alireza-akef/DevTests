package com.example.rss01;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Weather implements Serializable{

	String CityName="";
	String country;
	String location;
	Long CityLat =0L;
	Long CityLon=0L;
	int cnt;
	ArrayList<WeatherDetails> WeatherDetails = new ArrayList<WeatherDetails>();

}
