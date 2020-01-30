package telematics.nosova.lab3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Radio implements Runnable {
    private final int maxFreq = 108;
    private final int minFreq = 88;
    private int nowFreq = -1;

    private final Semaphore inSearch = new Semaphore(1);

    public Radio() {
    }

    private void play() {
        while (!inSearch.tryAcquire()) {
        }
        int fre = getNowFreq();
        if (fre!= -1) System.out.println("Radio is playing at a frequency of " + fre);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inSearch.release();
    }

    private void waitButtom() throws InterruptedException {
        System.out.println("Radio is waiting for a buttom to be pressed!");
        Thread.sleep(500);
    }

    public void run() {
        try {
            waitButtom();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        play();
    }

    public void setFreq() {
        nowFreq = maxFreq;
    }

    public void resetFreq() {
        nowFreq = -1;
    }

    public void incFreq() {
        nowFreq += ThreadLocalRandom.current().nextInt(1, 5);
        if (nowFreq > maxFreq) nowFreq = maxFreq;
    }

    public void decFreq() {
        nowFreq -= ThreadLocalRandom.current().nextInt(1, 5);
        if (nowFreq < minFreq) nowFreq = minFreq;
    }

    public Semaphore getInSearch() {
        return inSearch;
    }

    public int getNowFreq() {
        return nowFreq;
    }
}
