package com.agentic.shortcuts;

public class App {
    public static void main(String[] args) {
        ShortcutManager manager = new ShortcutManager();
        manager.addShortcut(new ShortcutEntry("!sc", "hello", "Hello there!"));
        manager.addShortcut(new ShortcutEntry("!sc", "bye", "Goodbye!"));

        String input = "Say hello!sc";
        String expansion = manager.findExpansion(input);
        System.out.println(expansion == null ? "NO_MATCH" : expansion);
    }
}
