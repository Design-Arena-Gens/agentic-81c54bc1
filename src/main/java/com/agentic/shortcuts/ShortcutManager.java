package com.agentic.shortcuts;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ShortcutManager {
    private final List<ShortcutEntry> entries = new ArrayList<>();

    public void addShortcut(ShortcutEntry entry) {
        if (entry.getId() == null) {
            entry.setId(UUID.randomUUID());
        }
        entries.add(entry);
    }

    public boolean updateShortcut(ShortcutEntry updated) {
        if (updated == null || updated.getId() == null) {
            return false;
        }
        for (int i = 0; i < entries.size(); i++) {
            ShortcutEntry current = entries.get(i);
            if (Objects.equals(current.getId(), updated.getId())) {
                current.setCommand(updated.getCommand());
                current.setKeyword(updated.getKeyword());
                current.setExpansionText(updated.getExpansionText());
                return true;
            }
        }
        return false;
    }

    public boolean deleteShortcut(UUID id) {
        if (id == null) {
            return false;
        }
        return entries.removeIf(e -> Objects.equals(e.getId(), id));
    }

    public String findExpansion(String textToMatch) {
        if (textToMatch == null || textToMatch.isEmpty()) {
            return null;
        }
        String bestMatch = null;
        int bestLength = -1;
        for (ShortcutEntry entry : entries) {
            String trigger = String.valueOf(entry.getKeyword()) + String.valueOf(entry.getCommand());
            if (!trigger.isEmpty() && textToMatch.endsWith(trigger)) {
                if (trigger.length() > bestLength) {
                    bestLength = trigger.length();
                    bestMatch = entry.getExpansionText();
                }
            }
        }
        return bestMatch;
    }

    public List<ShortcutEntry> getEntries() {
        return new ArrayList<>(entries);
    }
}
