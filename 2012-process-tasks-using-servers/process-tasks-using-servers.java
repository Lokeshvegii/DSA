class Solution {
    class Server {
        int weight;
        int index;
        long freeTime;
        Server(int weight, int index, int freeTime) {
            this.weight = weight;
            this.index = index;
            this.freeTime = freeTime;
        }
    }
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];
        PriorityQueue<Server> available = new PriorityQueue<>((a, b) -> {
            if(a.weight != b.weight) {
                return Integer.compare(a.weight, b.weight);
            }
            return Integer.compare(a.index, b.index);
        });

        PriorityQueue<Server> busy = new PriorityQueue<>((a,b) -> {
            if(a.freeTime != b.freeTime) {
                return Long.compare(a.freeTime, b.freeTime);
            }
            if(a.weight != b.weight) {
                return Integer.compare(a.weight, b.weight);
            }
            return Integer.compare(a.index, b.index);
    });

        for(int i = 0; i < n; i++) {
            available.offer(new Server(servers[i], i, 0));
        }
        long time = 0;
        for(int i = 0; i < m; i++) {
            time = Math.max(time, (long)i);
            while(!busy.isEmpty() && busy.peek().freeTime <= time) {
                available.offer(busy.poll());
            }
            if(available.isEmpty()) {
                time = busy.peek().freeTime;
                while(!busy.isEmpty() && busy.peek().freeTime <= time) {
                    available.offer(busy.poll());
                }
            }
            Server server = available.poll();
            ans[i] = server.index;
            server.freeTime = time + tasks[i];
            busy.offer(server);
        }
        return ans;
    }
}