package badPractices;

public class Calculadora {

    public Calculadora(){

    }

    public int sumar(int a, int b){
        return  a+b;
    }

    /**
     *  NO ES CORRECTO !!  no se debe probar de esta manera
     */
    public static void main(String[]argssss){
        Calculadora calculadora = new Calculadora();

        int actualResult= calculadora.sumar(5,6);
        int expectedResult=10;

        if (actualResult== expectedResult){
            System.out.println("Funciona");
        }else{
            System.out.println("NO Funciona");
        }
    }
}
