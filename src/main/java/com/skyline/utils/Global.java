package com.skyline.utils;

import com.skyline.database.entity.Owner;

public class Global {
	
	private static Global global = new Global();
	
	private Owner owner;
	
	private Global() {
		
	}
	
	public static Global getInstance( ) {
		return global;
	}
	
	public Owner getOwner() {
		return owner;
	}
	
	public void setOwner(Owner owner) {
		this.owner = owner;
	}

}
