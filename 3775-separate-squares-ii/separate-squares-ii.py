class Solution:
    def separateSquares(self, squares: List[List[int]]) -> float:
        # 1. Coordinate Compression for X
        xs = set()
        for x, y, l in squares:
            xs.add(x)
            xs.add(x + l)
        
        sorted_x = sorted(list(xs))
        x_map = {val: i for i, val in enumerate(sorted_x)}
        m = len(sorted_x)
        
        # Segment Tree Arrays
        # Range of elementary intervals is 0 to m-2
        tree_count = [0] * (4 * m)
        tree_len = [0.0] * (4 * m)
        
        def update(node, start, end, l, r, val):
            if l > end or r < start:
                return
            if l <= start and end <= r:
                tree_count[node] += val
            else:
                mid = (start + end) // 2
                update(node * 2, start, mid, l, r, val)
                update(node * 2 + 1, mid + 1, end, l, r, val)
            
            if tree_count[node] > 0:
                tree_len[node] = sorted_x[end + 1] - sorted_x[start]
            else:
                if start != end:
                    tree_len[node] = tree_len[node * 2] + tree_len[node * 2 + 1]
                else:
                    tree_len[node] = 0.0

        # 2. Events
        events = []
        for x, y, l in squares:
            idx1 = x_map[x]
            idx2 = x_map[x + l]
            # interval [idx1, idx2 - 1]
            events.append((y, 1, idx1, idx2 - 1))
            events.append((y + l, -1, idx1, idx2 - 1))
        
        events.sort(key=lambda x: x[0])
        
        # 3. Sweep
        history = [] # Stores (y_start, dy, width)
        prev_y = events[0][0]
        
        for y, type_, l_idx, r_idx in events:
            dy = y - prev_y
            if dy > 0:
                history.append((prev_y, dy, tree_len[1]))
            
            update(1, 0, m - 2, l_idx, r_idx, type_)
            prev_y = y
            
        # 4. Find Split
        total_area = sum(h[1] * h[2] for h in history)
        target = total_area / 2.0
        
        current_sum = 0.0
        for y_start, dy, width in history:
            strip_area = dy * width
            if current_sum + strip_area >= target:
                if width == 0:
                    return float(y_start)
                missing = target - current_sum
                return y_start + (missing / width)
            current_sum += strip_area
            
        return float(prev_y)