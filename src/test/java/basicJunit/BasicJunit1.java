package basicJunit;

import org.junit.*;

public class BasicJunit1 {

    @BeforeClass
    public static void beforeClass(){
        System.out.println(" *****BEFORE CLASS");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println(" ****** AFTER CLASS");
    }

    @Before
    public void before(){
        System.out.println(" ----> BEFORE METHOD");
    }
    @After
    public void after(){
        System.out.println(" ----> AFTER METHOD");
    }

    @Test
    public void verify_some_thing(){
         System.out.println("LOGICA DE MI TEST");
    }

    @Test
    public void verify_some_thing2(){
        System.out.println("LOGICA DE MI TEST 2 ");
    }

    @Test
    @Ignore
    public void verify_some_thing3(){
        System.out.println("LOGICA DE MI TEST 3");
    }

    @Test(timeout = 2000)
    public void verify_some_thing4(){
        System.out.println("LOGICA DE MI TEST 4 - VELOCIDAD METODO");
    }

    @Ignore
    @Test (expected = ArithmeticException.class)
    public void verify_some_thing5(){
        System.out.println("LOGICA DE MI TEST 5");
    }

}
