# [level 4] 도둑질 - 42897

<a href="../../../프로그래머스/4/42891. 무지의 먹방 라이브/무지의 먹방 라이브.java">java 풀이</a>

## 문제 풀이

- 알고리즘: Binary Search - Parametric Search, LowerBound Search

- 이분탐색이라는 것을 찾는 것도 중요하지만, 햇갈릴만한 요소와 꼼꼼함이 필요한 문제이다.

- 문제 풀이의 핵심
  1. 가능한 경우인가?
  2. 최소 몇 초 이상을 소모했을 때, 시간 `k`를 넘어설 수 있느냐를 찾는다.
  3. `k`의 값을 넘어서는 인덱스를 반환한다.

> 1. 가능한 경우인가?

- 가능하지 않은 경우에 대해서는 -1을 return 해야한다.
- 만약 `food_times`의 전체의 합이 k 보다 작다면 무지는 연결이 끊긴 후 음식을 먹을 수 없게 된다.
  - 이 경우 -1을 return한다.

<br/>

> 2. LowerBound Search

<details>
  <summary>LowerBound Python code</summary>

- 이 부분에 대해서는 분포적으로 생각해야할 요소가 존재하는데, 이해하면 좋겠지만 외우는 것도 괜찮다.
  - 이해하기는 어렵지만 내용이 별로 없기 때문이다.

```python
arr = [1, 1, 1, 1, 2, 2, 2, 3, 3, 3] # 목표: 2의 하한을 찾아라.

# 여기서 말하는 하한은 2를 포함하는 가장 낮은 번호의 인덱스이다.(예제의 답은 4)
```

```python
def lowerBound1(arr: list[int], target: int):
  left = 0
  right = len(arr)

  while left < right:
      mid = (left + right) // 2
      if (arr[mid] < target):
          left = mid + 1
      else:
          right = mid

  print(left)
```

```python
def lowerBound2(arr: list[int], target: int):
    left = 0
    right = len(arr) - 1

    while left <= right:
        mid = (left + right) // 2
        if (arr[mid] < target):
            left = mid + 1
        else:
            right = mid - 1

    print(left)
```

</details>

```java
private int getLowerBound(int[] food_times, long k) {
    int left = 1;
    int right = getMax(food_times);

    while (left < right) {
        int mid = (left + right) / 2;

        long sum = 0;
        for (int f: food_times) {
            sum += Math.min(f, mid);
        }

        if (sum < k + 1) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return left;
}
```

- 이 하한을 통해서 lb(LowerBound) 이상의 순회를 할 경우, k을 얻을 수 있다는 정보를 알게 된다.

<br/>

> 3. lb값을 통한 탐색으로 인덱스를 찾기

- 이 부분에서는 `lb - 1` 번의 순회까지 `food_times`에서 얻을 수 있는 시간을 계산하고, 그 후 순차적으로 더해 나가면서 합이 `k`을 넘어가는 시점을 계산한다.

  ```java
  for (int i = 0; i < food_times.length; i++) {
      int value = Math.min(lb - 1, food_times[i]);
      sum += value;
      food_times[i] -= value;
  }

  for (int i = 0; i < food_times.length; i++) {
      if (food_times[i] > 0) {
          if (++sum > k) {
              answer = i + 1;
              break;
          }
      }
  }
  ```
