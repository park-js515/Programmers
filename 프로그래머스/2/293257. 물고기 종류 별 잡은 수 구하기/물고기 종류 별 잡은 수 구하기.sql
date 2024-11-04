-- 코드를 작성해주세요
SELECT COUNT(*) AS FISH_COUNT, B.FISH_NAME AS FISH_NAME
FROM FISH_INFO A JOIN FISH_NAME_INFO B ON A.FISH_TYPE = B.FISH_TYPE
GROUP BY FISH_NAME
ORDER BY FISH_COUNT DESC