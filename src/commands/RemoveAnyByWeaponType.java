package commands;

import initials.HumanBeing;

import java.util.ArrayList;
/**
 * Команда 'remove_any_by_weapon_type'. Удаляет первый элемент коллекции у которого поле weaponType совпадает с заданым.
 * @author Ubica228
 */
public class RemoveAnyByWeaponType extends Command{
    private ArrayList<HumanBeing> humanBeings;


    public RemoveAnyByWeaponType(ArrayList<HumanBeing> humanBeings){
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
            for(int i = 0; i<humanBeings.size();i++){
                if (humanBeings.get(i).getWeaponType().toString().equals(weaponType)){
                    humanBeings.remove(i);
                    return true;
                }
            }
            System.out.println("Человека с таким оружием нет");
            return false;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Вы не ввели тип оружия человека");
            return false;
        }

    }
}
