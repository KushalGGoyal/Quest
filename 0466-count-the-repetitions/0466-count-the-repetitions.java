class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {

        int m = s2.length();

        // next[i] = position in s2 after processing one s1
        // when we start matching s2 from index i
        int[] next = new int[m];

        // gain[i] = number of complete s2 strings formed
        // while processing one s1 starting from i
        int[] gain = new int[m];

        for (int start = 0; start < m; start++) {

            int j = start;
            int count = 0;

            for (int k = 0; k < s1.length(); k++) {

                if (s1.charAt(k) == s2.charAt(j)) {
                    j++;

                    if (j == m) {
                        j = 0;
                        count++;
                    }
                }
            }

            next[start] = j;
            gain[start] = count;
        }

        // Detect cycle
        boolean[] visited = new boolean[m];

        int pos = 0;
        int totalS2 = 0;
        int usedS1 = 0;

        while (usedS1 < n1) {

            // Cycle detected
            if (visited[pos]) {

                int cycleStartS1 = usedS1;
                int cycleStartS2 = totalS2;

                // Find cycle length
                int cycleS1 = 0;
                int cycleS2 = 0;

                int cyclePos = pos;

                do {
                    cycleS1++;
                    cycleS2 += gain[cyclePos];
                    cyclePos = next[cyclePos];
                } while (cyclePos != pos);

                // Skip as many complete cycles as possible
                int remaining = n1 - usedS1;
                int cycles = remaining / cycleS1;

                usedS1 += cycles * cycleS1;
                totalS2 += cycles * cycleS2;

                // If no cycle can be skipped, process normally
                if (cycles == 0) {
                    totalS2 += gain[pos];
                    pos = next[pos];
                    usedS1++;
                }

                continue;
            }

            visited[pos] = true;

            totalS2 += gain[pos];
            pos = next[pos];
            usedS1++;
        }

        return totalS2 / n2;
    }
}