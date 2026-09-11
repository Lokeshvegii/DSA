class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        boolean[] used = new boolean[1000];
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(digits[i] % 2 != 0) continue;
            
            for(int j = 0; j < n; j++) {
                if(i == j) continue;

                for(int k = 0; k < n; k++) {
                    if(k == i || k == j) continue;
                    if (digits[k] == 0) continue;
                    int num = digits[k] * 100 + digits[j] * 10 + digits[i] *1;

                    if(!used[num]) {
                        used[num] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}