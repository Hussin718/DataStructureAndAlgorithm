package com.example.maze;

import com.example.Structure.structurebase.Node;
import com.example.Structure.structurebase.State;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MazeImageGenerator {
    private static final int TILE_SIZE = 20; 

    public static void saveMazeAsImage(Maze maze, Node solution, String fileName) {
        int width = maze.getWidth() * TILE_SIZE;
        int height = maze.getHeight() * TILE_SIZE;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        Set<String> pathCoords = new HashSet<>();
        Node curr = solution;
        while (curr != null) {
            pathCoords.add(curr.getState().getRow() + "," + curr.getState().getCol());
            curr = curr.getParent();
        }

        for (int r = 0; r < maze.getHeight(); r++) {
            for (int c = 0; c < maze.getWidth(); c++) {
                if (maze.isWall(r, c)) {
                    g2d.setColor(new Color(40, 40, 40));
                } else if (r == maze.getStart().getRow() && c == maze.getStart().getCol()) {
                    g2d.setColor(Color.RED); 
                } else if (r == maze.getGoal().getRow() && c == maze.getGoal().getCol()) {
                    g2d.setColor(Color.GREEN); 
                } else if (pathCoords.contains(r + "," + c)) {
                    g2d.setColor(Color.YELLOW); 
                } else {
                    g2d.setColor(Color.WHITE); 
                }

                g2d.fillRect(c * TILE_SIZE, r * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                g2d.setColor(Color.LIGHT_GRAY);
                g2d.drawRect(c * TILE_SIZE, r * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }

        g2d.dispose();

        try {
            ImageIO.write(image, "png", new File(fileName));
            System.out.println("Solution image saved as: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving image: " + e.getMessage());
        }
    }
}
