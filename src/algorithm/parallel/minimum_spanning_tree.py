import heapq
import sys
from typing import List, Tuple, Dict

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

    connected = set() # 간선 연결 정보
    heap = [] # 최소 힙

    # (정점, 가중치) 튜플 식으로 할당
    # 튜플의 첫 번째 요소(여기서는 가중치)를 기준으로 최소 힙이 구성
    heapq.heappush(heap, (0, start_vertex))

    # 최소 가중치
    min_sum_weight = 0

    while heap:
        # 가중치를 기준으로 한 최소 튜플(heapq.heappop(heap))의 정점([1])과 가중치([0]) 추출
        # 힙에서 팝하는 것이 현재 간선들 중에서 최소 가중치 간선을 뽑는 것
        cur_weight, cur_vertex = heapq.heappop(heap)

        # 현 시점에서의 최소 튜플이 이미 연결되어 있는 간선이라면 볼 필요 없음
        if cur_vertex not in connected:
            connected.add(cur_vertex)
            min_sum_weight += cur_weight

            print("연결된 정점 " + str(cur_vertex) + ", 선택 간선 가중치 : " + str(cur_weight))

            # 최소치 정점과 연결된 간선 정보들 탐색
            for adj_vertex, weight in graph[cur_vertex]:
                # 신장 트리에 새로 덧이어진 간선(인접 노드)들을 힙에 넣는다
                if adj_vertex not in connected:
                    # 이로써 이전 분기에서 최소치에 해당하지 못한 가중치, 간선 튜플과
                    # 현재 분기에서 덧이어진 가중치, 간선 튜플까지 전부 힙에 들어가서
                    # 최소 가중치 간선 추출 준비 완료
                    heapq.heappush(heap, (weight, adj_vertex))

    return min_sum_weight


graph = {
    0: [(1, 8), (5, 15)],  # 정점 0에 대한 간선 정보
    1: [(0, 8), (2, 17), (6, 10)],  # 정점 1에 대한 간선 정보
    2: [(1, 17), (3, 27)],  # 정점 2에 대한 간선 정보
    3: [(2, 27), (4, 29), (6, 25)],  # 정점 3에 대한 간선 정보
    4: [(3, 29), (5, 21), (6, 23)],  # 정점 4에 대한 간선 정보
    5: [(0, 15), (4, 21)],  # 정점 5에 대한 간선 정보
    6: [(1, 10), (3, 25), (4, 23)]  # 정점 6에 대한 간선 정보
}

mst = prim(graph, 0)
print(mst)