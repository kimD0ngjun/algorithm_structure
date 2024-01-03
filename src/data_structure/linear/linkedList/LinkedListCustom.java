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

    // 새로운 머리 노드를 설정하는 경우도 있을 수 있다
    // insert의 두 번째 매개변수를 pointerNode로 삼아야 된다
    // pointerNode가 가리키는 곳에 새로운 데이터 노드를 삽입하고 싶은 것
    // 만약 pointerNode가 null이라면 새로운 머리 노드를 만들고 싶다는 뜻
    // 매개변수를 previousData가 아닌, 원래 삽입하고 싶은 위치의 데이터
    public void insert(T insertedData, T targetData) {
        if (this.size == 0){
            throw new IllegalArgumentException("The Node can't be inserted in list. If list's size is 0, use add method.");
        }

        Node<T> previousNode = searchPreviousNode(targetData); // 삽입하려는 위치의 이전 노드
        Node<T> insertedNode = new Node<>(insertedData); // 새로운 노드 생성

        // 가장 앞(머리 노드 앞)에 삽입하려는 경우, previousData는 당연히 null일 것
        if (previousNode == null) {
            Node<T> secondPositionNode = this.headNode; // 기존의 머리 노드는 두 번째 위치로
            this.headNode = insertedNode; // 새로운 머리 노드 승계
            insertedNode.pointerNode = secondPositionNode; // 새로운 머리 노드의 포인터가 두 번째 노드를 가리킴
            this.size++; // 사이즈 증가

            return;
        }

        // 가장 앞이 아닌 경우
        Node<T> targetNode = previousNode.pointerNode; // 삽입 위치에 원래 존재하던 노드, 뒤로 밀려날 운명
        previousNode.pointerNode = insertedNode; // 이전 노드의 포인터가 새로운 노드를 가리킴
        insertedNode.pointerNode = targetNode; // 새로운 노드의 포인터가 밀려난 노드를 가리킴
        this.size++; // 사이즈 증가

//        if (this.size < 2) {
//            throw new IllegalArgumentException("The Node can't be inserted in list. If list's size is under 2, use add method.");
//        }
//
//        Node<T> previousNode = searchPreviousNode(previousData, true);
//        if (previousNode == null) {
//            throw new IllegalArgumentException("The Node with the specified data doesn't exist in the list.");
//        }
//        Node<T> newNode = new Node<>(newData);
//
//        newNode.updatePointer(previousNode.pointerNode);
//        previousNode.updatePointer(newNode);
//
//        this.size++;
    }

    // 삭제 역시, 삭제하려는 데이터의 노드를 포인터노드로 삼는 이전 노드를 찾으면 된다
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

        // 머리 노드를 삭제하려는 경우
        if (previousNode == null) {
            this.headNode = this.headNode.pointerNode;
            this.size--;
            return;
        }

        // 아닌 경우
        Node<T> deletedNode = previousNode.pointerNode;

        previousNode.pointerNode = deletedNode.pointerNode;
        this.size--;

//        Node<T> previousNode = searchPreviousNode(deleteData, false);
//        Node<T> currentNode = searchPreviousNode(deleteData, true);
//
//        if (currentNode == null || previousNode == null) {
//            throw new IllegalArgumentException("The Node with the specified data doesn't exist in the list.");
//        }
//
//        previousNode.pointerNode = currentNode.pointerNode;
//        this.size--;
    }

    // 이전 노드만 알면 그 노드로부터 포인터노드를 통해 이후에 위치한 노드들을 전부 알 수 있다
    // 이걸 이용해서 검색 함수의 활용을 최대한 줄여보자
    private Node<T> searchPreviousNode(T currentData) {
        if (this.headNode.nodeData.equals(currentData)) {
            return null; // 머리 노드의 nodeData를 currentData로 입력한 경우
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

        throw new IllegalArgumentException("The previous Node with the specified data doesn't exist in the list.");

//        Node<T> previousNode = null;
//        Node<T> currentNode = this.headNode;
//
//        while (currentNode != null) {
//            if (currentNode.nodeData.equals(data)) {
//                return findNode ? currentNode : previousNode;
//            }
//
//            previousNode = currentNode;
//            currentNode = currentNode.pointerNode;
//        }
//
//        return null;
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

