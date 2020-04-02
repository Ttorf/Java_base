import data.TestMethods;
import org.junit.Before;
import org.junit.Test;
import data.DataTest;
import task1.exceptions.ItemAlreadyPlacedException;
import task1.exceptions.ItemStoreException;

public class TestStack {

    DataTest dataTest = new DataTest();
    TestMethods testMethods = new TestMethods();

    @Before()
    public void addProperties() {
        dataTest.addProperties();
    }

    @Test()
    public void checkPutBoxToStackTest() throws ItemStoreException, ItemAlreadyPlacedException {

        testMethods.checkPutBoxToStack(dataTest.stack1, dataTest.box);

    }

    @Test()
    public void takeItemFromStackTest() throws ItemStoreException, ItemAlreadyPlacedException {

        testMethods.takeItemFromStack(dataTest.stack1, dataTest.box, dataTest.materialBuild2);

    }

}
