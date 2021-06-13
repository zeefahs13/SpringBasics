package com.springbasics.core;

public class AOPImpl {

	private String name;
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void printName() {
		System.out.println("Name:" + this.name);
	}

	public void printURL() {
		System.out.println("URL:" + this.url);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + " " + this.url;
	}

	public void AOPImplException() {
		throw new IllegalArgumentException("thrown exception in AOPImpl class");
	}

}
