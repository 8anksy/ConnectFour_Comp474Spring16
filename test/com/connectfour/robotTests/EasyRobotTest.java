package com.connectfour.robotTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.connectfour.robot.EasyRobot;

public class EasyRobotTest {
	
	@Before
	public void setUp() throws Exception {
		new EasyRobot();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testGetRandomColumn() {
		for (int i = 0; i < 100; i++) {
			if (EasyRobot.getRandomColumn() < 0) {
				fail("Expected column out of bounds");
				}
			if (EasyRobot.getRandomColumn() > 7) { 
				fail("Expected column out of bounds");
				}
		}
	}

}
