package commands;

import initials.HumanBeing;

import java.util.ArrayList;
/**
 * Команда 'clear'. Очищает коллекцию.
 * @author Ubica228
 */
public class Clear extends Command{
    ArrayList<HumanBeing> humanBeings;
    public Clear(ArrayList<HumanBeing> humanBeings){
        super("clear","Удаляет всех людей");
        this.humanBeings = humanBeings;
    }
    /**
     * Выполняет команду
     * @return  Успешность выполнения команды
     * */
    @Override
    public boolean execute(String[] arguments) {
        humanBeings.clear();
        return true;
    }
}
