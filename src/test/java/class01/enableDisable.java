package class01;

import org.testng.annotations.Test;

public class enableDisable {

    @Test(enabled = false)
    public void Atest(){
        System.out.println("I am first test case");
    }

    @Test
    public void Btest(){
        System.out.println("I am second test case");
    }
}
