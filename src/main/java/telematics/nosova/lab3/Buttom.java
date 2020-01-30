package telematics.nosova.lab3;

import java.util.concurrent.ThreadLocalRandom;

//class Buttom implements Runnable {
class Buttom{
    private final Radio rad;

    public Buttom(Radio radio) {
        rad = radio;
    }

    private void onOrOff(Radio rad) {  // Выключать мгновенно?
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

    /*
    public void run() {
        while (true) {
            scan(rad);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(700, 7000));
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            reset(rad);
        }
    */
}