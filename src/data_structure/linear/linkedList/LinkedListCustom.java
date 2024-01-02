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
        Node<T> prevNode = this.tailNode; // 이전의 꼬리 노드

        // 업데이트
        Node<T> newNode = new Node<>(data);
        this.tailNode = newNode;
        prevNode.updatePointer(newNode);

        if(this.size == 0) {
            this.headNode = this.tailNode;
        } // 최초 add일 경우의 headNode 설정

        this.size++;
        // 직전 노드의 pointer를 리턴해야 될 것 같기도
    }

    public void insert(T newData, T previousData) {
        if (this.size < 2) {
            throw new IllegalArgumentException("The Node can't be inserted in list. If list's size is under 2, use add method.");
        }
//        if (// previousData가 해당 리스트에 존재하지 않을 경우) { 예외 발생 }
        Node<T> previousNode = searchPreviousNode(previousData); // 이전 노드 검색
        Node<T> newNode = new Node<>(newData); // 새로운 노드 생성

        newNode.updatePointer(previousNode.pointerNode); // 새로운 노드의 포인터 설정
        previousNode.updatePointer(newNode); // 이전 노드의 포인터를 새로운 노드로

        this.size++;
    }

    public void delete(Node<T> deleteNode) {
        if (this.size == 1) {
            this.headNode = null;
            this.tailNode = null;
        }

        // 이전 노드의 pointer가 deleteNode.pointer;
        // 그렇다면 이전 노드 정보를 deleteNode로부터 갖고와야 함(어케...?)
    }

    private Node<T> searchPreviousNode(T data) {
        Node<T> previousNode = null;
        Node<T> currentNode = this.headNode;

        while (currentNode != null) {
            if (currentNode.nodeData.equals(data)) {
                return previousNode; // 특정 데이터와 일치하는 첫 번째 노드를 찾으면 바로 반환
            }

            previousNode = currentNode;
            currentNode = currentNode.pointerNode;
        }

        return null;
    }

    //TODO : 데이터 단위 노드를 중첩 클래스로 선언
    private class Node<T> {
        private T nodeData;
        private Node<T> pointerNode;

        private Node(T nodeData) {
            this.nodeData = nodeData;
            this.pointerNode = null;
        }

        // 단순 setter, 혹은 pointer 필드를 default, public 등으로 설정하면 은닉성에 문제...
        // 생성자 오버로딩을 할까? : 동등성이 무너지는 것은 hashCode()와 equals()를 오버로딩해서 수정하고
        // 아 근데 이러면 중복 노드가 저장 못 되잖아
        // 인덱스를 통한 접근은 안된다기 보다는 자바에서 가능은 한데 순회탐색(시간복잡도 N)

        // 최신 노드가 업데이트 됨 -> 업데이트 됨과 동시에 바로 직전의 노드는 pointer를 갖춤
        // 자바의 특성상, 이 pointer는 최신 노드의 참조변수

        // setter와 getter 말고 내부에서 포인터 재설정 리팩토링
        private void updatePointer(Node<T> newNode) {
            this.pointerNode = newNode.pointerNode;
        }
    }
}

