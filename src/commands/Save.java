package commands;

import utilities.FileManager;
import utilities.HumanBeingList;
import utilities.XML;

import java.io.IOException;
/**
 * Команда 'save'. Сохраняет коллекцию в файл.
 * @author Ubica228
 */
public class Save extends Command{
    HumanBeingList humanBeings;
    public Save(HumanBeingList humanBeings){
        super("save","Сохраняет людей");
        this.humanBeings = humanBeings;
    }
    /**
     * Выполняет команду
     * @return  Успешность выполнения команды
     * */
    @Override
    public boolean execute(String[] arguments) {
        try{
         FileManager.save(XML.toXML(humanBeings));
         return true;
        }
        catch (IOException e){
            System.out.println("Ошибка с записью в файл!");
            return false;
        }
    }
}
