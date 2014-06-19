package bowling.test;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.com.Frame;

public class TestFrame {

	@Test
	public void testScoreNoThrows() {
         
		Frame frame = new Frame();
		assertEquals(0, frame.getScore());
 	}
	
	@Test
	public void testAddOneThrow(){
		
		Frame frame = new Frame();
		frame.add(5);
		assertEquals(5, frame.getScore());
	}
}
