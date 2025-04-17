import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;

@SuiteDisplayName("Test Suite для OK")
@SelectPackages({"test.java"})
@IncludeTags("login")
public class TestSuite {
}
