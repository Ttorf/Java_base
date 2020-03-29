package task1.itembase;


import java.util.ArrayList;

import java.util.List;
import java.util.Objects;


import task1.exeptions.ItemAlreadyPlacedException;
import task1.exeptions.ItemStoreException;
import task1.general.Items;


public class BagItems extends Items {
    private final int totalWeight;
    private final String nameContainer;
    private String nameInContainer;
    private boolean owner = false;
    private int curretWeight;
    private List<Items> listItems;

    public BagItems(List<Items> listItems, String nameContainer, int curretWeight, int totalWeight) {
        super();
        this.listItems = listItems;
        this.curretWeight = curretWeight;
        this.nameContainer = nameContainer;
        this.totalWeight = totalWeight;
    }

    private Items randomItem() {
        List<Items> mainList = new ArrayList<>();
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

    void setOwnerContainer(boolean owner) {
        this.owner = owner;
    }


    public String getNameContainer() {
        return nameContainer;
    }

    private void setNameInContainer(String nameInContainer) {
        this.nameInContainer = nameInContainer;
    }

    public String getNameInContainer() {
        return nameInContainer;
    }

    public boolean isOwner() {
        return owner;
    }


    public void addItemToContainer(ItemImplementation item) throws ItemAlreadyPlacedException, ItemStoreException {

        int futureWeight = curretWeight + item.getWeightItem();
        if (futureWeight <= totalWeight && !item.isOwner()) {
            listItems.add(item);
            item.setOwner(true);
            item.setNameContainer(getNameContainer());
            System.out.println("Предмет" + "'" + item.getNameItem() + "'" + " добавлен в " + getNameContainer());
            this.curretWeight = curretWeight + item.getWeightItem();

        } else if (this.curretWeight > this.totalWeight || futureWeight > totalWeight) {
            throw new ItemStoreException("Failed to save object");

        } else if (item.isOwner()) {
            throw new ItemAlreadyPlacedException("Item is already in another container ");
        }


    }



    public void addItemToContainer(BagItems whichPutIninBagItem) throws ItemAlreadyPlacedException, ItemStoreException {


        int futureWeight = whichPutIninBagItem.getCurretWeight() + getCurretWeight();
        if (!whichPutIninBagItem.isOwner() && futureWeight <= getTotalWeight()) {
            int curretWeightTemp;
            curretWeightTemp = getCurretWeight() + whichPutIninBagItem.getCurretWeight();
            setCurretWeight(curretWeightTemp);
            listItems.add(whichPutIninBagItem);
            System.out.println("Контейнер" + "'" + whichPutIninBagItem.getNameContainer() + "'" + " добавлен в " + getNameContainer());
            whichPutIninBagItem.setOwnerContainer(true);
            whichPutIninBagItem.setNameInContainer(getNameContainer());

        } else if (this.curretWeight > this.totalWeight || futureWeight > totalWeight) {
            throw new ItemStoreException("Failed to save object");

        } else if (isOwner()) {
            throw new ItemAlreadyPlacedException("Item is already in another container ");
        }

    }

    public Items getItemByName(String itemName) {
        for (Items item : listItems) {
            if (item.getName().equals(itemName) && item.getClass().equals(ItemImplementation.class)) {
                ItemImplementation curretItem = (ItemImplementation) item;
                getItem(curretItem);
                return curretItem;
            } else if (item.getName().equals(itemName) && item.getClass().equals(BagItems.class)) {
                BagItems curretItem = (BagItems) item;
                getItem(curretItem);
                return curretItem;
            }
        }
        System.out.println(itemName + " не найден");
        return null;
    }


    public void getItem(ItemImplementation item) {

        if (listItems.size() > 0 && listItems.contains(item)) {
            this.curretWeight = curretWeight - item.getWeightItem();
            listItems.remove(item);
            item.setOwner(false);
            item.setNameContainer("Null");
            System.out.println("Вытащили объект:" + item.getNameItem());
        } else if (!listItems.contains(item)) {
            System.err.println("Данного объекта нет в контейнере");
        }
    }

    public void getItem(BagItems bagItem) {

        if (listItems.size() > 0 && listItems.contains(bagItem)) {
            this.curretWeight = curretWeight - bagItem.getCurretWeight();
            listItems.remove(bagItem);
            bagItem.setOwnerContainer(false);
            bagItem.setNameInContainer("Null");
            System.out.println("Вытащили объект:" + bagItem.getNameContainer());
        } else if (!listItems.contains(bagItem)) {
            System.err.println("Данного объекта нет в контейнере");
        }
    }

    public void getRandomItem() {

        if (!listItems.isEmpty()) {
            Items randomItemOf = randomItem();
            if (randomItemOf.getClass().equals(BagItems.class)) {
                BagItems randomItem = (BagItems) randomItemOf;
                this.curretWeight = curretWeight - randomItem.getCurretWeight();
                randomItem.setOwnerContainer(false);
                randomItem.setNameInContainer("Null");
                listItems.remove(randomItem);

                System.out.println("Вытащили объект:" + randomItem.getNameContainer());
            } else {
                ItemImplementation randomItem = (ItemImplementation) randomItemOf;

                this.curretWeight = curretWeight - randomItem.getWeightItem();
                randomItem.setOwner(false);
                randomItem.setNameContainer("Null");
                listItems.remove(randomItem);

                System.out.println("Вытащили объект:" + randomItem.getNameItem());
            }
        } else if (listItems.isEmpty()) {
            System.err.println("Контейнер пуст");
        }
    }

    @Override
    public String getName() {
        return getNameContainer();
    }

    public int getTotalWeight() {
        return this.totalWeight;
    }

    public int getCurretWeight() {
        return this.curretWeight;
    }


    @Override
    public void getInfoContainer() {
        this.listItems.forEach(System.out::println);
    }

    public List<Items> getListFromContainer() {
        return listItems;
    }

    @Override
    public String toString() {
        return "BagItems{" +
                "totalWeight=" + totalWeight +
                ", nameContainer='" + nameContainer + '\'' +
                ", nameInContainer='" + nameInContainer + '\'' +
                ", owner=" + owner +
                ", curretWeight=" + curretWeight +
                ", listItems=" + listItems +
                '}';
    }

    @Override
    public void getInfo() {
        System.out.println("Наименование контейнера " + getNameContainer() + ", Максимальный вес  " + getTotalWeight() + ", Текущий вес " + getCurretWeight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BagItems bagItems = (BagItems) o;
        return totalWeight == bagItems.totalWeight &&
                owner == bagItems.owner &&
                curretWeight == bagItems.curretWeight &&
                Objects.equals(nameContainer, bagItems.nameContainer) &&
                Objects.equals(nameInContainer, bagItems.nameInContainer) &&
                Objects.equals(listItems, bagItems.listItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalWeight, nameContainer, nameInContainer, owner, curretWeight, listItems);
    }
}




