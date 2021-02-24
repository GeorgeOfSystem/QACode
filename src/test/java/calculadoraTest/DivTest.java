package calculadoraTest;

import calculadora.Calculadora;
import org.junit.Assert;
import org.junit.Before;

public class DivTest {

    Calculadora cal;
    @Before
    public void before(){
        cal = new Calculadora();
    }

    @org.junit.Test
    public void divPares(){
        int actualResult= cal.div(4,2);
        int expectedResult= 2;
        Assert.assertEquals("ERROR! la suma es incorrecto",expectedResult,actualResult);

    }

    @org.junit.Test
    public void divImpares(){
        int actualResult= cal.div(15,3);
        int expectedResult= 5;
        Assert.assertEquals("ERROR! la suma es incorrecto",expectedResult,actualResult);

    }

    @org.junit.Test(expected = ArithmeticException.class)
    public void divImparesPares(){
        cal.div(9,0);
    }
}
