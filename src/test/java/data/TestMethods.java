package data;

import org.junit.Assert;
import task.laba1.exceptions.ItemAlreadyPlacedException;
import task.laba1.exceptions.ItemStoreException;
import task.laba1.models.Bag;
import task.laba1.models.Box;
import task.laba1.models.Item;
import task.laba1.models.Stack;

public class TestMethods {
    public void getItemFromBox(Box box, Item item, Stack stack) throws ItemStoreException, ItemAlreadyPlacedException {
        int expectedNumbersStart = 2;
        int expectedNumbersEnd = 0;
        box.addItemToContainer(item);
        box.addItemToContainer(stack);
        checkNumValues(expectedNumbersStart, box.getCurretNumberOfItems());
        box.getItem();
        box.getItem();
        checkNumValues(expectedNumbersEnd, box.getCurretNumberOfItems());
    }

    public void addBoxToBox(Box box, Box box2) throws ItemStoreException, ItemAlreadyPlacedException {
        box.addItemToContainer(box2);

        int expectedNum = 1;
        checkNumValues(expectedNum, box.getCurretNumberOfItems());
        checkStringValues(box.getNameContainer(), box2.getNameInContainer());
    }

    public void addStackToBox(Box box, Stack stack) throws ItemStoreException, ItemAlreadyPlacedException {
        box.addItemToContainer(stack);

        int expectedNum = stack.getCurretNumberOfItems();
        checkNumValues(expectedNum, box.getCurretNumberOfItems());
        checkStringValues(box.getNameContainer(), stack.getNameInContainer());
    }


    public void getItemFromBagByName(Bag bagItem, Item materialBuild, Item materialBuild2) throws ItemStoreException, ItemAlreadyPlacedException {
        String nameItem = materialBuild.getNameItem();
        bagItem.addItemToContainer(materialBuild);
        bagItem.addItemToContainer(materialBuild2);
        bagItem.getItemByName(nameItem);
    }

    public void checkWeightBag(Bag bagItem, Item materialBuild, Item materialBuild3) throws ItemStoreException, ItemAlreadyPlacedException {

        int expectedWeight = 50;
        bagItem.addItemToContainer(materialBuild);
        bagItem.addItemToContainer(materialBuild3);

        checkNumValues(expectedWeight, bagItem.getCurretWeight());
    }

    public void addItemToBox(Box box, Item materialBuild2) throws ItemStoreException, ItemAlreadyPlacedException {

        int expected = 1;
        box.addItemToContainer(materialBuild2);
        checkNumValues(expected, box.getCurretNumberOfItems());

    }

    public void takeRandomItem(Bag bagItem1, Bag bagItem2, Item materialBuild) throws ItemStoreException, ItemAlreadyPlacedException {
        bagItem1.addItemToContainer(bagItem2);
        bagItem1.addItemToContainer(materialBuild);
        bagItem1.getRandomItem();
        bagItem1.getRandomItem();
    }

    public void takeItemFromStack(Stack stack1, Box box, Item materialBuild) throws ItemStoreException, ItemAlreadyPlacedException {


        stack1.addBoxToStack(box);
        stack1.addItemToContainer(materialBuild);
        stack1.getItem();
        stack1.getItem();

    }

    public void checkPutBoxToStack(Stack stack1, Box box) throws ItemStoreException, ItemAlreadyPlacedException {


        stack1.addBoxToStack(box);

    }

    public void checkPutItemToStack(Stack stack1, Item materialBuild2, Item materialBuild3, Item materialBuild6) throws ItemStoreException, ItemAlreadyPlacedException {


        stack1.addItemToContainer(materialBuild2);
        stack1.addItemToContainer(materialBuild3);
        stack1.addItemToContainer(materialBuild6);
    }

    public void checkUnpackAndPutBag(Item materialBuild, Item materialBuild4, Item materialBuild5, Item materialBuild2, Bag bagItem, Bag bagItem2, Bag bagItem3) throws ItemStoreException, ItemAlreadyPlacedException {
        boolean expectedTrue = true;


        bagItem.addItemToContainer(materialBuild);
        bagItem.getItem(materialBuild2);
        bagItem3.addItemToContainer(materialBuild4);
        bagItem2.addItemToContainer(materialBuild5);
        bagItem2.addItemToContainer(bagItem);
        bagItem2.addItemToContainer(bagItem3);
        Assert.assertEquals(expectedTrue, bagItem.isOwner());

    }

    public void checkingTheNumberOfItems(Stack stack1, Item materialBuild, Item materialBuild2, Item materialBuild3) throws ItemStoreException, ItemAlreadyPlacedException {


        stack1.addItemToContainer(materialBuild2);
        stack1.addItemToContainer(materialBuild);
        stack1.addItemToContainer(materialBuild3);

    }

    public void checkWeightItemTest(Item materialBuild, Item materialBuild2, Bag bagItem) throws ItemStoreException, ItemAlreadyPlacedException {


        bagItem.addItemToContainer(materialBuild);
        bagItem.addItemToContainer(materialBuild2);

    }


    public void addToTwoBagItems(Item materialBuild, Bag bagItem, Bag bagItem2) throws ItemStoreException, ItemAlreadyPlacedException {


        bagItem.addItemToContainer(materialBuild);
        bagItem2.addItemToContainer(materialBuild);
    }

    public void checkNumValues(int expected, int current) {

        Assert.assertEquals(current, expected);

    }

    public void checkStringValues(String expected, String current) {

        Assert.assertEquals(current, expected);

    }

}
