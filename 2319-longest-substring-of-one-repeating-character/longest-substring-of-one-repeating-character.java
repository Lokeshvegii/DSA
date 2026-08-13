class Solution {

    int size;
    int[] pre, suf, max;
    char[] left, right;

    private void pull(int p) {
        int l = p << 1;
        int r = l | 1;

        left[p] = left[l];
        right[p] = right[r];

        pre[p] = pre[l];
        if (pre[l] == sizeOf(l) && right[l] == left[r]) {
            pre[p] += pre[r];
        }

        suf[p] = suf[r];
        if (suf[r] == sizeOf(r) && right[l] == left[r]) {
            suf[p] += suf[l];
        }

        max[p] = Math.max(max[l], max[r]);

        if (right[l] == left[r]) {
            max[p] = Math.max(max[p], suf[l] + pre[r]);
        }
    }

    private int sizeOf(int p) {
        int level = 31 - Integer.numberOfLeadingZeros(p);
        return size >> level;
    }

    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        int n = s.length();

        size = 1;
        while (size < n) {
            size <<= 1;
        }

        int total = size << 1;

        pre = new int[total];
        suf = new int[total];
        max = new int[total];
        left = new char[total];
        right = new char[total];


        for (int i = 0; i < n; i++) {
            int p = size + i;

            pre[p] = 1;
            suf[p] = 1;
            max[p] = 1;
            left[p] = s.charAt(i);
            right[p] = s.charAt(i);
        }

        for (int p = size - 1; p > 0; p--) {
            pull(p);
        }

        int q = queryIndices.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {

            int pos = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            int p = size + pos;

            pre[p] = 1;
            suf[p] = 1;
            max[p] = 1;
            left[p] = ch;
            right[p] = ch;

            for (p >>= 1; p > 0; p >>= 1) {
                pull(p);
            }

            ans[i] = max[1];
        }

        return ans;
    }
}