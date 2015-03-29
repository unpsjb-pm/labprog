import java.util.Collection;
import java.util.Iterator;


public class Graph<Node> implements Iterable<Node>, GraphImplementation<Node> {

	private GraphImplementation<Node> g;
	private TraverseAlgorithm<Node> ta;
	
	public Graph(GraphImplementation<Node> graph, TraverseAlgorithm<Node> algorithm) {
		g = graph;
		ta = algorithm;
	}
	
	/* High-level methods. Implementation independent. */
	public int inDeegre(Node n){
		return g.predecessors(n).size();
	}
	
	public int outDeegre(Node n){
		return g.successors(n).size();
	}

	public int deegre(Node n){
		return inDeegre(n) + outDeegre(n);
	}
	
	public int order(){
		return g.getAllNodes().size();
	}
		
	
	/* Traverse methods. */
	
	@Override
	public Iterator<Node> iterator() {
		ta.setGraph(this);
		return ta.createIterator();
	}

	// GraphImplementation use.
	
	@Override
	public boolean addNode(Node n) {
		return g.addNode(n);
	}

	@Override
	public boolean removeNode(Node n) {
		return g.removeNode(n);
	}

	@Override
	public boolean addArc(Node origin, Node destiny) {
		return g.addArc(origin, destiny);
	}

	@Override
	public boolean removeArc(Node origin, Node destiny) {
		return g.removeArc(origin, destiny);
	}

	@Override
	public Collection<Node> successors(Node n) {
		return g.successors(n);
	}

	@Override
	public Collection<Node> predecessors(Node n) {
		return g.successors(n);
	}

	@Override
	public Collection<Node> getAllNodes() {
		return g.getAllNodes();
	}

}
