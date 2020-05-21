package uvsq21807481.Command;

import uvsq21807481.Shape.*;

import java.util.Scanner;

public class DrawingTUI {

    private Scanner scan;
    private Group g;

    public DrawingTUI() {
        this.g = new Group("all");
        this.scan = new Scanner(System.in);
    }

    public void setGroup(Group g) {
        this.g = g;
    }

    public Command nextCommand() {
        Command command = null;
        String user = this.scan.nextLine();
        user = user.replace(" ", "");
        String[] input = user.split("\\(");
        String commandChoice = input[0];
        String[] parameters = input[1].split(",");
        if(commandChoice == "circle") {
            String name = parameters[0];
            double centerX = Double.parseDouble(parameters[1]);
            double centerY = Double.parseDouble(parameters[2]);
            double radius = Double.parseDouble(parameters[3].replace("\\)", ""));
            command = new CommandCircle(this.g, name, centerX, centerY, radius);
        }
        else if(commandChoice == "rectangle") {
            String name = parameters[0];
            double centerX = Double.parseDouble(parameters[1]);
            double centerY = Double.parseDouble(parameters[2]);
            double length = Double.parseDouble(parameters[3]);
            double width = Double.parseDouble(parameters[4].replace("\\)", ""));
            command = new CommandRectangle(this.g, name, centerX, centerY, length, width);
        }
        else if(commandChoice == "square") {
            String name = parameters[0];
            double centerX = Double.parseDouble(parameters[1]);
            double centerY = Double.parseDouble(parameters[2]);
            double side = Double.parseDouble(parameters[3].replace("\\)", ""));
            command = new CommandSquare(this.g, name, centerX, centerY, side);
        }
        else if(commandChoice == "triangle") {
            String name = parameters[0];
            double x1 = Double.parseDouble(parameters[1]);
            double y1 = Double.parseDouble(parameters[2]);
            double x2 = Double.parseDouble(parameters[3]);
            double y2 = Double.parseDouble(parameters[4]);
            double x3 = Double.parseDouble(parameters[5]);
            double y3 = Double.parseDouble(parameters[6].replace("\\)", ""));
            command = new CommandTriangle(this.g, name, x1, y1, x2, y2, x3, y3);
        }
        else if(commandChoice == "group") {
            String name = parameters[0].replace("\\)", "");
            command = new CommandGroup(this.g, name);
        }
        else if(commandChoice == "link") {
            String container = parameters[0];
            String element = parameters[1].replace("\\)", "");

            int found = 0;
            int i = 0;
            Shape s = null;
            while(found == 0 && i < this.g.getShapes().size()) {
                s = this.g.getShapes().get(i);
                if(s.getName() == element) {
                    found = 1;
                }
                i++;
            }
            if(found == 0) {
                System.out.println("Shape does not exist");
            }
            else {
                if(container == "all") {
                    command = new CommandLink(this.g, s);
                }
                else {
                    found = 0;
                    i = 0;
                    Shape group = null;
                    while(found == 0 && i < this.g.getShapes().size()) {
                        group = this.g.getShapes().get(i);
                        if(group.getName() == container && group instanceof Group) {
                            found = 1;
                        }
                        i++;
                    }
                    if(found == 0) {
                        System.out.println("Group does not exist");
                    }
                    else {
                        command = new CommandLink((Group)group, s);
                    }
                }
            }
        }
        else if(commandChoice == "show") {
            String name = parameters[0].replace("\\)", "");
            if(name == "all") {
                command = new CommandShow(this.g);
            }
            else {
                int found = 0;
                int i = 0;
                Shape s = null;
                while (found == 0 && i < this.g.getShapes().size()) {
                    s = this.g.getShapes().get(i);
                    if (s.getName() == name) {
                        found = 1;
                    }
                    i++;
                }
                if (found == 0) {
                    System.out.println("Shape or Group does not exist");
                } else {
                    command = new CommandShow(s);
                }
            }
        }
        else if(commandChoice == "delete") {
            String groupName = parameters[0];
            String shapeName = parameters[1].replace("\\)", "");

            if (groupName == "all") {
                command = new CommandDelete(this.g, shapeName);
            }
            else {
                int found = 0;
                int i = 0;
                Shape group = null;
                while (found == 0 && i < this.g.getShapes().size()) {
                    group = this.g.getShapes().get(i);
                    if (group.getName() == groupName && group instanceof Group) {
                        found = 1;
                    }
                    i++;
                }
                if (found == 0) {
                    System.out.println("Group does not exist");
                }
                else {
                    command = new CommandDelete((Group) group, shapeName);
                }
            }
        }
        else if(commandChoice == "move") {
            String shapeName = parameters[0];
            double moveX = Double.parseDouble(parameters[1]);
            double moveY = Double.parseDouble(parameters[2].replace("\\)", ""));

            int found = 0;
            int i = 0;
            Shape s = null;
            while(found == 0 && i < this.g.getShapes().size()) {
                s = this.g.getShapes().get(i);
                if(s.getName() == shapeName) {
                    found = 1;
                }
                i++;
            }
            if(found == 0) {
                System.out.println("Shape or Group does not exist");
            }
            else {
                command = new CommandMove(s, moveX, moveY);
            }
        }
        else if(commandChoice == "save") {
            command = new CommandSave(this.g);
        }
        else if(commandChoice == "load") {
            String name = parameters[1].replace("\\)", "");
            command = new CommandLoad(name, this);
        }
        else if(commandChoice == "quit") {
            command  = new CommandQuit();
        }
        else {
            System.out.println("Command does not exist");
        }
        return command;
    }
}
