package ejercicio1;

public class CalcularNota {


    public String notaFinal(int firstNota, int secondNota, int thirdNota) {
        String message;

        if (firstNota<0 || firstNota>100 || secondNota<0 || secondNota>100 || thirdNota<0 || thirdNota>100)
            return "*** INGRESE DATOS CORRECTOS ***";

        int result= (firstNota+secondNota+thirdNota)/3;

        if (result >=90 && result <=100){
            message="Excelente su nota es : "+result;
        }else if(result >=80 && result <90){
            message="Muy Bien su nota es : "+result;
        }else if (result >=71 && result <80){
            message="Bien su nota es : "+result;
        }else{
            message="Esfuerzate mas, su nota es : "+result;
        }
        return message;
    }
}
