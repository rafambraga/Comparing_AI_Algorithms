package Assignment5;
import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;

public class Main {
	
	static void initCompleteUSMap(Map map) {
		map.states.add("Alabama");			// 0
		map.states.add("Alaska");			// 1
		map.states.add("Arizona");			// 2
		map.states.add("Arkansas");			// 3
		map.states.add("California");		// 4
		map.states.add("Colorado");			// 5
		map.states.add("Connecticut");		// 6
		map.states.add("Delaware");			// 7
		map.states.add("Florida");			// 8
		map.states.add("Georgia");			// 9
		map.states.add("Hawaii");			// 10
		map.states.add("Idaho");			// 11
		map.states.add("Illinois");			// 12
		map.states.add("Indiana");			// 13
		map.states.add("Iowa");				// 14
		map.states.add("Kansas");			// 15
		map.states.add("Kentucky");			// 16
		map.states.add("Louisiana");		// 17
		map.states.add("Maine");			// 18
		map.states.add("Maryland");			// 19
		map.states.add("Massachusetts");	// 20
		map.states.add("Michigan");			// 21
		map.states.add("Minnesota");		// 22
		map.states.add("Mississippi");		// 23
		map.states.add("Missouri");			// 24
		map.states.add("Montana");			// 25
		map.states.add("Nebraska");			// 26
		map.states.add("Nevada");			// 27
		map.states.add("New Hampshire");	// 28
		map.states.add("New Jersey");		// 29
		map.states.add("New Mexico");		// 30
		map.states.add("New York");			// 31
		map.states.add("North Carolina");	// 32
		map.states.add("North Dakota");		// 33
		map.states.add("Ohio");				// 34
		map.states.add("Oklahoma");			// 35
		map.states.add("Oregon");			// 36
		map.states.add("Pennsylvania");		// 37
		map.states.add("Rhode Island");		// 38
		map.states.add("South Carolina");	// 39
		map.states.add("South Dakota");		// 40
		map.states.add("Tennessee");		// 41
		map.states.add("Texas");			// 42
		map.states.add("Utah");				// 43
		map.states.add("Vermont");			// 44
		map.states.add("Virginia");			// 45
		map.states.add("Washington");		// 46
		map.states.add("West Virginia");	// 47
		map.states.add("Wisconsin");		// 48
		map.states.add("Wyoming");			// 49

		map.borders.add(new Border(0, 8));
		map.borders.add(new Border(0, 9));
		map.borders.add(new Border(0, 23));
		map.borders.add(new Border(0, 41));
		map.borders.add(new Border(2, 4));
		map.borders.add(new Border(2, 27));
		map.borders.add(new Border(2, 30));
		map.borders.add(new Border(2, 43));
		map.borders.add(new Border(3, 17));
		map.borders.add(new Border(3, 23));
		map.borders.add(new Border(3, 24));
		map.borders.add(new Border(3, 35));
		map.borders.add(new Border(3, 41));
		map.borders.add(new Border(3, 42));
		map.borders.add(new Border(4, 27));
		map.borders.add(new Border(4, 36));
		map.borders.add(new Border(5, 15));
		map.borders.add(new Border(5, 26));
		map.borders.add(new Border(5, 30));
		map.borders.add(new Border(5, 35));
		map.borders.add(new Border(5, 43));
		map.borders.add(new Border(5, 49));
		map.borders.add(new Border(6, 20));
		map.borders.add(new Border(6, 31));
		map.borders.add(new Border(6, 38));
		map.borders.add(new Border(7, 19));
		map.borders.add(new Border(7, 29));
		map.borders.add(new Border(7, 37));
		map.borders.add(new Border(8, 9));
		map.borders.add(new Border(9, 32));
		map.borders.add(new Border(9, 39));
		map.borders.add(new Border(9, 41));
		map.borders.add(new Border(11, 25));
		map.borders.add(new Border(11, 27));
		map.borders.add(new Border(11, 36));
		map.borders.add(new Border(11, 43));
		map.borders.add(new Border(11, 46));
		map.borders.add(new Border(11, 49));
		map.borders.add(new Border(12, 13));
		map.borders.add(new Border(12, 14));
		map.borders.add(new Border(12, 16));
		map.borders.add(new Border(12, 24));
		map.borders.add(new Border(12, 48));
		map.borders.add(new Border(13, 16));
		map.borders.add(new Border(13, 21));
		map.borders.add(new Border(13, 34));
		map.borders.add(new Border(14, 22));
		map.borders.add(new Border(14, 24));
		map.borders.add(new Border(14, 26));
		map.borders.add(new Border(14, 40));
		map.borders.add(new Border(14, 48));
		map.borders.add(new Border(15, 24));
		map.borders.add(new Border(15, 26));
		map.borders.add(new Border(15, 35));
		map.borders.add(new Border(16, 24));
		map.borders.add(new Border(16, 34));
		map.borders.add(new Border(16, 41));
		map.borders.add(new Border(16, 45));
		map.borders.add(new Border(16, 47));
		map.borders.add(new Border(17, 23));
		map.borders.add(new Border(17, 42));
		map.borders.add(new Border(18, 28));
		map.borders.add(new Border(19, 37));
		map.borders.add(new Border(19, 45));
		map.borders.add(new Border(19, 47));
		map.borders.add(new Border(20, 28));
		map.borders.add(new Border(20, 31));
		map.borders.add(new Border(20, 38));
		map.borders.add(new Border(20, 44));
		map.borders.add(new Border(21, 34));
		map.borders.add(new Border(21, 48));
		map.borders.add(new Border(22, 33));
		map.borders.add(new Border(22, 40));
		map.borders.add(new Border(22, 48));
		map.borders.add(new Border(23, 41));
		map.borders.add(new Border(24, 26));
		map.borders.add(new Border(24, 35));
		map.borders.add(new Border(24, 41));
		map.borders.add(new Border(25, 33));
		map.borders.add(new Border(25, 40));
		map.borders.add(new Border(25, 49));
		map.borders.add(new Border(26, 40));
		map.borders.add(new Border(26, 49));
		map.borders.add(new Border(27, 36));
		map.borders.add(new Border(27, 43));
		map.borders.add(new Border(28, 44));
		map.borders.add(new Border(29, 31));
		map.borders.add(new Border(29, 37));
		map.borders.add(new Border(30, 35));
		map.borders.add(new Border(30, 42));
		map.borders.add(new Border(30, 43));
		map.borders.add(new Border(31, 37));
		map.borders.add(new Border(31, 44));
		map.borders.add(new Border(32, 39));
		map.borders.add(new Border(32, 41));
		map.borders.add(new Border(32, 45));
		map.borders.add(new Border(33, 40));
		map.borders.add(new Border(34, 37));
		map.borders.add(new Border(34, 47));
		map.borders.add(new Border(35, 42));
		map.borders.add(new Border(36, 46));
		map.borders.add(new Border(37, 47));
		map.borders.add(new Border(40, 49));
		map.borders.add(new Border(41, 45));
		map.borders.add(new Border(43, 49));
		map.borders.add(new Border(45, 47));
	}
	
	/**
	 * Initializes the map of the states in the South West of the USA
	 * @param map The map to be initialized
	 */
	static void initMap(Map map) {
		map.states.add("North Carolina");
		map.states.add("South Carolina");
		map.states.add("Virginia");
		map.states.add("Tennessee");
		map.states.add("Kentucky");
		map.states.add("West Virginia");
		map.states.add("Georgia");
		map.states.add("Alabama");
		map.states.add("Mississippi");
		map.states.add("Florida");

		map.borders.add(new Border(0, 1));
		map.borders.add(new Border(0, 2));
		map.borders.add(new Border(0, 3));
		map.borders.add(new Border(0, 6));
		map.borders.add(new Border(1, 6));
		map.borders.add(new Border(2, 3));
		map.borders.add(new Border(2, 4));
		map.borders.add(new Border(2, 5));
		map.borders.add(new Border(3, 4));
		map.borders.add(new Border(3, 6));
		map.borders.add(new Border(3, 7));
		map.borders.add(new Border(3, 8));
		map.borders.add(new Border(4, 5));
		map.borders.add(new Border(6, 7));
		map.borders.add(new Border(6, 9));
		map.borders.add(new Border(7, 8));
		map.borders.add(new Border(7, 9));
	}
	
	/**
	 * Initialized some sudoku.
	 * @param sudoku The sudoku to be initialized.
	 */
	static void initSudoku(Sudoku sudoku) {
		sudoku.givenValues.put("A3", 6);
		sudoku.givenValues.put("A4", 9);
		sudoku.givenValues.put("A5", 8);
		sudoku.givenValues.put("B1", 9);
		sudoku.givenValues.put("B7", 2);
		sudoku.givenValues.put("B8", 5);
		sudoku.givenValues.put("B9", 1);
		sudoku.givenValues.put("C3", 4);
		sudoku.givenValues.put("C6", 1);
		sudoku.givenValues.put("D5", 2);
		sudoku.givenValues.put("D6", 4);
		sudoku.givenValues.put("E1", 7);
		sudoku.givenValues.put("E2", 2);
		sudoku.givenValues.put("E5", 5);
		sudoku.givenValues.put("E8", 6);
		sudoku.givenValues.put("E9", 3);
		sudoku.givenValues.put("F4", 1);
		sudoku.givenValues.put("F5", 7);
		sudoku.givenValues.put("G4", 3);
		sudoku.givenValues.put("G7", 5);
		sudoku.givenValues.put("H1", 8);
		sudoku.givenValues.put("H2", 6);
		sudoku.givenValues.put("H3", 7);
		sudoku.givenValues.put("H9", 9);
		sudoku.givenValues.put("I5", 9);
		sudoku.givenValues.put("I6", 7);
		sudoku.givenValues.put("I7", 1);
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please choose implementation: \n1: Political map of the South-Eastern states \n2: USA Map \n3: Sudoku");
		int action = input.nextInt();
		Map map = new Map();
		Sudoku sudoku = new Sudoku();
		CSP<Integer> cspb, cspbmrv, csp, cspmrv, cspac3, cspac3mrv,cspmin;
		
		if(action!=3){
			if(action ==1)
				initMap(map);
			else
				initCompleteUSMap(map);
		
			cspb = map.createCSP();
			cspbmrv = map.createCSP();
			csp = map.createCSP();
			cspmrv = map.createCSP();	
			cspac3 = map.createCSP();
			cspac3mrv = map.createCSP();	
			cspmin = map.createCSP();
		}
		else{
			initSudoku(sudoku);
			cspb = sudoku.createCSP();
			cspbmrv = sudoku.createCSP();
			csp = sudoku.createCSP();
			cspmrv = sudoku.createCSP();	
			cspac3 = sudoku.createCSP();
			cspac3mrv = sudoku.createCSP();	
			cspmin = sudoku.createCSP();
		}

		/*
		cspb.domains.get("Georgia").clear();
		cspb.domains.get("Georgia").add(2);
		cspbmrv.domains.get("Georgia").clear();
		cspbmrv.domains.get("Georgia").add(2);
		csp.domains.get("Georgia").clear();
		csp.domains.get("Georgia").add(2);
		cspmrv.domains.get("Georgia").clear();
		cspmrv.domains.get("Georgia").add(2);
		cspac3.domains.get("Georgia").clear();
		cspac3.domains.get("Georgia").add(2);
		cspac3mrv.domains.get("Georgia").clear();
		cspac3mrv.domains.get("Georgia").add(2);
		cspmin.domains.get("Georgia").clear();
		cspmin.domains.get("Georgia").add(2);
		cspb.domains.get("Georgia").clear();
		cspb.domains.get("Georgia").add(2);
		*/
		
		CSPSolver solverForwardChecking = new BacktrackingCSPSolver();
		CSPResult<Integer> resultForwardChecking = null; 
		int runTimes = 30;
		long time = 0; 
		for (int i = 1; i<=runTimes; i++) {
			long start1 = System.nanoTime();
			resultForwardChecking = solverForwardChecking.solve(csp,0);
			long end1 = System.nanoTime(); 
			time = time + end1-start1; 
		}
		System.out.println("Elapsed Time in nano seconds for fowardChecking: "+ time/runTimes);
		
		
		time = 0;
		CSPSolver solverForwardCheckingMRVLRVDH = new BacktrackingCSPSolver();
		CSPResult<Integer> resultForwardCheckingMRVLRVDH = null;
		for (int i = 1; i<=runTimes; i++) {
			long start1 = System.nanoTime();
			resultForwardCheckingMRVLRVDH = solverForwardCheckingMRVLRVDH.solve(cspmrv,1);
			long end1 = System.nanoTime(); 
			time = time + end1-start1; 
		}
		System.out.println("Elapsed Time in nano seconds for foward checking using Min Remaining Value, Least Remaining Value and One Degree Heuristic: "+ time/runTimes);
		
		time = 0;
		CSPSolver solverAC3 = new BacktrackingCSPSolver();
		CSPResult<Integer> resultAC3 =  null;
		for (int i = 1; i<=runTimes; i++) {
			long start1 = System.nanoTime();
			resultAC3 = solverAC3.solve(cspac3,2);
			long end1 = System.nanoTime(); 
			time = time + end1-start1; 
		}
		System.out.println("Elapsed Time in nano seconds using AC3: "+ time/runTimes);
		
		time = 0;
		CSPSolver solverAC3MRVLRVDH = new BacktrackingCSPSolver();
		CSPResult<Integer> resultAC3MRVLRVDH =  null;
		for (int i = 1; i<=runTimes; i++) {
			long start1 = System.nanoTime();
			resultAC3MRVLRVDH  = solverAC3MRVLRVDH.solve(cspac3mrv,3);
			long end1 = System.nanoTime(); 
			time = time + end1-start1; 
		}
		System.out.println("Elapsed Time in nano seconds using AC3 using Min Remaining Value, Least Remaining Value and One Degree Heuristic: "+ time/runTimes);
		
		time = 0;
		CSPSolver solverBacktracking = new BacktrackingCSPSolver();
		CSPResult<Integer> resultBacktracking  =  null;
		for (int i = 1; i<=runTimes; i++) {
			long start1 = System.nanoTime();
			resultBacktracking  = solverBacktracking.solve(cspb,4);
			long end1 = System.nanoTime(); 
			time = time + end1-start1; 
		}
		System.out.println("Elapsed Time in nano seconds using Backtracking: "+ time/runTimes);
		
		
		time = 0;
		CSPSolver solverBacktrackingMRVLCVDH = new BacktrackingCSPSolver();
		CSPResult<Integer> resultBacktrackingMRVLCVDH  =  null;
		for (int i = 1; i<=runTimes; i++) {
			long start1 = System.nanoTime();
			resultBacktrackingMRVLCVDH  = solverBacktracking.solve(cspbmrv,5);
			long end1 = System.nanoTime(); 
			time = time + end1-start1; 
		}
		System.out.println("Elapsed Time in nano seconds using Backtracking and Min Remaining Value, Least Remaining Value and One Degree Heuristic: "+ time/runTimes);
		
		time = 0;
		CSPSolver solverMinConflicts = new MinConflicts();
		CSPResult<Integer> resultMinConflicts =  null;
		for (int i = 1; i<=runTimes; i++) {
			long start1 = System.nanoTime();
			resultMinConflicts = solverMinConflicts.solve(cspmin,2);
			long end1 = System.nanoTime(); 
			time = time + end1-start1; 
		}
		System.out.println("Elapsed Time in nano seconds using min conflicts: "+ time/runTimes +"\n");

		
		
		System.out.println("Backtracking using Forward Checking:");
		if(resultForwardChecking.assignment == null) {
			System.out.println("Found no solution!\n");
		} else {
			System.out.println(resultForwardChecking.toString()+"\n");
		}
		
		System.out.println("Backtracking using AC3:");
		if(resultAC3.assignment == null) {
			System.out.println("Found no solution!\n");
		} else {
			System.out.println(resultAC3.toString()+"\n");
		}
		
		System.out.println("Backtracking using Min Remaining Value, Least Remaining Value and One Degree Heuristic:");
		if(resultBacktrackingMRVLCVDH.assignment == null) {
			System.out.println("Found no solution!\n");
		} else {
			System.out.println(resultBacktrackingMRVLCVDH.toString()+"\n");
		}
		
		System.out.println("Backtracking using Forward Checking with Min Remaining Value, Least Remaining Value and One Degree Heuristic:");
		if(resultForwardCheckingMRVLRVDH.assignment == null) {
			System.out.println("Found no solution!\n");
		} else {
			System.out.println(resultForwardCheckingMRVLRVDH.toString()+"\n");
		}
		
		System.out.println("Backtracking using AC3 with Min Remaining Value, Least Remaining Value and One Degree Heuristic:");
		if(resultAC3MRVLRVDH.assignment == null) {
			System.out.println("Found no solution!\n");
		} else {
			System.out.println(resultAC3MRVLRVDH.toString()+"\n");
		}
		
		System.out.println("Local Search using Min Conflicts:");
		if(resultMinConflicts.assignment == null) {
			System.out.println("Found no solution!\n");
		} else {
			System.out.println(resultMinConflicts.toString()+"\n");
		}
	}
}