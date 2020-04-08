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

@Epic(value = "Тесты контейнера: Стак")
public class TestStack {

    DataTest dataTest = new DataTest();
    TestMethods testMethods = new TestMethods();

    @Before()
    public void addProperties() {
        dataTest.addProperties();
    }

    @Test()
    @Feature(value = "Добавление ящика в стак")
    @DisplayName(value = "Проверка добавления контейнера Ящик в конейнер Стак")
    @Description(value = "Добавление предмета контейнер Ящик в контейнер Стак")
    public void checkPutBoxToStackTest() throws ItemStoreException, ItemAlreadyPlacedException {

        testMethods.checkPutBoxToStack(dataTest.stack1, dataTest.box);
        testMethods.checkValue(dataTest.stack1.getCurretNumberOfItems(), 19, "ожидаемое количество предметов", "текущее количество предметов");
    }

    @Test()
    @Feature(value = "Удаление  предмета из стака")
    @DisplayName(value = "Проверка удаления предмета из контейнера Стак")
    @Description(value = "Добавление ящика и предмета в стак и удаление добавленных предметов по очереди")
    public void takeItemFromStackTest() throws ItemStoreException, ItemAlreadyPlacedException {

        testMethods.takeItemFromStack(dataTest.stack1, dataTest.box, dataTest.materialBuild2);
        testMethods.checkValue(18, dataTest.stack1.getCurretNumberOfItems(), "ожидаемое количество предметов", "текущее количество предметов");
    }


}
