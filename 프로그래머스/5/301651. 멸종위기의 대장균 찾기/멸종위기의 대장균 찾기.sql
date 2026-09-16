WITH RECURSIVE CTE AS (
    SELECT
        ID,
        1 AS GENERATION
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT
        A.ID,
        CTE.GENERATION + 1
    FROM 
        CTE 
        JOIN 
        ECOLI_DATA A
        ON
        CTE.ID = A.PARENT_ID
    
), CTE2 AS (
    SELECT
        A.ID,
        COUNT(B.ID) AS CHILD_CNT
    FROM    
        CTE A 
        LEFT JOIN 
        ECOLI_DATA B 
        ON A.ID = B.PARENT_ID
    GROUP BY A.ID
)

SELECT
    COUNT(*) AS COUNT,
    A.GENERATION AS GENERATION
FROM
    CTE A
    JOIN
    (SELECT * FROM CTE2 WHERE CHILD_CNT = 0) B
    ON A.ID = B.ID
GROUP BY 2
ORDER BY 2