package br.senai.suico.RestauranteX;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class MockSpy {

	@Mock
	private List<String> mockList;

	@Spy
	private List<String> spyList = new ArrayList<String>();

	@Test
	public void testMockList() {
		// by default, calling the methods of mock object will do nothing
		mockList.add("test");
		Assertions.assertNull(mockList.get(0));
	}

	@Test
	public void testSpyList() {
		// spy object will call the real method when not stub
		spyList.add("test");
		Assertions.assertEquals("test", spyList.get(0));
	}

	@Test
	public void testMockWithStub() {
		// try stubbing a method
		String expected = "Mock 100";
		Mockito.when(mockList.get(100)).thenReturn(expected);

		Assertions.assertEquals(expected, mockList.get(100));
	}

	@Test
	public void testSpyWithStub() {
		// stubbing a spy method will result the same as the mock object
		String expected = "Spy 100";
		// take note of using doReturn instead of when
		Mockito.when(spyList.get(100)).thenReturn(expected);

		Assertions.assertEquals(expected, spyList.get(100));
	}
}
