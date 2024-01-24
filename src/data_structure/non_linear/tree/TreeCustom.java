package data_structure.non_linear.tree;

import data_structure.non_linear.graph.GraphCustom;

public class TreeCustom<T> extends GraphCustom<T> {
    //TODO : 데이터 단위 정점을 중첩 클래스로 선언
    // 그래프 클래스의 중첩 정점 클래스를 상속받아 변형
    public static class Node<T> extends Vertex<T> {
        // 간선은 자식 노드만 담도록 하기
        public Node(T data) {
            super(data);
        }
    }
}
