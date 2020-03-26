package task1.itembase;


import java.util.ArrayList;

import java.util.List;


import task1.exeptions.ItemAlreadyPlacedException;
import task1.exeptions.ItemStoreException;
import task1.general.Container;

public class BagItems extends ArrayList<Container> implements Container {
    private final int totalWeight;
    private final String nameContainer;
    private final String type = "bag";
    private String nameInContainer;
    private boolean owner = false;
    private int curretWeight;
    private final boolean flat = false;
    private boolean unlock = false;
    private ArrayList<ItemImplementation> listItems;
    private ArrayList<BagItems> listContainers;

    public BagItems(ArrayList<ItemImplementation> listItems, ArrayList<BagItems> listContainers, String nameContainer, int curretWeight, int totalWeight) {
        this.listItems = listItems;
        this.curretWeight = curretWeight;
        this.nameContainer = nameContainer;
        this.totalWeight = totalWeight;
        this.listContainers = listContainers;
    }

    private ItemImplementation RandomItem() {
        List<ItemImplementation> mainList = new ArrayList<>();
        mainList.addAll(listItems);
        int startNumber = 0;
        int random_number = startNumber + (int) (Math.random() * listItems.size());
        if (random_number > startNumber) {

            return mainList.get(random_number);
        } else {
            return mainList.get(startNumber);
        }
    }


    private void setCurretWeight(int curretWeight) {
        this.curretWeight = curretWeight;
    }

    private void setOwner(boolean owner) {
        this.owner = owner;
    }

    private boolean isUnlock() {
        return unlock;
    }

    private String getNameContainer() {
        return nameContainer;
    }

    private void setNameInContainer(String nameInContainer) {
        this.nameInContainer = nameInContainer;
    }

    public String getNameInContainer() {
        return nameInContainer;
    }

    public String getType() {
        return type;
    }

    public boolean isOwner() {
        return owner;
    }

    @Override
    public void addItemToContainer(ItemImplementation item) throws ItemAlreadyPlacedException, ItemStoreException {

        int futureWeight = curretWeight + item.getWeightItem();
        if (futureWeight <= totalWeight && !item.isOwner() && isUnlock()) {
            listItems.add(item);
            item.setOwner(true);
            item.setNameContainer(getNameContainer());
            System.out.println("Предмет" + "'" + item.getNameItem() + "'" + " добавлен в " + getNameContainer());
            this.curretWeight = curretWeight + item.getWeightItem();

        } else if (this.curretWeight > this.totalWeight || futureWeight > totalWeight) {
            throw new ItemStoreException("Failed to save object");
        } else if (!isUnlock()) {
            System.err.println("Контейнер закрыт!Чтобы добавить предмет, сначала откройте контейнер!");

        } else if (item.isOwner()) {
            throw new ItemAlreadyPlacedException("Item is already in another container ");
        }


    }


    public void getItem(ItemImplementation item) {

        if (listItems.size() > 0 && listItems.contains(item) && isUnlock()) {
            this.curretWeight = curretWeight - item.getWeightItem();
            listItems.remove(item);
            item.setOwner(false);
            item.setNameContainer("Null");
            System.out.println("Вытащили объект:" + item.getNameItem());
        } else if (!listItems.contains(item)) {
            System.err.println("Данного объекта нет в контейнере");
        } else if (!isUnlock()) {
            System.err.println("Контейнер закрыт! Чтобы добавить предмет, сначала откройте контейнер!");
        }
    }

    public void getRandomItem() {

        if (!listItems.isEmpty() && isUnlock()) {
            ItemImplementation randomItem = RandomItem();
            this.curretWeight = curretWeight - randomItem.getWeightItem();
            randomItem.setOwner(false);
            randomItem.setNameContainer("Null");
            listItems.remove(randomItem);

            System.out.println("Вытащили объект:" + randomItem.getNameItem());

        } else if (listItems.isEmpty()) {
            System.err.println("Контейнер пуст");
        } else if (!isUnlock()) {
            System.err.println("Контейнер закрыт!Чтобы добавить предмет, сначала откройте контейнер!");
        }
    }

    public void addContainerToContainer(BagItems whichPutIninBagItem) throws ItemAlreadyPlacedException, ItemStoreException {


        int futureWeight = whichPutIninBagItem.getCurretWeight() + getCurretWeight();
        if (isUnlock() && !whichPutIninBagItem.isOwner() && futureWeight <= getTotalWeight()) {
            int curretWeightTemp;
            curretWeightTemp = getCurretWeight() + whichPutIninBagItem.getCurretWeight();
            setCurretWeight(curretWeightTemp);
            listContainers.add(whichPutIninBagItem);

            whichPutIninBagItem.setOwner(true);
            whichPutIninBagItem.setNameInContainer(getNameContainer());

        } else if (this.curretWeight > this.totalWeight || futureWeight > totalWeight) {
            throw new ItemStoreException("Failed to save object");
        } else if (!isUnlock()) {
            System.err.println("Контейнер закрыт!Чтобы добавить предмет, сначала откройте контейнер!");

        } else if (isOwner()) {
            throw new ItemAlreadyPlacedException("Item is already in another container ");
        }

    }

    public int getTotalWeight() {
        return this.totalWeight;
    }

    public int getCurretWeight() {
        return this.curretWeight;
    }

    public boolean openBag() {
        return this.unlock = true;
    }

    public boolean closeBag() {
        return this.unlock = false;
    }


    @Override
    public void getInfoContainer() {
        this.listItems.forEach(System.out::println);
        this.listContainers.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "BagItems{" +
                "totalWeight=" + totalWeight +
                ", nameContainer='" + nameContainer + '\'' +
                ", nameInContainer='" + nameInContainer + '\'' +
                ", owner=" + owner +
                ", curretWeight=" + curretWeight +
                ", unlock=" + unlock +
                ", listItems=" + listItems +
                ", listContainers=" + listContainers +
                '}';
    }
}




