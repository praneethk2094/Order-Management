import java.io.File;

public class TestOrders {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void myTest() {
        // this folder gets cleaned up automatically by JUnit
        File file = folder.newFile("someTestFile.txt");

        // populate the file
        // run your test
    }
}
