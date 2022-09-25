package Assignment5;
import java.util.List;
import java.util.ArrayList;

/**
 * Implements the inequality constraint of two variables. 
 */
public class InequalityConstraint implements Constraint {
	private String value1, value2;

	public InequalityConstraint(String value1, String value2) {
		this.value1 = value1;
		this.value2 = value2;
	}

	@Override
	public List<String> getScope() {
		/* TODO
		 * return a list containing value1 and value2
		 */
		List<String> listval = new ArrayList<String>();
		listval.add(value1);
		listval.add(value2);
		return listval;
	}

	@Override
	public <E> boolean isConsistent(Assignment<E> assignment) {
		if(assignment.get(value1) == null || assignment.get(value2)== null) {
			return true;
		}
		if(assignment.get(value1).equals(assignment.get(value2))){
			return false;
		}
		/* TODO
		 * Check if the assignment is consistent with the constraint,
		 * or if it violates it. It is consistent if the assigned values
		 * of the two variables differ. Keep in mind, that if the assignment
		 * does not contain an assigned value for both variables, the
		 * constraint is not violated, and therefore consistent!
		 */
		return true;
	}
	
	@Override
	public String toString() {
		return value1 + " != " + value2;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof InequalityConstraint)) {
			return false;
		}
		InequalityConstraint other = (InequalityConstraint)o;
		return value1.equals(other.value1) && value2.equals(other.value2);
	}
}