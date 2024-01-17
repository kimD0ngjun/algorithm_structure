package data_structure.non_linear.graph;

import algorithm.sequential.PathFinder;

public class GraphExample {
    public static void main(String[] args) {
        GraphCustom<String> graph = new GraphCustom<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");

        graph.addEdge("A", "B");

        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        graph.addEdge("B", "E");
        graph.addEdge("B", "I");

        graph.addEdge("C", "H");

        graph.addEdge("D", "E");
        graph.addEdge("D", "G");

        graph.addEdge("E", "F");
        graph.addEdge("E", "I");

        graph.addEdge("G", "H");

        graph.addEdge("H", "I");

        graph.getVertices();
        System.out.println();

        graph.getSpecificVertex("A");
        graph.getSpecificVertex("B");
        graph.getSpecificVertex("C");
        graph.getSpecificVertex("D");
        graph.getSpecificVertex("E");
        graph.getSpecificVertex("F");
        graph.getSpecificVertex("G");
        graph.getSpecificVertex("H");
        graph.getSpecificVertex("I");

        // 길찾기

        PathFinder pathFinder = new PathFinder(graph);
        pathFinder.findPathByBfs("A", "I");
        pathFinder.findPathByBfs("C", "F");
        pathFinder.findPathByBfs("F", "H");
        pathFinder.findPathByBfs("H", "A");

//        graph.addVertex("NO");
//        pathFinder.findPathByBfs("A", "NO");
    }
}
