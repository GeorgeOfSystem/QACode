package ejercicio4Test;

import ejercicio4.BDUtil;
import ejercicio4.Cajero;
import ejercicio4.ClientDB;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@RunWith(value= Parameterized.class)
public class CajeroTest {

    private int ci;
    private int amount;
    private int totalCash;
    private boolean expectedMockClient;
    private boolean expectedMockDB;
    private String expectedResult;

    public CajeroTest(int ci, int amount, int totalCash, String expectedResult, boolean expectedMockClient, boolean expectedMockDB){
        this.ci=ci;
        this.amount = amount;
        this.totalCash = totalCash;
        this.expectedResult = expectedResult;
        this.expectedMockClient = expectedMockClient;
        this.expectedMockDB =expectedMockDB;
    }

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
        objects.add(new Object[]{908013,7,470,"Usted esta sacando la cantidad de 7 y tiene en saldo 463",true,true});
        objects.add(new Object[]{908013,3,350,  "Actualizacion Incorrecta, Intente Nuevamente",true,false});
        objects.add(new Object[]{908013,54,350, "Conexion a BD no fue satisfactoria",false,false});
        objects.add(new Object[]{908013,66,350, "Conexion a BD no fue satisfactoria",false,false});
        return objects;
    }

    //PASO 2
    BDUtil bdUtilMocked= Mockito.mock(BDUtil.class);
    ClientDB clientDBMocked = Mockito.mock(ClientDB.class);

    @Test
    public void verify_calculate_credit(){
        // Paso 3
        Mockito.when(clientDBMocked.isConnectionSuccessfully("mysql")).thenReturn(this.expectedMockClient);
        Mockito.when(bdUtilMocked.updateSaldo(this.ci,this.totalCash-this.amount)).thenReturn(this.expectedMockDB);
        // Paso 4
        Cajero cajero = new Cajero(totalCash,bdUtilMocked,clientDBMocked);
        String actualResult= cajero.getCash(this.ci,this.amount);
        Assert.assertEquals("ERROR! ",this.expectedResult,actualResult);
    }

}