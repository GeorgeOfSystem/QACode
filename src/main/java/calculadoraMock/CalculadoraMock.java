package calculadoraMock;

public class CalculadoraMock {

     BasicCalculadoraService service = new BasicCalculadoraService();

     public CalculadoraMock(){

     }

     // PASO 1 para el MOCK - Constrcutor parametrizado
     public CalculadoraMock(BasicCalculadoraService mockService){
         this.service=mockService;
     }


     public int factorial(int n){
         int fact=1;

         for (int i = 1; i <= n  ; i++) {
             fact=this.service.multi(fact,i);
         }
          return fact;
     }

}
