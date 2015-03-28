import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class BreadthFirstSearch<Node> implements TraverseAlgorithm<Node> {

	private Graph<Node> g = null;
	private Node starting = null;
	
	private Queue<Node> queue;
	
	public BreadthFirstSearch(){
		queue = new LinkedList<Node>();
	}
	
	@Override
	public boolean hasNext() {
		if (queue.isEmpty()) return false;
		return true;
	}

	@Override
	public Node next() {
		Node curr = queue.poll();
		
		for(Node n: g.successors(curr))
			queue.offer(n);
		
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
		
		queue.clear();
		queue.offer(n);
		
		return (BreadthFirstSearch<Node>)clone();
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
	protected Object clone() {
		BreadthFirstSearch<Node> clone = new BreadthFirstSearch<Node>();
		clone.g = g;
		clone.starting = starting;
		LinkedList<Node> l = (LinkedList<Node>)queue;		
		clone.queue = ((Queue<Node>)l.clone()); 
		
		return clone;
	}

}
