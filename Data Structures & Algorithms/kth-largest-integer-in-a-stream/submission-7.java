class KthLargest {

    private Queue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {

        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for (int curr : nums){

            minHeap.offer(curr);

            if (minHeap.size() > k){
                minHeap.poll();
            }

        }
        
    }
    
    public int add(int val) {

        minHeap.offer(val);

        if (minHeap.size() > k){
            minHeap.poll();
        }

        return minHeap.peek();
        
    }
}
