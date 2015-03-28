import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;


public class DepthFirstSearch<Node> implements TraverseAlgorithm<Node> {

	private Graph<Node> g = null;
	private Node starting = null;
	
	private Deque<Node> stack;
	
	public DepthFirstSearch(){
		stack = new LinkedList<Node>();
	}
	
	@Override
	public boolean hasNext() {
		if (stack.isEmpty()) return false;
		return true;
	}

	@Override
	public Node next() {
		if (stack.isEmpty()) return null;
		
		Node curr = stack.pop();
		
		for(Node n: g.successors(curr))
			stack.push(n);
		
		return curr;
	}

	@Override
	public void remove() {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<Node> createIterator() {
		if (g == null || g.order() == 0) return null;
		
		Node n = getStartingNode();
		if (n == null) return null;
		
		stack.clear();
		stack.push(n);
		
		return (DepthFirstSearch<Node>)clone();
	}

	@Override
	public void setStartingNode(Node n) {
		starting = n;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Node getStartingNode() {
		
		if (starting == null) {
			starting = (Node)g.getAllNodes().toArray()[0];
		}
		
		return starting;
	}

	@Override
	public void setGraph(Graph<Node> graph) {
		g = graph;		
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Object clone(){
		DepthFirstSearch<Node> clone = new DepthFirstSearch<Node>();
		clone.g = g;
		clone.starting = starting;
		LinkedList<Node> l = (LinkedList<Node>)stack;
		clone.stack = ((Deque<Node>)l.clone()); 
		
		return clone;
	}

}
