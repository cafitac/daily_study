package cafitac.example.chapter1.advantureGame.character;

import cafitac.example.chapter1.advantureGame.weaponBehavior.WeaponBehavior;

public abstract class Character {

    WeaponBehavior weapon;

    public abstract void fight();

    public void setWeapon(final WeaponBehavior weaponBehavior) {
        this.weapon = weaponBehavior;
    }
}
