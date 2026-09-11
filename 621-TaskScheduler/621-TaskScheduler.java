// Last updated: 11/09/2026, 09:30:42
/*class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(int i=0; i<tasks.length; i++){
            freq[tasks[i] - 'A']++;
        }
        //we want to execute highest freq tasks first and put into cooldown
        PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
        for(int count: freq){
            if(count > 0)
            maxH.offer(count);
        }
        //after executing a task put here
        //[element, availableTime]
        Queue<int[]> coolDown = new ArrayDeque<>();
        int time = 0;
        //if either has an element we still have to process
        while(!maxH.isEmpty() || !coolDown.isEmpty()){
            time++;
            //imp: if cooldown is over add back to heap 
            if(!coolDown.isEmpty() && coolDown.peek()[1] == time){
                maxH.offer(coolDown.poll()[0]);
            }
            if(!maxH.isEmpty()){
                int remaining = maxH.poll();
                remaining--;
                if(remaining > 0){
                    coolDown.offer(new int[]{remaining, time+n+1});
                }
            }
        }
        return time;
    }
}*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        // Count frequency of each task
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Find maximum frequency
        int maxFreq = 0;
        for (int count : freq) {
            maxFreq = Math.max(maxFreq, count);
        }

        // Count how many tasks have maximum frequency
        int maxFreqTasks = 0;
        for (int count : freq) {
            if (count == maxFreq) {
                maxFreqTasks++;
            }
        }

        // Minimum length forced by the most frequent tasks
        int skeleton = (maxFreq - 1) * (n + 1) + maxFreqTasks;

        // Either the skeleton forces idle time,
        // or we can fill everything with actual tasks.
        return Math.max(tasks.length, skeleton);
    }
}