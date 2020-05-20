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

    public Command nextCommand() {
        Command command = null;
        String user = this.scan.nextLine();
        user = user.replace(" ", "");
        if(user.contains("circle")) {
            String[] newCircle = user.split(",");
            String[] start = newCircle[0].split("\\(");
            String name = start[1];
            double coorX = Double.parseDouble(newCircle[1]);
            double coorY = Double.parseDouble(newCircle[2]);
            newCircle[3].replace("\\)","");
            double radius = Double.parseDouble(newCircle[3]);
            command = new CommandCircle(this.g, name, coorX, coorY, radius);
        }
        else if(user.contains("rectangle")) {
            String[] newRectangle = user.split(",");
            String[] start = newRectangle[0].split("\\(");
            String name = start[1];
            double coorX = Double.parseDouble(newRectangle[1]);
            double coorY = Double.parseDouble(newRectangle[2]);
            double length = Double.parseDouble(newRectangle[3]);
            newRectangle[4].replace("\\)","");
            double width = Double.parseDouble(newRectangle[4]);
            command = new CommandRectangle(this.g, name, coorX, coorY, length, width);
        }
        else if(user.contains("square")) {
            String[] newSquare = user.split(",");
            String[] start = newSquare[0].split("\\(");
            String name = start[1];
            double coorX = Double.parseDouble(newSquare[1]);
            double coorY = Double.parseDouble(newSquare[2]);
            newSquare[3].replace("\\)","");
            double side = Double.parseDouble(newSquare[3]);
            command = new CommandSquare(this.g, name, coorX, coorY, side);
        }
        else if(user.contains("triangle")) {
            String[] newTriangle = user.split(",");
            String[] start = newTriangle[0].split("\\(");
            String name = start[1];
            double coorX1 = Double.parseDouble(newTriangle[1]);
            double coorY1 = Double.parseDouble(newTriangle[2]);
            double coorX2 = Double.parseDouble(newTriangle[3]);
            double coorY2 = Double.parseDouble(newTriangle[4]);
            double coorX3 = Double.parseDouble(newTriangle[5]);
            newTriangle[6].replace("\\)","");
            double coorY3 = Double.parseDouble(newTriangle[6]);
            command = new CommandTriangle(this.g, name, coorX1, coorY1, coorX2, coorY2, coorX3, coorY3);
        }
        else if(user.contains("move")) {
            String[] movement = user.split(",");
            String[] start = movement[0].split("\\(");
            String target = start[1];
            double moveX = Double.parseDouble(movement[1]);
            movement[2].replace("\\)","");
            double moveY = Double.parseDouble(movement[2]);
            if(target == "all") {
                command = new CommandMove(this.g, moveX, moveY);
            }
            else {
                int found = 0;
                int i = 0;
                Shape s = null;
                while(found == 0 && i < this.g.getShapes().size()) {
                    s = g.getShapes().get(i);
                    if(s.getName() == target) {
                        found = 1;
                    }
                    i++;
                }
                if(found == 0) {
                    System.out.println("Target does not exist");
                }
                else {
                    command = new CommandMove(s, moveX, moveY);
                }
            }
        }
        /*
        else if(user.contains("delete")) {

        }
        */
        return command;
    }
}
