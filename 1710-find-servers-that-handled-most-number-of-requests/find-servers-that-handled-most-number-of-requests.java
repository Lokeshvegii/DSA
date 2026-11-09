class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> avl = new TreeSet<>();
        PriorityQueue<int[]> busy = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        int[] count  = new int[k];

        for(int i = 0; i < k; i++) {
            avl.add(i);
        }
        for(int i = 0; i < arrival.length; i++) {
            int  t = arrival[i];
            while(!busy.isEmpty() && busy.peek()[0] <= t) {
                int[] s = busy.poll();
                avl.add(s[1]);
            }
            if(avl.isEmpty()) continue;

            int j = i % k;

            Integer server = avl.ceiling(j);
            if(server == null) {
                server = avl.first();
            }
            avl.remove(server);
            count[server]++;
            busy.offer(new int[]{t + load[i], server});
        }
        int max = Integer.MIN_VALUE;
        for(int c : count) {
            max = Math.max(max, c);
        }
        List<Integer> re = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            if(count[i] == max) {
                re.add(i);
            }
        }
        return re;
    }
}