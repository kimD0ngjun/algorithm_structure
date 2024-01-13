package data_structure.non_linear.graph;

import java.util.ArrayList;
import java.util.List;

//TODO : 무방향 그래프
public class GraphCustom<T> {
    private List<Vertex<T>> vertices; // 정점들의 집합
    // 모든 간선들의 집합은 단위 정점 클래스의 edges 필드를 getter로 가져와 출력?
    // 각 사이즈(정점 집합, 간선 집합)는 List의 메소드 활용으로 출력

    public GraphCustom() {
        this.vertices = new ArrayList<>();
    }

    // 정점 추가
    public void addVertex(T newData) {
        vertices.add(new Vertex<>(newData));
    }

    // 간선 추가
    public void addEdge(T oneData, T anotherData) {
    }

    //TODO : 데이터 단위 정점을 중첩 클래스로 선언
    private static class Vertex<T> {
        private final T data;
        private List<Vertex<T>> edges; // 단위 정점에 연결된 간선들의 집합

        private Vertex(T data) {
            this.data = data;
            this.edges = new ArrayList<>();
        }
    }
}
