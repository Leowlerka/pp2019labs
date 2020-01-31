package telematics.nosova.lab4;

import java.util.ArrayList;
import java.util.List;

public class lab4 {
    public static void main(String[] args) {
        int totla = running(20, 1000);
    }

    public static int running(int num, int bound1) {
        int numThreads = num;
        int bound = bound1;
        int prev = (int) Math.sqrt(bound) + 1;
        List<Integer> AllPrimes = new ArrayList<Integer>();
        AllPrimes.add(2);
        Prime GeneralFind = new Prime(AllPrimes, 3, prev, 2);

        long timeStart = System.currentTimeMillis();
        GeneralFind.run();
        if (prev % 2 == 0) prev++;

        Prime[] threads = new Prime[numThreads];
        List[] copies = new List[numThreads];
        for (int i = 0; i < numThreads; i++) {
            List<Integer> copy = new ArrayList<Integer>(AllPrimes);
            threads[i] = new Prime(copy, prev + 2 * i, bound, 2 * numThreads);
            copies[i] = copy;
            threads[i].start();
        }
        long timeFinish = System.currentTimeMillis();

        try {
            for (int i = 1; i < numThreads; i++)
                threads[i].join();
        } catch (InterruptedException ex) {
        }

        int total = AllPrimes.size();
        for (int i = 0; i < numThreads; i++)
            total += (copies[i].size() - AllPrimes.size());
        System.out.println("Total Primes found: " + total);
        System.out.println("Time: " + (timeFinish - timeStart));
        return total;
    }
}