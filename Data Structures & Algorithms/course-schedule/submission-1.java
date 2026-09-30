class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        int[] preReqCount = new int[numCourses];

        for (int j = 0; j < prerequisites.length; j++){

            preReqCount[prerequisites[j][0]]++;
            adjList.get(prerequisites[j][1]).add(prerequisites[j][0]);

        }

        Deque<Integer> toProcess = new ArrayDeque<>();

        for (int i = 0; i < preReqCount.length; i++){

            if (preReqCount[i] == 0){
                toProcess.offer(i);
            }

        }

        while (!toProcess.isEmpty()){

            int curr = toProcess.poll();

            for (int currAdj : adjList.get(curr)){

                preReqCount[currAdj]--;
                if (preReqCount[currAdj] == 0){
                    toProcess.offer(currAdj);
                }
            }

        }

        for (int count : preReqCount){
            if (count > 0){
                return false;
            }
        }

        return true;

        // Time Complexity: O(V + E)
        // Space Complexity: O(V + E)
        
    }
}
