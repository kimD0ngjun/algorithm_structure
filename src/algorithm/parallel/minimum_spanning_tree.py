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
    mst_graph: Dict[int, List[Tuple[int, int]]] = {i: [] for i in range(len(graph))}

    visited = set() # 방문 정보
    heap = [] # 최소 힙

    # (가중치, 정점) 튜플 식으로 할당
    # 튜플의 첫 번째 요소(여기서는 가중치)를 기준으로 최소 힙이 구성
    heapq.heappush(heap, (0, start_vertex))

    while heap:
        # 가중치를 기준으로 한 최소 튜플(heapq.heappop(heap))의 정점([1]) 추출
        cur_min_vertex = heapq.heappop(heap)[1]

        # 백트랙킹
        if cur_min_vertex in visited:
            continue

        visited.add(cur_min_vertex) # 방문 기록

        # # 최소 가중치 및 해당 최소 정점(즉 간선을 구성하는) 초기화
        min_weight = sys.maxsize
        min_vertex = None

        # 인접 간선 정보들 순회
        for adj_vertex, cost in graph[cur_min_vertex]:
            # 이미 탑색이 끝난 정점은 백트랙킹
            # 순환형 재탐색 방지
            if adj_vertex in visited:
                continue

            # 현재까지의 최소 가중치와 그 가중치를 가진 간선 갱신
            if cost < min_weight:
                min_weight = cost
                min_vertex = adj_vertex

                # 최소 가중치 간선 방문 기록 추가
                visited.add(min_vertex)

                # 최소 신장 트리에 업뎃
                mst_graph[cur_min_vertex].append((min_vertex, min_weight))
                mst_graph[min_vertex].append((cur_min_vertex, min_weight))

                 # 해당 인접 정점과 연결된 간선 정보를 힙에 추가
                heapq.heappush(heap, (min_weight, min_vertex))

        return mst_graph

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