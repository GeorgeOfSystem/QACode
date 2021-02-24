package calculadoraMockTest;

import calculadoraMock.BasicCalculadoraService;
import calculadoraMock.CalculadoraMock;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class CalculadoraMockTest {

    // PASO 2 para MOCK - instanciar el objeto con el metodo externo para mockeralo
    BasicCalculadoraService serviceMockito= Mockito.mock(BasicCalculadoraService.class);

     @Test
     public void verify_factorial_test(){

         // PASO 3 para MOCK - poner datos de entrada y salida al metodo externo
         Mockito.when(serviceMockito.multi(1,1)).thenReturn(1);
         Mockito.when(serviceMockito.multi(1,2)).thenReturn(2);
         Mockito.when(serviceMockito.multi(2,3)).thenReturn(6);
         Mockito.when(serviceMockito.multi(6,4)).thenReturn(24);

         //PASO 4 para MOCK - utilizar el constrcutor parametrizado y enviar el objeto mockeado
         CalculadoraMock calculadora = new CalculadoraMock(serviceMockito);
         int actualResult=calculadora.factorial(4);
         int expectedResult=24;
         Assert.assertEquals("ERROR en factorial!",expectedResult,actualResult);

         // Verificacion que realmente estamos utilizando el mock del metodo
         Mockito.verify(serviceMockito).multi(1,1);
         Mockito.verify(serviceMockito).multi(1,2);
         Mockito.verify(serviceMockito).multi(2,3);
         Mockito.verify(serviceMockito).multi(6,4);
     }
}
