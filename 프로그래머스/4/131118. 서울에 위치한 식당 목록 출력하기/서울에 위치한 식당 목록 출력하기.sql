# 서울이라고 했는데, %서울% 이 안되는 문제. 뭔가 어색하다 문제가. 서울특별시, 서울시 가 있는데
# 왜 이런 문제를 낸 거지?

SELECT 
    A.REST_ID, 
    A.REST_NAME, 
    A.FOOD_TYPE, 
    A.FAVORITES,
    A.ADDRESS,
    ROUND(AVG(REVIEW_SCORE), 2) AS SCORE
FROM
    REST_INFO A 
    JOIN REST_REVIEW B ON A.REST_ID = B.REST_ID
WHERE A.ADDRESS LIKE '서울%'
GROUP BY REST_ID
ORDER BY AVG(REVIEW_SCORE) DESC, 4 DESC