package commands;

import initials.WeaponType;
import utilities.HumanBeingList;

import java.util.NoSuchElementException;

/**
 * Команда 'remove_any_by_weapon_type'. Удаляет первый элемент коллекции у которого поле weaponType совпадает с заданым.
 * @author Ubica228
 */
public class RemoveAnyByWeaponType extends Command{
    private HumanBeingList humanBeings;


    public RemoveAnyByWeaponType(HumanBeingList humanBeings){
        super("remove_any_by_weapon_type","Удаляет людей по типу оружия");
        this.humanBeings = humanBeings;
    }
    /**
     * Выполняет команду
     * @return  Успешность выполнения команды
     * */
    @Override
    public boolean execute(String[] arguments) {
        try{
            String weaponType = arguments[1];
            humanBeings.getByWeaponType(WeaponType.valueOf(weaponType));
            return true;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Вы не ввели тип оружия человека");
            return false;
        }
        catch (NoSuchElementException e){
            System.out.println(e.getMessage());
            return false;
        }

    }
}
