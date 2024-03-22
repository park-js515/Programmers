// 회전 변환 행렬 [[0, -1], [1, 0]]를 활용해 보자.

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Collections;

class Solution {
    private int n;
    private ArrayList<Integer> rotation(ArrayList<Integer> arr) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-arr.get(1));
        list.add(arr.get(0));
        
        return list;
    }
    
    private ArrayList<ArrayList<Integer>> scaling(ArrayList<ArrayList<Integer>> arr) {
        ArrayList<ArrayList<Integer>> next = new ArrayList<>();
        for (ArrayList<Integer> l: arr) {
            next.add(rotation(l));
        }
        arr = next;
        int scaleX = Integer.MAX_VALUE;
        int scaleY = Integer.MAX_VALUE;
        for (ArrayList<Integer> l: arr) {
            scaleX = Math.min(scaleX, l.get(0));
            scaleY = Math.min(scaleY, l.get(1));
        }
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (ArrayList<Integer> l: arr) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(l.get(0) - scaleX);
            temp.add(l.get(1) - scaleY);
            list.add(temp);
        }
        
        return list;
    }
    
    private ArrayList<ArrayList<Integer>> getBlock(int target, boolean[][] visited, int r, int c, int[][] arr) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {r, c});
        visited[r][c] = true;
        list.add(new ArrayList<>(Arrays.asList(r, c)));
        
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int dr = node[0] + d[i][0];
                int dc = node[1] + d[i][1];
                if (dr < 0 || dr >= n || dc < 0 || dc >= n || visited[dr][dc] || arr[dr][dc] != target) {
                    continue;
                };
                visited[dr][dc] = true;
                list.add(new ArrayList<>(Arrays.asList(dr, dc)));
                queue.add(new int[] {dr, dc});
            }
        }
        
        return list;
    }
    
    public int solution(int[][] game_board, int[][] table) {
        this.n = game_board.length;
        boolean[][] visited1 = new boolean[n][n];
        boolean[][] visited2 = new boolean[n][n];
        ArrayList<ArrayList<ArrayList<Integer>>> blanks = new ArrayList<>();
        ArrayList<ArrayList<ArrayList<Integer>>> tempBlocks = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited1[i][j] && game_board[i][j] == 0) {
                    blanks.add(getBlock(0, visited1, i, j, game_board));
                }
                if (!visited2[i][j] && table[i][j] == 1) {
                    tempBlocks.add(getBlock(1, visited2, i, j, table));
                }
            }
        }
        for (int i = 0; i < blanks.size(); i++) {
            blanks.set(i, scaling(blanks.get(i)));
            Collections.sort(blanks.get(i), (o1, o2) -> {
                if (o1.get(0) != o2.get(0)) {
                    return o1.get(0) - o2.get(0);
                }
                return o1.get(1) - o2.get(1);
            });
        }
        
        int answer = 0;
        boolean[] visited3 = new boolean[blanks.size()];
        point: for (int i = 0; i < tempBlocks.size(); i++) {
            ArrayList<ArrayList<Integer>> tempList = tempBlocks.get(i);
            for (int j = 0; j < 4; j++) {
                tempList = scaling(tempList);
                Collections.sort(tempList, (o1, o2) -> {
                    if (o1.get(0) != o2.get(0)) {
                        return o1.get(0) - o2.get(0);
                    }
                    return o1.get(1) - o2.get(1);
                });
                for (int k = 0; k < blanks.size(); k++) {
                    if (!visited3[k] && blanks.get(k).equals(tempList)) {
                        answer += tempList.size();
                        visited3[k] = true;
                        continue point;
                    }
                }
            }
        }

        return answer;
    }
}