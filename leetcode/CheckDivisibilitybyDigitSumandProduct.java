package leetcode;

class CheckDivisibilitybyDigitSumandProduct {
    public boolean checkDivisibility(int n) {
        int sum = 0, product = 1, a = n;

        while (a > 0) {
            int d = a % 10;
            sum += d;
            product *= d;
            a /= 10;
        }

        return n % (sum + product) == 0;
    }
}