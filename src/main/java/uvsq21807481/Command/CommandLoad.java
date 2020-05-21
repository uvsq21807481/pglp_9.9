package uvsq21807481.Command;

import uvsq21807481.DAO_JDBC.DAOFactory;

public class CommandLoad implements Command {

    private String name;
    private DrawingTUI dtui;

    public CommandLoad(String name, DrawingTUI dtui) {
        this.name = name;
        this.dtui = dtui;
    }

    @Override
    public void execute() {
        this.dtui.setGroup(DAOFactory.getDAOGroup().read(this.name));
    }
}
