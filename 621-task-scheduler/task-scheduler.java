class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxFrequency = 0;
        int numberOfMostFrequentTasks = 0 ;
        int[] frequency = new int[26];
        for(char task: tasks){
            int index = task-'A';
            frequency[index]++;
            maxFrequency=Math.max(maxFrequency,frequency[index]);
        }

        for(int i=0;i<26;i++){
            if(frequency[i]==maxFrequency){
                numberOfMostFrequentTasks++;
            }
        }
        return Math.max(tasks.length,((maxFrequency-1)*(n+1))+numberOfMostFrequentTasks);
    }
}