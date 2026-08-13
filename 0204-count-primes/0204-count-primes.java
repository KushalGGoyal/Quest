class Solution {
    public int countPrimes(int n) {

        boolean[] composite = new boolean[n];

        // Mark composite numbers
        for (int p = 2; p * p < n; p++) {

            if (!composite[p]) {

                for (int i = p * p; i < n; i += p) {
                    composite[i] = true;
                }
            }
        }

        // Count primes
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!composite[i]) {
                count++;
            }
        }

        return count;
    }
}