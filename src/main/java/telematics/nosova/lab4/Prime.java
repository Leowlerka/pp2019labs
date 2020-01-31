package telematics.nosova.lab4;

import java.util.List;

public class Prime extends Thread {
    private List<Integer> primes;
    private int diff, prev, cur;

    public Prime(List<Integer> listPrimes, int curn, int pre, int dif) {
        primes = listPrimes;
        cur = curn;
        prev = pre;
        diff = dif;
    }

    private void findPrime() {
        while (cur <= prev) {
            boolean isPrime = true;
            for (int i : primes) {
                if (i * i > cur) break;
                if (cur % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(cur);
                //System.out.println(cur);
            }
            cur += diff;
        }
    }

    @Override
    public void run() {
        findPrime();
    }
}