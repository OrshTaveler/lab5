package commands;

import initials.HumanBeing;

import java.util.ArrayList;
/**
 * Команда 'filter_starts_with_name'. Выводит элементы коллекции у которых поле name начинается с заданой подстроки.
 * @author Ubica228
 */
public class FilterStartsWithName extends Command {
    ArrayList<HumanBeing> humanBeings;
    public FilterStartsWithName(ArrayList<HumanBeing> humanBeings){
        super("filter_starts_with_name","Находит людей у которых имя начинается на");
        this.humanBeings = humanBeings;
    }
    /**
     * Выполняет команду
     * @return  Успешность выполнения команды
     * */
    @Override
    public boolean execute(String[] arguments) {
        try {
         String subString = arguments[1];
         for(HumanBeing humanBeing: humanBeings){
             if(humanBeing.getName().startsWith(subString)){
                 System.out.println(humanBeing.toString());
             }
         }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Вы не ввели подстроку");
            return false;
        }
        return true;
    }
}
