package data_structure.non_linear.graph;

public class GraphExample {
    public static void main(String[] args) {
        GraphCustom<String> graph = new GraphCustom<>();

//        graph.addEdge("A", "B");
        graph.addVertex("A");
        graph.getVertices();
        graph.getSpecificVertex("A");

        System.out.println();

        graph.addVertex("B");
        graph.getVertices();

        System.out.println();

//        graph.deleteVertex("B");
//        graph.getVertices();

        graph.addEdge("A", "B");
        graph.getSpecificVertex("A");

        System.out.println();
        graph.getSpecificVertex("B");

//        System.out.println();
//        graph.deleteEdge("A", "B");
//        graph.getSpecificVertex("B");
//        graph.getSpecificVertex("A");

//        graph.deleteEdge("A", "C");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        System.out.println();
        graph.getVertices();

        System.out.println();
        graph.addEdge("A", "F");
        graph.addEdge("A", "D");
        graph.addEdge("D", "B");
        graph.getSpecificVertex("A");
        graph.getSpecificVertex("B");
        graph.getSpecificVertex("D");
        graph.getSpecificVertex("F");

        System.out.println();
        graph.deleteVertex("D");
        graph.getVertices();
        graph.getSpecificVertex("A");
        graph.getSpecificVertex("B");
        graph.getSpecificVertex("F");
    }
}
