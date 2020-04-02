import data.TestMethods;
import org.junit.Before;
import data.DataTest;
import org.junit.Test;
import task1.exceptions.ItemAlreadyPlacedException;
import task1.exceptions.ItemStoreException;

public class TestBag {
    DataTest dataTest = new DataTest();
    TestMethods testMethods = new TestMethods();

    @Before()
    public void addProperties() {
        dataTest.addProperties();
    }

    @Test
    public void checkWeightBoxTest() throws ItemStoreException, ItemAlreadyPlacedException {
        testMethods.checkWeightBag(dataTest.bagItem, dataTest.materialBuild, dataTest.materialBuild3);

    }

    @Test
    public void CheckUnpackItemFromBagTest() throws ItemStoreException, ItemAlreadyPlacedException {

        testMethods.checkUnpackAndPutBag(dataTest.materialBuild, dataTest.materialBuild4, dataTest.materialBuild5, dataTest.materialBuild2, dataTest.bagItem, dataTest.bagItem2, dataTest.bagItem3);

    }

    @Test()
    public void getItemFromBagByNameTest() throws ItemStoreException, ItemAlreadyPlacedException {
        testMethods.getItemFromBagByName(dataTest.bagItem, dataTest.materialBuild, dataTest.materialBuild4);
    }

    @Test()
    public void takeRandomItemTest() throws ItemStoreException, ItemAlreadyPlacedException {
        testMethods.takeRandomItem(dataTest.bagItem, dataTest.bagItem2, dataTest.materialBuild2);
    }

}
