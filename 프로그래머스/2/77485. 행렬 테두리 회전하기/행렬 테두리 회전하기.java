import java.util.ArrayList;

class Solution {
    private int[][] field;
    private int getMin(int[] query) {
        ArrayList<int[]> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int r1 = query[0] - 1, c1 = query[1] -1, r2 = query[2] - 1, c2 = query[3] - 1;
        int r = r1, c = c1;
        int rowGap = r2 - r1;
        int colGap = c2 - c1;
        int[] d = {1, 1, -1, -1};
        
        for (int i = 0; i < 4; i++) {
            boolean isEven = i % 2 == 0;
            if (isEven) {
                for (int j = 0; j < colGap; j++) {
                    c += d[i];
                    list1.add(new int[] {r, c});
                }
            } else {
                for (int j = 0; j < rowGap; j++) {
                    r += d[i];
                    list1.add(new int[] {r, c});
                }
            }
        }
        
        int size = list1.size();
        for (int[] point: list1) {
            list2.add(field[point[0]][point[1]]);
        }
        list2.add(0, list2.remove(size - 1));
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            int[] point = list1.get(i);
            field[point[0]][point[1]] = list2.get(i);
            min = Math.min(min, list2.get(i));
        }
        
        return min;
    }
    
    public int[] solution(int rows, int columns, int[][] queries) {
        field = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                field[i][j] = (i * columns) + j + 1;
            }
        }
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = getMin(queries[i]);
        }
        return answer;
    }
}