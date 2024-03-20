package commands;

public class Exit extends Command{

    public Exit(){
        super("exit","Выключает программу");

    }
    /**
     * Выполняет команду
     * @return  Успешность выполнения команды
     * */
    @Override
    public boolean execute(String[] arguments) {
        System.exit(0);
        return true;
    }
}
