package com.connectfour.robotTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.connectfour.model.Board;
import com.connectfour.robot.EasyRobot;

public class EasyRobotTest {
	
	private EasyRobot easyRobot;
	
	@Before
	public void setUp() throws Exception {
		easyRobot = new EasyRobot(new Board());
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testGetRandomColumn() {
		for (int i = 0; i < 100; i++) {
			if (easyRobot.getColumn() < 0) {
				fail("Expected column out of bounds");
				}
			if (easyRobot.getColumn() > 7) { 
				fail("Expected column out of bounds");
				}
		}
	}

}
