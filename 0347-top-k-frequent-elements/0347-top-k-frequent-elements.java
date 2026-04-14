class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map1.put(nums[i], map1.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.count - b.count);

        int count = 0;
        for(Map.Entry<Integer, Integer> e : map1.entrySet()){
            if(pq.size() != k){
                pq.add(new Pair(e.getValue(),e.getKey()));
                continue;
            }
            if(pq.peek().count < e.getValue()){
                pq.poll();
                pq.add(new Pair(e.getValue(),e.getKey()));
            }
        }

        int[] result = new int[k];

        for(int i =0; i<k; i++){
            result[i] = pq.poll().member;
        }

        return result;

    }

    class Pair {
        int count;
        int member;

        public Pair(int count, int member) {
            this.count = count;
            this.member = member;
        }
    }
}