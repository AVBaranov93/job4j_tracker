package ru.job4j.pojo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShopTest {

    @Test
    void whenMiddleNull() {
        Product milk = new Product("milk", 2);
        Product chocolate = new Product("chocolate", 5);
        Product bread = new Product("bread", 3);
        Product[] products = new Product[] {milk, chocolate, null, bread, null};
        int expected = 2;
        int result = Shop.indexOfNull(products);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenLastNull() {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        int rsl = Shop.indexOfNull(products);
        int expected = 3;
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    public void whenFirstNull() {
        Product[] products = new Product[5];
        products[1] = new Product("Milk", 10);
        int rsl = Shop.indexOfNull(products);
        int expected = 0;
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    public void whenHasNotNull() {
        Product[] products = new Product[1];
        products[0] = new Product("Milk", 10);
        int rsl = Shop.indexOfNull(products);
        int expected = -1;
        assertThat(rsl).isEqualTo(expected);
    }
}