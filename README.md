## 백준

[![Solved.ac 프로필](http://mazassumnida.wtf/api/v2/generate_badge?boj=hdcom37)](https://solved.ac/hdcom37)

## 문제 풀이 전략(프로그래머스 기준)

프로그래머스 경진대회에서 느낀 점을 토대로 정리한다.

---

### 1. 문제의 문맥을 정확하게 판단한다.

말 그대로 문제의 요구사항을 제대로 이해하는 것이다. 문제에서 필요로 하는 것이 무엇인지 정확하게 판단하고, 어떻게 풀지 대략적으로 로직을 구상한다.

- 이 과정에서 상하좌우로 이동해야하는 델타 문제의 경우 반드시 내가 생각한 좌표계와 일치하는지 확인해야 한다.
  - 내가 생각한 좌표계는 남동쪽으로 증가하는 좌표계인데, 북동쪽으로 증가하는 좌표계를 **일부러** 제시하는 경우가 허다하다.
  - 행좌표와 열좌표를 바꿔서 제시하는 경우도 너무 허다하다.
  - 이것을 명확하게 체크하지 않으면 로직이 많이 꼬여서 되돌릴 수 없는 문제가 발생한다.

---

### 2. 문제에 필요한 함수들를 절차적으로 구성한다.

이 과정에서 대충 어떤 로직을 수행하고, 값을 리턴하겠다는 것으로 만든다. 너무 정확하게 만들다보면 오히려 구성이 이상해져서 더 많은 시간, 로직의 꼬임이 발생한다.

나의 경우는 다음과 같이 설계한다.

- `init()`으로 필요한 변수값들을 객체 변수로 옮긴다.
  - 이것은 처음부터 구체적으로 구성해도 좋다.
- 객체 클래스가 필요하다면 구현한다.
  - 이 과정에서 정렬이 필요하면 `implements Comparable<T>`, `@Override public int compareTo(T o)`를 구현을 고려한다.
  - 값의 동등성을 고려해야할 경우, `@Override public boolean equals(Object o)`, `@Override public int hasCode()`를 반드시 구현한다.
  - 생성자를 통해서 객체를 만드는 것이 바람직하며, `equals()`, `hashCode()`를 고려해 정렬된 값으로 초기화하는 것도 고려해야 할 수 있다.
- 필요한 메서드(예를 들면 bfs, binarySearch)들을 구현하면서 적절하게 쪼개서 함수를 구현한다.

---

### 3. 반드시 반드시 단위 테스트를 진행한다.

내가 로직을 정확하게 만들었다고 해서, 코딩할 때 실수를 안할 수 있는 것은 아니다. 아무리 명확하더라도 언젠가 실수할 수 있다.

- 객체를 구현하거나 함수를 구현할 때, 반드시 테스트를 하고 다음 단계로 넘어가자.
  - 테스트를 하지 않았는데, 바로 다음단계로 가서 오류가 나면 되돌리기가 매우 까다롭다. 상황이 좋지 않으면 아예 코드를 처음부터 짜야하는 문제가 발생할 수 있다.
