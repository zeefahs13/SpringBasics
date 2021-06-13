package com.springbasics.core;

public class InvOfControl {
	
	/******************************************************************
	 * 
	 * There are two type of Spring containers(IoC container)
	 * 
	 * a. BeanFactory container: It will construct when u request for it
	 * b. ApplicationContext : Contructs object even if u dont request for it. Buit on top of
	 * bean factory. Provides features of Entreprise level application
	 * 
	 * 
	 * 
	 */
	
	
	

	private int id;
	private String name;
	private Object obj;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+" "+this.name;
	}
	
}
