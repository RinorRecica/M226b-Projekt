package player;

import character.PlayerHealth;
import weapons.Weapon;

import java.awt.Image;

public class Player {
    private Weapon weapon;  // Waffe des Spielers
    private PlayerHealth health;  // Gesundheit des Spielers
    private boolean isAttacking;

    public Player(Weapon weapon, PlayerHealth health) {
        this.weapon = weapon;
        this.health = health;
    }

    public Player() {
        this.weapon = new Weapon("Holzschwert", 10, 1);  // Der Spieler beginnt mit einem Holzschwert
        this.health = new PlayerHealth();  // Der Spieler beginnt mit einer bestimmten Gesundheitsmenge, die in der PlayerHealth-Klasse festgelegt ist
    }

    // Getter und Setter für die Waffe
    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    // Getter und Setter für die Gesundheit
    public PlayerHealth getHealth() {
        return health;
    }

    public void setHealth(PlayerHealth health) {
        this.health = health;
    }

    public void attack() {
        isAttacking = true;

        // Hier kannst du weitere Logik für den Angriff einfügen

        // Überprüfe, ob die Waffe den Schwungbild hat und setze es entsprechend
        if (weapon.getSwingImage() != null) {
            weapon.setWeaponImage(weapon.getSwingImage());
        }
    }

    public void stopAttack() {
        isAttacking = false;
    }

    public boolean isAttacking() {
        return isAttacking;
    }
}
