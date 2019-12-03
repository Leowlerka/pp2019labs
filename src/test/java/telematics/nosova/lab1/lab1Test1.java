package telematics.nosova.lab1;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class lab1Test1 {

    @Test
    public void transArr() {
        String[][] arr = lab1.TransArr("arr.txt");
        String[][] newArr = {{"11", "4"}, {"9", "5"} , {"3", "8"}};
        Assert.assertTrue(Arrays.deepEquals(arr, newArr));

        String[][] arr1 = lab1.TransArr("arr1.txt");
        String[][] newArr1 = {{"abba", "good", "yellow"}, {"hello", "spell", "silver"}};
        Assert.assertTrue(Arrays.deepEquals(arr1, newArr1));

        String[][] arr2 = lab1.TransArr("arr2.txt");
        String[][] newArr2 = {{"j"}};
        Assert.assertTrue(Arrays.deepEquals(arr2, newArr2));
    }
}