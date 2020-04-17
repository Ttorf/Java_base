package task.laba1.models;

import task.laba1.exceptions.ItemAlreadyPlacedException;
import task.laba1.exceptions.ItemStoreException;

public abstract class AbstractContainer extends Item {

    abstract int getCurretWeight();

    abstract void setOwnerContainer(boolean owner);

    abstract public String getNameContainer();

    abstract public void getInfoContainer();

    abstract public void addItemToContainer(Item item)
            throws ItemAlreadyPlacedException, ItemStoreException;
}
