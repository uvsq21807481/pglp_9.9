package uvsq21807481.Command;

import uvsq21807481.DAO_JDBC.DAOFactory;
import uvsq21807481.Shape.Group;

public class CommandSave implements Command {

    private Group g;

    public CommandSave(Group g) {
        this.g = g;
    }

    @Override
    public void execute() {
        DAOFactory.getDAOGroup().create(this.g);
    }
}
