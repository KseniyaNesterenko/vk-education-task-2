import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class VKExampleTest {

    @Test
    void testTrue() {
        assertTrue(true);
    }

    @Test
    void testStringContainsVK() {
        String message = "VK";
        assertTrue(message.contains("VK"), "Строка должна содержать 'VK'");
    }
}
