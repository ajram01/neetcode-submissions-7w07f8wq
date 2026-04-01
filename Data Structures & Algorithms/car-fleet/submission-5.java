class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int size = position.length;

        int[][] cars = new int[size][2];

        for (int i = 0; i < size; i++){

            cars[i][0] = position[i];
            cars[i][1] = speed[i];

        }

        Arrays.sort(cars, (a,b) -> Integer.compare(a[0], b[0]));

        Deque<Double> fleets = new ArrayDeque<>();

        for (int j = size - 1; j >= 0; j--){

            double timeToTarget = (double) (target - cars[j][0]) / cars[j][1];
            System.out.println("Car: " + cars[j][0] + "Time to target: " + timeToTarget);

            if( fleets.isEmpty() || fleets.peek() < timeToTarget){
                fleets.push(timeToTarget);
            }

        }

        return fleets.size();
        
    }
}
