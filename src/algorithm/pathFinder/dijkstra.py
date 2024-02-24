# 순차 탐색 : 인접행렬
# 우선순위 큐 : 리스트 => 방문기록이 필요없다 어차피 최소값을 뽑아내므로

import heapq

# 예시 그래프 정보(이중 맵으로 표현하는 게 훨씬 편하네...? 앞으로 애용해야지)
graph = {
    'A': {'B': 8, 'C': 1, 'D': 2},
    'B': {},
    'C': {'B': 5, 'D': 2},
    'D': {'E': 3, 'F': 5},
    'E': {'F': 1},
    'F': {'A': 5}
}

def dijkstra(graph, start):
    # 초기 각 최단거리 초기화용 파이썬 내 최대값
    inf = float("inf") # 가중치 무한대
    min_distance = {vertex: inf for vertex in graph} # 각 정점 간 최단거리 초기화
    min_distance[start] = 0 # 시작 정점간 거리는 0

    # 최소 힙(우선순위 큐)을 기반으로 한 다익스트라 구현