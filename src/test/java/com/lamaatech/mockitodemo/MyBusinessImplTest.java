package com.lamaatech.mockitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MyBusinessImplTest {

	@Mock
	DataService dataServiceMock;
	
	@InjectMocks
	MyBusinessImpl service;
	
	@Test
	void test() {
		
		
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5,10,20});
		
		
		int result = service.findTheGreatest();
		
		
		assertEquals(20, result);
		
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {100,200,300});
		
		assertEquals(300,service.findTheGreatest());
	}
	
	@Test
	void testOneValue() {
		
		
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
		
		
		int result = service.findTheGreatest();
		
		
		assertEquals(5, result);
		
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {200});
		
		assertEquals(200,service.findTheGreatest());
	}


}

class DataServiceStub implements DataService{
	
	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {5,10,22};
	}	
}
