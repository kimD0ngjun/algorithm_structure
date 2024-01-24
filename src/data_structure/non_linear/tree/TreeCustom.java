package data_structure.non_linear.tree;

import data_structure.non_linear.graph.GraphCustom;

public class TreeCustom<T> extends GraphCustom<T> {

    public TreeCustom() {
        super();
    }

    // 노드 간 부모 자식 설정
    @Override
    public void addEdge(T parentData, T childData) {
        if (!containVertex(parentData) || !containVertex(childData)) {
            throw new IllegalArgumentException(
                    "The data isn't contained in the graph. Check the data");
        }
    }

    //TODO : 데이터 단위 정점을 중첩 클래스로 선언
    // 그래프 클래스의 중첩 정점 클래스를 상속받아 변형
    public static class Node<T> extends Vertex<T> {
        // 간선은 자식 노드만 담도록 하기
        // 층 : 몇 층의 노드인지 정보 담기(부모 노드는 바로 윗층)
        // 조건 : 초기화는 0, 루트는 1층, 그 이후로 쭉쭉 층++
        public int floor;

        public Node(T data) {
            super(data);
            this.floor = 0;
        }
    }
}
