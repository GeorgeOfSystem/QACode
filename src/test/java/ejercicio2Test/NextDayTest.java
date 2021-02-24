package ejercicio2Test;

import ejercicio2.NextDay;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(value= Parameterized.class)
public class NextDayTest {

    private int day;
    private String month;
    private int year;
    private int hour;
    private int minute;
    private int second;
    private String expectedResult;

    public NextDayTest(int day, String month,int year,int hour,int minute,int second, String expectedResult){
        this.day=day;
        this.month=month;
        this.year=year;
        this.hour=hour;
        this.minute=minute;
        this.second=second;
        this.expectedResult=expectedResult;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]> objects= new ArrayList<>();
        objects.add(new Object[]{1,"Enero",2020,23,59,59,"2 Enero 2020 00:00:00"});
        objects.add(new Object[]{1,"Febrero",2020,23,59,59,"2 Febrero 2020 00:00:00"});
        objects.add(new Object[]{1,"Marzo",2020,23,59,59,"2 Marzo 2020 00:00:00"});
        objects.add(new Object[]{1,"Abril",2020,23,59,59,"2 Abril 2020 00:00:00"});
        objects.add(new Object[]{1,"Mayo",2020,23,59,59,"2 Mayo 2020 00:00:00"});
        objects.add(new Object[]{1,"Junio",2020,23,59,59,"2 Junio 2020 00:00:00"});
        objects.add(new Object[]{1,"Julio",2020,23,59,59,"2 Julio 2020 00:00:00"});
        objects.add(new Object[]{1,"Agosto",2020,23,59,59,"2 Agosto 2020 00:00:00"});
        objects.add(new Object[]{1,"Septiembre",2020,23,59,59,"2 Septiembre 2020 00:00:00"});
        objects.add(new Object[]{1,"Octubre",2020,23,59,59,"2 Octubre 2020 00:00:00"});
        objects.add(new Object[]{1,"Noviembre",2020,23,59,59,"2 Noviembre 2020 00:00:00"});
        objects.add(new Object[]{1,"Diciembre",2020,23,59,59,"2 Diciembre 2020 00:00:00"});

        objects.add(new Object[]{31,"Enero",2020,23,59,59,"1 Febrero 2020 00:00:00"});
        objects.add(new Object[]{28,"Febrero",2021,23,59,59,"1 Marzo 2021 00:00:00"});
        objects.add(new Object[]{29,"Febrero",2020,23,59,59,"1 Marzo 2020 00:00:00"});
        objects.add(new Object[]{28,"Febrero",2020,23,59,59,"29 Febrero 2020 00:00:00"});
        objects.add(new Object[]{31,"Marzo",2020,23,59,59,"1 Abril 2020 00:00:00"});
        objects.add(new Object[]{30,"Abril",2020,23,59,59,"1 Mayo 2020 00:00:00"});
        objects.add(new Object[]{31,"Mayo",2020,23,59,59,"1 Junio 2020 00:00:00"});
        objects.add(new Object[]{30,"Junio",2020,23,59,59,"1 Julio 2020 00:00:00"});
        objects.add(new Object[]{31,"Julio",2020,23,59,59,"1 Agosto 2020 00:00:00"});
        objects.add(new Object[]{31,"Agosto",2020,23,59,59,"1 Septiembre 2020 00:00:00"});
        objects.add(new Object[]{30,"Septiembre",2020,23,59,59,"1 Octubre 2020 00:00:00"});
        objects.add(new Object[]{31,"Octubre",2020,23,59,59,"1 Noviembre 2020 00:00:00"});
        objects.add(new Object[]{30,"Noviembre",2020,23,59,59,"1 Diciembre 2020 00:00:00"});
        objects.add(new Object[]{31,"Diciembre",2020,23,59,59,"1 Enero 2021 00:00:00"});

        objects.add(new Object[]{20,"Febrero",-1,23,59,59,"Invalid Year -1"});
        objects.add(new Object[]{31,"Febrero",2020,23,59,59,"Invalid Day 31"});
        objects.add(new Object[]{31,"Diciembres",2020,23,59,59,"Invalid Month Diciembres"});

        objects.add(new Object[]{31,"Diciembre",2020,-1,59,59,"Invalid Hour -1"});
        objects.add(new Object[]{31,"Diciembre",2020,00,59,59,"31 Diciembre 2020 01:00:00"});
        objects.add(new Object[]{31,"Diciembre",2020,01,59,59,"31 Diciembre 2020 02:00:00"});
        objects.add(new Object[]{31,"Diciembre",2020,11,59,59,"31 Diciembre 2020 12:00:00"});
        objects.add(new Object[]{31,"Diciembre",2020,12,59,59,"31 Diciembre 2020 13:00:00"});
        objects.add(new Object[]{31,"Diciembre",2020,13,59,59,"31 Diciembre 2020 14:00:00"});
        objects.add(new Object[]{31,"Diciembre",2020,22,59,59,"31 Diciembre 2020 23:00:00"});
        objects.add(new Object[]{31,"Diciembre",2020,23,59,59,"1 Enero 2021 00:00:00"});
        objects.add(new Object[]{31,"Diciembre",2020,24,59,59,"Invalid Hour 24"});

        objects.add(new Object[]{31,"Diciembre",2020,01,-1,59,"Invalid Minute -1"});
        objects.add(new Object[]{31,"Diciembre",2020,01,00,59,"31 Diciembre 2020 01:01:00"});
        objects.add(new Object[]{31,"Diciembre",2020,01,1,59,"31 Diciembre 2020 01:02:00"});
        objects.add(new Object[]{31,"Diciembre",2020,01,29,59,"31 Diciembre 2020 01:30:00"});
        objects.add(new Object[]{31,"Diciembre",2020,01,30,59,"31 Diciembre 2020 01:31:00"});
        objects.add(new Object[]{31,"Diciembre",2020,01,31,59,"31 Diciembre 2020 01:32:00"});
        objects.add(new Object[]{31,"Diciembre",2020,01,58,59,"31 Diciembre 2020 01:59:00"});
        objects.add(new Object[]{31,"Diciembre",2020,01,59,59,"31 Diciembre 2020 02:00:00"});
        objects.add(new Object[]{31,"Diciembre",2020,01,60,59,"Invalid Minute 60"});

        objects.add(new Object[]{31,"Diciembre",2020,01,01,-1,"Invalid Second -1"});
        objects.add(new Object[]{31,"Diciembre",2020,01,01,00,"31 Diciembre 2020 01:01:01"});
        objects.add(new Object[]{31,"Diciembre",2020,01,01,1,"31 Diciembre 2020 01:01:02"});
        objects.add(new Object[]{31,"Diciembre",2020,01,01,29,"31 Diciembre 2020 01:01:30"});
        objects.add(new Object[]{31,"Diciembre",2020,01,01,30,"31 Diciembre 2020 01:01:31"});
        objects.add(new Object[]{31,"Diciembre",2020,01,01,31,"31 Diciembre 2020 01:01:32"});
        objects.add(new Object[]{31,"Diciembre",2020,01,01,58,"31 Diciembre 2020 01:01:59"});
        objects.add(new Object[]{31,"Diciembre",2020,01,01,59,"31 Diciembre 2020 01:02:00"});
        objects.add(new Object[]{31,"Diciembre",2020,01,01,60,"Invalid Second 60"});

        return objects;
    }


    @Test
    public void verify_suma_all_values(){

        NextDay nextDay = new NextDay();
        String actualResult= nextDay.calculateNextTime(this.day,this.month,this.year,this.hour,this.minute,this.second);
        Assert.assertEquals("ERROR! ",this.expectedResult,actualResult);
    }

}
