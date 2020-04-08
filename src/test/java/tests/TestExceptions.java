package tests;

import data.TestMethods;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import data.DataTest;
import org.junit.experimental.categories.Category;
import task.laba1.exceptions.ItemAlreadyPlacedException;
import task.laba1.exceptions.ItemStoreException;

@Epic(value = "Тесты Exceptions")
public class TestExceptions {

    DataTest dataTest = new DataTest();
    TestMethods testMethods = new TestMethods();

    @Before()
    public void addProperties() {
        dataTest.addProperties();
    }


    @Test(expected = ItemAlreadyPlacedException.class)
    @Feature(value = "ItemAlreadyPlacedException")
    @DisplayName(value = "Проверка добавления одного и того-же предмета в два разных контейнера")
    @Description(value = "Ошибка ItemAlreadyPlacedException при добавлении одного и того же предмета в контейнер")
    public void alreadyPlacedItemToBagTest() throws ItemAlreadyPlacedException, ItemStoreException {

        testMethods.addToTwoBagItems(dataTest.materialBuild, dataTest.bagItem, dataTest.bagItem2);

    }

    @Test(expected = ItemStoreException.class)
    @Feature(value = "ItemStoreException")
    @DisplayName(value = "Проверка добавления предметов, вес которых превышает допустимый вес контейнера")
    @Description(value = "Ошибка ItemStoreException при добавлении двух предметов, вес которых превышает допустимый вес контейнера")
    public void itemStoreExceptionBagTest() throws ItemStoreException, ItemAlreadyPlacedException {

        testMethods.checkWeightItemTest(dataTest.materialBuild, dataTest.materialBuild2, dataTest.bagItem);

    }

    @Test(expected = ItemStoreException.class)
    @Feature(value = "ItemStoreException")
    @DisplayName(value = "Проверка добавления большего количества предметов в контейнер Стак, чем он может уместить")
    @Description(value = "Ошибка ItemStoreException при добавлении предметов в контейнер Стак, если количество предметов превышает максимальное допустимое количество предметов в данном контейнере ")
    public void ItemStoreExceptionStackTest() throws ItemStoreException, ItemAlreadyPlacedException {

        testMethods.checkingTheNumberOfItems(dataTest.stack1, dataTest.materialBuild3, dataTest.materialBuild2, dataTest.materialBuild6);
    }


    @Test(expected = ItemStoreException.class)
    @Feature(value = "ItemStoreException")
    @DisplayName(value = "Проверка добавления не плоского предметов в контейнер Стак")
    @Description(value = "Ошибка ItemStoreException при добавлении не плоского предмета в Стак")
    public void checkPutItemToStackTest() throws ItemStoreException, ItemAlreadyPlacedException {

        testMethods.checkPutItemToStack(dataTest.stack3, dataTest.materialBuild2, dataTest.materialBuild3, dataTest.materialBuild6);

    }
}
