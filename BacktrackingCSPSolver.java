package Assignment5;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Random;

/**
 * A class implementing the backtracking CSP algorithm.
 */
public class BacktrackingCSPSolver implements CSPSolver {
	private int iterationCount;
	
	
	/**
	 * Initiates the backtracking search for this CSP.
	 * @return A consistent assignment for this CSP
	 */
	@Override
	public <E> CSPResult<E> solve(CSP<E> csp, int i) {
		iterationCount = 0;
		if(i==0) {
			Assignment<E> finalAssignment = backtrackFC(csp, new Assignment<E>());
			return new CSPResult<E>(finalAssignment, iterationCount);	
		}
		if(i==1) {
			Assignment<E> finalAssignment = backtrackFCMRVLRVDH(csp, new Assignment<E>());
			return new CSPResult<E>(finalAssignment, iterationCount);	
		}
		if(i==2) {
			
			Assignment<E> AC3Assignment = backtrackAC3(csp, new Assignment<E>());
			return new CSPResult<E>(AC3Assignment,iterationCount);
		}
		if(i==3) {
			
			Assignment<E> AC3Assignment = backtrackAC3MRVLRVDH(csp, new Assignment<E>());
			return new CSPResult<E>(AC3Assignment,iterationCount);
		}
		if(i==4) {
			
			Assignment<E> Backtracking = backtracking(csp, new Assignment<E>(), new HashMap<String,Set<E>>());
			return new CSPResult<E>(Backtracking,iterationCount);
		}
		if(i==5) {
			
			Assignment<E> Backtracking = backtrackingMRVLCVDH(csp, new Assignment<E>(), new HashMap<String,Set<E>>());
			return new CSPResult<E>(Backtracking,iterationCount);
		}
		return null;
	}
	
	/**
	 * Selects an unassigned variable. For this algorithm, it can be just the first, or a
	 * randomly chosen unassigned variable.
	 * @param assignment The assignment for which to determine an unassigned variable
	 * @return A variable that is not assigned yet.
	 */
	protected <E> String selectUnassignedVariable(CSP<E> csp, Assignment<E> assignment) {
		List<String> unassigned= new ArrayList<String>(); 
		for(String i:csp.variables){
			if(!assignment.containsKey(i)){
				unassigned.add(i);
			}
		}
		Random random = new Random();
		int rand=random.nextInt(unassigned.size());
		return unassigned.get(rand);
	}
	/**
	 * Selects an unassigned variable. For this algorithm, it can be just the first, or a
	 * randomly chosen unassigned variable.
	 * @param assignment The assignment for which to determine an unassigned variable using the MRV
	 * @return A variable that is not assigned yet and has the few kegal values.
	 */
	protected <E> String MinRemainingValue(CSP<E> csp, Assignment<E> assignment) {
		String var="";
		int minVar=100;
		for(String i:csp.variables){
			if(!assignment.containsKey(i)){
				int min = csp.domains.get(i).size();
				if(min<=minVar) {
					if(min==minVar) {
						String varLess=OneDegreeHeuristics(csp,i,var);
						minVar=csp.domains.get(varLess).size();;
						var=varLess;
					}
					else {
						minVar=min;
						var=i;
					}	
				}
			}
		}
		return var;	
	}
	/**
	 * Returns the varianble with the highest degree heuristic
	 * @param var1 the first variable to compare
	 * @param var2 the second variable to compare 
	 * @return the variable that has the highest degree heuristic, therefore the one involved in more conflicts
	 */
	protected <E> String OneDegreeHeuristics(CSP<E> csp, String var1, String var2){
		int x=0;
		int y=0;
		for(Constraint i:csp.constraints) {
			List<String> constraint = i.getScope();
			for(String j:constraint){
				if(j.equals(var1)) {
					x++;
				}
				if(j.equals(var2)) {
					y++;
				}
			}
		}
		if(x>y) {
			return var1;
		}
		return var2;
	}
	/**
	 * Crestes a sorted list of the domains values of var.
	 * @param var the variable for which determine the best value
	 * @return the value that rules out the  fewest choices for the neighbores variables.
	 */
	protected <E> List<E> LeastConstrainingValue(CSP<E> csp, String var){
		List<String> neighbores = new ArrayList<String>();
		for(Constraint i:csp.constraints) {
			List<String> constraint = i.getScope();
			for(String j:constraint){
				if(j.equals(var)) {
					neighbores.addAll(constraint);
				}
			}
		}
		HashMap<E, Integer> affected = new HashMap<E, Integer>();
		for(int value=0; value<csp.domains.get(var).size();value++) {
			int sum=0;
			for(String i:neighbores){
				if(!i.equals(var)){
					List<E> domain=csp.domains.get(i);
					for(E j:domain){
						if(j.equals(value)){
							sum++;
						}
					}
				}
			}
			affected.put(csp.domains.get(var).get(value),sum);
		}
		List<E> values = new ArrayList<E>();
		Entry<E, Integer> pos = null;
		while(values.size()<affected.size()){
			int min=1000;
			for (Entry<E, Integer> i:affected.entrySet()) {
				if(i.getValue()<min) {
					min=i.getValue();
					pos=i;
				}
			}
			values.add(pos.getKey());
			affected.put(pos.getKey(),1000);
		}
		
		return values;
	}
	/**
	 * This method returns the values of the domain of a variable in
	 * a specific order. Can be used to implement e.g. least-constraining-value heuristic.
	 * For this algorithm, it can be in any order, e.g. the arbitrary order in which they are
	 * stored in the csp.
	 * @param variable The variable for which the domain values should be returned
	 * @param assignment The current assignment
	 * @return An ordering of all domain values of the given variable.
	 */
	protected <E> List<E> orderDomainValues(CSP<E> csp, String variable, Assignment<E> assignment) {
		return csp.domains.get(variable);
	}
	
	/**
	 * Crestes a sorted list of the domains values of var.
	 * @param var the variable for which determine the best value
	 * @return the value that rules out the  fewest choices for the neighbores variables.
	 */
	protected <E> boolean Visited(HashMap<String, Set<E>> explored, String var, E value){
		if(explored.containsKey(var)) {
			if(explored.get(var).contains(value)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Actual recursive implementation of the backtracking search. The
	 * implementation can pretty much follow the pseudo-code in the text book.
	 * Basically, the algorithm can be implemented using almost only calls to the other
	 * methods of this and the other classes.
	 * @param assignment The current assignment
	 * @return The updated assignment, or null if there is no valid assignment
	 */
	
	private <E> Assignment<E> backtracking(CSP<E> csp, Assignment<E> assignment, HashMap<String,Set<E>> explored) {
		++iterationCount;
		if(assignment.isComplete(csp) || iterationCount>10000){
			return assignment;
		}
		String var=selectUnassignedVariable(csp, assignment);
		List<E> values= orderDomainValues(csp, var, assignment);
		Set<E> valuesSet = new HashSet<>();
		for(int i=0;i<values.size();i++){
			boolean consistent=true;
			if(!Visited(explored,var,values.get(i))){
				valuesSet.add(values.get(i));
				assignment.put(var,values.get(i));
				explored.put(var,valuesSet);
				if(csp.isConsistent(assignment)){
					Assignment<E> result = backtracking(csp, assignment, explored);
					if(result!=null) {
						return result;
					}
				}
				assignment.remove(var);
			}
		}
		explored.get(var).clear();
		return null;
	}

	/**
	 * Actual recursive implementation of the backtracking search. The
	 * implementation can pretty much follow the pseudo-code in the text book.
	 * Basically, the algorithm can be implemented using almost only calls to the other
	 * methods of this and the other classes.
	 * @param assignment The current assignment
	 * @return The updated assignment, or null if there is no valid assignment
	 */
	
	private <E> Assignment<E> backtrackingMRVLCVDH(CSP<E> csp, Assignment<E> assignment, HashMap<String,Set<E>> explored) {
		++iterationCount;
		if(assignment.isComplete(csp) || iterationCount>10000){
			return assignment;
		}
		String var=MinRemainingValue(csp, assignment);
		List<E> values= LeastConstrainingValue(csp,var);
		Set<E> valuesSet = new HashSet<>();
		for(int i=0;i<values.size();i++){
			boolean consistent=true;
			if(!Visited(explored,var,values.get(i))){
				valuesSet.add(values.get(i));
				assignment.put(var,values.get(i));
				explored.put(var,valuesSet);
				if(csp.isConsistent(assignment)){
					Assignment<E> result = backtracking(csp, assignment, explored);
					if(result!=null) {
						return result;
					}
				}
				assignment.remove(var);
			}
		}
		explored.get(var).clear();
		return null;
	}

	/**
	 * Actual recursive implementation of the backtracking using forward checking 
	 * @param assignment The current assignment
	 * @return The updated assignment, or null if there is no valid assignment
	 */
	
	private <E> Assignment<E> backtrackFC(CSP<E> csp, Assignment<E> assignment) {
		++iterationCount;
		if(assignment.isComplete(csp) || iterationCount>10000){
			return assignment;
		}
		String var=selectUnassignedVariable(csp, assignment);
		List<E> values= orderDomainValues(csp, var, assignment);
		for(int i=0;i<values.size();i++){
			assignment.put(var,values.get(i));
			if(csp.isConsistent(assignment)){
				Inference<E> inference=ForwardCheckingCSPSolver.inference(csp, assignment, var, values.get(i));
				if(inference!=null){
					inference.reduceDomain(csp);
					Assignment<E> result = backtrackFC(csp, assignment);
					inference.restoreDomain(csp);
					if(result!=null){
						return result;
					}
				}
			}
			assignment.remove(var);
		}
		return null;
	}

	/**
	 * Actual recursive implementation of the backtracking search using forward checking. Using Minimun remaining value, one degree heuristics and lest remaining value
	 * @param assignment The current assignment
	 * @return The updated assignment, or null if there is no valid assignment
	 */
	private <E> Assignment<E> backtrackFCMRVLRVDH(CSP<E> csp, Assignment<E> assignment) {
		++iterationCount;
		if(assignment.isComplete(csp) || iterationCount>10000){
			return assignment;
		}
		String var=MinRemainingValue(csp, assignment);
		List<E> variables= LeastConstrainingValue(csp,var);
		for(int i=0; i<variables.size();i++) {
			assignment.put(var,variables.get(i));
			if(csp.isConsistent(assignment)){
				Inference<E> inference=ForwardCheckingCSPSolver.inference(csp, assignment, var, variables.get(i));
				if(inference!=null){
					inference.reduceDomain(csp);
					Assignment<E> result = backtrackFCMRVLRVDH(csp, assignment);
					inference.restoreDomain(csp);
					if(result!=null){
						return result;
					}
				}
			}
			assignment.remove(var);
		}
		return null;
		
	}

	/**
	 * Actual recursive implementation of the backtracking search using AC3
	 * @param assignment The current assignment
	 * @return The updated assignment, or null if there is no valid assignment
	 */
	private <E> Assignment<E> backtrackAC3(CSP<E> csp, Assignment<E> assignment) {
		++iterationCount;
		if(assignment.isComplete(csp) || iterationCount>10000){
			return assignment;
		}
		String var=selectUnassignedVariable(csp, assignment);
		List<E> variables= orderDomainValues(csp, var, assignment);
		for(int i=0; i<variables.size();i++) {
			assignment.put(var,variables.get(i));
			if(csp.isConsistent(assignment)){
				Inference<E> inference=AC3.ac3(csp,var,variables,variables.get(i));
				if(inference!=null){
					inference.reduceDomain(csp);
					Assignment<E> result = backtrackAC3(csp, assignment);
					inference.restoreDomain(csp);
					if(result!=null){
						return result;
					}
				}
			}
			assignment.remove(var);
		}
		return null;
	}

	/**
	 * Actual recursive implementation of the backtracking using AC3. using forward checking. Using Minimun remaining value, one degree heuristics and lest remaining value
	 * @param assignment The current assignment
	 * @return The updated assignment, or null if there is no valid assignment
	 */
	
	private <E> Assignment<E> backtrackAC3MRVLRVDH(CSP<E> csp, Assignment<E> assignment) {
		++iterationCount;
		if(assignment.isComplete(csp) || iterationCount>10000){
			return assignment;
		}
		String var=MinRemainingValue(csp, assignment);
		List<E> variables= LeastConstrainingValue(csp,var);
		for(int i=0; i<variables.size();i++) {
			assignment.put(var,variables.get(i));
			if(csp.isConsistent(assignment)){
				Inference<E> inference=AC3.ac3(csp,var,variables,variables.get(i));
				if(inference!=null){
					inference.reduceDomain(csp);
					Assignment<E> result = backtrackAC3MRVLRVDH(csp, assignment);
					inference.restoreDomain(csp);
					if(result!=null){
						return result;
					}
				}
			}
			assignment.remove(var);
		}
		return null;
	}
}