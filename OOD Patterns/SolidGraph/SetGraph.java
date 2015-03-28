import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class SetGraph<Node> implements GraphImplementation<Node> {

	private final int ORIGIN = 0;
	private final int DESTINY = 0;
	
	
	Set<Node> nodes;
	Set<ArrayList<Node>> arcs;
	
	public SetGraph(){
		nodes = new HashSet<Node>();
		arcs = new HashSet<ArrayList<Node>>();
	}
	
	@Override
	public boolean addNode(Node n) {
		return nodes.add(n);		
	}

	@Override
	public boolean removeNode(Node n) {
		return nodes.remove(n);		
	}

	private ArrayList<Node> createArc(Node origin, Node destiny) {
		ArrayList<Node> arc = new ArrayList<Node>(2);
		arc.add(ORIGIN, origin);
		arc.add(DESTINY, destiny);
		
		return arc;
	}
	
	@Override
	public boolean addArc(Node origin, Node destiny) {
		return arcs.add(createArc(origin, destiny));
	}

	@Override
	public boolean removeArc(Node origin, Node destiny) {
		ArrayList<Node> arc = createArc(origin, destiny);
		return arcs.remove(arc);
	}

	private Collection<Node> neighbors(Node n, int src) {
		Set<Node> suc = new HashSet<Node>();
		
		for(ArrayList<Node> arc: arcs)
			if (arc.get(src).equals(n)) suc.add(n);
		
		return suc;
	}
	
	@Override
	public Collection<Node> successors(Node n) {
		return neighbors(n,ORIGIN);
	}

	@Override
	public Collection<Node> predecessors(Node n) {
		return neighbors(n,DESTINY);
	}

	@Override
	public Collection<Node> getAllNodes(){
		return new HashSet<Node>(nodes);
	}
}
