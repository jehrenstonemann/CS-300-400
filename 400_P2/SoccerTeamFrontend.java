import java.util.List;
import java.util.Scanner;

/**
 * This class implements the ISoccerTeam Frontend Interface
 * allowing for a user interface to the roster allowing for it to be displayed
 * and for filters to be added for specified searches
 * @author Bryce
 *
 */
public class SoccerTeamFrontend implements ISoccerTeamFrontend{
        private ISoccerTeamBackend backend;                                     // backend instance
    private Scanner scanner = new Scanner(System.in);           // creates a scanner allowing user input
    String command;                                                                                     // user command for>
    String filterLowM;                                                                                  // low filter for m>
    String filterHiM;                                                                                   // high filter for >
    String filterLowR;                                                                                  // low filter for p>
    String filterHiR;                                                                                   // high filter for >
    
    /**
     * This method constructs the SoccerTeamFrontend providing a backend for
     * the ability to search and sort the roster
     * @param userInputScanner
     * @param backend
     */
    public SoccerTeamFrontend(Scanner userInput, ISoccerTeamBackend backend) {
        this.backend = backend;
    }    /**
     * This method runs the frontend initially displaying the application name and main menu
     * the user then has the ability to select one of the filters exit or display the roster
     */
        @Override
        public void runCommandLoop() {
                System.out.println("********************************************************************************************************\r\n"
                                + "Welcome to the Soccer Team Application!\r\n"
                                + "********************************************************************************************************\r\n");
        displayMainMenu();
        this.command = scanner.nextLine();
        while(!this.command.equals("4")) {
                if(this.command.equals("1")) {
                        displayRoster();
                displayMainMenu();
                this.command = scanner.nextLine();
            }
                else if(this.command.equals("2")) {
                marketValueFilter();
                displayMainMenu();
                this.command = scanner.nextLine();
            }
                else if(this.command.equals("3")) {
                        playerRatingFilter();
                displayMainMenu();
                this.command = scanner.nextLine();
            }
        }
        System.out.println("Closing application, goodbye!");

        }        /**
         * This method prints the main menu and prompts user input
         */
        @Override
        public void displayMainMenu() {
                System.out.println("Currently, you are in the main menu, select one of the following options:\r\n"
                                + "\r\n"
                                + "1) Display Roster\r\n"
                                + "2) Filter by Market Value\r\n"
                                + "3) Filter by Player Rating\r\n"
                                + "4) Exit\r\n");

        }

        /**
         * This method prints out the players matching the filters specified by the user
         */
        @Override
        public void displayRoster() {
                List<IPlayer> roster = this.backend.ListPlayers();
                System.out.println("Number of matches: " + roster.size());
                for(int i = 0; i < roster.size(); i++) {
                        System.out.println((i + 1) + ") " + roster.get(i).getName() 
                                        + " with a " + roster.get(i).getValue() 
                                        + " Market Value and a rating of " 
                                        + roster.get(i).getRating() + " out of 100.");
                }
                System.out.println();
        }/**
         * This method updates the market value filter values depending on user input if
         * filter is left blank by user that filter is reset
         */
        @Override
        public void marketValueFilter() {
                boolean lowFilter = false;
                boolean highFilter = false;
                System.out.print("You are in the Filter by Market Value Menu:\r\n"
                                + "                     Enter lower bound for Market Value Filter in Euros: ");
                this.filterLowM = scanner.nextLine();

                System.out.print("\r\n                  Enter upper bound for Market Value Filter in Euros: ");
                this.filterHiM = scanner.nextLine();

                if(filterLowM.equals("")) {
                        this.backend.resetLowerBoundMarketValueFilter();
                        lowFilter = true;
                }else {
                        try {
                                Integer.parseInt(filterLowM);
                                if(Integer.parseInt(filterLowM) < 0) {
                                        System.out.println("\r\nINVALID FILTER: must enter a positive int (enter nothing to reset)\r\n");
                                        marketValueFilter();
                                }
                                lowFilter = true;
                        } catch (NumberFormatException e) {
                                System.out.println("\r\nINVALID FILTER: must enter a positive int (enter nothing to reset)\r\n");
                                marketValueFilter();
                        }
                }
                if(filterHiM.equals("")) {
                        this.backend.resetUpperBoundMarketValueFilter();         
                        highFilter = true;}else {
                            try {
                                Integer.parseInt(filterHiM);
                                if(Integer.parseInt(filterHiM) < 0) {
                                            System.out.println("\r\nINVALID FILTER: must enter a positive int (enter nothing to reset)\r\n");
                                            marketValueFilter();
                                    }
                                highFilter = true;
                            } catch (NumberFormatException e) {
                                    System.out.println("\r\nINVALID FILTER: must enter a positive int (enter nothing to reset)\r\n");
                                    marketValueFilter();
                            }       
                    }
                    this.backend.setMarketValueLowerBoundFilter(filterLowM);
                    this.backend.setMarketValueUpperBoundFilter(filterHiM);
                    if((lowFilter == true) && (highFilter == true)) {
                            System.out.println("\r\nMarket Value Filter Set.\r\n");
                    }
        }
                    
                    /**
                     * This method updates the player rating filter values depending on user input if
                     * filter is left blank by user that filter is reset
                     */
                    @Override
                    public void playerRatingFilter() {
                        boolean lowFilter = false;
                        boolean highFilter = false;
                        System.out.print("You are in the Filter by Player Rating Menu:\r\n"
                                        + "                     Enter lower bound for Player Rating Filter (0 - 100): ");
                        this.filterLowR = scanner.nextLine();

                        System.out.print("\r\n                  Enter upper bound for Player Rating Filter (0 - 100): ");
                        this.filterHiR = scanner.nextLine();

                        if(filterLowR.equals("")) {
                                this.backend.resetLowerBoundRatingFilter();
                                lowFilter = true;
                        }else {
                                try {
                                        Integer.parseInt(filterLowR);
                                        if((Integer.parseInt(filterLowR) < 0) || (Integer.parseInt(filterLowR) > 100)) {
                                                System.out.println("\r\nINVALID FILTER: must enter a positive int (0 - 100)(enter nothing to reset)\r\n");
                                                playerRatingFilter();
                                        }
                                        lowFilter = true;
                                } catch (NumberFormatException e) {
                                        System.out.println("\r\nINVALID FILTER: must enter a positive int (0 - 100)(enter nothing to reset)\r\n");
                                        playerRatingFilter();
                                }
                        }
                        if(filterHiR.equals("")) {
                                this.backend.resetUpperBoundRatingFilter();
                                highFilter = true;
                        }else {
                                try {
                                        Integer.parseInt(filterHiR);
                                        if((Integer.parseInt(filterHiR) < 0) || (Integer.parseInt(filterHiR) > 100)) {
                                                System.out.println("\r\nINVALID FILTER: must enter a positive int (0 - 100)(enter nothing to reset)\r\n");
                                                playerRatingFilter();
                                        }
                                        highFilter = true;
                                } catch (NumberFormatException e) {
                                        System.out.println("\r\nINVALID FILTER: must enter a positive int (0 - 100)(enter nothing to reset)\r\n");
                                        playerRatingFilter();
                                }
                        }
                        this.backend.setRatingFilterLowerBound(filterLowR);
                        this.backend.setRatingFilterUpperBound(filterHiR);
                        if((lowFilter == true) && (highFilter == true)) {
                                System.out.println("\r\nPlayer Rating Filter Set.\r\n");
                        }
                    }
        }