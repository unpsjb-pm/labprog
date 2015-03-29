# S.O.L.I.D. GRAPH
Un implementación S.O.L.I.D. de la estructura de datos Grafo.

## << GraphImplementation >>
La interface *GraphImplementation* presenta el comportamiento mínimo de un grafo. Este conjunto de métodos es dependiente de la implementación, siendo los únicos que deben ser codificados para crear una nueva implementación completa de grafo.
```
boolean addNode(Node n);
boolean removeNode(Node n);
boolean addArc(Node origin, Node destiny);
boolean removeArc(Node origin, Node destiny);
Collection<Node> successors(Node n);
Collection<Node> predecessors(Node n);
Collection<Node> getAllNodes();
```

## SetGraph
Esta clase es una implementación de grafo basada en la definición matemática G = {N,A} y formada por dos conjuntos, arcos y nodos.
```
implements GraphImplementation<Node>
```

## Graph
La clase *Graph* extiende el comportamiento de la implementación del grafo proveyendo métodos de alto nivel que son independientes de la misma.
Permite también indicar un algoritmo de recorrido especifico pare el mismo implementado por medio de la interface *TraverseAlgorithm*.
```
Graph(GraphImplementation<Node> graph, TraverseAlgorithm<Node> algorithm);
int inDeegre(Node n);
int outDeegre(Node n);
int deegre(Node n);
int order();
```
```
implements Iterable<Node>, GraphImplementation<Node>
```

## << TraverseAlgorithm >>
La interface *TraverseAlgorithm* provee los métodos que necesita la clase grafo para hacer el recorrido de los nodos y que deben ser implementadas por las diferentes estrategias de recorrido.
```
void setGraph(Graph<Node> g);	
void setStartingNode(Node n);
Node getStartingNode();
Iterator<Node> createIterator();	
```
```
implements TraverseAlgorithm<Node>
```

## BreadthFirstSearch
*BreadthFirstSearch* realiza el recorrido del grafo por amplitud.
```
implements TraverseAlgorithm<Node>
```

## DepthFirstSearch
*DepthFirstSearch* realiza el recorrido del grafo por profundidad.
```
implements TraverseAlgorithm<Node>
```
