package task1.general;

import task1.exeptions.ItemAlreadyPlacedException;
import task1.exeptions.ItemStoreException;
import task1.itembase.ItemImplementation;

public abstract class Items {
    String name;
    public abstract void getInfo();

    public String getName(){
        return name;
    }

    public abstract void getInfoContainer();
    public void addItemToContainer(ItemImplementation item) throws ItemAlreadyPlacedException, ItemStoreException {
    }


}
