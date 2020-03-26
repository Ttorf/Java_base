import org.junit.Test;
import org.junit.Assert;
import task1.exeptions.ItemAlreadyPlacedException;
import task1.exeptions.ItemStoreException;
import task1.itembase.BagItems;
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
    String nameStack = "стопка";
    int weightItem1 = 20;
    int weightItem2 = 90;
    int weightItem3 = 30;
    int weightItem4 = 10;
    int curretWeight1 = 2;
    int curretWeight2 = 2;
    int totalWeight = 100;
    int curretNumberOfItems = 19;
    int maxNumberOfItems = 19;
    ArrayList<BagItems> batList3 = new ArrayList<>();
    ArrayList<BagItems> batList2 = new ArrayList<>();
    ArrayList<BagItems> batList1 = new ArrayList<>();
    Set<String> testPropertiesSetItem1 = new HashSet<>();
    Set<String> testPropertiesSetItem2 = new HashSet<>();
    Set<String> testPropertiesSetItem3 = new HashSet<>();
    ArrayList<ItemImplementation> itemImplementationArrayList = new ArrayList<>();
    ArrayList<ItemImplementation> itemImplementationArrayList2 = new ArrayList<>();
    ArrayList<ItemImplementation> itemImplementationArrayList3 = new ArrayList<>();
    ItemImplementation materialBuild = new ItemImplementation(nameItem1, testPropertiesSetItem1, weightItem1);
    ItemImplementation materialBuild2 = new ItemImplementation(nameItem2, testPropertiesSetItem2, weightItem2);
    ItemImplementation materialBuild3 = new ItemImplementation(nameItem3, testPropertiesSetItem2, weightItem3);
    ItemImplementation materialBuild4 = new ItemImplementation(nameItem4, testPropertiesSetItem3, weightItem4);
    ItemImplementation materialBuild5 = new ItemImplementation(nameItem5, testPropertiesSetItem3, weightItem4);
    BagItems bagItem = new BagItems(itemImplementationArrayList, batList1, nameBox1, curretWeight1, totalWeight);
    BagItems bagItem2 = new BagItems(itemImplementationArrayList2, batList2, nameBox2, curretWeight2, totalWeight);
    BagItems bagItem3 = new BagItems(itemImplementationArrayList3, batList3, nameBox3, curretWeight2, totalWeight);
    Deque<ItemImplementation> itemImplementationDeque = new ArrayDeque<>();
    StackItems stackItems1 = new StackItems(itemImplementationDeque, nameStack, curretNumberOfItems, maxNumberOfItems);

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

        checkingTheNumberOfItems(stackItems1, materialBuild3, materialBuild2);

    }

    @Test
    public void CheckWeightTest() throws ItemStoreException, ItemAlreadyPlacedException {
        int expectedWeight = 52;
        int unExpectedWeight = 21;
        bagItem.openBag();
        bagItem.addItemToContainer(materialBuild);
        bagItem.addItemToContainer(materialBuild3);

        Assert.assertNotEquals(unExpectedWeight, bagItem.getCurretWeight());
        checkWeight(expectedWeight, bagItem.getCurretWeight());

    }

    @Test
    public void CheckUnpackItemFromBagTest() throws ItemStoreException, ItemAlreadyPlacedException {

        checkUnpackAndPutBag(materialBuild, materialBuild4, materialBuild5, materialBuild2, bagItem, bagItem2, bagItem3);

    }
    @Test(expected = ItemStoreException.class)
    public void checkPutItemToStackTest() throws ItemStoreException, ItemAlreadyPlacedException {

        checkPutItemToStack(stackItems1,materialBuild2,materialBuild3);

    }

public void checkPutItemToStack(StackItems stackItems1,ItemImplementation materialBuild2, ItemImplementation materialBuild3)throws ItemStoreException, ItemAlreadyPlacedException
{
    addProperties(testPropertiesSetItem1, testPropertiesSetItem2);

    stackItems1.addItemToContainer(materialBuild2);
    stackItems1.addItemToContainer(materialBuild3);

    }

    public void checkUnpackAndPutBag(ItemImplementation materialBuild, ItemImplementation materialBuild4, ItemImplementation materialBuild5, ItemImplementation materialBuild2, BagItems bagItem, BagItems bagItem2, BagItems bagItem3) throws ItemStoreException, ItemAlreadyPlacedException {
        boolean expectedTrue = true;
        addProperties(testPropertiesSetItem1, testPropertiesSetItem2);

        bagItem.openBag();
        bagItem.addItemToContainer(materialBuild);
        bagItem.getItem(materialBuild2);
        bagItem3.openBag();
        bagItem3.addItemToContainer(materialBuild4);
        bagItem2.openBag();
        bagItem2.addItemToContainer(materialBuild5);
        bagItem2.addContainerToContainer(bagItem);
        bagItem2.addContainerToContainer(bagItem3);

        Assert.assertEquals(expectedTrue, bagItem.isOwner());

    }

    public void checkingTheNumberOfItems(StackItems stackItems1, ItemImplementation materialBuild, ItemImplementation materialBuild2) throws ItemStoreException, ItemAlreadyPlacedException {

        addProperties(testPropertiesSetItem1, testPropertiesSetItem2);

        stackItems1.addItemToContainer(materialBuild2);
        stackItems1.addItemToContainer(materialBuild);

    }

    public void checkWeightItemTest(ItemImplementation materialBuild, ItemImplementation materialBuild2, BagItems bagItem) throws ItemStoreException, ItemAlreadyPlacedException {

        addProperties(testPropertiesSetItem1, testPropertiesSetItem2);

        bagItem.openBag();
        bagItem.addItemToContainer(materialBuild);
        bagItem.addItemToContainer(materialBuild2);
        bagItem.closeBag();

    }


    public void addToTwoBagItems(ItemImplementation materialBuild, BagItems bagItem, BagItems bagItem2) throws ItemStoreException, ItemAlreadyPlacedException {

        addProperties(testPropertiesSetItem1, testPropertiesSetItem2);

        bagItem.openBag();
        bagItem2.openBag();
        bagItem.addItemToContainer(materialBuild);
        bagItem2.addItemToContainer(materialBuild);
        bagItem.closeBag();
    }

    public void checkWeight(int expected, int current) {

        Assert.assertEquals(current, expected);

    }

    public void addProperties(Set<String> testPropertiesSetItem1, Set<String> testPropertiesSetItem2) {
        testPropertiesSetItem1.add(ListProperties.HEAVY.getPropertoies());
        testPropertiesSetItem2.add(ListProperties.FLAT.getPropertoies());
    }
}

