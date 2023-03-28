package class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNGannotations {

    @BeforeMethod
    public void beforeMethods(){
        System.out.println("I am before method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method");
    }

    @Test(groups = "regression")
    public void afirstTestCase(){
        System.out.println("I am the first test case");
    }

    @Test
    public void bsecondTestcase(){
        System.out.println("I am the second test case");
    }

    @Test
    public void cthirdTestcase(){
        System.out.println("I am the third test case");
    }
}
