import heapq

# 신장 트리 : 모든 정점 연결 + 사이클 없는 그래프
# 최소 신장 트리 : 각 간선이 갖는 가중치의 합이 최소인 신장 트리

### 예시 그래프는 이중 리스트로 구현된다
# 각 알고리즘 메소드가 받아들이는 인자는
# 정점의 개수(n), 간선 정보 리스트((정점, 인접 정점, 가중치) 튜플 요소의 리스트 edges), 시작 정점(start_vertex)

# 프림 알고리즘
def prim(graph, start_vertex):
    # 그래프 세팅
    # 이중 리스트로 내부 리스트에 (인접 정점, 가중치) 튜플로 간선 정보 표기
    # 그 중, 최소 신장 트리만을 추출하기
    mst_graph = {i: [] for i in range(len(graph))}
    temp = []

    connected = set() # 간선 연결 정보
    heap = [] # 최소 힙

    # (정점, 가중치) 튜플 식으로 할당
    # 튜플의 첫 번째 요소(여기서는 가중치)를 기준으로 최소 힙이 구성
    connected_vertex = 0
    heapq.heappush(heap, (0, start_vertex, connected_vertex))

    # 최소 가중치
    min_sum_weight = 0

    while heap:
        # 가중치를 기준으로 한 최소 튜플(heapq.heappop(heap))의 정점([1])과 가중치([0]) 추출
        # 힙에서 팝하는 것이 현재 간선들 중에서 최소 가중치 간선을 뽑는 것
        cur_weight, cur_adj_vertex, cur_connected_vertex = heapq.heappop(heap)

        # 반대로 생각해보면 양방향 그래프니까 cur_vertex(인접객체)를 중심 정점으로 삼고
        # cur_weight만큼의 가중치를 지닌 간선 정보에 담긴 인접 객체를 튜플에서 찾아서 그 값에 해당하는 mst 딕셔너리에
        # 키를 찾아서 (cur_vertex, cur_weight)를 넣는다

        # 근데 이건 안 되겠네... 다른 간선도 가중치가 같으면 우째...
        # connected에 포함된 정점인지 확인하면 됨?
        # for connected_vertex, connected_weight in graph[cur_adj_vertex]:
        #     if connected_weight == cur_weight and connected_vertex in connected:
        #         mst_graph[connected_vertex].append((cur_adj_vertex, cur_weight))

        # 현 시점에서의 최소 튜플이 이미 연결되어 있는 간선이라면 볼 필요 없음
        if cur_adj_vertex not in connected:
            connected.add(cur_adj_vertex)
            min_sum_weight += cur_weight

            temp.append({cur_connected_vertex : (cur_adj_vertex, cur_weight)})

            print("연결된 정점 " + str(cur_adj_vertex) + ", 선택 간선 가중치 : " + str(cur_weight))

            # 최소치 정점과 연결된 간선 정보들 탐색
            for adj_vertex, weight in graph[cur_adj_vertex]:
                # 신장 트리에 새로 덧이어진 간선(인접 노드)들을 힙에 넣는다
                # 탐색된 간선들 중 connected에 존재한다는 것은 이미 신장 트리에 포함됐다는 뜻
                if adj_vertex not in connected:
                    # 이로써 이전 분기에서 최소치에 해당하지 못한 가중치, 간선 튜플과
                    # 현재 분기에서 덧이어진 가중치, 간선 튜플까지 전부 힙에 들어가서
                    # 최소 가중치 간선 추출 준비 완료
                    heapq.heappush(heap, (weight, adj_vertex, cur_adj_vertex))

    return min_sum_weight, temp


graph = {
    0: [(1, 8), (5, 15)],  # 정점 0에 대한 간선 정보
    1: [(0, 8), (2, 17), (6, 10)],  # 정점 1에 대한 간선 정보
    2: [(1, 17), (3, 27)],  # 정점 2에 대한 간선 정보
    3: [(2, 27), (4, 29), (6, 25)],  # 정점 3에 대한 간선 정보
    4: [(3, 29), (5, 21), (6, 23)],  # 정점 4에 대한 간선 정보
    5: [(0, 15), (4, 21)],  # 정점 5에 대한 간선 정보
    6: [(1, 10), (3, 25), (4, 23)]  # 정점 6에 대한 간선 정보
}

msw, mst = prim(graph, 0)
print(msw)
print(mst)