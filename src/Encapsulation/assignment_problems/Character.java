package Encapsulation.assignment_problems;

public class Character {
    private final int maxHealth;
    private int currentHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            this.currentHealth = Math.max(0, this.currentHealth - amount);
            System.out.println("c.takeDamage(" + amount + ") -> health = " + this.currentHealth);
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            this.currentHealth = Math.min(this.maxHealth, this.currentHealth + amount);
            System.out.println("c.heal(" + amount + ") -> health = " + this.currentHealth);
        }
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        c.heal(50);
        c.takeDamage(150);
    }
}
