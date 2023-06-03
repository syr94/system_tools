package com.app.util;

import java.util.List;
import java.util.Random;

public class DirectoryTree {

    private static List<String> directories;

    static {
        // Method that gets all directories in the home directory
        directories = getDirectories(System.getProperty("user.home"));
    }

    public static String getRandomDirectory() {
        Random rand = new Random();
        return directories.get(rand.nextInt(directories.size()));
    }

    private static List<String> getDirectories(String path) {
        // TODO: Implement this method to return all directories in a given path
        return null;
    }
}