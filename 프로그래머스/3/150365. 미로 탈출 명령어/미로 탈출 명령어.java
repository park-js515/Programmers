// 우선순위에 의해서
// (x, y) -> (n, y) -> (n, 1) -> (r, c) 로 이동을 한다.
// 만약 (n, 1)에 도착했을 때도 k가 남았다면, rl을 반복한다.

import java.util.HashMap;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dist = Math.abs(x - r) + Math.abs(y - c);
        k -= dist;
        if (k < 0 || k % 2 != 0) {
            return "impossible";
        }
        
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('d', 0);
        map.put('l', 0);
        map.put('u', 0);
        map.put('r', 0);
        
        if (x > r) {
            map.put('u', x - r);
        } else {
            map.put('d', r - x);
        }
        if (y > c) {
            map.put('l', y - c);
        } else {
            map.put('r', c - y);
        }
        
        for (int i = 0; i < map.get('d'); i++) {
            sb.append('d');
        }
        int d = Math.min(k / 2, n - (x + map.get('d')));
        for (int i = 0; i < d; i++) {
            sb.append('d');
        }
        map.put('u', map.get('u') + d);
        k -= 2 * d;
        
        for (int i = 0; i < map.get('l'); i++) {
            sb.append('l');
        }
        int l = Math.min(k / 2, y - map.get('l') - 1);
        for (int i = 0; i < l; i++) {
            sb.append('l');
        }
        map.put('r', map.get('r') + l);
        k -= 2 * l;
        
        for (int i = 0; i < k / 2; i++) {
            sb.append("rl");
        }
        for (int i = 0; i < map.get('r'); i++) {
            sb.append('r');
        }
        for (int i = 0; i < map.get('u'); i++) {
            sb.append('u');
        }
        
        return sb.toString();
    }
}