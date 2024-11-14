-- 코드를 작성해주세요
SELECT 
    SCORE, A.EMP_NO, EMP_NAME, POSITION, EMAIL
FROM 
    (SELECT
        SUM(SCORE) AS SCORE, EMP_NO
     FROM 
        HR_GRADE
     WHERE 
        YEAR = 2022
     GROUP BY 
        EMP_NO
     ORDER BY
        SCORE DESC
     LIMIT 1
    ) A
    JOIN 
        HR_EMPLOYEES B 
    ON 
        A.EMP_NO = B.EMP_NO