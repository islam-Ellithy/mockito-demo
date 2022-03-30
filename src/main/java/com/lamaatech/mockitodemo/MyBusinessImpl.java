package com.lamaatech.mockitodemo;

public class MyBusinessImpl {
	DataService dataService ;
	
	public MyBusinessImpl() {
		
	}
 	
	public MyBusinessImpl(DataService service) {
		dataService = service;
	}

	int findTheGreatest() {
		int[] data = dataService.retrieveAllData();
		int theGreatest = Integer.MIN_VALUE;
		for (int num : data) {
			if(num > theGreatest) {
				theGreatest = num;
			}
		}
		
		return theGreatest;
	}
	
}


