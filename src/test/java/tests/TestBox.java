package tests;

import data.TestMethods;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import data.DataTest;
import task.laba1.exceptions.ItemAlreadyPlacedException;
import task.laba1.exceptions.ItemStoreException;

@Epic(value = "Тесты контейнера: Коробка")
public class TestBox {
    DataTest dataTest = new DataTest();
    TestMethods testMethods = new TestMethods();

    @Before()
    public void addProperties() {
        dataTest.addProperties();
    }

    @Test()
    @Feature(value = "Добавление предметов в ящик")
    @DisplayName(value = "Проверка добавления контейнера ящик в контейнер ящик ")
    @Description(value = "Тест проверяет корректность добавления контейнера ящик в контейнер ящик")
    public void addBoxToBoxTest() throws ItemStoreException, ItemAlreadyPlacedException {
        testMethods.addBoxToBox(dataTest.box, dataTest.box2);
        testMethods.checkValue(1, dataTest.box.getCurretNumberOfItems(), "ожидаемое количество предметов", "текущее количество предметов");
        testMethods.checkStringValue(dataTest.box.getNameContainer(), dataTest.box2.getNameInContainer(), "Наименование контейнера", "Наименование родительского контейнера");
    }

    @Test()
    @Feature(value = "Добавление предметов в ящик")
    @DisplayName(value = "Проверка добавления контейнера стак в контейнер ящик ")
    @Description(value = "Тест проверяет корректность добавления контейнера стак в контейнер ящик")
    public void addStackToBoxTest() throws ItemStoreException, ItemAlreadyPlacedException {
        testMethods.addStackToBox(dataTest.box, dataTest.stack1);
        testMethods.checkValue(dataTest.stack1.getCurretNumberOfItems(), dataTest.box.getCurretNumberOfItems(), "ожидаемое количество предметов", "текущее количество предметов");
    }

    @Test()
    @Feature(value = "Удаление контейнера стак из контейнера ящик")
    @DisplayName(value = "Проверка удаления контейнера стак из контейнера ящик ")
    @Description(value = "Тест проверяет корректность добавления контейнера стак в контейнер ящик")
    public void getItemFromBoxTest() throws ItemStoreException, ItemAlreadyPlacedException {
        testMethods.getItemFromBox(dataTest.box, dataTest.materialBuild, dataTest.stack2);
        testMethods.checkValue(dataTest.box.getCurretWeight(), dataTest.stack2.getCurretWeight(), "ожидаемого веса", "текущего веса");

    }

    @Test()
    @Feature(value = "Добавление предметов в ящик")
    @DisplayName(value = "Проверка добавления предмета в контейнер ящик ")
    @Description(value = "Тест проверяет корректность добавления предмета в контейнер ящик")
    public void addItemToBoxTest() throws ItemStoreException, ItemAlreadyPlacedException {
        testMethods.addItemToBox(dataTest.box, dataTest.materialBuild2);
        testMethods.checkValue(1, dataTest.box.getCurretNumberOfItems(), "ожидаемое количество предметов", "текущее количество предметов");
    }


}
