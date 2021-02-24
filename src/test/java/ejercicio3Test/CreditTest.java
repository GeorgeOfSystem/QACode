package ejercicio3Test;

import calculadoraMock.BasicCalculadoraService;
import ejercicio2.NextDay;
import ejercicio3.Asfi;
import ejercicio3.Credito;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@RunWith(value= Parameterized.class)
public class CreditTest {

    private int ci;
    private int credit;
    private boolean expectedMock;
    private String expectedResult;

    public CreditTest(int ci, int credit , String expectedResult, boolean expectedMock){
        this.ci=ci;
        this.credit = credit;
        this.expectedResult=expectedResult;
        this.expectedMock=expectedMock;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]> objects= new ArrayList<>();
        objects.add(new Object[]{989898,0,"Credito Incorrecto",true});
        objects.add(new Object[]{989898,1    ,"el interes es del 15%",true});
        objects.add(new Object[]{989898,2    ,"el interes es del 15%",true});
        objects.add(new Object[]{989898,499  ,"el interes es del 15%",true});
        objects.add(new Object[]{989898,500  ,"el interes es del 15%",true});
        objects.add(new Object[]{989898,501  ,"el interes es del 15%",true});
        objects.add(new Object[]{989898,9999 ,"el interes es del 15%",true});
        objects.add(new Object[]{989898,10000,"el interes es del 15%",true});
        objects.add(new Object[]{989898,10001,"el interes es de 13%" ,true});
        objects.add(new Object[]{989898,10002,"el interes es de 13%" ,true});
        objects.add(new Object[]{989898,14999,"el interes es de 13%" ,true});
        objects.add(new Object[]{989898,15000,"el interes es de 13%" ,true});
        objects.add(new Object[]{989898,15001,"el interes es de 13%" ,true});
        objects.add(new Object[]{989898,19999,"el interes es de 13%" ,true});
        objects.add(new Object[]{989898,20000,"el interes es de 13%" ,true});
        objects.add(new Object[]{989898,20001,"el interes es de 10%" ,true});
        objects.add(new Object[]{989898,20002,"el interes es de 10%" ,true});
        objects.add(new Object[]{989898,24999,"el interes es de 10%" ,true});
        objects.add(new Object[]{989898,25000,"el interes es de 10%" ,true});
        objects.add(new Object[]{989898,25001,"el interes es de 10%" ,true});
        objects.add(new Object[]{989898,29999,"el interes es de 10%" ,true});
        objects.add(new Object[]{989898,30000,"el interes es de 10%" ,true});
        objects.add(new Object[]{989898,30001,"el interes es de 5%"  ,true});
        objects.add(new Object[]{100001,1,    "Usuario no esta habilitado para prestamos",false});
        objects.add(new Object[]{100001,10001,"Usuario no esta habilitado para prestamos",false});
        objects.add(new Object[]{100001,20001,"Usuario no esta habilitado para prestamos",false});
        objects.add(new Object[]{100001,30001,"Usuario no esta habilitado para prestamos",false});

        return objects;
    }

    //PASO 2
    Asfi asfiMocked= Mockito.mock(Asfi.class);
    @Test
    public void verify_calculate_credit(){
        // Paso 3
        Mockito.when(asfiMocked.isUserEnable(this.ci)).thenReturn(this.expectedMock);

        // Paso 4
        Credito credito= new Credito(asfiMocked);
        String actualResult= credito.calculateCredito(this.ci,this.credit);
        Assert.assertEquals("ERROR! ",this.expectedResult,actualResult);
    }

}
