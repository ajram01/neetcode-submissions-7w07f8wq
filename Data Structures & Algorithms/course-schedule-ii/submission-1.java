class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] numPrereq = new int[numCourses];

        List<List<Integer>> preReqList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++){

            preReqList.add(new ArrayList<>());

        }

        for (int[] curr : prerequisites){

            numPrereq[curr[0]]++;
            preReqList.get(curr[1]).add(curr[0]);

        }

        Deque<Integer> toProcess = new ArrayDeque<>();

        for (int i = 0; i < numPrereq.length; i++){

            if (numPrereq[i] == 0){
                toProcess.offer(i);
            }

        }

        int coursesTaken = 0;
        int[] returnList = new int[numCourses];

        while (!toProcess.isEmpty()){

            int taken = toProcess.poll();
            returnList[coursesTaken++] = taken;

            for (int next : preReqList.get(taken)){

                if (--numPrereq[next] == 0){
                    toProcess.offer(next);
                }

            }

        }

        return coursesTaken == numCourses ? returnList : new int[] {};


        
    }
}
