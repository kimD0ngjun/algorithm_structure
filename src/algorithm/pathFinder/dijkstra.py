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

        """다른 블로그에서 참조 : 조금의 효율성이라도 더 챙겨보기"""
        # 추출한 인접 간선의 가중치가 현재까지의 업뎃 과정을 거쳐 갱신된 가중치보다 크다?
        # 더해도 어차피 min_distance[adj_vertex]보다 작을 것이기 때문에 굳이 볼 필요가 없음
        if min_distances[cur_dir_vertex] < cur_distance:
            continue

        # 경유 우회해서 도착한 특정 정점까지의 거리와 이전까지 업뎃된 정점까지의 거리를 비교하기 위함
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

# print(dijkstra(graph, 'A'))

"""
추가 기능 구현 : 최단 경로를 출력할 수 있지 않을까?

생각 정리
1. 큐(힙)에 들어가는 건 현재로써는 업데이트된 최단 경로와 목적지인 cur_dir_vertex인데, 이 cur_dir_vertex를 바꿔야 할듯
2, 어떻게 바꿀까? 이제까지 거쳤던 곳을 리스트로써 업뎃하는 게 옳을까?
"""

another_graph = {
    'A': {'B': 8, 'C': 1, 'D': 2},
    'B': {},
    'C': {'B': 5, 'D': 2, 'G': 1},
    'D': {'E': 3, 'F': 5},
    'E': {'F': 1},
    'F': {'A': 5},
    'G': {'B': 1, 'E': 1}
}

def dijkstraWithPrintPath(graph, start):
    inf = float("inf")
    min_distances = {vertex: inf for vertex in graph}
    # 거리 출력용 추가 딕셔널
    min_paths = {vertex: [] for vertex in graph}
    min_distances[start] = 0

    queue = []
    # 현재 최단거리, 시작 정점에서 향하는 목적지 정점, 이제까지의 경로
    heapq.heappush(queue, (min_distances[start], start, [start]))

    while queue:
        cur_distance, cur_dir_vertex, cur_path = heapq.heappop(queue)

        if min_distances[cur_dir_vertex] < cur_distance:
            continue

        for adj_vertex, weight in graph[cur_dir_vertex].items():
            updated_distance = cur_distance + weight
            # 경로 업데이트를 대비한 임시용 경로 배열 생성
            temp = cur_path[:]
            temp.append(adj_vertex)

            if updated_distance < min_distances[adj_vertex]:
                min_distances[adj_vertex] = updated_distance
                min_paths[adj_vertex] = temp
                heapq.heappush(queue, (updated_distance, adj_vertex, temp))

    return min_distances, min_paths

# test
min_distances, min_paths = dijkstraWithPrintPath(another_graph, 'A')

print(min_distances)
# print(min_paths)

for vertex, path in min_paths.items():
    min_path = ' -> '.join(path)
    print(min_path)