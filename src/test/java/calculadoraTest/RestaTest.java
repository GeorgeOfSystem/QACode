package calculadoraTest;

import calculadora.Calculadora;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RestaTest {

    Calculadora cal;
    @Before
    public void before(){
        cal = new Calculadora();
    }

    @Test
    public void restarPares(){
        int actualResult= cal.restar(4,2);
        int expectedResult= 2;
        Assert.assertEquals("ERROR! la suma es incorrecto",expectedResult,actualResult);

    }

    @Test
    public void restarImpares(){
        int actualResult= cal.restar(5,3);
        int expectedResult= 2;
        Assert.assertEquals("ERROR! la suma es incorrecto",expectedResult,actualResult);

    }

    @Test
    public void restarImparesPares(){
        int actualResult= cal.restar(4,7);
        int expectedResult= -3;
        Assert.assertEquals("ERROR! la suma es incorrecto",expectedResult,actualResult);
    }
}
