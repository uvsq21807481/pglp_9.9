package uvsq21807481.Command;

import static java.lang.System.exit;

public class CommandQuit implements Command {

    public CommandQuit(){}

    @Override
    public void execute() {
        exit(0);
    }
}
