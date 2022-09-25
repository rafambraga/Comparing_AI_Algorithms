package Assignment5;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AC3 {
	/**
	 * This class represents a single arc for the AC-3 algorithm.
	 */
	public static class Arc {
		private String value1, value2;

		public Arc(String value1, String value2) {
			this.value1 = value1;
			this.value2 = value2;
		}
	}
	
	/**
	 * Implements the AC-3 algorithm to make a csp arc consistent.
	 * @param csp The csp
	 * @return Whether an inconsistency was found (false) or not (true)
	 * 
	 */
	public static <E> Inference<E> ac3(CSP<E> csp, String var, List<E> values, E value) {
		List<Arc> queue = new ArrayList<Arc>();
		Inference<E> inference = new Inference<E>();
		Set<E> valuesRem = new HashSet<E>();
		for(int i=0;i<values.size();i++){
			if(values.get(i)!=value){
				valuesRem.add(values.get(i));
			}
		}
		inference.put(var, valuesRem);
		inference.reduceDomain(csp);
		for(Constraint i:csp.constraints){
			List<String> variable= i.getScope();
			Arc forward= new Arc(variable.get(0), variable.get(1));
			Arc backwards= new Arc(variable.get(1), variable.get(0));
			queue.add(forward);
			queue.add(backwards);
		}
		while(!queue.isEmpty()){
			Arc polled = queue.get(0);
			queue.remove(polled);
			String vari = polled.value1;
			String varj = polled.value2;
			if(revise(csp, vari, varj, inference)){
				if(csp.domains.get(vari).size()==0){
					inference.restoreDomain(csp);
					return null;
				}
				Set<String> neigbores=neighbors(csp, vari);
				for(String k:neigbores){
					Arc relation= new Arc(k,vari);
					queue.add(relation);
				}
			}
		}
		inference.restoreDomain(csp);
		return inference;
	}
	
	/**
	 * Implements the revise-routine of the AC-3 algorithm. Effectively iterates
	 * over all domain values of var1 and checks if there is at least 1 possible value
	 * for var2 remaining. If not, removes that value from the domain of var1.
	 * @param csp
	 * @param var1
	 * @param var2
	 * @return
	 */
	private static <E> boolean revise(CSP<E> csp, String var1, String var2, Inference<E> inference) {
		List<E> values=csp.domains.get(var1);
		List<E> values2=csp.domains.get(var2);
		Set<E> valuesRemove = new HashSet<E>();
		boolean consistency=false;
		boolean revised=false;
		for(E i:values){
			for(E j:values2){
				if(j!=i){
					consistency=true;
					break;
				}
			}
			if(!consistency){
				valuesRemove.add(i);
				revised=true;	
			}
		}
		if(revised) {
			if(inference.containsKey(var1)) {
				Set<E> valList = inference.get(var1);
				for(E i:valList) {
					E value = i;
					valuesRemove.add(value);
				}
			}
			inference.put(var1, valuesRemove);
			inference.reduceDomain(csp);
		}
		return revised;
	}
	
	
	/**
	 * Computes the "neighbors" of a variable in a CSP. A variable is
	 * a neighbor if it is coupled to another variable by a constraint.
	 * @param csp The csp
	 * @param var The variable the neighbors of which are to be found.
	 * @return The neighbors of the given variable.
	 */
	private static <E> Set<String> neighbors(CSP<E> csp, String var) {
		Set<String> neigbores=new HashSet<>();
		for(Constraint i:csp.constraints){
			List<String> variables = i.getScope();
			int pos=0;
			for(String j:variables){
				if(j.equals(var)){
					break;
				}
				pos++;
			}
			if(pos==0){
				neigbores.add(variables.get(1));
			}
			else{
				neigbores.add(variables.get(0));
			}
		}
		return neigbores;
	}
}