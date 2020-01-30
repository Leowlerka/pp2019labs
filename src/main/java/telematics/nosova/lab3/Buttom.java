package telematics.nosova.lab3;

import org.junit.Assert;

import java.util.concurrent.ThreadLocalRandom;

class Buttom implements Runnable {
    private final Radio rad;

    public Buttom(Radio radio) {
        rad = radio;
    }

    private void onOrOff(Radio rad) {
        if (rad.getNowFreq() == -1 && rad.getInSearch().tryAcquire()) {
            rad.setFreq();
            System.out.println("Radio is on!");
            rad.getInSearch().release();
        } else if (rad.getNowFreq() != -1 && rad.getInSearch().tryAcquire()) {
            rad.resetFreq();
            System.out.println("Radio is off!");
            rad.getInSearch().release();
        }
    }

    private void scan(Radio rad) { // if freq -1 nothing to do
        if (rad.getInSearch().tryAcquire() && rad.getNowFreq() != -1) {
            rad.incFreq();
            rad.getInSearch().release();
            System.out.println("New freq is " + rad.getNowFreq());
        }
    }

    private void reset(Radio rad) {
        if (rad.getInSearch().tryAcquire() && rad.getNowFreq() != -1) {
            rad.decFreq();
            rad.getInSearch().release();
            System.out.println("New freq is " + rad.getNowFreq());
        }
    }

    public void run() {
        onOrOff(rad);
        reset(rad);
        onOrOff(rad);
        onOrOff(rad);
        scan(rad);
        reset(rad);
        reset(rad);
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3000));
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}