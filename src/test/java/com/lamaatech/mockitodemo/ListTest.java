package com.lamaatech.mockitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ListTest {

	@Mock
	List listMock;

	@Test
	void testSize() {

		when(listMock.size()).thenReturn(10).thenReturn(20);

		assertEquals(10, listMock.size());
		assertEquals(20, listMock.size());
		assertEquals(20, listMock.size());

	}
	
	@Test
	void testGet_SpecificParameter() {

		when(listMock.get(0)).thenReturn("SomeString");

		assertEquals("SomeString", listMock.get(0));
	}

	@Test
	void testGet_GenericParameter() {

		when(listMock.get(Mockito.anyInt())).thenReturn("SomeString");

		assertEquals("SomeString", listMock.get(5));
	}


}
