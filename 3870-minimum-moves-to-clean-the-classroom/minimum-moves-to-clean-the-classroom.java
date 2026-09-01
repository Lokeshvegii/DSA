class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0, litterCount = 0;
        int[][] id = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                id[i][j] = -1;
                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } else if (ch == 'L') {
                    id[i][j] = litterCount++;
                }
            }
        }

        int masks = 1 << litterCount;
        int fullMask = masks - 1;
        int totalStates = m * n * (energy + 1) * masks;

        boolean[] visited = new boolean[totalStates];
        int[] queue = new int[totalStates];

        int start = (((sr * n + sc) * (energy + 1) + energy) * masks) + fullMask;

        queue[0] = start;
        visited[start] = true;

        int head = 0, tail = 1, moves = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (head < tail) {
            int levelEnd = tail;

            while (head < levelEnd) {
                int state = queue[head++];

                int mask = state % masks;
                state /= masks;

                int currEnergy = state % (energy + 1);
                state /= (energy + 1);

                int r = state / n;
                int c = state % n;

                if (mask == 0) {
                    return moves;
                }

                if (currEnergy == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    char cell = classroom[nr].charAt(nc);

                    if (cell == 'X') {
                        continue;
                    }

                    int nextEnergy = currEnergy - 1;
                    int nextMask = mask;

                    if (cell == 'R') {
                        nextEnergy = energy;
                    }

                    if (cell == 'L') {
                        nextMask &= ~(1 << id[nr][nc]);
                    }

                    int nextState =
                        (((nr * n + nc) * (energy + 1) + nextEnergy) * masks)
                        + nextMask;

                    if (!visited[nextState]) {
                        visited[nextState] = true;
                        queue[tail++] = nextState;
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}