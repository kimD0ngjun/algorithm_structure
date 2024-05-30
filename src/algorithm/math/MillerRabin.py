class MillerRabin:
    def __init__(self):
        pass

    def power(self, x, y, p):
        """
        모듈러 연산에서 x^y % p를 계산하는 메서드

        :param x: 밑
        :param y: 지수
        :param p: 모듈러
        :return: x^y % p의 결과
        """
        res = 1  # 결과값 초기화
        x = x % p  # x를 p로 나눈 나머지로 초기화

        while y > 0:
            if y % 2 == 1:  # y가 홀수이면
                res = (res * x) % p  # 현재 x를 결과에 곱하고 모듈러 연산

            y = y // 2  # y를 2로 나누기
            x = (x * x) % p  # x를 제곱하고 모듈러 연산

        return res

    def test(self, n, a):
        """
        밀러-라빈 소수 판정 메서드

        :param n: 소수 여부를 판정할 수
        :param a: 기반이 되는 값
        :return: n이 소수일 가능성이 있으면 True, 확실히 합성수이면 False
        """
        d = n - 1  # n - 1을 d로 초기화
        while d % 2 == 0:  # d가 짝수이면
            d //= 2  # d를 2로 나누기

        x = self.power(a, d, n)  # a^d % n을 계산

        if x == 1 or x == n - 1:  # x가 1 또는 n-1이면
            return True  # 소수일 가능성이 있음

        while d != n - 1:  # d가 n-1이 아닌 동안
            x = self.power(x, 2, n)  # x를 제곱하고 모듈러 연산
            d *= 2  # d를 2배로 증가

            if x == 1:  # x가 1이면
                return False  # 확실히 합성수
            if x == n - 1:  # x가 n-1이면
                return True  # 소수일 가능성이 있음

        return False  # 합성수

    def calculate(self, n):
        """
        소수 판정 메서드

        :param n: 소수 여부를 판정할 수
        :return: n이 소수이면 True, 아니면 False
        """
        if n in [2, 3]:  # n이 2 또는 3이면
            return True  # 소수

        if n == 1 or n % 2 == 0:  # n이 1이거나 짝수이면
            return False  # 소수가 아님

        for a in [2, 3]:  # 2와 3을 사용하여 밀러-라빈 테스트
            """
            2^64 미만의 수 n에 대하여 임의의 수 a가 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37 계산
            """
            if not self.test(n, a):  # 테스트를 통과하지 못하면
                return False  # 소수가 아님

        return True  # 소수


mr = MillerRabin()

print(mr.calculate(17))  # True
print(mr.calculate(18))  # False
print(mr.calculate(29))  # True