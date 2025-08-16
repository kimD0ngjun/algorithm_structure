"""
모든 경로는 최대 노드 수 - 1 개의 간선을 거침
초과하면 사이클을 거침
가중치가 음인 시점에서 최솟값 갱신 방법에서 간선 n - 1번 넘기는 건 음의 사이클이라고 간주 가능
"""
n, m = map(int, input().split())

graph = []
for _ in range(m):
    u, v, w = map(int, input().split())
    graph.append((u, v, w))

def bellman_ford(start, end, graph):
    dp = [float('inf')] * (n+1) # 노드의 개수
    dp[start] = 0

    # n-1번 반복 -> 모든 경로의 음의 사이클이 없는 최댓값 갯수
    for _ in range(n-1):
        # 모든 간선 탐색
        for node, adj_node, weight in graph:
            """
            1. start에서 node까지 가는 방법이 있는가?
            2. 있다면 start에서 adj_node까지 가는 기존 루트보다 start에서 node를 거쳐 adj_node까지 가는 새로운 루트가 더 빠른가?
            """
            if dp[node] != float('inf') and dp[adj_node] > dp[node] + weight:
                dp[adj_node] = dp[node] + weight

    # 음의 사이클 검증을 위한 반복
    for node, adj_node, c in graph:
        # 했는데 더 빠른 루트가 나온다? -> 간선 최대 가능수 넘어선 상태(음의 사이클이 존재)
        if dp[node] != float('inf') and dp[adj_node] > dp[node] + c:
            # 음의 사이클이 존재한다면 기존 경로 탐색은 오염된 정보 하에서 이뤄진 셈 -> 폐기
            return None

    # print(dp)
    return dp[end]

print(bellman_ford(1, n, graph))
