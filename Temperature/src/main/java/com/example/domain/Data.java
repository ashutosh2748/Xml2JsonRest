package com.example.domain;

//import java.time.LocalDate;

public class Data {
 private String day;
 private String maxTemperature;

public Data(String string, String textContent) {
	this.day=string;
	this.maxTemperature=textContent;
}
public String getDay() {
	return day;
}
public void setDay(String day) {
	this.day = day;
}
public String getMaxTemperature() {
	return maxTemperature;
}
public void setMaxTemperature(String maxTemperature) {
	this.maxTemperature = maxTemperature;
}
 
}
