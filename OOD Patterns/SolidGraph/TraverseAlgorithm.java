import java.util.Iterator;


public interface TraverseAlgorithm<Node> extends Iterator<Node>{

	public void setGraph(Graph<Node> g);
	
	public void setStartingNode(Node n);
	
	public Node getStartingNode();
	
	public Iterator<Node> createIterator();	
}
