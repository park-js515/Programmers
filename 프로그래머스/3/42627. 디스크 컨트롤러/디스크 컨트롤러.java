import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;
        int time = 0;
        int sum = 0;
        PriorityQueue<Disk> disks = new PriorityQueue<>();
        PriorityQueue<Task> tasks = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            disks.add(new Disk(i, jobs[i][0], jobs[i][1]));
        }
        
        while (!disks.isEmpty() || !tasks.isEmpty()) {
            // tasks 작업 처리 후 시간 계산
            if (!tasks.isEmpty()) {
                Task task = tasks.poll();
                time += task.c;
                sum += time - task.b;
            }
            
            // disks에서 빼서 넣기
            while (!disks.isEmpty() && disks.peek().b <= time) {
                tasks.add(new Task(disks.poll()));
            }
            
            if (tasks.isEmpty() && !disks.isEmpty()) {
                Disk disk = disks.poll();
                time = disk.b;
                tasks.add(new Task(disk));
                
                while (!disks.isEmpty() && disks.peek().b == time) {
                    tasks.add(new Task(disks.poll()));
                }
            }
        }
        
        return sum / n;
    }
    
    private class Disk implements Comparable<Disk> {
        int a, b, c;
        
        public Disk(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        @Override
        public int compareTo(Disk o) {
            return Integer.compare(this.b, o.b);
        }
    }
    
    private class Task implements Comparable<Task> {
        int a, b, c; // 작업 번호, 작업 요청 시간, 작업 소요 시간
        
        public Task(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        public Task(Disk disk) {
            this.a = disk.a;
            this.b = disk.b;
            this.c = disk.c;
        }
        
        @Override
        public int compareTo(Task o) {
            if (this.c != o.c) {
                return Integer.compare(this.c, o.c);
            }
            if (this.b != o.b) {
                return Integer.compare(this.b, o.b);
            }
            return Integer.compare(this.a, o.a);
        }
    }
}