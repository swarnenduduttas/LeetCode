class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map1 = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map1.put(nums[i], map1.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->{
                return b.second - a.second;
            }
        );

        for(Map.Entry<Integer, Integer> e : map1.entrySet()) {
            pq.add(new Pair(e.getKey(), e.getValue()));
        }

        int[] result = new int[k];

        for(int i = 0; i<k; i++){
            result[i] = pq.poll().first;
        }

        return result;

    }

    class Pair {
        int first;
        int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}