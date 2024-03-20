package commands;

import utilities.HumanBeingList;
/**
 * Команда 'clear'. Очищает коллекцию.
 * @author Ubica228
 */
public class Clear extends Command{
    HumanBeingList humanBeings;
    public Clear(HumanBeingList humanBeings){
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
