import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * junit test for backend developer
 * 
 * @author Huang Xiangyu
 *
 */
class BackendDeveloperTests {

	/**
	 * check if get numbers of players and insert players work as expected
	 */
	@Test
	void test1() {
		BDSoccerTeamBackend test = new BDSoccerTeamBackend();
		BDPlayer player1=new BDPlayer("A","11","3");
		BDPlayer player2=new BDPlayer("B","15","2");
		BDPlayer player3=new BDPlayer("C","17","5");
		assertEquals(test.getNumberOfPlayers(),Integer.parseInt("0"));
		test.addPlayer(player1);
		test.addPlayer(player2);
		assertEquals(test.getNumberOfPlayers(),Integer.parseInt("2"));
		test.addPlayer(player3);
		assertEquals(test.getNumberOfPlayers(),Integer.parseInt("3"));
	}
	
	/**
	 * check if set filters and list players work as expected
	 */
	@Test
	void test2() {
		BDSoccerTeamBackend test = new BDSoccerTeamBackend();
		BDPlayer player1=new BDPlayer("A","11","3");
		BDPlayer player2=new BDPlayer("B","15","2");
		BDPlayer player3=new BDPlayer("C","17","5");
		BDPlayer player4=new BDPlayer("D","13","2");
		BDPlayer player5 = new BDPlayer("E","19","1");
		test.addPlayer(player1);
		test.addPlayer(player2);
		test.addPlayer(player3);
		test.addPlayer(player4);
		test.addPlayer(player5);
		// 1-3
		test.setRatingFilterLowerBound("1");
		test.setRatingFilterUpperBound("3");
		List<IPlayer> list = test.ListPlayers();
		assertEquals(list.get(0),player2);
		assertEquals(list.get(1),player4);
		assertEquals(test.getLowerBoundRatingFilter(),Integer.parseInt("1"));
		assertEquals(test.getUpperBoundRatingFilter(),Integer.parseInt("3"));	
	}
	
	/**
	 * check if reset filters work correctly
	 */
	@Test
	void test3() {
		BDSoccerTeamBackend test = new BDSoccerTeamBackend();
		BDPlayer player1=new BDPlayer("A","11","3");
		BDPlayer player2=new BDPlayer("B","15","2");
		BDPlayer player3=new BDPlayer("C","17","5");
		BDPlayer player4=new BDPlayer("D","13","2");
		BDPlayer player5 = new BDPlayer("E","19","1");
		test.addPlayer(player1);
		test.addPlayer(player2);
		test.addPlayer(player3);
		test.addPlayer(player4);
		test.addPlayer(player5);
		test.setRatingFilterLowerBound("1");
		test.setRatingFilterUpperBound("3");
		test.resetLowerBoundRatingFilter();
		List<IPlayer> list = test.ListPlayers();
		assertEquals(list.get(0),player2);
		assertEquals(list.get(1),player4);
		assertEquals(list.get(2),player5);
		assertEquals(test.getUpperBoundRatingFilter(),Integer.parseInt("3"));
	}
	
	/**
	 * check if setting multiple filters work correctly
	 */
	@Test
	void test4() {
		BDSoccerTeamBackend test = new BDSoccerTeamBackend();
		BDPlayer player1=new BDPlayer("A","11","3");
		BDPlayer player2=new BDPlayer("B","15","2");
		BDPlayer player3=new BDPlayer("C","17","5");
		BDPlayer player4=new BDPlayer("D","13","2");
		BDPlayer player5 = new BDPlayer("E","19","1");
		test.addPlayer(player1);
		test.addPlayer(player2);
		test.addPlayer(player3);
		test.addPlayer(player4);
		test.addPlayer(player5);
		test.setMarketValueLowerBoundFilter("12");
		test.setMarketValueUpperBoundFilter("16");
		test.setRatingFilterLowerBound("0");
		test.setRatingFilterUpperBound("3");
		List<IPlayer> list = test.ListPlayers();
		assertEquals(list.get(0),player2);
		assertEquals(list.get(1),player4);
	}
	
	/**
	 * check if just setting one boundary (either lower or higher) works correctly
	 */
	@Test
	void test5() {
		BDSoccerTeamBackend test = new BDSoccerTeamBackend();
		BDPlayer player1=new BDPlayer("A","11","3");
		BDPlayer player2=new BDPlayer("B","15","2");
		BDPlayer player3=new BDPlayer("C","17","5");
		BDPlayer player4=new BDPlayer("D","13","2");
		BDPlayer player5 = new BDPlayer("E","19","1");
		test.addPlayer(player1);
		test.addPlayer(player2);
		test.addPlayer(player3);
		test.addPlayer(player4);
		test.addPlayer(player5);
		test.setMarketValueUpperBoundFilter("16");
		test.setRatingFilterLowerBound("1");
		List<IPlayer> list = test.ListPlayers();
		assertEquals(list.get(0),player1);
		assertEquals(list.get(1),player2);
		assertEquals(list.get(2),player4);
	}
	
	/**
	 * test whether filter rating works correctly
	 */
	@Test
	void Integration1() {
		try {
			List<IPlayer> players = (new PlayerLoader()).loadPlayers("player.xml");;
			SoccerTeamBackend test = new SoccerTeamBackend();
			for (IPlayer player : players) {
				test.addPlayer(player);
			}
			assertEquals(test.getNumberOfPlayers(),37);
			test.setRatingFilterLowerBound("60");
			test.setRatingFilterUpperBound("70");
			assertEquals(test.getLowerBoundRatingFilter(),Integer.parseInt("60"));
			assertEquals(test.getUpperBoundRatingFilter(),Integer.parseInt("70"));
			assertEquals(test.ListPlayers().size(),3);
			test.setRatingFilterLowerBound("");
			test.setRatingFilterUpperBound("");
			assertEquals(test.ListPlayers().size(),37);
		}catch(FileNotFoundException e) {
			fail("FileNotFoundException");
		}
	}
	
	/**
	 * test whether Market Value rating works correctly
	 */
	@Test
	void Integration2() {
		try {
			List<IPlayer> players = (new PlayerLoader()).loadPlayers("player.xml");;
			SoccerTeamBackend test = new SoccerTeamBackend();
			for (IPlayer player : players) {
				test.addPlayer(player);
			}
			assertEquals(test.getNumberOfPlayers(),37);
			test.setMarketValueLowerBoundFilter("20000000");
			test.setMarketValueUpperBoundFilter("30000000");
			assertEquals(test.getMarketValueLowerBoundFilter(),Integer.parseInt("20000000"));
			assertEquals(test.getMarketValueUpperBoundFilter(),Integer.parseInt("30000000"));
			assertEquals(test.ListPlayers().size(),1);
			test.setMarketValueLowerBoundFilter("");
			test.setMarketValueUpperBoundFilter("");
			assertEquals(test.ListPlayers().size(),37);
		}catch(FileNotFoundException e) {
			fail("FileNotFoundException");
		}
	}
	
	@Test
	void CodeReviewOfFrontendDeveloper1() {
		try {
		List<IPlayer> players = (new PlayerLoader()).loadPlayers("player.xml");;
		SoccerTeamBackend test = new SoccerTeamBackend();
		for (IPlayer player : players) {
			test.addPlayer(player);
		}
		boolean line = true;                                                  
        TextUITester test1 = new TextUITester("1\n4");                       
        SoccerTeamFrontend frontend = new SoccerTeamFrontend(null, test);    
        frontend.runCommandLoop();                                             
        String console = test1.checkOutput();                                   

        if(console.contains("Number of matches: 37") == false) {
                line = false;
        }
        if(console.contains("1) Kylian Mbappe with a 190500000 Market Value and a rating of 91 out of 100.") == false) {
                line = false;
        }
        if(console.contains("37) Alejandro Garnacho with a 1600000 Market Value and a rating of 64 out of 100.") == false) {
                line = false;
        }
        assertEquals(true,line);
		}catch(FileNotFoundException e) {
			fail("FileNotFoundException");
		}
	}
	@Test
	void CodeReviewOfFrontendDeveloper2() {
		try {
		List<IPlayer> players = (new PlayerLoader()).loadPlayers("player.xml");;
		SoccerTeamBackend test = new SoccerTeamBackend();
		for (IPlayer player : players) {
			test.addPlayer(player);
		}
		boolean line = true;                                                   
        TextUITester test1 = new TextUITester("2\n\n4700000\n3\n70\n\n1\n4\n");             
        SoccerTeamFrontend frontend = new SoccerTeamFrontend(null, test);   
        frontend.runCommandLoop();                                             
        String console = test1.checkOutput();                                 

        if(console.contains("Number of matches: 2") == false) {
                line = false;
        }
        if(console.contains("1) E. Choupo-Moting with a 3600000 Market Value and a rating of 75 out of 100.") == false) {
                line = false;
        }
        if(console.contains("2) Dani Alves with a 2300000 Market Value and a rating of 77 out of 100.") == false) {
                line = false;
        }
        assertEquals(true,line);
		}catch(FileNotFoundException e) {
			fail("FileNotFoundException");
		}
	}
}
