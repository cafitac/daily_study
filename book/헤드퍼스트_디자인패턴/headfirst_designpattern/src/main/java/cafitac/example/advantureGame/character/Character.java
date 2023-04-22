package cafitac.example.advantureGame.character;

import cafitac.example.advantureGame.weaponBehavior.WeaponBehavior;

public abstract class Character {

    WeaponBehavior weapon;

    public abstract void fight();

    public void setWeapon(final WeaponBehavior weaponBehavior) {
        this.weapon = weaponBehavior;
    }
}
