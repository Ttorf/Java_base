import data.TestMethods;
import org.junit.Before;
import org.junit.Test;
import data.DataTest;
import task1.exceptions.ItemAlreadyPlacedException;
import task1.exceptions.ItemStoreException;

public class TestExceptions {

    DataTest dataTest = new DataTest();
    TestMethods testMethods = new TestMethods();

    @Before()
    public void addProperties() {
        dataTest.addProperties();
    }

    @Test(expected = ItemAlreadyPlacedException.class)
    public void alreadyPlacedItemToBagTest() throws ItemAlreadyPlacedException, ItemStoreException {

        testMethods.addToTwoBagItems(dataTest.materialBuild, dataTest.bagItem, dataTest.bagItem2);

    }

    @Test(expected = ItemStoreException.class)
    public void itemStoreExceptionBagTest() throws ItemStoreException, ItemAlreadyPlacedException {

        testMethods.checkWeightItemTest(dataTest.materialBuild, dataTest.materialBuild2, dataTest.bagItem);

    }

    @Test(expected = ItemStoreException.class)
    public void ItemStoreExceptionStackTest() throws ItemStoreException, ItemAlreadyPlacedException {

        testMethods.checkingTheNumberOfItems(dataTest.stack1, dataTest.materialBuild3, dataTest.materialBuild2, dataTest.materialBuild6);

    }

    @Test(expected = ItemStoreException.class)
    public void checkPutItemToStackTest() throws ItemStoreException, ItemAlreadyPlacedException {

        testMethods.checkPutItemToStack(dataTest.stack1, dataTest.materialBuild2, dataTest.materialBuild3, dataTest.materialBuild6);

    }

}
