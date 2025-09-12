"""
위상 정렬(topological sorting)은 유향 그래프의 꼭짓점들(vertex)을 변의 방향을 거스르지 않도록 나열하는 것
사이클 판별 알고리즘으로도 활용할 수 있을듯. 위상 정렬 자체가 DAG(사이클 없는 방향 그래프)에서만 적용 가능하므

결국 간선을 중심으로, '위상 정렬'의 결과로 나온 간선들 중 어느 것을 뽑아도 노드 간 선후 관계가 준수될 것
팬인 사이즈가 0인 애들부터 하나씩 그래프에서 삭제해나가기?

자기 자신을 가리키는 변이 없는 꼭짓점을 찾음.
찾은 꼭짓점을 출력하고 출력한 꼭짓점과 그 꼭짓점에서 출발하는 변을 삭제
아직 그래프에 꼭짓점이 남아있으면 단계 1로 돌아가고, 아니면 알고리즘을 종료시킨다.
"""

from collections import deque

N, M = map(int, input().split()) # N : 노드 갯수, M : 간선 갯수
graph = [[] for _ in range(N + 1)]
entry_sizes = [0] * (N + 1) # 진입값 사이즈

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    entry_sizes[b] += 1 # 진입되는 간선 카운팅

"""
칸 알고리즘 기반 위상정렬(BFS 차용)
"""
queue = deque() # 진입간선 0인 노드의 큐
answer = []

for i in range(1, N + 1):
    if entry_sizes[i] == 0:
        queue.append(i) # 진입값 0인 애들부터 우선 큐 산입

while queue:
    node = queue.popleft()
    answer.append(node)

    for adj in graph[node]:
        entry_sizes[adj] -= 1 # 진입 간선 차감

        if entry_sizes[adj] == 0:
            queue.append(adj)

print(*answer)

"""
DP와의 연계가 매우 자연스러운 알고리즘 같음
실제 백준 문제도 DP와 같이 나오는 케이스들이 수두룩하고...

노드를 순차 정렬하고 그 중 어떤 노드 한 쌍을 선택해도 원본 그래프의 간선 순서를 준수하므로
단위 순서로 쪼개기 쉬운 알고리즘이라 DP와 같이 많이 나오는 듯하다
