package data_structure.non_linear.tree;

public class SegmentTree {
    private final int[] tree; // 세그먼트 트리를 저장할 배열
    private final int n; // 원본 배열 크기

    /**
     * 세그먼트 트리의 리프 노드 : 입력 배열의 각 요소
     * 내부 노드 : 자식 노드들의 구간 값을 결합하여 부모 노드의 값이 됨
     */
    public SegmentTree(int[] arr) {
        n = arr.length;
        /**
         * 트리 높이 : h == log_2_n
         * 노드의 개수 : 2^(h+1) - 1 -> 이걸 커버하기 위한 임의의 뭉뚱그림으로써 n * 4
         */
        tree = new int[n * 4];
        buildTree(arr, 0, n - 1, 1);
    }

    // 세그먼트 트리 생성 (재귀적으로 구현)

    /**
     * 재귀 함수
     * @param arr : 세그먼트 트리의 타겟 입력 배열
     * @param start : 타겟 입력 배열의 시작 인덱스
     * @param end : 타겟 입력 배열의 종료 인덱스
     * @param node : 1부터 시작하게 되면 2를 곱했을 때는 왼쪽 자식 노드를 가리키고, 2를 곱하고 1을 더하면 오른쪽 자식 노드를 가리키기 위함
     */
    private void buildTree(int[] arr, int start, int end, int node) {
        if (start == end) { // 리프 노드
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        buildTree(arr, start, mid, node * 2); // 왼쪽 자식
        buildTree(arr, mid + 1, end, node * 2 + 1); // 오른쪽 자식

        tree[node] = tree[node * 2] + tree[node * 2 + 1]; // 부모 노드는 두 자식 노드의 합
    }

    // 구간 합 쿼리 (재귀적으로 구현)
    public int getRangeSum(int left, int right) {
        return query(0, n - 1, 1, left, right);
    }

    private int query(int start, int end, int node, int left, int right) {
        if (right < start || end < left) { // 범위 밖
            return 0;
        }

        if (left <= start && end <= right) { // 범위 안
            return tree[node];
        }

        int mid = (start + end) / 2;

        return query(start, mid, node * 2, left, right) +
                query(mid + 1, end, node * 2 + 1, left, right);
    }

    // 특정 위치 값 업데이트
    public void updateValue(int index, int newValue) {
        update(0, n - 1, 1, index, newValue);
    }

    private void update(int start, int end, int node, int index, int newValue) {
        if (start == end) { // 리프 노드 업데이트
            tree[node] = newValue;
            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid) { // 왼쪽 자식
            update(start, mid, node * 2, index, newValue);
        } else { // 오른쪽 자식
            update(mid + 1, end, node * 2 + 1, index, newValue);
        }

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}

// 사용 예시
class Example {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        SegmentTree segmentTree = new SegmentTree(arr);

        System.out.println(segmentTree.getRangeSum(1, 3)); // 2 + 3 + 4 = 9
        segmentTree.updateValue(2, 10); // arr[2] = 10
        System.out.println(segmentTree.getRangeSum(1, 3)); // 2 + 10 + 4 = 16
    }
}

