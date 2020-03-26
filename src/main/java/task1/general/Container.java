package task1.general;

import task1.exeptions.ItemAlreadyPlacedException;
import task1.exeptions.ItemStoreException;
import task1.itembase.ItemImplementation;

import java.util.ArrayList;
import java.util.Set;

public interface Container {


    void addItemToContainer(ItemImplementation item) throws ItemAlreadyPlacedException, ItemStoreException;
    void getInfoContainer();

}
