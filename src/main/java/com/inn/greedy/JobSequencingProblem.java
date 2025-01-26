package com.inn.greedy;

/*
https://www.geeksforgeeks.org/job-sequencing-problem/
https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
 */


import java.util.Arrays;

class Job {
    int id, deadline, profit;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}


public class JobSequencingProblem {

    public static void main(String[] args) {
        Job[] arr = {
                new Job(1,2,100),
                new Job(2,1,19),
                new Job(3,2,27),
                new Job(4,1,25),
                new Job(5,1,15)
        };

        int[] res = JobScheduling(arr, arr.length);
        System.out.println(Arrays.toString(res));
    }

    // using greedy approach
    private static int[] JobScheduling(Job jobs[], int n) {
        // Your code here
        // sort jobs bases on profits
        Arrays.sort(jobs, (job1, job2) -> job2.profit - job1.profit);

        boolean[] flags = new boolean[n];

        int totalProfit = 0;
        int totalJobs = 0;

        for (Job job : jobs){

            for (int j=Math.min(job.deadline-1, flags.length-1);j>=0;j--){
                if(!flags[j]){
                    flags[j] = true;
                    totalProfit += job.profit;
                    totalJobs++;

                    break;
                }
            }
        }

        return new int[]{totalJobs, totalProfit};
    }
}
