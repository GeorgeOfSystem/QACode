package calculadoraPowerMockito;

import calculadotaPowerMockito.CalculadoraPowerMock;
import calculadotaPowerMockito.HelperCalculadoraService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

//Paso 1 para metodos estaticos
@RunWith(PowerMockRunner.class)
//Paso 2 para metodos estaticos
@PrepareForTest(HelperCalculadoraService.class)
public class CalculadoraPowerMockTest {

    @Test
    public void verify_calculadora_power_mock(){
        //Paso 3 utilizat el powermock sobre la clase que tiene el metodo estatico
        PowerMockito.mockStatic(HelperCalculadoraService.class);
        //Paso 4 darle logica al metodo estatico mocked
        Mockito.when(HelperCalculadoraService.multi(1,1)).thenReturn(1);
        Mockito.when(HelperCalculadoraService.multi(1,2)).thenReturn(2);
        Mockito.when(HelperCalculadoraService.multi(2,3)).thenReturn(6);

        CalculadoraPowerMock calculadora = new CalculadoraPowerMock();

        int expectedResult=6;
        int actualResult= calculadora.factorial(3);
        Assert.assertEquals("ERROR en factorial!",expectedResult,actualResult);

    }

}
