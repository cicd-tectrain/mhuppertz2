package at.tectrain.demo.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CalculatorServiceTest {
    CalculatorService service = new CalculatorService();
    @Test
    void testAdd(){
        int result = service.add(1,2);
        assertEquals(3,result);
    }
}
