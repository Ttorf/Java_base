import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import task1.exeptions.ItemAlreadyPlacedException;
import task1.exeptions.ItemStoreException;
import task1.general.Items;
import task1.itembase.BagItems;
import task1.itembase.BoxItems;
import task1.itembase.ItemImplementation;

import task1.itembase.StackItems;
import task1.lists.ListProperties;

import java.util.*;


public class TestJavaBase {

    String nameBox1 = "пакет";
    String nameBox2 = "мешок";
    String nameBox3 = "корзина";
    String nameItem1 = "кирпич";
    String nameItem2 = "доска";
    String nameItem3 = "блок";
    String nameItem4 = "верёвка";
    String nameItem5 = "лопата";
    String nameItem6 = "кирка";
    String nameStack = "стопка";
    int weightItem1 = 20;
    int weightItem2 = 90;
    int weightItem3 = 30;
    int weightItem4 = 10;
    int curretWeight1 = 2;
    int curretWeight2 = 2;
    int curretWeight3 = 0;
    int totalWeight = 100;
    int curretNumberOfItems = 18;
    int curretNumberOfItems2 = 1;
    int maxNumberOfItems = 20;
    ArrayList<Items> batList3 = new ArrayList<>();
    ArrayList<Items> batList2 = new ArrayList<>();
    ArrayList<Items> batList1 = new ArrayList<>();
    ArrayList<Items> listItems = new ArrayList<>();
    Deque<Items> itemImplementationDeque = new ArrayDeque<>();
    Set<String> testPropertiesSetItem1 = new HashSet<>();
    Set<String> testPropertiesSetItem2 = new HashSet<>();
    Set<String> testPropertiesSetItem3 = new HashSet<>();
    ItemImplementation materialBuild = new ItemImplementation(nameItem1, testPropertiesSetItem1, weightItem1);
    ItemImplementation materialBuild2 = new ItemImplementation(nameItem2, testPropertiesSetItem2, weightItem2);
    ItemImplementation materialBuild6 = new ItemImplementation(nameItem6, testPropertiesSetItem2, weightItem4);
    ItemImplementation materialBuild3 = new ItemImplementation(nameItem3, testPropertiesSetItem2, weightItem3);
    ItemImplementation materialBuild4 = new ItemImplementation(nameItem4, testPropertiesSetItem3, weightItem4);
    ItemImplementation materialBuild5 = new ItemImplementation(nameItem5, testPropertiesSetItem3, weightItem4);
    BagItems bagItem = new BagItems(batList1, nameBox1, curretWeight1, totalWeight);
    BagItems bagItem2 = new BagItems(batList2, nameBox2, curretWeight2, totalWeight);
    BagItems bagItem3 = new BagItems(batList3, nameBox3, curretWeight2, totalWeight);
    StackItems stackItems1 = new StackItems(itemImplementationDeque, nameStack, curretNumberOfItems, maxNumberOfItems);
    StackItems stackItems2 = new StackItems(itemImplementationDeque, nameStack, curretNumberOfItems2, maxNumberOfItems);
    BoxItems boxItems = new BoxItems(listItems, maxNumberOfItems, totalWeight, "Коробка картонная", curretWeight3);
    BoxItems boxItems2 = new BoxItems(batList1, maxNumberOfItems, totalWeight, "Коробка пластиковая", curretWeight3);

    @Before()
    public void addProperties() {
        testPropertiesSetItem1.add(ListProperties.COLLORWHITE.getPropertoies());
        testPropertiesSetItem2.add(ListProperties.HEAVY.getPropertoies());
        testPropertiesSetItem2.add(ListProperties.FLAT.getPropertoies());
        testPropertiesSetItem3.add(ListProperties.COLLORBLACK.getPropertoies());
    }

    @Test(expected = ItemAlreadyPlacedException.class)
    public void alreadyPlacedItemToBagTest() throws ItemAlreadyPlacedException, ItemStoreException {

        addToTwoBagItems(materialBuild, bagItem, bagItem2);

    }

    @Test(expected = ItemStoreException.class)
    public void itemStoreExceptionBagTest() throws ItemStoreException, ItemAlreadyPlacedException {

        checkWeightItemTest(materialBuild, materialBuild2, bagItem);

    }

    @Test(expected = ItemStoreException.class)
    public void ItemStoreExceptionStackTest() throws ItemStoreException, ItemAlreadyPlacedException {

        checkingTheNumberOfItems(stackItems1, materialBuild3, materialBuild2, materialBuild6);

    }

    @Test
    public void checkWeightBoxTest() throws ItemStoreException, ItemAlreadyPlacedException {
        checkWeightBox(bagItem, materialBuild, materialBuild3);

    }

    @Test
    public void CheckUnpackItemFromBagTest() throws ItemStoreException, ItemAlreadyPlacedException {

        checkUnpackAndPutBag(materialBuild, materialBuild4, materialBuild5, materialBuild2, bagItem, bagItem2, bagItem3);

    }

    @Test(expected = ItemStoreException.class)
    public void checkPutItemToStackTest() throws ItemStoreException, ItemAlreadyPlacedException {

        checkPutItemToStack(stackItems1, materialBuild2, materialBuild3, materialBuild6);

    }

    @Test()
    public void checkPutBoxToStackTest() throws ItemStoreException, ItemAlreadyPlacedException {

        checkPutBoxToStack(stackItems1, boxItems);

    }

    @Test()
    public void takeItemFromStackTest() throws ItemStoreException, ItemAlreadyPlacedException {

        takeItemFromStack(stackItems1, boxItems, materialBuild2);

    }

    @Test()
    public void takeRandomItemTest() throws ItemStoreException, ItemAlreadyPlacedException {
        takeRandomItem(bagItem, bagItem2, materialBuild2);
    }

    @Test()
    public void addItemToBoxTest() throws ItemStoreException, ItemAlreadyPlacedException {
        addItemToBox(boxItems, materialBuild2);
    }

    @Test()
    public void getItemFromBagByNameTest() throws ItemStoreException, ItemAlreadyPlacedException {
        getItemFromBagByName(bagItem, materialBuild, materialBuild4);
    }

    @Test()
    public void addBoxToBoxTest() throws ItemStoreException, ItemAlreadyPlacedException {
        addBoxToBox(boxItems, boxItems2);
    }

    @Test()
    public void addStackToBoxTest() throws ItemStoreException, ItemAlreadyPlacedException {
        addStackToBox(boxItems, stackItems1);
    }

    @Test()
    public void getItemFromBoxTest() throws ItemStoreException, ItemAlreadyPlacedException {
        getItemFromBox(boxItems, materialBuild, stackItems2);


    }

    public void getItemFromBox(BoxItems boxItems, ItemImplementation item, StackItems stackItems) throws ItemStoreException, ItemAlreadyPlacedException {
        int expectedNumbersStart = 2;
        int expectedNumbersEnd = 0;
        boxItems.addItemToContainer(item);
        boxItems.addItemToContainer(stackItems);
        checkNumValues(expectedNumbersStart, boxItems.getCurretNumberOfItems());
        boxItems.getItem();
        boxItems.getItem();
        checkNumValues(expectedNumbersEnd, boxItems.getCurretNumberOfItems());
    }

    public void addBoxToBox(BoxItems boxItems, BoxItems boxItems2) throws ItemStoreException, ItemAlreadyPlacedException {
        boxItems.addItemToContainer(boxItems2);

        int expectedNum = 1;
        checkNumValues(expectedNum, boxItems.getCurretNumberOfItems());
        checkStringValues(boxItems.getNameContainer(), boxItems2.getNameInContainer());
    }

    public void addStackToBox(BoxItems boxItems, StackItems stackItems) throws ItemStoreException, ItemAlreadyPlacedException {
        boxItems.addItemToContainer(stackItems);

        int expectedNum = stackItems.getCurretNumberOfItems();
        checkNumValues(expectedNum, boxItems.getCurretNumberOfItems());
        checkStringValues(boxItems.getNameContainer(), stackItems.getNameInContainer());
    }


    public void getItemFromBagByName(BagItems bagItem, ItemImplementation materialBuild, ItemImplementation materialBuild2) throws ItemStoreException, ItemAlreadyPlacedException {
        String nameItem = materialBuild.getNameItem();
        bagItem.addItemToContainer(materialBuild);
        bagItem.addItemToContainer(materialBuild2);
        bagItem.getItemByName(nameItem);
    }

    public void checkWeightBox(BagItems bagItem, ItemImplementation materialBuild, ItemImplementation materialBuild3) throws ItemStoreException, ItemAlreadyPlacedException {

        int expectedWeight = 52;
        bagItem.addItemToContainer(materialBuild);
        bagItem.addItemToContainer(materialBuild3);

        checkNumValues(expectedWeight, bagItem.getCurretWeight());
    }

    public void addItemToBox(BoxItems boxItems, ItemImplementation materialBuild2) throws ItemStoreException, ItemAlreadyPlacedException {

        int expected = 1;
        boxItems.addItemToContainer(materialBuild2);
        checkNumValues(expected, boxItems.getCurretNumberOfItems());

    }

    public void takeRandomItem(BagItems bagItem1, BagItems bagItem2, ItemImplementation materialBuild) throws ItemStoreException, ItemAlreadyPlacedException {
        bagItem1.addItemToContainer(bagItem2);
        bagItem1.addItemToContainer(materialBuild);
        bagItem1.getRandomItem();
        bagItem1.getRandomItem();
    }

    public void takeItemFromStack(StackItems stackItems1, BoxItems boxItems, ItemImplementation materialBuild) throws ItemStoreException, ItemAlreadyPlacedException {


        stackItems1.addBoxToStack(boxItems);
        stackItems1.addItemToContainer(materialBuild);
        stackItems1.getItem();
        stackItems1.getItem();

    }

    public void checkPutBoxToStack(StackItems stackItems1, BoxItems boxItems) throws ItemStoreException, ItemAlreadyPlacedException {


        stackItems1.addBoxToStack(boxItems);

    }

    public void checkPutItemToStack(StackItems stackItems1, ItemImplementation materialBuild2, ItemImplementation materialBuild3, ItemImplementation materialBuild6) throws ItemStoreException, ItemAlreadyPlacedException {


        stackItems1.addItemToContainer(materialBuild2);
        stackItems1.addItemToContainer(materialBuild3);
        stackItems1.addItemToContainer(materialBuild6);
    }

    public void checkUnpackAndPutBag(ItemImplementation materialBuild, ItemImplementation materialBuild4, ItemImplementation materialBuild5, ItemImplementation materialBuild2, BagItems bagItem, BagItems bagItem2, BagItems bagItem3) throws ItemStoreException, ItemAlreadyPlacedException {
        boolean expectedTrue = true;


        bagItem.addItemToContainer(materialBuild);
        bagItem.getItem(materialBuild2);
        bagItem3.addItemToContainer(materialBuild4);
        bagItem2.addItemToContainer(materialBuild5);
        bagItem2.addItemToContainer(bagItem);
        bagItem2.addItemToContainer(bagItem3);
        Assert.assertEquals(expectedTrue, bagItem.isOwner());

    }

    public void checkingTheNumberOfItems(StackItems stackItems1, ItemImplementation materialBuild, ItemImplementation materialBuild2, ItemImplementation materialBuild3) throws ItemStoreException, ItemAlreadyPlacedException {


        stackItems1.addItemToContainer(materialBuild2);
        stackItems1.addItemToContainer(materialBuild);
        stackItems1.addItemToContainer(materialBuild3);

    }

    public void checkWeightItemTest(ItemImplementation materialBuild, ItemImplementation materialBuild2, BagItems bagItem) throws ItemStoreException, ItemAlreadyPlacedException {


        bagItem.addItemToContainer(materialBuild);
        bagItem.addItemToContainer(materialBuild2);

    }


    public void addToTwoBagItems(ItemImplementation materialBuild, BagItems bagItem, BagItems bagItem2) throws ItemStoreException, ItemAlreadyPlacedException {


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

