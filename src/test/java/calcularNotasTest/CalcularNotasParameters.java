package calcularNotasTest;

import ejercicio1.CalcularNota;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(value= Parameterized.class)
public class CalcularNotasParameters {

    private int firstNota;
    private int secondNota;
    private int thirdNota;
    private String expectedResult;

    public CalcularNotasParameters(int firstNota, int secondNota, int thirdNota, String expectedResult){
        this.firstNota =firstNota;
        this.secondNota=secondNota;
        this.thirdNota=thirdNota;
        this.expectedResult=expectedResult;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]>objects= new ArrayList<>();
        objects.add(new Object[]{0,0,0,"Esfuerzate mas, su nota es : 0"});
        objects.add(new Object[]{100,100,100,"Excelente su nota es : 100"});
        objects.add(new Object[]{101,80,80,"*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{99,80,80,"Muy Bien su nota es : 86"});
        objects.add(new Object[]{1,80,80,"Esfuerzate mas, su nota es : 53"});
        objects.add(new Object[]{-1,80,80,"*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{49,80,80,"Esfuerzate mas, su nota es : 69"});
        objects.add(new Object[]{50,80,80,"Esfuerzate mas, su nota es : 70"});
        objects.add(new Object[]{51,80,80,"Esfuerzate mas, su nota es : 70"});

        objects.add(new Object[]{80,0  ,80,"Esfuerzate mas, su nota es : 53"});
        objects.add(new Object[]{80,100,80,"Muy Bien su nota es : 86"});
        objects.add(new Object[]{80,101,80,"*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{80,99 ,80,"Muy Bien su nota es : 86"});
        objects.add(new Object[]{80,1  ,80,"Esfuerzate mas, su nota es : 53"});
        objects.add(new Object[]{80,-1 ,80,"*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{80,49 ,80,"Esfuerzate mas, su nota es : 69"});
        objects.add(new Object[]{80,50 ,80,"Esfuerzate mas, su nota es : 70"});
        objects.add(new Object[]{80,51 ,80,"Esfuerzate mas, su nota es : 70"});

        objects.add(new Object[]{80,80,0  ,"Esfuerzate mas, su nota es : 53"});
        objects.add(new Object[]{80,80,100,"Muy Bien su nota es : 86"});
        objects.add(new Object[]{80,80,101,"*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{80,80,99 ,"Muy Bien su nota es : 86"});
        objects.add(new Object[]{80,80,1  ,"Esfuerzate mas, su nota es : 53"});
        objects.add(new Object[]{80,80,-1 ,"*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{80,80,49 ,"Esfuerzate mas, su nota es : 69"});
        objects.add(new Object[]{80,80,50 ,"Esfuerzate mas, su nota es : 70"});
        objects.add(new Object[]{80,80,51 ,"Esfuerzate mas, su nota es : 70"});


        objects.add(new Object[]{30,30,30 ,"Esfuerzate mas, su nota es : 30"});
        objects.add(new Object[]{90,90,90 ,"Excelente su nota es : 90"});
        objects.add(new Object[]{95,95,95 ,"Excelente su nota es : 95"});
        objects.add(new Object[]{80,80,80 ,"Muy Bien su nota es : 80"});
        objects.add(new Object[]{88,88,88 ,"Muy Bien su nota es : 88"});
        objects.add(new Object[]{89,89,89 ,"Muy Bien su nota es : 89"});
        objects.add(new Object[]{71,71,71 ,"Bien su nota es : 71"});
        objects.add(new Object[]{75,75,75 ,"Bien su nota es : 75"});
        objects.add(new Object[]{79,79,79 ,"Bien su nota es : 79"});

        return objects;
    }


    @Test
    public void verify_suma_all_values(){

        CalcularNota calculaNota = new CalcularNota();
        String actualResult= calculaNota.notaFinal(this.firstNota,this.secondNota,this.thirdNota);
        Assert.assertEquals("ERROR! ",this.expectedResult,actualResult);

    }

}
