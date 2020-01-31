package telematics.nosova.lab4;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static telematics.nosova.lab4.lab4.running;

public class PrimeTest {
    @Test
    public void test() {
        int total = running(20, 1000);
        Assert.assertTrue(total == 168);
        total = running(20, 10000);
        Assert.assertTrue(total == 1230);
        total = running(2, 1000);
        Assert.assertTrue(total == 168);
        total = running(5, 5000);
        Assert.assertTrue(total == 670);
        total = running(30, 1000000);
        Assert.assertTrue(total == 78498);
    }
}