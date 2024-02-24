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
    inf = float("inf") # 각 정점 간 최단거리 초기화용 무한
    min_distances = {vertex: inf for vertex in graph} # 시작 정점(start)에서 각 정점 간 최단거리 초기화
    min_distances[start] = 0 # 시작 정점간 거리는 0

    """
    최소 힙(우선순위 큐)을 기반으로 한 다익스트라 구현
    """
    queue = [] # 힙 할당용 큐
    # (시작 정점에서 특정 정점까지의 최단 거리, 특정 정점)을 튜플 형식으로 산입
    # 튜플의 첫 번째 요소를 기준으로 최소치를 뽑게 됨
    heapq.heappush(queue, (min_distances[start], start))

    # 최종적으로 최단 거리들이 전부 업데이트 돼서 큐가 비워질 때까지
    while queue:
        # 시작 정점으로부터 현재 가장 최단거리인 특정 정점까지의 거리, 특정 정점을 뽑는다
        cur_distance, cur_dir_vertex = heapq.heappop(queue)

        # .items() 메서드를 호출하면 중첩 그래프의 내부 딕셔너리의 키(간선으로 이어진 정점)-값(가중치) 쌍을 튜플 형태로 반환
        for adj_vertex, weight in graph[cur_dir_vertex].items():
            updated_distance = cur_distance + weight

            # 가산된 거리가 '간선으로 이어진 정점까지의 최단 거리'보다 짧으면...
            if updated_distance < min_distances[adj_vertex]:
                # 해당 정점까지의 최단 거리를 업데이트
                min_distances[adj_vertex] = updated_distance
                # 해당 정점까지의 업데이트된 최단 거리, 해당 정점 다시 큐에 할당
                heapq.heappush(queue, (updated_distance, adj_vertex))

    # 최종 업데이트 된 각 정점 목적 최단거리 반환
    return min_distances

print(dijkstra(graph, 'A'))