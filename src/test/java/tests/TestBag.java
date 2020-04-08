package tests;

import data.TestMethods;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import data.DataTest;
import org.junit.Test;
import task.laba1.exceptions.ItemAlreadyPlacedException;
import task.laba1.exceptions.ItemStoreException;


@Epic(value = "Тесты контейнера: Рюкзак")
public class TestBag {
    DataTest dataTest = new DataTest();
    TestMethods testMethods = new TestMethods();

    @Before()
    public void addProperties() {
        dataTest.addProperties();
    }


    @Test()
    @Feature(value = "Добавление преметов в рюкзак")
    @DisplayName(value = "Проверка Веса Рюкзака")
    @Description(value = "Тест проверяет корректность веса рюкзака при добавлении в него продметов  ")
    public void checkWeightBagTest() throws ItemStoreException, ItemAlreadyPlacedException {
        int sumWeight = dataTest.materialBuild.getWeightItem() + dataTest.materialBuild3.getWeightItem();
        testMethods.checkWeightBag(dataTest.bagItem, dataTest.materialBuild, dataTest.materialBuild3);
        testMethods.checkValue(dataTest.bagItem.getCurretWeight(), sumWeight, "ожидаемого веса", "текущего веса");
    }

    @Test
    @Feature(value = "Добавление преметов в рюкзак")
    @DisplayName(value = "Добавление предметов и контейнеров в рюкзак")
    @Description(value = "Тест проверяет корректность удаления предмета из рюкзака")
    public void CheckUnpackItemFromBagTest() throws ItemStoreException, ItemAlreadyPlacedException {
        testMethods.checkUnpackAndPutBag(dataTest.materialBuild, dataTest.materialBuild4, dataTest.materialBuild5, dataTest.materialBuild2, dataTest.bagItem, dataTest.bagItem2, dataTest.bagItem3);
        int sumWeight = dataTest.materialBuild4.getWeightItem() + dataTest.bagItem.getCurretWeight() + dataTest.bagItem3.getCurretWeight();
        testMethods.checkValue(dataTest.bagItem2.getCurretWeight(), sumWeight, "ожидаемого веса", "текущего веса");
    }

    @Test()
    @Feature(value = "Удаление преметов из рюкзака")
    @DisplayName(value = "Проверка удаления предмета из рюкзака по наименованию ")
    @Description(value = "Тест проверяет корректность удаления одого предмета по наименованию из рюкзака ")
    public void getItemFromBagByNameTest() throws ItemStoreException, ItemAlreadyPlacedException {
        testMethods.getItemFromBagByName(dataTest.bagItem, dataTest.materialBuild, dataTest.materialBuild4);
        testMethods.checkValue(1, dataTest.bagItem.getListFromContainer().size(), "ожидаемого веса", "текущего веса");
    }

    @Test()
    @Feature(value = "Удаление преметов из рюкзака")
    @DisplayName(value = "Проверка удаления случайного предмета из рюкзака")
    @Description(value = "Тест проверяет корректность удаления случайного предмета из рюкзака")
    public void takeRandomItemTest() throws ItemStoreException, ItemAlreadyPlacedException {
        testMethods.takeRandomItem(dataTest.bagItem, dataTest.bagItem2, dataTest.materialBuild2);
        testMethods.checkValue(1, dataTest.bagItem.getListFromContainer().size(), "ожидаемого веса", "текущего веса");
    }

}
