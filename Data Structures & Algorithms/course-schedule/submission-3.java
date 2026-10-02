class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] preReqs = new int[numCourses];
        List<List<Integer>> preReqList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++){
            preReqList.add(new ArrayList<>());
        }

        for (int[] curr : prerequisites){

            preReqs[curr[0]]++;
            preReqList.get(curr[1]).add(curr[0]);

        }

        Deque<Integer> toProcess = new ArrayDeque<>();

        for (int i = 0; i < preReqs.length; i++){

            if (preReqs[i] == 0){
                toProcess.offer(i);
            }

        }

        int classesTaken = 0;

        while (!toProcess.isEmpty()){

            int curr = toProcess.poll();
            classesTaken++;

            for (int currClass : preReqList.get(curr)){

                preReqs[currClass]--;

                if (preReqs[currClass] == 0){
                    toProcess.offer(currClass);
                }
            }
        }

        System.out.println(classesTaken);

        return classesTaken == numCourses;
        
    }
}
