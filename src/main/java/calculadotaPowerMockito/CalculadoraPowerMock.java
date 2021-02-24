package calculadotaPowerMockito;

public class CalculadoraPowerMock {

     public CalculadoraPowerMock(){
      }

     public int factorial(int n){
         int fact=1;

         for (int i = 1; i <= n  ; i++) {
             fact=HelperCalculadoraService.multi(fact,i);
         }
          return fact;
     }

}
