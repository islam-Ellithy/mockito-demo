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
	void testFindTheGreatestFromAllData() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5,10,20});
		assertEquals(20, service.findTheGreatest());
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {100,200,300});
		assertEquals(300,service.findTheGreatest());
	}
	
	@Test
	void testFindTheGreatestFromAllData_ForOneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
		assertEquals(5, service.findTheGreatest());
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {100});
		assertEquals(100,service.findTheGreatest());
	}

	@Test
	void testFindTheGreatestFromAllData_ForNoValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, service.findTheGreatest());
	}

}

 