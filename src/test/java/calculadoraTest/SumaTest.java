package calculadoraTest;

import calculadora.Calculadora;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SumaTest {

    Calculadora cal;
    @Before
    public void before(){
        cal = new Calculadora();
    }

    @Test
    public void sumarPares(){
        int actualResult= cal.sumar(4,2);
        int expectedResult= 6;
        Assert.assertEquals("ERROR! la suma es incorrecto",expectedResult,actualResult);

    }

    @Test
    public void sumarImpares(){
        int actualResult= cal.sumar(5,3);
        int expectedResult= 8;
        Assert.assertEquals("ERROR! la suma es incorrecto",expectedResult,actualResult);

    }

    @Test
    public void sumarImparesPares(){
        int actualResult= cal.sumar(4,7);
        int expectedResult= 11;
        Assert.assertEquals("ERROR! la suma es incorrecto",expectedResult,actualResult);
    }
}
