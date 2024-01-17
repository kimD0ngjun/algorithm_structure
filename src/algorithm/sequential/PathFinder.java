package algorithm.sequential;

import data_structure.non_linear.graph.GraphCustom;
import data_structure.non_linear.graph.GraphCustom.Vertex;
import java.util.LinkedList;
import java.util.Queue;

public class PathFinder {
    // TODO : 필드
    private GraphCustom<?> graph;

    // TODO : 생성자
    public PathFinder(GraphCustom<?> graph) {
        this.graph = graph;
    }

    // TODO : 메소드
    // 메소드를 통해 접근을 시도하지만, 노드의 취지 및 의미에 부합하려면 접근제한자를 유지하고 내부 클래스 혹은 메소드로 구현하는 것이 옳음
    // 그럼에도 이렇게 구현한 이유는, 자료구조와 알고리즘을 패키지 단위로 구별하기 위함이라서 알고리즘 클래스의 자료구조 클래스 접근이 부득이함
    public void findPathByBfs(Object startData, Object endData) {
        Vertex<?> start = graph.searchVertex(startData);
        Vertex<?> end = graph.searchVertex(endData);

        if (start == null || end == null) {
            throw new IllegalArgumentException("There is no data in the vertex of graph");
            return;
        }

        boolean[] visit = new boolean[graph.vertices.size()]; // 방문 여부 배열
        Vertex<?>[] shortestPath = new Vertex<?>[graph.vertices.size()]; // 최단 경로 저장 배열
        // 최단 길이는 어차피 정점 배열 길이를 초과할 수 없음

        Queue<Vertex<?>> queue = new LinkedList<>(); // bfs용 큐 생성
        queue.add(start); // 시작점 추가
        visit[graph.vertices.indexOf(start)] = true; // 시작점 방문 기록

        while (!queue.isEmpty()) { // bfs용 큐가 비워질 때까지
            // queue.add(neighbor)에 의해서 이웃 정점들이 채워지면서 반복 반복 반복...
            Vertex<?> current = queue.poll(); // 선입선출 수행

            for (Vertex<?> neighbor : current.edges) { // 꺼내진 정점의 연결 간선들(여기서는 이어진 이웃 정점) 수색
                int neighborIndex = graph.vertices.indexOf(neighbor); // 꺼내진 이웃 정점의 정점 리스트 인덱스 확인

                if (!visit[neighborIndex]) { // 만약 그 이웃 정점을 아직 방문하지 않은 상태라면
                    queue.add(neighbor); // bfs용 큐에 넣기
                    visit[neighborIndex] = true; // 방문 기록 남기기
                    shortestPath[neighborIndex] = current; // 이웃 정점의 최단 경로를 현재 정점으로 설정
                }
            }
        }
    }
}
