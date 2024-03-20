package controllers;

import commands.Command;
import utilities.Asker;
import utilities.FileManager;
import utilities.HumanBeingList;
import utilities.InputGetter;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

/**
 * Класс наследник ControlLoop. Получает команды из стандартного потока ввода
 * @author Ubica228
 */
public class MainLoop extends ControlLoop{
    HumanBeingList humanBeings;

    public MainLoop(Map<String,Command> commands, Scanner scanner, Asker asker, HumanBeingList humanBeings){
        super(commands,scanner,asker,new InputGetter(scanner,false));
        this.humanBeings =humanBeings;
        printIndication();
    }
    public void printIndication(){
        System.out.print(">");
    }
    @Override
    public boolean execute(){

        boolean work = true;
        while (work){
            String[] commandInput = this.inputGetter.getInputLine();
            String commandName = commandInput[0];
            try {
                if (commandName.equals("execute_script")) {
                    Scanner scriptScanner = FileManager.getFileScanner(commandInput[1]);
                    asker.changeMode();
                    asker.changeScanner(scriptScanner);

                    ScriptLoop scriptLoop = new ScriptLoop(commands, scriptScanner, asker, commandInput[1], humanBeings);
                    work = scriptLoop.execute();

                    asker.changeMode();
                    asker.changeScanner(scanner);

                    printIndication();
                } else {
                    this.commands.get(commandName).execute(commandInput);
                    printIndication();
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Не указан аргумент для команды "+commandName);
            }
            catch (NullPointerException e){
               System.out.println(e.getMessage());
               if(!commandName.isEmpty()) System.out.println("Введена не существующая команда. help чтобы узнать команды");
               printIndication();
            }
            catch (FileNotFoundException e) {
                System.out.println("Файл скрипта не найден!");
                printIndication();
            }
        }
        return work;
   }
}
