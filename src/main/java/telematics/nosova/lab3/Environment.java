package telematics.nosova.lab3;

class Environment {
    private final Radio radio;

    public Environment() {
        radio = new Radio();
    }

    public void runEnvironment() {
        for (int i = 0; i < 3; i++) { // 1 - onoff, 2 - scan, 3 - reset
            Thread t = new Thread(new Buttom(radio), "Buttom " + i);
            t.start();
        }
        Thread radioThread = new Thread((Runnable) radio, "Radio");
        radioThread.run();
    }

    public Radio getRadio() {
        return radio;
    }
}
