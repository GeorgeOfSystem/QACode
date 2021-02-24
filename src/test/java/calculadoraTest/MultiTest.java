package calculadoraTest;

import calculadora.Calculadora;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MultiTest {

    Calculadora cal;
    @Before
    public void before(){
        cal = new Calculadora();
    }

    @Test
    public void multiPares() throws InterruptedException {
        int actualResult= cal.multi(4,2);
        int expectedResult= 8;
        Assert.assertEquals("ERROR! la suma es incorrecto",expectedResult,actualResult);

    }

    @Test
    public void multiImpares() throws InterruptedException {
        int actualResult= cal.multi(5,3);
        int expectedResult= 15;
        Assert.assertEquals("ERROR! la suma es incorrecto",expectedResult,actualResult);

    }

    @Test
    public void multiImparesPares() throws InterruptedException {
        int actualResult= cal.multi(4,7);
        int expectedResult= 28;
        Assert.assertEquals("ERROR! la suma es incorrecto",expectedResult,actualResult);
    }

    @Test(timeout = 1000)
    public void multiTime() throws InterruptedException {
        int actualResult= cal.multi(4,4);
        int expectedResult= 16;
        Assert.assertEquals("ERROR! la suma es incorrecto",expectedResult,actualResult);
    }
}
