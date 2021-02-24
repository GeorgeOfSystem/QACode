package ejercicio3;

public class Credito2 {

    private String message;

    public Credito2(){}

    public String calculateCredito(int ci, int credit) {
        if (credit<1){
            message="Credito Incorrecto";
        } else if (AsfiUtil.isUserEnable(ci)){

            if (credit<=10000){
                message="el interes es del 15%";
            } else if( credit>10000 && credit<=20000){
                message="el interes es de 13%";
            } else if (credit > 20000 && credit <=30000){
                message="el interes es de 10%";
            } else{
                message="el interes es de 5%";
            }

        } else{
            message="Usuario no esta habilitado para prestamos";
        }
       return message;
    }
}
