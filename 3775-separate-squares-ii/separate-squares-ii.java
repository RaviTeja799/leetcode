import java.util.*;

class Solution {
    // Segment Tree components
    private int[] count;
    private double[] length;
    private double[] X;

    private void update(int node, int start, int end, int l, int r, int val) {
        if (l > end || r < start) return;
        if (l <= start && end <= r) {
            count[node] += val;
        } else {
            int mid = start + (end - start) / 2;
            update(node * 2, start, mid, l, r, val);
            update(node * 2 + 1, mid + 1, end, l, r, val);
        }

        if (count[node] > 0) {
            length[node] = X[end + 1] - X[start];
        } else {
            if (start != end) {
                length[node] = length[node * 2] + length[node * 2 + 1];
            } else {
                length[node] = 0.0;
            }
        }
    }

    public double separateSquares(int[][] squares) {
        // 1. Coordinate Compression
        TreeSet<Double> xSet = new TreeSet<>();
        for (int[] sq : squares) {
            xSet.add((double) sq[0]);
            xSet.add((double) sq[0] + sq[2]);
        }
        
        X = new double[xSet.size()];
        int i = 0;
        for (Double val : xSet) X[i++] = val;
        
        Map<Double, Integer> xMap = new HashMap<>();
        for (i = 0; i < X.length; i++) xMap.put(X[i], i);

        int m = X.length;
        count = new int[4 * m];
        length = new double[4 * m];

        // 2. Events
        List<Event> events = new ArrayList<>();
        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];
            int idx1 = xMap.get((double)sq[0]);
            int idx2 = xMap.get((double)sq[0] + l);
            // Update interval [idx1, idx2 - 1]
            events.add(new Event(y, 1, idx1, idx2 - 1));
            events.add(new Event(y + l, -1, idx1, idx2 - 1));
        }
        
        Collections.sort(events);

        // 3. Sweep
        List<Strip> history = new ArrayList<>();
        double prev_y = events.get(0).y;
        
        for (Event ev : events) {
            double curr_y = ev.y;
            double dy = curr_y - prev_y;
            
            if (dy > 0) {
                history.add(new Strip(prev_y, dy, length[1]));
            }
            
            update(1, 0, m - 2, ev.x_l, ev.x_r, ev.type);
            prev_y = curr_y;
        }
        
        // 4. Calculate Total Area and find Split
        double totalArea = 0;
        for (Strip s : history) totalArea += s.dy * s.width;
        
        double target = totalArea / 2.0;
        double currentSum = 0;
        
        for (Strip s : history) {
            double stripArea = s.dy * s.width;
            if (currentSum + stripArea >= target) {
                double missing = target - currentSum;
                if (s.width == 0) return s.y_start;
                return s.y_start + (missing / s.width);
            }
            currentSum += stripArea;
        }
        
        return prev_y;
    }
    
    // Helper classes
    private static class Event implements Comparable<Event> {
        double y;
        int type;
        int x_l, x_r;
        public Event(double y, int type, int x_l, int x_r) {
            this.y = y; this.type = type; this.x_l = x_l; this.x_r = x_r;
        }
        public int compareTo(Event other) {
            return Double.compare(this.y, other.y);
        }
    }
    
    private static class Strip {
        double y_start, dy, width;
        public Strip(double y_start, double dy, double width) {
            this.y_start = y_start; this.dy = dy; this.width = width;
        }
    }
}