class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        List<Pair> taskList = new ArrayList<>();
        for (int i = 0; i < capital.length; i++) {
            taskList.add(new Pair(capital[i], profits[i]));
        }

        taskList.sort((a, b) -> a.capital - b.capital);

        int index = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.profit - a.profit);

        while (k > 0) {
            while (index < taskList.size()) {
                if (taskList.get(index).capital > w) {
                    break;
                }
                pq.add(taskList.get(index));
                index++;
            }
            if (pq.isEmpty()) {
                return w;
            }
            w += pq.poll().profit;
            k--;
        }

        return w;

    }
}

class Pair {
    int capital;
    int profit;

    public Pair(int capital, int profit) {
        this.capital = capital;
        this.profit = profit;
    }
}