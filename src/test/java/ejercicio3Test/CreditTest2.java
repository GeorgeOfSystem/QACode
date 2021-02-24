package ejercicio3Test;

import calculadotaPowerMockito.HelperCalculadoraService;
import ejercicio3.Asfi;
import ejercicio3.AsfiUtil;
import ejercicio3.Credito;
import ejercicio3.Credito2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import java.util.ArrayList;
import java.util.List;


@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(Parameterized.class)
@PrepareForTest(AsfiUtil.class)
public class CreditTest2 {

    @Parameterized.Parameter(0)
    public int ci;
    @Parameterized.Parameter(1)
    public int credit;
    @Parameterized.Parameter(2)
    public String expectedResult;
    @Parameterized.Parameter(3)
    public boolean expectedMock;

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

    @Test
    public void verify_calculate_credit(){
        // PASO 3
        PowerMockito.mockStatic(AsfiUtil.class);
        // PASO 4
        Mockito.when(AsfiUtil.isUserEnable(this.ci)).thenReturn(this.expectedMock);
        Credito2 credito= new Credito2();
        String actualResult= credito.calculateCredito(this.ci,this.credit);
        Assert.assertEquals("ERROR! ",this.expectedResult,actualResult);
    }

}
