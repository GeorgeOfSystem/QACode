package ejercicio2;

import java.util.HashMap;
import java.util.Map;

public class NextDay {

    private Map<String,Integer> monthDays= new HashMap<String,Integer>();
    private Map<String,String> nextMonth= new HashMap<String,String>();
    private String errorMessage="";

    public NextDay(){
        monthDays.put("Enero",31);
        monthDays.put("Febrero",28);
        monthDays.put("Marzo",31);
        monthDays.put("Abril",30);
        monthDays.put("Mayo",31);
        monthDays.put("Junio",30);
        monthDays.put("Julio",31);
        monthDays.put("Agosto",31);
        monthDays.put("Septiembre",30);
        monthDays.put("Octubre",31);
        monthDays.put("Noviembre",30);
        monthDays.put("Diciembre",31);

        nextMonth.put("Enero","Febrero");
        nextMonth.put("Febrero","Marzo");
        nextMonth.put("Marzo","Abril");
        nextMonth.put("Abril","Mayo");
        nextMonth.put("Mayo","Junio");
        nextMonth.put("Junio","Julio");
        nextMonth.put("Julio","Agosto");
        nextMonth.put("Agosto","Septiembre");
        nextMonth.put("Septiembre","Octubre");
        nextMonth.put("Octubre","Noviembre");
        nextMonth.put("Noviembre","Diciembre");
        nextMonth.put("Diciembre","Enero");


    }


    public String calculateNextTime(int day, String month, int year, int hour, int minute, int second) {

            if (second<0 || second>59)
                errorMessage=errorMessage+"Invalid Second "+second;
            if (minute<0 || minute>59)
                errorMessage=errorMessage+"Invalid Minute "+minute;
            if (hour<0 || hour>23)
                errorMessage=errorMessage+"Invalid Hour "+hour;
            if (year<0)
              errorMessage=errorMessage+"Invalid Year "+year;

            if (year%4==0)
                monthDays.put("Febrero",29);

            if (!monthDays.containsKey(month)) {
                errorMessage = errorMessage + "Invalid Month " + month;
            }else if(day<0 || day>monthDays.get(month))
                errorMessage=errorMessage+"Invalid Day "+day;

            second=second+1;

            if(second==60 && errorMessage.isEmpty()){
                second=00;
                minute++;
                if(minute==60){
                    minute=00;
                    hour++;
                    if (hour==24){
                        hour=00;
                        day++;
                        if(day>monthDays.get(month)){
                            day=1;
                            month=nextMonth.get(month);
                            if(month.equals("Enero")){
                                year++;
                            }
                        }
                    }
                }
            }

            String hourS=hour<10?"0"+hour:hour+"";
            String minuteS=minute<10?"0"+minute:minute+"";
            String secondS=second<10?"0"+second:second+"";
            return  errorMessage.isEmpty()?day+" "+month+" "+year+" "+hourS+":"+minuteS+":"+secondS :errorMessage;

    }
}
