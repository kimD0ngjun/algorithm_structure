package data_structure.linear.linkedList;

public class LinkedListCustom<T> {
    private Node<T> headNode, tailNode;
    private int size = 0;
    // 굳이 데이터 전체 묶음을 필드에 저장할 필요가 없을 것 같기도?

    public LinkedListCustom() {
        this.headNode = null;
        this.tailNode = null;
        this.size = 0;
    }

    // add(데이터 노드 추가), insert(삽입), delete(삭제)  : 매개변수를 pointer 정보로?, 전체 조회
    public void add(T data) {
        Node<T> pointer = this.tailNode; // 포인터 업데이트 용 참조변수
        // 업데이트
        this.tailNode = Node.createNode(data);

        if(this.size == 0) {
            this.headNode = this.tailNode;
        } // 최초 add일 경우의 headNode 설정

        this.tailNode.updatePointer(pointer);
        this.size++;
    }
}

// 데이터 단위 노드를 내부 클래스로 선언
class Node<T> {
    private T nodeData;
    private Node<T> pointer;

    private Node(T nodeData) {
        this.nodeData = nodeData;
        this.pointer = null;
    }

    // 단순 setter, 혹은 pointer 필드를 default, public 등으로 설정하면 은닉성에 문제...
    // 생성자 오버로딩을 할까? : 동등성이 무너지는 것은 hashCode()와 equals()를 오버로딩해서 수정하고
    // 아 근데 이러면 중복 노드가 저장 못 되잖아
    // 인덱스를 통한 접근은 안된다기 보다는 자바에서 가능은 한데 순회탐색(시간복잡도 N)

    // 최신 노드가 업데이트 됨 -> 업데이트 됨과 동시에 바로 직전의 노드는 pointer를 갖춤
    // 자바의 특성상, 이 pointer는 최신 노드의 참조변수

    // 팩토리 매서드화
    static <T> Node<T> createNode(T data) {
        return new Node<>(data);
    }

    void updatePointer(Node<T> pointer) {
        this.pointer = pointer;
    }
}