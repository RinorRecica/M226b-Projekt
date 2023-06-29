package weapons;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Weapon {
    private String name;
    private int damagePoints;
    private int range;
    private int killCount; // Anzahl der getöteten Feinde
    private int level; // Stufe der Waffe
    private Image swingImage;


    private Image weaponImage;

    public Weapon(String name, int damagePoints, int range) {
        this.name = name;
        this.damagePoints = damagePoints;
        this.range = range;
        this.killCount = 0;
        this.level = 1;
        updateWeaponImage(); // Bild beim Erzeugen des Objekts laden
    }

    // ... Getter und Setter Methoden ...
    public Image getSwingImage() {
        return swingImage;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getKillCount() {
        return killCount;
    }

    public void setKillCount(int killCount) {
        this.killCount = killCount;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Image getWeaponImage() {
        return weaponImage;
    }

    public void setWeaponImage(Image weaponImage) {
        this.weaponImage = weaponImage;
    }

    public void enemyKilled() {
        killCount++;
        if (killCount >= 10) {
            upgrade();
        }
    }


    public void upgrade() {
        this.level++; // Stufe erhöhen
        this.killCount = 0; // killCount zurücksetzen

        // Logik zur Verbesserung der Waffe, abhängig von der Stufe
        switch (level) {
            case 2:
                this.name = "Knochenschwert";
                this.damagePoints += 5;
                this.range += 1;
                break;
            case 3:
                this.name = "Steinschwert";
                this.damagePoints += 10;
                this.range += 2;
                break;
            case 4:
                this.name = "Bronzeschwert";
                this.damagePoints += 15;
                this.range += 2;
                break;
            case 5:
                this.name = "Eisenschwert";
                this.damagePoints += 20;
                this.range += 3;
                break;
            case 6:
                this.name = "Stahlschwert";
                this.damagePoints += 25;
                this.range += 3;
                break;
            case 7:
                this.name = "Titanschwert";
                this.damagePoints += 30;
                this.range += 4;
                break;
            case 8:
                this.name = "Obsidianschwert";
                this.damagePoints += 35;
                this.range += 4;
                break;
            case 9:
                this.name = "Diamantschwert";
                this.damagePoints += 40;
                this.range += 5;
                break;
            case 10:
                this.name = "Vibraniumschwert";
                this.damagePoints += 45;
                this.range += 5;
                break;
            default:
                System.out.println("Maximale Stufe erreicht!");
                break;
        }

        updateWeaponImage();
    }

    private void updateWeaponImage() {
        String imagePath = "images/weapons/" + getWeaponType() + ".png";
        ImageIcon weaponIcon = new ImageIcon(imagePath);
        weaponImage = weaponIcon.getImage();
    }


    // Methode zum Abrufen des Waffentyps
    public String getWeaponType() {
        return this.name; // gibt den Namen der Waffe zurück, der auch den Typ repräsentiert
    }
}

