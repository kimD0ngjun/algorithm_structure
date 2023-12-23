# Stack(스택)

## 개념

**<span style='color:skyblue'>프링글스</span>** 통에 들어있는 과자를 생각하자.<br/>
생산 과정에서 가장 먼저 통에 들어간 과자는 가장 마지막에 꺼내진다. 이를 **후입선출**(**LIFO** : Last In First Out)이라고 한다.

핵심은 <span style='color:skyblue'>가장 나중에 들어온 데이터를 먼저 처리하기 위함.</span>

## Java 관련

### 선언
```java
Stack<T> stack = new Stack<>();
```

자바의 `util` 패키지에서 `Stack` 클래스를 제공한다.<br />
선언은 제네릭에 타입을 지정해서 해당 타입의 스택 구조를 생성한다. `Stack` 클래스에서 제공하는 메소드를 통해 해당 내용을 다룬다.

### push
```java
stack.push(T element)
```
프링글스 통의 가장 아래에서부터 쌓이기 시작한다.
```java
Stack<Integer> stack = new Stack<>(); // []

stack.push(0); // [0]
stack.push(1); // [0, 1]
stack.push(2); // [0, 1, 2]
```
비유상, 가장 아래에는 0, 가장 위에는 2가 있는 상태다.

----

```java
stack.add(0);
```
자매품으로 `add()` 메소드도 제공되지만, 얘는 `push()` 메소드와 하는 작업이 똑같다. 기왕이면 가독성을 위해 `push()` 메소드를 선호할 것.

### pop
```java
stack.pop();
```
이제 위에서 과자를 하나씩 끄집어서 꺼낸다.
```java
stack.pop(); // 2를 꺼내고 통에는 0과 1이 있다.
stack.pop(); // 1를 꺼내고 통에는 0이 있다.
stack.pop(); // 0을 꺼내고 통에는 아무것도 없다.
```
스택은 <span style='color:skyblue'>LIFO</span>가 원칙이므로 가장 마지막에 쌓인 위에서부터 하나씩 데이터를 조회해 간다.

### peak
현 시점에서 가장 마지막에 저장된, 즉 가장 위에 있는 데이터를 조회한다.
```java
stack.push(0); // [0]
stack.push(1); // [0, 1]
stack.push(2); // [0, 1, 2]

stack.peek(); // 2
```

### clear
스택의 핑거스냅이다. 저장된 스택 구조를 완전히 비워버린다.
```java
stack.push(0); // [0]
stack.push(1); // [0, 1]
stack.push(2); // [0, 1, 2]

stack.clear(); // []
```

### empty
스택이 비었는지 여부를 `boolean` 값으로 반환한다.
```java
stack.push(0); // [0]
stack.push(1); // [0, 1]
stack.push(2); // [0, 1, 2]
stack.empty(); // false

stack.clear(); // []
stack.empty(); // true
```

### search
스택에 쌓인 데이터들의 위치를 반환한다.<br />
**여기서 위치는 <span style='color:skyblue'>index가 아니다. 빠져나오는 순번을 뜻한다.</span>**
```java
stack.push(0); // [0]
stack.push(1); // [0, 1]
stack.push(2); // [0, 1, 2]
stack.psuh(100); // [0, 1, 2, 100]

stack.search(2);
// 2는 두 번째로 빠져나온다. 그래서 2를 반환한다.
stack.search(100);
// 100은 가장 첫 번째로 빠져나온다. 그래서 1을 반환한다.
stack.search(0);
// 0은 마지막 네 번째로 빠져나온다. 그래서 4를 반환한다.
```
만약 스택에 존재하지 않는 데이터를 `search()` 메소드로 찾으면 `-1` 을 반환한다.
```java
stack.search(1832); // -1
```

### size
스택의 크기(배열의 길이)를 반환한다.
```java
stack.push(0); // [0]
stack.push(1); // [0, 1]
stack.push(2); // [0, 1, 2]

stack.size(); // 3
```

### capacity
스택의 현재 용량을 반환한다고 한다. 근데 뭔 소린지 모르겠다.
스택의 `size()` 가 10을 초과할 때마다 10, 20... 을 반환하는 듯하다.
스택 클래스의 `capacity()` 메서드는 이 스택의 용량을 구하는 데 사용됩니다. 이는 이 스택 컨테이너에 있는 엘리먼트의 수입니다... 라는데...

**용량**의 의미를 좀 더 공부하기.