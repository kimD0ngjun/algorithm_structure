package data_structure.linear.linkedList;

public class LinkedListCustom<T> {
    private Node<T> headNode;

    // 데이터 단위 노드를 내부 클래스로 선언
    class Node<T> {
        private T nodeData;
        private Node<T> pointer;

        // 단순 setter, 혹은 pointer 필드를 default, public 등으로 설정하면 은닉성에 문제...
        // 생성자 오버로딩을 할까? : 동등성이 무너지는 것은 hashCode()와 equals()를 오버로딩해서 수정하고
        // 아 근데 이러면 중복 노드가 저장 못 되잖아
        // 인덱스를 통한 접근은 안됨

        // 최신 노드가 업데이트 됨 -> 업데이트 됨과 동시에 바로 직전의 노드는 pointer를 갖춤
        // 자바의 특성상, 이 pointer는 최신 노드의 참조변수
    }

    public LinkedListCustom() {
    }

    public void add (T data) {

    }
}
