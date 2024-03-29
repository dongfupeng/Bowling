package bowling.test;

import org.junit.Test;

import bowling.com.Game;

import junit.framework.TestCase;

public class TestGame extends TestCase {

	private Game game;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		game = new Game();
	}

	@Test
	public void testTwoThrowsNoMark() {
		game.add(4);
		game.add(5);
		assertEquals(9, game.score());
	}

	@Test
	public void testFourThrowsNoMark() {
		game.add(5);
		game.add(4);
		game.add(7);
		game.add(2);
		assertEquals(18, game.score());
		assertEquals(9, game.scoreForFrame(1));
		assertEquals(18, game.scoreForFrame(2));
	}
	
	@Test
	public void testSimpleSpare(){
		game.add(3);
		game.add(7);
		game.add(3);
		assertEquals(13, game.scoreForFrame(1));
	}

	
	@Test 
	public void testSimpleFrameAfterSpare(){
		game.add(3);
		game.add(7);
		game.add(3);
		game.add(4);
		assertEquals(13, game.scoreForFrame(1));
	    assertEquals(20, game.scoreForFrame(2));
	    assertEquals(20, game.score());
	}
	
	@Test
	public void test(){
		game.add(10);
		game.add(3);
		game.add(6);
		assertEquals(19, game.scoreForFrame(1));
		assertEquals(28, game.score());
		
	}
	
	@Test
	public void testPerfectGame(){
		for(int i  = 0;i<12;i++){
			game.add(10);
		}
		assertEquals(300, game.score());
	}
	
	@Test
	public void testEndOfArray(){
		for(int i = 0;i<9;i++){
			game.add(0);
			game.add(0);
		}
		game.add(2);
		game.add(8);
		game.add(10);
		assertEquals(20, game.score());
	}
	
	@Test
	public void testSampleGame(){
		game.add(1);
		game.add(4);
		game.add(4);
		game.add(5);
		game.add(6);
		game.add(4);
		game.add(5);
		game.add(5);
		game.add(10);
		game.add(0);
		game.add(1);
		game.add(7);
		game.add(3);
		game.add(6);
		game.add(4);
		game.add(10);
		game.add(2);
		game.add(8);
		game.add(6);
		assertEquals(133, game.score());
	}
	
	@Test
	public void testHeartBreak(){
		for(int i = 0;i<11;i++){
			game.add(10);
		}
		game.add(9);
		assertEquals(299, game.score());
	}
	
	@Test
	public void testTenthFrameSpare(){
		for(int i = 0;i<9;i++){
			game.add(10);
		}	
			game.add(9);
			game.add(1);
			game.add(1);
			assertEquals(270, game.score());
	}
}