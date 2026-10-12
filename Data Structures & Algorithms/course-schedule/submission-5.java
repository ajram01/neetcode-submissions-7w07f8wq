class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] preReqs = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++){

            preReqs[prerequisites[i][0]]++;

            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);

        }

        Deque<Integer> canTake = new ArrayDeque<>();

        for (int i = 0; i < preReqs.length; i++){

            if (preReqs[i] == 0){
                canTake.offer(i);
            }

        }

        int taken = 0;

        while (!canTake.isEmpty()){

            int curr = canTake.poll();
            taken++;

            for(int course : adj.get(curr)){

                preReqs[course]--;
                if (preReqs[course] == 0){
                    canTake.add(course);
                }

            }

        }

        return taken == numCourses;
        
    }
}
