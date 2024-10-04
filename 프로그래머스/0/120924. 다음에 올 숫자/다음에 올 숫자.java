class Solution {
    public int solution(int[] common) {
        int gap1 = common[1] - common[0];
        int gap2 = common[2] - common[1];
        int last = common[common.length - 1];
        
        return gap1 == gap2 ? last + gap1 : last * (common[1] / common[0]);
    }
}