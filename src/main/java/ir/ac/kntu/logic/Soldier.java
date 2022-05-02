package ir.ac.kntu.logic;

public class Soldier {
    private final String id;
    private int health;
    private int damage;
    private final Gun gun;

    public Soldier(String id, int health, int damage, Gun gun) {
        this.id = id;
        this.health = health;
        this.damage = damage;
        this.gun = gun;
    }

    public String getId() {
        return this.id;
    }

    public int getHealth() {
        return this.health;
    }

    public int getDamage() {
        return this.damage;
    }

    public Gun getGun() {
        return gun;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Soldier other = (Soldier) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(id);
    }

    @Override
    public String toString() {
        return "ID@" + id + " ==>" + " |HP~" + health + " |Dmg~" + damage + gun.toString();
    }
}