import heapq
from typing import List, Tuple

# 신장 트리 : 모든 정점 연결 + 사이클 없는 그래프
# 최소 신장 트리 : 각 간선이 갖는 가중치의 합이 최소인 신장 트리

### 예시 그래프는 이중 리스트로 구현된다
# 각 알고리즘 메소드가 받아들이는 인자는
# 정점의 개수(n), 간선 정보 리스트((정점, 인접 정점, 가중치) 튜플 요소의 리스트 edges), 시작 정점(start_vertex)

# 프림 알고리즘
def prim(n, edges, start_vertex):
    # 그래프 세팅
    # 이중 리스트로 내부 리스트에 (인접 정점, 가중치) 튜플로 간선 정보 표기
    graph: List[List[Tuple[int, int]]] = [[] for _ in range(n + 1)]

    for vertex, adj_vertex, cost in edges:
        graph[vertex].append((cost, adj_vertex))
        graph[adj_vertex].append((cost, vertex))

    visited = set() # 방문 정보
    heap = [] # 최소 힙

    # (가중치, 정점) 튜플 식으로 할당
    # 튜플의 첫 번째 요소(여기서는 가중치)를 기준으로 최소 힙이 구성
    heapq.heappush(heap, (0, start_vertex))

    while heap:
        # 가중치를 기준으로 한 최소 튜플(heapq.heappop(heap))의 정점([1]) 추출
        cur_min_vertex = heapq.heappop(heap)[1]
        visited.add(cur_min_vertex) # 방문 기록


