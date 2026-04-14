class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (!Objects.equals(a.count, b.count)) {
                        return b.count - a.count;
                    } else {
                        return b.member.compareTo(a.member);
                    }
                });

        for (Map.Entry<Character, Integer> e : freqMap.entrySet()) {
            pq.add(new Pair(e.getValue(), e.getKey()));
        }

        List<Character> res = new ArrayList<>();
        int seat = 0;
        while (!pq.isEmpty()) {
            Pair pair1 = pq.poll();
            if (res.isEmpty() || res.get(seat - 1) != pair1.member) {
                res.add(pair1.member);
                pair1.count--;
                if (pair1.count != 0) {
                    pq.add(pair1);
                }
            } else {
                if (pq.isEmpty()) {
                    return "";
                } else {
                    Pair pair2 = pq.poll();
                    res.add(pair2.member);
                    pair2.count--;
                    if (pair2.count != 0) {
                        pq.add(pair2);
                    }
                    pq.add(pair1);
                }
            }
            seat++;
        }

        StringBuilder result = new StringBuilder();
        for (Character c : res) {
            result.append(c);
        }
        return result.toString();

    }
}

class Pair {
    Integer count;
    Character member;

    public Pair(Integer count, Character member) {
        this.count = count;
        this.member = member;
    }
}