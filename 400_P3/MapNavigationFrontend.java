import java.util.List;
import java.util.Scanner;

public class MapNavigationFrontend implements IMapNavigationFrontend {

  private IMapNavigationBackend backend;
  private Scanner scnr;
  private String input;

  public MapNavigationFrontend(Scanner userInputScanner, IMapNavigationBackend backend) {
    scnr = new Scanner(System.in);
    this.backend = backend;
  }

  /**
   * This method starts the command loop for the frontend, and will terminate when the user exits
   * the app.
   */
  @Override
  public void runCommandLoop() {
    System.out.println("Welcome to the UW-Madison Mailing Application!");
    System.out.println("x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x\n");
    displayMainMenu();
    input = scnr.nextLine();
    while (!input.equals("4")) {
      if (input.equals("1")) {
        displaynearestlocations();
        displayMainMenu();
      } else if (input.equals("2")) {
        displayshortestpath();
        displayMainMenu();
      } else if (input.equals("3")) {
        distanceFilter();
        displayMainMenu();
      } else {
        System.out.println("please type 1 2 3 4");
      }
      this.input = scnr.nextLine();
    }
    System.out.println("Goodbye!");
  }

  /**
   * This method prints command options to System.out
   */
  @Override
  public void displayMainMenu() {
    System.out.println("You are in the Main Menu:");
    System.out.println("          1) Find nearest locations");
    System.out.println("          2) Get Shortest Path");
    System.out.println("          3) Distance filter");
    System.out.println("          4) Exit Application");
  }

  /**
   * This method finds the nearest locations 
   */
  @Override
  public void displaynearestlocations() {
    System.out.println(
        "You are in the Find nearest locations Menu, here is the list of location you can set: ");
    System.out.println("   A. FedEx");
    System.out.println("   B. CSBuilding");
    System.out.println("   C. Grainger");
    System.out.println("   D. Chemistry Building");
    System.out.println("   E. Chamberlin");
    System.out.println("   F. Sterling");
    System.out.println("   G. Van Hise");
    System.out.println("   H. Van Vleck");
    System.out.println("");
    System.out.println("       Please set your current location: ");
    input = scnr.nextLine();
    if (input.toUpperCase().equals("A")) {
      backend.setCurrLocation("FedEx");
    } else if (input.toUpperCase().equals("B")) {
      backend.setCurrLocation("CSBuilding");
    } else if (input.toUpperCase().equals("C")) {
      backend.setCurrLocation("Grainger");
    } else if (input.toUpperCase().equals("D")) {
      backend.setCurrLocation("Chemistry Building");
    } else if (input.toUpperCase().equals("E")) {
      backend.setCurrLocation("Chamberlin");
    } else if (input.toUpperCase().equals("F")) {
      backend.setCurrLocation("Sterling");
    } else if (input.toUpperCase().equals("G")) {
      backend.setCurrLocation("VanHise");
    } else if (input.toUpperCase().equals("H")) {
      backend.setCurrLocation("VanVleck");
    } else {
      System.out.println("This is not a valid location, you can only type letter A-H");
      System.out.println("");
      return;
    }
    List<String> list = backend.displayNearbyBuildings();
    System.out.println("Here are the shortest distances to go to these locations (" + list.size()
        + " of 7 match):");
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i) + ": " + backend.shortestPathCost(list.get(i)));
    }
    System.out.println("");
  }

  /**
   * This method reads starting point and ending from System.in, and displays results
   */
  @Override
  public void displayshortestpath() {
    System.out.println(
        "You are in the Get Shortest Path Menu, here is the list of location you can set: ");
    System.out.println("   A. FedEx");
    System.out.println("   B. CSBuilding");
    System.out.println("   C. Grainger");
    System.out.println("   D. Chemistry Building");
    System.out.println("   E. Chamberlin");
    System.out.println("   F. Sterling");
    System.out.println("   G. Van Hise");
    System.out.println("   H. Van Vleck");
    System.out.println("");
    System.out.println("          Enter Starting Location: ");
    input = scnr.nextLine();
    if (input.toUpperCase().equals("A")) {
      backend.setCurrLocation("FedEx");
    } else if (input.toUpperCase().equals("B")) {
      backend.setCurrLocation("CSBuilding");
    } else if (input.toUpperCase().equals("C")) {
      backend.setCurrLocation("Grainger");
    } else if (input.toUpperCase().equals("D")) {
      backend.setCurrLocation("Chemistry Building");
    } else if (input.toUpperCase().equals("E")) {
      backend.setCurrLocation("Chamberlin");
    } else if (input.toUpperCase().equals("F")) {
      backend.setCurrLocation("Sterling");
    } else if (input.toUpperCase().equals("G")) {
      backend.setCurrLocation("VanHise");
    } else if (input.toUpperCase().equals("H")) {
      backend.setCurrLocation("VanVleck");
    } else {
      System.out.println("This is not a valid location, you can only type letter A-H");
      System.out.println("");
      return;
    }
    System.out.println("          Enter Destination: ");
    String input2 = scnr.nextLine();
    double shortestPathCost = 0.0;
    List<String> shortestPath;
    if (input2.toUpperCase().equals(input.toUpperCase())) {
      System.out.println("You can't set currLocation and destination the same");
      System.out.println("");
      return;
    } else if (input2.toUpperCase().equals("A")) {
      shortestPathCost = backend.shortestPathCost("FedEx");
      shortestPath = backend.shortestPath("FedEx");
    } else if (input2.toUpperCase().equals("B")) {
      shortestPathCost = backend.shortestPathCost("CSBuilding");
      shortestPath = backend.shortestPath("CSBuilding");
    } else if (input2.toUpperCase().equals("C")) {
      shortestPathCost = backend.shortestPathCost("Grainger");
      shortestPath = backend.shortestPath("Grainger");
    } else if (input2.toUpperCase().equals("D")) {
      shortestPathCost = backend.shortestPathCost("Chemistry Building");
      shortestPath = backend.shortestPath("Chemistry Building");
    } else if (input2.toUpperCase().equals("E")) {
      shortestPathCost = backend.shortestPathCost("Chamberlin");
      shortestPath = backend.shortestPath("Chamberlin");
    } else if (input2.toUpperCase().equals("F")) {
      shortestPathCost = backend.shortestPathCost("Sterling");
      shortestPath = backend.shortestPath("Sterling");
    } else if (input2.toUpperCase().equals("G")) {
      shortestPathCost = backend.shortestPathCost("VanHise");
      shortestPath = backend.shortestPath("VanHise");
    } else if (input2.toUpperCase().equals("H")) {
      shortestPathCost = backend.shortestPathCost("VanVleck");
      shortestPath = backend.shortestPath("VanVleck");
    } else {
      System.out.println("This is not a valid location, you can only type letter A-H");
      System.out.println("");
      return;
    }
    System.out.println(
        "Shortest distance between starting location and destination is " + shortestPathCost);
    System.out.print("Shortest path: ");
    for (int i = 0; i < shortestPath.size(); i++) {
      System.out.print(shortestPath.get(i));
      if (i < shortestPath.size() - 1) {
        System.out.print(" -> ");
      }
    }
    System.out.println("\n");
  }

  /**
   * This method reads cost from System.in, and sets it to backend
   */
  @Override
  public void distanceFilter() {
    System.out.println("You are in the Set Distance Filter Menu: ");
    System.out.println("       Set the maximum distance: ");
    input = scnr.nextLine();
    if (input.equals("")) {
      backend.resetDistanceFilter();
    } else {
      try {
        double distance = Double.parseDouble(input);
        if (distance <= 0) {
          throw new Exception();
        }
        backend.setDistanceFilter(input);
      } catch (Exception e) {
        System.out.println("You should enter a valid positive number");
      }
    }
  }
}
