package ejercicio4Test;


import ejercicio4.BDUtil2;
import ejercicio4.Cajero;
import ejercicio4.Cajero2;
import ejercicio4.ClientDB2;
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

//Paso 1 para metodos estaticos
@RunWith(PowerMockRunner.class)
//Paso 2 para metodos estaticos
@PowerMockRunnerDelegate(Parameterized.class)

@PrepareForTest({ClientDB2.class, BDUtil2.class})

public class CajeroTest2 {

    @Parameterized.Parameter(0)
    public int ci;
    @Parameterized.Parameter(1)
    public int amount;
    @Parameterized.Parameter(2)
    public int totalCash;
    @Parameterized.Parameter(3)
    public String expectedResult;
    @Parameterized.Parameter(4)
    public boolean expectedMockClient;
    @Parameterized.Parameter(5)
    public boolean expectedMockDB;


    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]> objects= new ArrayList<>();
        //CASES
        objects.add(new Object[]{01032,-1,100, "Amount No Valido" ,true, true});
        objects.add(new Object[]{01032,0,500,"Amount No Valido",true, true});
        objects.add(new Object[]{01032,9,19,"Usted esta sacando la cantidad de 9 y tiene en saldo 10",true, true});
        objects.add(new Object[]{01032,10,10, "Usted esta sacando la cantidad de 10 y tiene en saldo 0",true,true});
        objects.add(new Object[]{01032,100,100, "Actualizacion Incorrecta, Intente Nuevamente",true,false});
        objects.add(new Object[]{01032,100,100, "Conexion a BD no fue satisfactoria",false,true});
        objects.add(new Object[]{01032,110,50,"Usted no tiene suficiente saldo" ,true,true});
        objects.add(new Object[]{01032,110,50,"Usted no tiene suficiente saldo" ,true,false});
        objects.add(new Object[]{01032,110,50,"Conexion a BD no fue satisfactoria" ,false,true});
        objects.add(new Object[]{01032,110,50,"Conexion a BD no fue satisfactoria",false,false});
        objects.add(new Object[]{908013,500,900,"Usted esta sacando la cantidad de 500 y tiene en saldo 400",true,true});
        objects.add(new Object[]{908013,8,58,"Usted esta sacando la cantidad de 8 y tiene en saldo 50",true,true});
        objects.add(new Object[]{908013,7,470,"Usted esta sacando la cantidad de 70 y tiene en saldo 400",true,true});
        objects.add(new Object[]{908013,3,350,  "Actualizacion Incorrecta, Intente Nuevamente",true,false});
        objects.add(new Object[]{908013,54,350, "Conexion a BD no fue satisfactoria",false,false});
        objects.add(new Object[]{908013,66,350, "Conexion a BD no fue satisfactoria",false,false});
        return objects;
    }

    @Test
    public void verify_calculate_amount(){
        //STEP 3
        PowerMockito.mockStatic(ClientDB2.class);
        PowerMockito.mockStatic(BDUtil2.class);
        //STEP 4
        Mockito.when(ClientDB2.isConnectionSuccessfully("mysql")).thenReturn(this.expectedMockClient);
        Mockito.when(BDUtil2.updateSaldo(this.ci,this.totalCash-this.amount)).thenReturn(this.expectedMockDB);
        Cajero2 cajero2 = new Cajero2(this.totalCash);
        String actualResult= cajero2.getCash(this.ci,this.amount);
        Assert.assertEquals("ERROR! ",this.expectedResult,actualResult);
    }

}