package Assignment5;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Implements the min-conflict local search CSP solver 
 */
public class MinConflicts implements CSPSolver {

	@Override
	public <E> CSPResult<E> solve(CSP<E> csp, int i) {
		/* TODO
		 * find reasonable value for max iterations.
		 */
		int maxSteps=200;
		return minConflicts(csp,maxSteps);
	}
	
	/**
	 * Implements the min-conflicts algorithm.
	 * @param csp The csp to solve
	 * @param maxSteps The max number of steps
	 * @return A solution to the csp, or null if none was found.
	 */
	private static <E> CSPResult<E> minConflicts(CSP<E> csp, int maxSteps) {
		Assignment<E> current = createCompleteAssignment(csp);
		int iterations=1;
		for(int i=1; i<=maxSteps; i++){
			if(current.isComplete(csp) && csp.isConsistent(current)){
				break;
			}
			String var = getRandomConflictedVariable(current, csp);
			E value = null;
			int min=1000;
			for(E k:csp.domains.get(var)){
				int num=conflicts(var, k, current, csp);
				if(num<min && k!=current.get(var)){
					min=num;
					value=k;
				}
			}
			current.put(var,value);
			iterations++;
		}
		if(!csp.isConsistent(current)) {
			current=null;
		}
		return new CSPResult(current,iterations);
		
		/* TODO
		 * The implementation can pretty much follow the pseudo code
		 * in the text book:
		 * 
		 * current <- an initial complete assignment for csp
		 * for i = 1 to max_steps do
		 *   if current is a solution for csp then return current
		 *   var <- a randomly chosen conflicted variable from csp.VARIABLES
		 *   value <- the value v for var that minimizes CONFLICTS(var, v, current, csp)
		 *   set var = value in current
		 * return failure
		 * 
		 * Most of it is straight forward, because there is a separate
		 * function for it. Only finding the value that minimizes the
		 * number of conflicts is a little more complicated. However,
		 * you should use the function conflicts() for this purpose.
		 * Also, please note that "failure" is "null" in this implementation.
		 * You should return the result like "new CSPResult(current, i);"
		 */
	}
	
	/**
	 * Randomly selects a conflicted variable.
	 * @param current The current assignment
	 * @param csp The csp
	 * @return A randomly chosen conflicted variable.
	 */
	private static <E> String getRandomConflictedVariable(Assignment<E> current, CSP<E> csp) {
		Random rand = new Random();
		List<String> conflicted = new ArrayList<String>();
		for(Constraint i:csp.constraints){
			if(!i.isConsistent(current)){
				for(String j:i.getScope()){
					if(!conflicted.contains(j)){
						conflicted.add(j);
					}	
				}
			}
		}
		int randpos = rand.nextInt(conflicted.size());
		return conflicted.get(randpos);
		/* TODO
		 * First, you should create an initially empty set of conflicted variables.
		 * Then, iterate over all constraints, and if it is not consistent, add
		 * all the variables from its scope to the set of conflicted variables.
		 * Afterwards, just return a randomly selected one of them. (Hint: make
		 * sure that variables that appear in multiple constraints are not
		 * selected with a higher probability, they should be selected unbiased).
		 */
	}
	
	/**
	 * Creates an assignment in which every varibale is assigned a value from its domain.
	 * @param csp The underlying csp that defines the domains and the variables
	 * @return A complete assignment
	 */
	private static <E> Assignment<E> createCompleteAssignment(CSP<E> csp) {
		Random rand = new Random();
		Assignment<E> assignment = new Assignment<E>();
		for(String i:csp.variables){
			int randValue = rand.nextInt(csp.domains.get(i).size());
			assignment.put(i,csp.domains.get(i).get(randValue));
		}
		/* TODO
		 * create a new assignment and randomly assign a value to every
		 * variable from its domain.
		 */
		return assignment;
	}
	
	/**
	 * Computes the number of conflict based on an assignment, but with one variable
	 * set to a specific value.
	 * @param var The variable to be checked
	 * @param value The value to be checked
	 * @param current The current assignment used as basis
	 * @param csp The csp problem
	 * @return The number of conflict given the current assignment, but with var=value
	 */
	private static <E> int conflicts(String var, E value, Assignment<E> current, CSP<E> csp) {
		E originalValue = current.get(var);
		current.put(var,value);
		int conflicts=0;
		for (Constraint k:csp.constraints){
				if(!k.isConsistent(current)) {
					conflicts++;
				}
		}
		
		current.put(var,originalValue);
		/* TODO
		 * You might want to temporarily modify the assignment
		 * to set var = value (undo this afterwards!). Then
		 * iterate over all constraints and count the number of
		 * insonsistent constraints.
		 */
		
		return conflicts;
	}
}