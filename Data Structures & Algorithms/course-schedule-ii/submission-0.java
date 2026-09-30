class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        int[] preReqCount = new int[numCourses];

        for (int[] preReq : prerequisites){

            preReqCount[preReq[0]]++;
            adjList.get(preReq[1]).add(preReq[0]);

        }

        Deque<Integer> fulfilledPreReq = new ArrayDeque<>();

        for (int i = 0; i < preReqCount.length; i++){
            if (preReqCount[i] == 0){
                fulfilledPreReq.offer(i);
            }
        }

        int count = 0;
        int[] returnOrder = new int[numCourses];

        while (!fulfilledPreReq.isEmpty()){

            int currClass = fulfilledPreReq.poll();
            returnOrder[count] = currClass;
            count++;

            for (int currAdj : adjList.get(currClass)){

                preReqCount[currAdj]--;

                if (preReqCount[currAdj] == 0){
                    fulfilledPreReq.offer(currAdj);
                }
            }
        }

        return count == numCourses ? returnOrder : new int[] {};
        
    }
}
