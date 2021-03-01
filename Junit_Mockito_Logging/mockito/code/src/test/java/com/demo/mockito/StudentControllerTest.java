package com.demo.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentControllerTest {
	StudentController stud;
	@BeforeEach
	void before()
	{
		stud = new StudentController();
	}
	@Test
	void testName() {
		Student s = mock(Student.class);
		when(s.getFirstName()).thenReturn("Mohit");
		when(s.getLastName()).thenReturn("Gupta");
		String name = stud.getFullName(s);
		assertEquals("Mohit Gupta",name);
		verify(s).getFirstName();
		verify(s,times(1)).getLastName();
	}
	@Test
	void testRollNumber() {
		Student s = mock(Student.class);
		when(s.getId()).thenReturn(21);
		int roll = stud.getStudentRollNumber(s);
		assertEquals(21,roll);
		verify(s).getId();
	}
	@Test
	void testAge() {
		Student s = mock(Student.class);
		when(s.getFirstName()).thenReturn("Mohit");
		when(s.getLastName()).thenReturn("Gupta");
		when(s.getAge()).thenReturn(21);
		String roll = stud.getStudentAge(s);
		assertEquals("Mohit Gupta is 21 years old.",roll);
		verify(s).getAge();
	}
	@AfterEach
	void after()
	{
		stud = null;
	}
}
