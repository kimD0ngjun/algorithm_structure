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

    // TODO : 추가 메소드
    // 정점 추가
    public void addVertex(T newData) {
        if (!containVertex(newData)) {
            vertices.add(new Vertex<>(newData));
        } else {
            throw new IllegalArgumentException("The data was already added. Check the data.");
        }
    }

    // 간선 추가
    public void addEdge(T oneData, T anotherData) {
        if (!containVertex(oneData) || !containVertex(anotherData)) {
            throw new IllegalArgumentException(
                    "The data isn't contained in the graph. Check the data");
        }
        if (containVertex(oneData) && containVertex(anotherData)) {
            Vertex<T> oneVertex = searchVertex(oneData);
            Vertex<T> anotherVertex = searchVertex(anotherData);

            if (!oneVertex.edges.contains(anotherVertex)
                    && !anotherVertex.edges.contains(oneVertex)) {
                oneVertex.edges.add(anotherVertex);
                anotherVertex.edges.add(oneVertex);
            } else {
                throw new IllegalArgumentException("Already existed edge.");
            }
        }
    }

    // TODO : 삭제 메소드
    // 정점 삭제
    public void deleteVertex(T data) {
        if (!containVertex(data)) {
            throw new IllegalArgumentException(
                    "The data isn't contained in the graph. Check the data");
        } else {
            Vertex<T> deletedVertex = searchVertex(data);

            for (Vertex<T> vertex : vertices) {
                vertex.edges.remove(deletedVertex);
            } // 삭제 정점이 포함된 간선들 전부 삭제

            vertices.remove(deletedVertex); // 정점 삭제
        }
    }

    // 간선 삭제
    public void deleteEdge(T oneData, T anotherData) {
        if (!containVertex(oneData) || !containVertex(anotherData)) {
            throw new IllegalArgumentException(
                    "The data isn't contained in the graph. Check the data");
        }
        if (containVertex(oneData) && containVertex(anotherData)) {
            Vertex<T> oneVertex = searchVertex(oneData);
            Vertex<T> anotherVertex = searchVertex(anotherData);

            if (oneVertex.edges.contains(anotherVertex)
                    && anotherVertex.edges.contains(oneVertex)) {
                oneVertex.edges.remove(anotherVertex);
                anotherVertex.edges.remove(oneVertex);
            } else {
                throw new IllegalArgumentException("Already disconnected edge.");
            }
        }
    }

    // TODO : (정점) 데이터 교체 메소드
    public void changeData(T newData, T oldData) {
        if (!containVertex(oldData)) {
            throw new IllegalArgumentException(
                    "The data isn't contained in the graph. Check the data");
        }

        for (Vertex<T> vertex: vertices) {
            if (oldData.equals(vertex.data)) {
                vertex.setData(newData);
                break;
            }
        }
    }

    // TODO : 유틸리티 메소드
    // 정점 데이터 중복 배제 메소드
    private boolean containVertex(T data) {
        return searchVertex(data) != null;
    }

    // 정점 검색 메소드
    private Vertex<T> searchVertex(T data) {
        for (Vertex<T> vertex : vertices) {
            if (vertex.data.equals(data)) {
                return vertex;
            }
        }
        return null; // 데이터에 해당하는 정점이 없는 경우
    }

    // 정점 집합 조회 메소드
    public void getVertices() {
        System.out.println("- 정점 집합 -");
        vertices.forEach(e -> System.out.print(e.data + ", "));
        System.out.println();
    }

    // 특정 정점 정보(정점 데이터, 정점이 보유한 간선) 조회 메소드
    public void getSpecificVertex(T data) {
        if (!containVertex(data)) {
            throw new IllegalArgumentException(
                    "The data isn't contained in the graph. Check the data");
        } else {
            System.out.println("- 데이터 " + data + "의 정보 -");

            Vertex<T> specificVertex = searchVertex(data);
            System.out.print("연결 간선 : ");
            for (Vertex<T> vertex: specificVertex.edges) {
                System.out.print(data.toString() + vertex.data.toString() + ", ");
            }
            System.out.println("\n");
        }
    }

    //TODO : 데이터 단위 정점을 중첩 클래스로 선언
    private static class Vertex<T> {
        private T data;
        private List<Vertex<T>> edges; // 단위 정점에 연결된 간선들의 집합

        private Vertex(T data) {
            this.data = data;
            this.edges = new ArrayList<>();
        }

        private void setData(T data) {
            this.data = data;
        }
    }
}
