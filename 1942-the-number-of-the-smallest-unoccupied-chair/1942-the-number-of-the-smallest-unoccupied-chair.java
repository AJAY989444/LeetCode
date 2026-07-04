class Solution {
    public int smallestChair(int[][] times, int targetFriend) {

        int n = times.length;

        int[][] friends = new int[n][3];

        for (int i = 0; i < n; i++) {
            friends[i][0] = times[i][0]; 
            friends[i][1] = times[i][1]; 
            friends[i][2] = i;           
        }

        Arrays.sort(friends, (a, b) -> a[0] - b[0]);

        
        PriorityQueue<Integer> freeChairs = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            freeChairs.offer(i);
        }

        
        PriorityQueue<int[]> occupied = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        for (int[] friend : friends) {

            int arrival = friend[0];
            int leave = friend[1];
            int index = friend[2];

            
            while (!occupied.isEmpty() && occupied.peek()[0] <= arrival) {
                freeChairs.offer(occupied.poll()[1]);
            }

            int chair = freeChairs.poll();

            if (index == targetFriend) {
                return chair;
            }

            occupied.offer(new int[]{leave, chair});
        }

        return -1;
    }
}