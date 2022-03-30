package com.lamaatech.mockitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class MyBusinessImplTest {

	@Test
	void test() {
		
		
		DataService dataServiceMock = mock(DataService.class);
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5,10,20});

		
		MyBusinessImpl service = new MyBusinessImpl(dataServiceMock);
		
		
		int result = service.findTheGreatest();
		
		
		assertEquals(20, result);
		
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {100,200,300});
		
		assertEquals(300,service.findTheGreatest());
	}
	
	@Test
	void testOneValue() {
		
		
		DataService dataServiceMock = mock(DataService.class);
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});

		
		MyBusinessImpl service = new MyBusinessImpl(dataServiceMock);
		
		
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
