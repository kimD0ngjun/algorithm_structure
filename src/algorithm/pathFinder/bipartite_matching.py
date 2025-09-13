"""
이분 매칭 잘 정리해둔 포스트
https://uknowblog.tistory.com/444

이분 매칭은 백트랙킹과 그래프가 섞인 느낌
요약하자면 연애 매칭 프로그램

남녀 그룹이 각각 호감 표시(유방향 간선)를 했는데,
연애 프로그램은 최대한 많은 짝을 매칭시키기 위한 가짓수를 세리는 것

대표적인 문제가 백준 1298번
https://www.acmicpc.net/problem/1298
"""

N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)] # 학생 그룹 - 노트북 그룹 단방향 그래프
match = [-1] * (N + 1) # 노트북당 학생 매칭 여부

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)

# dfs 기반 이분 매칭
def dfs(node):
    if visited[node]:
        return False

    visited[node] = True # 방문 처리

    """
    어떤 학생이 가리키는 노트북(들)에 대하여
    1. 아직 매칭이 안됐거나
    2. 노트북이 이미 다른 학생과 매칭돼서, 다른 학생을 다른 노트북으로 옮길 수 있는지 다른 학생들 노트북군 재귀적으로 탐색
    옮길 수 있다면 어떤 학생도, 다른 학생도 노트북 매핑이 가능해짐
    """
    for adj in graph[node]:
        if match[adj] == -1 or dfs(match[adj]):
            match[adj] = node
            return True

    return False

result = 0
for i in range(1, N + 1):
    visited = [False] * (N + 1)
    if dfs(i): result += 1

print(result)
