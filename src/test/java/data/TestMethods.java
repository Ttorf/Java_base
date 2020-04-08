package data;

import io.qameta.allure.Step;
import org.junit.Assert;
import task.laba1.exceptions.ItemAlreadyPlacedException;
import task.laba1.exceptions.ItemStoreException;
import task.laba1.models.Bag;
import task.laba1.models.Box;
import task.laba1.models.Item;
import task.laba1.models.Stack;

public class TestMethods {
    @Step("Добавление и удаление контейнеров {box} и {stack} по очереди из {box}")
    public void getItemFromBox(Box box, Item item, Stack stack) throws ItemStoreException, ItemAlreadyPlacedException {
        box.addItemToContainer(item);
        box.addItemToContainer(stack);
        box.getItem();
    }

    @Step("Добавление {box2} в {box} ")
    public void addBoxToBox(Box box, Box box2) throws ItemStoreException, ItemAlreadyPlacedException {
        box.addItemToContainer(box2);

    }

    public void addStackToBox(Box box, Stack stack) throws ItemStoreException, ItemAlreadyPlacedException {
        box.addItemToContainer(stack);
    }

    @Step("Добавление предметов {materialBuild} и {materialBuild2} в {bagItem}, удаление предмета по имени")
    public void getItemFromBagByName(Bag bagItem, Item materialBuild, Item materialBuild2) throws ItemStoreException, ItemAlreadyPlacedException {
        String nameItem = materialBuild.getNameItem();
        bagItem.addItemToContainer(materialBuild);
        bagItem.addItemToContainer(materialBuild2);
        bagItem.getItemByName(nameItem);


    }

    @Step("Добавление предметов {materialBuild3} и {materialBuild} в {bagItem}")
    public void checkWeightBag(Bag bagItem, Item materialBuild, Item materialBuild3) throws ItemStoreException, ItemAlreadyPlacedException {
        bagItem.addItemToContainer(materialBuild);
        bagItem.addItemToContainer(materialBuild3);


    }

    @Step("Добавление предмета {materialBuild2} в {box} ")
    public void addItemToBox(Box box, Item materialBuild2) throws ItemStoreException, ItemAlreadyPlacedException {

        box.addItemToContainer(materialBuild2);


    }

    @Step("Добавление предметов {bagItem1} и {materialBuild} в {bagItem2},вытащить случайный предмет")
    public void takeRandomItem(Bag bagItem1, Bag bagItem2, Item materialBuild) throws ItemStoreException, ItemAlreadyPlacedException {
        bagItem1.addItemToContainer(bagItem2);
        bagItem1.addItemToContainer(materialBuild);
        bagItem1.getRandomItem();
    }

    @Step("Добавление предметов {box} и {materialBuild} в {stack1},вытащить предметы по очереди")
    public void takeItemFromStack(Stack stack1, Box box, Item materialBuild) throws ItemStoreException, ItemAlreadyPlacedException {
        stack1.addBoxToStack(box);
        stack1.addItemToContainer(materialBuild);
        stack1.getItem();
        stack1.getItem();

    }

    public void checkPutBoxToStack(Stack stack1, Box box) throws ItemStoreException, ItemAlreadyPlacedException {
        stack1.addBoxToStack(box);

    }

    @Step("Добавление предметов: {materialBuild3}, {materialBuild2} и {materialBuild6}  в {stack1}")
    public void checkPutItemToStack(Stack stack1, Item materialBuild2, Item materialBuild3, Item materialBuild6) throws ItemStoreException, ItemAlreadyPlacedException {
        stack1.addItemToContainer(materialBuild2);
        stack1.addItemToContainer(materialBuild3);
        stack1.addItemToContainer(materialBuild6);
    }

    @Step("Добавление предметов {materialBuild} и {materialBuild2} в контейнер{bagItem}, добавление предмета {materialBuild4} в контейнер {bagItem2}, добавление предмета {materialBuild5} и конейнеров {bagItem} и {bagItem3} в контейнер {bagItem2}")
    public void checkUnpackAndPutBag(Item materialBuild, Item materialBuild4, Item materialBuild5, Item materialBuild2, Bag bagItem, Bag bagItem2, Bag bagItem3) throws ItemStoreException, ItemAlreadyPlacedException {
        bagItem.addItemToContainer(materialBuild);
        bagItem.getItem(materialBuild2);
        bagItem3.addItemToContainer(materialBuild4);
        bagItem2.addItemToContainer(materialBuild5);
        bagItem2.addItemToContainer(bagItem);
        bagItem2.addItemToContainer(bagItem3);


    }

    @Step("Добавление предметов: {materialBuild}, {materialBuild2} и {materialBuild3}  в {stack1}")
    public void checkingTheNumberOfItems(Stack stack1, Item materialBuild, Item materialBuild2, Item materialBuild3) throws ItemStoreException, ItemAlreadyPlacedException {
        stack1.addItemToContainer(materialBuild2);
        stack1.addItemToContainer(materialBuild);
        stack1.addItemToContainer(materialBuild3);

    }

    @Step("Добавление предмета {materialBuild} и {materialBuild2} и {bagItem} ")
    public void checkWeightItemTest(Item materialBuild, Item materialBuild2, Bag bagItem) throws ItemStoreException, ItemAlreadyPlacedException {
        bagItem.addItemToContainer(materialBuild);
        bagItem.addItemToContainer(materialBuild2);

    }

    @Step("Добавление предмета {materialBuild} в {bagItem} и {bagItem2} ")
    public void addToTwoBagItems(Item materialBuild, Bag bagItem, Bag bagItem2) throws ItemStoreException, ItemAlreadyPlacedException {
        bagItem.addItemToContainer(materialBuild);
        bagItem2.addItemToContainer(materialBuild);
    }


    @Step("Проверка эквивалентности  {nameExpectedP} {expectedP} и {nameCurretP} {curretP} ")
    public void checkStringValue(String expectedP, String curretP, String nameExpectedP, String nameCurretP) {
        Assert.assertEquals(curretP, expectedP);

    }

    @Step("Проверка эквивалентности  {nameExpectedP} {expectedP} и {nameCurretP} {curretP} ")
    public void checkValue(int curretP, int expectedP, String nameExpectedP, String nameCurretP) {
        Assert.assertEquals(curretP, expectedP);
    }


}
