package com.example.domain;


public class FormObject {
	private String zip;
	private Data[] data;
	
	FormObject(int n,String zip){
		this.data=new Data[n];
		this.zip=zip;
		
	}
	
	public static FormObject getFormObject(int n,String zip){
		return new FormObject(n,zip);
			}

	public Data[] getData() {
		
		return data;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setData(Data[] data) {
		this.data = data;
	}
	
}
