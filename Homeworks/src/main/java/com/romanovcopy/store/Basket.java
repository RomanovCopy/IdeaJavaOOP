package com.romanovcopy.store;

import lombok.Getter;
import lombok.Setter;
import lombok.Data;

import java.util.ArrayList;


@Data
@Setter
@Getter
public class Basket {


    private ArrayList<StoreItem>items;

    public Basket() {
    }



    @Override
    public String toString() {
        return "Basket{" + "items=" + items + '}';
    }


}
