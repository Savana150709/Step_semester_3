package Encapsulation.assignment_problems;

public class Cart {
    private final String cartId;
    private final double[] itemPrices;
    private int count;

    public Cart(String cartId, int maxCapacity) {
        this.cartId = cartId;
        this.itemPrices = new double[maxCapacity];
        this.count = 0;
    }

    public String getCartId() {
        return this.cartId;
    }

    public void addItem(double price) {
        if (count < itemPrices.length) {
            itemPrices[count] = price;
            count++;
        }
    }

    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < count; i++) {
            total += itemPrices[i];
        }
        return total;
    }

    public int getItemCount() {
        return this.count;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("cart.getTotal() -> " + (int)cart.getTotal());
        System.out.println("cart.getItemCount() -> " + cart.getItemCount());
    }
}
