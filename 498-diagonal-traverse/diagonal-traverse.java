class Solution {
    public void reverse(List<Integer> list) {
        int i = 0, j = list.size() - 1;
        while (i < j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i + j;

                List<Integer> list = map.getOrDefault(key, new ArrayList<>());
                list.add(mat[i][j]);
                map.put(key, list);
            }
        }

        // Step 2: Traverse diagonals
        int arr[] = new int[m * n], i = 0;
        for (int d = 0; d < m + n - 1; d++) {
            List<Integer> list = map.get(d);

            if (d % 2 == 0) {
                reverse(list);
            }
            // add to result array
            for (int num : list)
                arr[i++] = num;

        }
        return arr;
    }
}