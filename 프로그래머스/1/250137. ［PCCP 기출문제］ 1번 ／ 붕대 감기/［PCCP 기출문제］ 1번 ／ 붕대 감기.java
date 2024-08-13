class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0;
        int max = health;
        
        for (int[] attack: attacks) {
            int gap = attack[0] - time - 1;
            time = attack[0];
            int mul = gap / bandage[0];
            int plus = bandage[1] * gap + mul * bandage[2];
            health = Math.min(max, health + plus);
            
            health -= attack[1];
            if (health <= 0) {
                return -1;
            }
        }
        
        return health;
    }
}