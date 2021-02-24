package calculadoraParameters;

import calculadora.Calculadora;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(value= Parameterized.class)
public class TestSumaParameter {

    private int firstNumber;
    private int secondNumber;
    private int expectedResult;

    public TestSumaParameter(int firstNumber,int secondNumber,int expectedResult){
        this.firstNumber=firstNumber;
        this.secondNumber=secondNumber;
        this.expectedResult=expectedResult;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]>objects= new ArrayList<>();
        objects.add(new Object[]{1,1,2});
        objects.add(new Object[]{-1,-1,-2});
        objects.add(new Object[]{100,400,500});
        objects.add(new Object[]{2,2,4});
        objects.add(new Object[]{3,5,8});
        objects.add(new Object[]{3,0,3});
        objects.add(new Object[]{0,0,0});
        objects.add(new Object[]{10,3,13});
        objects.add(new Object[]{3,3,6});
        objects.add(new Object[]{-5,-4,-9});
        objects.add(new Object[]{-5,4,-1});
        return objects;
    }


    @Test
    public void verify_suma_all_values(){
        Calculadora calculadora= new Calculadora();
        int actualResult=  calculadora.sumar(this.firstNumber,this.secondNumber);
        Assert.assertEquals("ERROR ! la suma es incorrecta",this.expectedResult,actualResult);
    }



}
