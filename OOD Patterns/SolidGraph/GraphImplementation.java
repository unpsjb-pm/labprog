import java.util.Collection;


public interface GraphImplementation<Node> {
	public boolean addNode(Node n);
	public boolean removeNode(Node n);
	
	public boolean addArc(Node origin, Node destiny);
	public boolean removeArc(Node origin, Node destiny);
	
	public Collection<Node> successors(Node n);
	public Collection<Node> predecessors(Node n);
	
	public Collection<Node> getAllNodes();
}
