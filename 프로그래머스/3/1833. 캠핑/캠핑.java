import java.util.*;

class Solution {
public int solution(int n, int[][] data) {

	// 1. 정렬
    Arrays.sort(data,(o1,o2)->{
		if(o1[0]==o2[0]) return o1[1]-o2[1];
		return o1[0]-o2[0];
	});
    
	int ans = 0;
    //2. 사용할수 있는 쐐기 구하기
    //2-1. 첫번째 쐐기
	for(int i=0; i<data.length; i++) {
    
		//2.2 두번째 쐐기
		for(int j=i+1; j<data.length; j++) {
       		//2-3. 넓이가 0인지 확인
			if(data[i][0] == data[j][0] || data[i][1]==data[j][1]) continue;
			
            //2-4. 텐트안에 쐐기가 없는지 확인
			boolean check = true;
			for(int k=i+1; k<j; k++) {
				if((data[i][0]<data[k][0] &&
                data[k][0] <data[j][0]) &&
                Math.min(data[i][1], data[j][1])< data[k][1] && 
                Math.max(data[i][1], data[j][1]) > data[k][1]) {
					check= false;
					break;
				}
			}
			if(check) {
				ans++;
			}
			
			
		}
	}
	return ans;

}}