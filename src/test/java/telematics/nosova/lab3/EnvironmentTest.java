package telematics.nosova.lab3;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class EnvironmentTest {
    private Environment env;

    @Test
    void runEnvironment() {
        env = new Environment();
        env.runEnvironment();
        Assert.assertTrue(true);
    }
}