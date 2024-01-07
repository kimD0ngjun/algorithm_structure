package data_structure.linear.linkedList;

public class LinkedListCustom<T> {
    protected Node<T> headNode, tailNode;
    protected int size;

    public LinkedListCustom() {
        this.headNode = null;
        this.tailNode = null;
        this.size = 0;
    }

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

    public void insert(T insertedData, T targetData) {
        if (this.size == 0){
            throw new IllegalArgumentException("The Node can't be inserted in list. If list's size is 0, use add method.");
        }

        Node<T> previousNode = searchPreviousNode(targetData);
        Node<T> insertedNode = new Node<>(insertedData);

        if (previousNode == null) {
            Node<T> secondPositionNode = this.headNode;
            this.headNode = insertedNode;
            insertedNode.pointerNode = secondPositionNode;
            this.size++;

            return;
        }

        Node<T> targetNode = previousNode.pointerNode;
        previousNode.pointerNode = insertedNode;
        insertedNode.pointerNode = targetNode;
        this.size++;
    }

    public void delete(T deletedData) {
        if (this.size == 0) {
            throw new IllegalArgumentException("The Node can't be deleted in list. Check that list's size is 0.");
        }

        if (this.size == 1) {
            this.headNode = null;
            this.tailNode = null;
            this.size = 0;
            return;
        }

        Node<T> previousNode = searchPreviousNode(deletedData);

        if (previousNode == null) {
            this.headNode = this.headNode.pointerNode;
            this.size--;
            return;
        }

        Node<T> deletedNode = previousNode.pointerNode;

        previousNode.pointerNode = deletedNode.pointerNode;
        this.size--;
    }

    protected Node<T> searchPreviousNode(T currentData) {
        if (this.headNode.nodeData.equals(currentData)) {
            return null;
        }

        Node<T> previousNode = null;
        Node<T> currentNode = this.headNode;

        while (currentNode != null) {
            if (currentNode.nodeData.equals(currentData)) {
                return previousNode;
            }
            previousNode = currentNode;
            currentNode = currentNode.pointerNode;
        }

        throw new IllegalArgumentException("The specified data doesn't exist in the list.");
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
    protected static class Node<T> {
        public final T nodeData;
        protected Node<T> pointerNode;

        protected Node(T nodeData) {
            this.nodeData = nodeData;
            this.pointerNode = null;
        }

        protected void updatePointer(Node<T> newNode) {
            this.pointerNode = newNode;
        }
    }
}

