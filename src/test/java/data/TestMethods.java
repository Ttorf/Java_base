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

    @Step("Добавление предмета из {box.nameContainer}")
    public void getItemFromBox(Box box, Item item, Stack stack) throws ItemStoreException, ItemAlreadyPlacedException {
        box.addItemToContainer(item);
        box.addItemToContainer(stack);
        box.getItem();
    }

    @Step("Добавление {box2.nameContainer} в {box.nameContainer} ")
    public void addBoxToBox(Box box, Box box2) throws ItemStoreException, ItemAlreadyPlacedException {
        box.addItemToContainer(box2);

    }

    @Step("Добавление {stack.nameStackItem} в {box.nameContainer} ")
    public void addStackToBox(Box box, Stack stack) throws ItemStoreException, ItemAlreadyPlacedException {
        box.addItemToContainer(stack);
    }

    @Step("Добавление предметов {materialBuild.nameItem} и {materialBuild2.nameItem} в {bagItem.nameContainer}, удаление предмета по имени")
    public void getItemFromBagByName(Bag bagItem, Item materialBuild, Item materialBuild2) throws ItemStoreException, ItemAlreadyPlacedException {
        String nameItem = materialBuild.getNameItem();
        bagItem.addItemToContainer(materialBuild);
        bagItem.addItemToContainer(materialBuild2);
        bagItem.getItemByName(nameItem);


    }

    @Step("Добавление предметов {materialBuild3.nameItem} и {materialBuild.nameItem} в {bagItem.nameContainer}")
    public void checkWeightBag(Bag bagItem, Item materialBuild, Item materialBuild3) throws ItemStoreException, ItemAlreadyPlacedException {
        bagItem.addItemToContainer(materialBuild);
        bagItem.addItemToContainer(materialBuild3);


    }

    @Step("Добавление предмета {materialBuild2.nameItem} в {box.nameContainer} ")
    public void addItemToBox(Box box, Item materialBuild2) throws ItemStoreException, ItemAlreadyPlacedException {
        box.addItemToContainer(materialBuild2);
    }

    @Step("Удаление случайного предмета из {bagItem2.nameContainer},вытащить случайный предмет")
    public void takeRandomItem(Bag bagItem1, Bag bagItem2, Item materialBuild) throws ItemStoreException, ItemAlreadyPlacedException {
        bagItem1.addItemToContainer(bagItem2);
        bagItem1.addItemToContainer(materialBuild);
        bagItem1.getRandomItem();
    }

    @Step("Добавление предметов {box.nameContainer} и {materialBuild.nameItem} в {stack1.nameStackItem},вытащить предметы по очереди")
    public void takeItemFromStack(Stack stack1, Box box, Item materialBuild) throws ItemStoreException, ItemAlreadyPlacedException {
        stack1.addBoxToStack(box);
        stack1.addItemToContainer(materialBuild);
        stack1.getItem();
        stack1.getItem();
    }

    @Step("Добавление {box.nameContainer} в {stack1.nameStackItem}")
    public void checkPutBoxToStack(Stack stack1, Box box) throws ItemStoreException, ItemAlreadyPlacedException {
        stack1.addBoxToStack(box);


    }

    @Step("Добавление предметов: {materialBuild3.nameItem}, {materialBuild2.nameItem} и {materialBuild6.nameItem}  в {stack1.nameStackItem}")
    public void checkPutItemToStack(Stack stack1, Item materialBuild2, Item materialBuild3, Item materialBuild6) throws ItemStoreException, ItemAlreadyPlacedException {
        stack1.addItemToContainer(materialBuild2);
        stack1.addItemToContainer(materialBuild3);
        stack1.addItemToContainer(materialBuild6);
    }

    @Step("Добавление предметов {materialBuild.nameItem} и {materialBuild2.nameItem} в контейнер{bagItem.nameContainer}, добавление предмета {materialBuild4.nameItem} в контейнер {bagItem2.nameContainer}, добавление предмета {materialBuild5.nameItem} и конейнеров {bagItem.nameContainer} и {bagItem3.nameContainer} в контейнер {bagItem2.nameContainer}")
    public void checkUnpackAndPutBag(Item materialBuild, Item materialBuild4, Item materialBuild5, Item materialBuild2, Bag bagItem, Bag bagItem2, Bag bagItem3) throws ItemStoreException, ItemAlreadyPlacedException {
        bagItem.addItemToContainer(materialBuild);
        bagItem.getItem(materialBuild2);
        bagItem3.addItemToContainer(materialBuild4);
        bagItem2.addItemToContainer(materialBuild5);
        bagItem2.addItemToContainer(bagItem);
        bagItem2.addItemToContainer(bagItem3);


    }

    @Step("Добавление предметов: {materialBuild.nameItem}, {materialBuild2.nameItem} и {materialBuild3.nameItem}  в {stack1.nameStackItem}")
    public void checkingTheNumberOfItems(Stack stack1, Item materialBuild, Item materialBuild2, Item materialBuild3) throws ItemStoreException, ItemAlreadyPlacedException {
        stack1.addItemToContainer(materialBuild2);
        stack1.addItemToContainer(materialBuild);
        stack1.addItemToContainer(materialBuild3);

    }

    @Step("Добавление предмета {materialBuild.nameItem} и {materialBuild2.nameItem} и {bagItem.nameContainer} ")
    public void checkWeightItemTest(Item materialBuild, Item materialBuild2, Bag bagItem) throws ItemStoreException, ItemAlreadyPlacedException {
        bagItem.addItemToContainer(materialBuild);
        bagItem.addItemToContainer(materialBuild2);

    }

    @Step("Добавление предмета {materialBuild.nameItem} в {bagItem.nameContainer} и {bagItem2.nameContainer} ")
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
