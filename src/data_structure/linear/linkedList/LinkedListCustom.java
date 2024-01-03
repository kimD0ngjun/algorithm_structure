package data_structure.linear.linkedList;

public class LinkedListCustom<T> {
    private Node<T> headNode, tailNode;
    private int size;

    public LinkedListCustom() {
        this.headNode = null;
        this.tailNode = null;
        this.size = 0;
    }

    // add(데이터 노드 추가), insert(삽입), delete(삭제), 전체 조회
    public void add(T data) {
        Node<T> previousNode = this.tailNode;

        Node<T> newNode = new Node<>(data);
        this.tailNode = newNode;
        if (previousNode != null) {
            previousNode.updatePointer(newNode);
        }

        if (this.size == 0) {
            this.headNode = this.tailNode;
        }

        this.size++;
    }

    public void insert(T newData, T previousData) {
        if (this.size < 2) {
            throw new IllegalArgumentException("The Node can't be inserted in list. If list's size is under 2, use add method.");
        }

        Node<T> previousNode = searchNode(previousData, true);
        if (previousNode == null) {
            throw new IllegalArgumentException("The Node with the specified data doesn't exist in the list.");
        }
        Node<T> newNode = new Node<>(newData);

        newNode.updatePointer(previousNode.pointerNode);
        previousNode.updatePointer(newNode);

        this.size++;
    }

    public void delete(T deleteData) {
        if (this.size == 0) {
            throw new IllegalArgumentException("The Node can't be deleted in list. Check that list's size is 0.");
        }

        if (this.size == 1) {
            this.headNode = null;
            this.tailNode = null;
            this.size = 0;
            return;
        }

        Node<T> previousNode = searchNode(deleteData, false);
        Node<T> currentNode = searchNode(deleteData, true);

        if (currentNode == null || previousNode == null) {
            throw new IllegalArgumentException("The Node with the specified data doesn't exist in the list.");
        }

        previousNode.pointerNode = currentNode.pointerNode;
        this.size--;
    }

    // 이전 노드만 알면 그 노드로부터 포인터노드를 통해 이후에 위치한 노드들을 전부 알 수 있다
    // 이걸 이용해서 검색 함수의 활용을 최대한 줄여보자
    private Node<T> searchNode(T data, boolean findNode) {
        Node<T> previousNode = null;
        Node<T> currentNode = this.headNode;

        while (currentNode != null) {
            if (currentNode.nodeData.equals(data)) {
                return findNode ? currentNode : previousNode;
            }

            previousNode = currentNode;
            currentNode = currentNode.pointerNode;
        }

        return null;
    }

    public void printAllNodes() {
        Node<T> currentNode = this.headNode;

        while (currentNode != null) {
            System.out.print(currentNode.nodeData + " ");
            currentNode = currentNode.pointerNode;
        }

        System.out.println();
    }

    public void getSize() {
        System.out.println("현재 list 크기 : " + this.size);
    }

    //TODO : 데이터 단위 노드를 중첩 클래스로 선언
    private static class Node<T> {
        private final T nodeData;
        private Node<T> pointerNode;

        private Node(T nodeData) {
            this.nodeData = nodeData;
            this.pointerNode = null;
        }

        private void updatePointer(Node<T> newNode) {
            this.pointerNode = newNode;
        }
    }
}

