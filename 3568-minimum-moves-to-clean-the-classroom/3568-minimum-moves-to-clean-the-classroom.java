import java.util.*;

class Solution {

    static class State {
        int x, y, energy, mask, moves;

        State(int x, int y, int energy, int mask, int moves) {
            this.x = x;
            this.y = y;
            this.energy = energy;
            this.mask = mask;
            this.moves = moves;
        }
    }

    public int minMoves(String[] classroom, int maxEnergy) {

        int m = classroom.length;
        int n = classroom[0].length();

        char[][] grid = new char[m][n];

        int sx = -1, sy = -1;

        List<int[]> litter = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                grid[i][j] = classroom[i].charAt(j);

                if (grid[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }

                if (grid[i][j] == 'L') {
                    litter.add(new int[]{i, j});
                }
            }
        }

        int k = litter.size();

        if (k == 0) return 0;

        int targetMask = (1 << k) - 1;

        int[][] litterIndex = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(litterIndex[i], -1);
        }

        for (int i = 0; i < k; i++) {
            int x = litter.get(i)[0];
            int y = litter.get(i)[1];
            litterIndex[x][y] = i;
        }

        boolean[][][][] visited =
            new boolean[m][n][maxEnergy + 1][1 << k];

        Queue<State> q = new ArrayDeque<>();

        q.offer(new State(sx, sy, maxEnergy, 0, 0));

        visited[sx][sy][maxEnergy][0] = true;

        int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!q.isEmpty()) {

            State curr = q.poll();

            if (curr.mask == targetMask) {
                return curr.moves;
            }

            for (int[] dir : dirs) {

                int nx = curr.x + dir[0];
                int ny = curr.y + dir[1];

                if (nx < 0 || nx >= m ||
                    ny < 0 || ny >= n) {
                    continue;
                }

                if (grid[nx][ny] == 'X') {
                    continue;
                }

                int newEnergy = curr.energy - 1;

                if (newEnergy < 0) {
                    continue;
                }

                int newMask = curr.mask;

                if (grid[nx][ny] == 'L') {
                    int index = litterIndex[nx][ny];
                    newMask |= (1 << index);
                }

                if (grid[nx][ny] == 'R') {
                    newEnergy = maxEnergy;
                }

                if (visited[nx][ny][newEnergy][newMask]) {
                    continue;
                }

                visited[nx][ny][newEnergy][newMask] = true;

                q.offer(new State(
                    nx,
                    ny,
                    newEnergy,
                    newMask,
                    curr.moves + 1
                ));
            }
        }

        return -1;
    }
}