package br.unicamp.ft.a166348.navigationdraweraula.sell;

import java.util.List;

/**
 * Created by andre on 02/04/2018.
 */

public class RestaurantMenu {
    private List<SellableProduct> menuProducts;

    public RestaurantMenu(List<SellableProduct> menuProducts) {
        this.menuProducts = menuProducts;
    }

    public List<SellableProduct> getMenuProducts() {
        return menuProducts;
    }
}
