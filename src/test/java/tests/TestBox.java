package tests;

import data.TestMethods;
import org.junit.Before;
import org.junit.Test;
import data.DataTest;
import task.laba1.exceptions.ItemAlreadyPlacedException;
import task.laba1.exceptions.ItemStoreException;

public class TestBox {
    DataTest dataTest = new DataTest();
    TestMethods testMethods = new TestMethods();

    @Before()
    public void addProperties() {
        dataTest.addProperties();
    }

    @Test()
    public void addBoxToBoxTest() throws ItemStoreException, ItemAlreadyPlacedException {
        testMethods.addBoxToBox(dataTest.box, dataTest.box2);
    }

    @Test()
    public void addStackToBoxTest() throws ItemStoreException, ItemAlreadyPlacedException {
        testMethods.addStackToBox(dataTest.box, dataTest.stack1);
    }

    @Test()
    public void getItemFromBoxTest() throws ItemStoreException, ItemAlreadyPlacedException {
        testMethods.getItemFromBox(dataTest.box, dataTest.materialBuild, dataTest.stack2);


    }

    @Test()
    public void addItemToBoxTest() throws ItemStoreException, ItemAlreadyPlacedException {
        testMethods.addItemToBox(dataTest.box, dataTest.materialBuild2);
    }


}
