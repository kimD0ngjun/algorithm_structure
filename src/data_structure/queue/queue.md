# Queue(큐)

## 개념

스택의 정반대</br>
파이프에 구슬을 넣어 보내면 반대편 구멍으로 빠져나온다. 이때, 먼저 들어간 구슬은 먼저 빠져나온다.</br>
이를 **선입선출**(**FIFO** : First In First Out)이라고 한다.

핵심은 <span style='color:skyblue'>가장 먼저 들어온 데이터를 먼저 처리하기 위함.</span>

## Java 관련

자바 라이브러리의 `queue` 는 <span style='color:skyblue'>인터페이스</span>다(!)
>- 스택(stack)은 후입선출이라는 단순한 구조여서 구현이 고정되어 있어도 큰 제약이 따르지 않는다. 그래서 다형성의 이점을 얻기 어려워서 클래스로 구현이 되어 있다.

>- 큐(queue)는 선입선출이라는 흐름이 중요한 구조여서 구현이 자유롭게 이뤄질 필요성이 있다. 예를 들면, **우선순위 큐**, **동기화된 큐** 등의 응용이 가능한 구현체가 여럿 있어서 인터페이스로 구현이 되어 있다.

상술한 이유로 자바의 `queue` 는 인터페이스로 구현이 되어 있으며, 구현체로 `LinkedList` , `PriorityQueue` , `ArrayBlockingQueue` , `LinkedBlockingQueue` 등등이 있다.<br />

우선은 `queue` 인터페이스의 메소드에 대해 이해해보자.

### `queue` 인터페이스의 특징

기본적으로 `queue` 인터페이스에는 **추가**, **조회**가 있다.<br />
근데 **조회**는 그냥 **조회**하냐, **조회 후 제거**하냐의 차이가 있다.
 또한, 각각의 기능의 결과에 있어 예상 외의 경우가 발생하면, `null` 을 반환하거나 `Exception` 처리를 하냐에 따라 두 가지로 나뉜다. 딱히 재정의하지 않는 이상, 기본 제공된 기능으로써 작동할 것이다.

### 추가(add, offer)
둘 다 요소를 추가한다.
```java
boolean add(T t)
```
add는 추가에 성공하면 `true` 를, 큐가 꽉 차 있어서 추가에 실패하면 `IllegalStateException` 을 던진다.<br />
즉, add 메소드는 `false` 를 반환하지 않는다.
```java
boolean offer(T t)
```
offer는 는 추가에 성공하면 `true` 를, 큐가 꽉 차 있어서 추가에 실패하면 `false` 를 반환한다.<br />

### 단순 조회(element, peak)
둘 다 맨 앞의 요소(즉, **맨 먼저 넣은 요소**)를 조회(반환)한다.
```java
T element() // 만약 큐가 비어있을 경우 `NoSuchElementException` 이 발생한다.
```
```java
T peak() // 만약 큐가 비어있을 경우 `null` 을 반환한다. 
```
### 조회 후 제거(remove, poll)
둘 다 맨 앞의 요소(즉, **맨 먼저 넣은 요소**)를 조회(반환)하고 그것을 <span style='color:skyblue'>제거</span>한다. 요소를 제거함으로써 큐의 크기가 1 감소한다.
```java
T remove() // 만약 큐가 비어있을 경우 `NoSuchElementException` 이 발생한다.
```
```java
T poll() // 만약 큐가 비어있을 경우 `null` 을 반환한다. 
```