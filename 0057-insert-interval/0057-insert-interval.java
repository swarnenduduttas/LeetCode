class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();

        // if(n < 1){
        //     res.add(newInterval);
        //     return res.toArray(new int[res.size()][]);
        // }
        boolean inserted = false;
        for(int[] interval: intervals){
            if(interval[0]>newInterval[0]){
                res.add(newInterval);
                inserted = true;
            }
            res.add(interval);
        }
        if(!inserted){
            res.add(newInterval);
        }
        return merge(res.toArray(new int[res.size()][]));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x,y)->Integer.compare(x[0], y[0]));

        int start1 = intervals[0][0];
        int end1 = intervals[0][1];
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();

        for(int i = 0; i< intervals.length; i++){
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];
            if(end1>=start2){
                start1 = start1;
                end1= Math.max(end1,end2);
                continue;
            }
            res.add(new int[]{start1, end1});
            start1 = start2;
            end1= end2;
        }
        res.add(new int[]{start1,end1});
        return res.toArray(new int[res.size()][]);
    }
}