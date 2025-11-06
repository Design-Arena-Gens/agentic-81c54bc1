package com.agentic.shortcuts;

import java.util.UUID;

public class ShortcutEntry {
    private UUID id;
    private String command;
    private String keyword;
    private String expansionText;

    public ShortcutEntry(UUID id, String command, String keyword, String expansionText) {
        this.id = id;
        this.command = command;
        this.keyword = keyword;
        this.expansionText = expansionText;
    }

    public ShortcutEntry(String command, String keyword, String expansionText) {
        this(UUID.randomUUID(), command, keyword, expansionText);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getExpansionText() {
        return expansionText;
    }

    public void setExpansionText(String expansionText) {
        this.expansionText = expansionText;
    }
}
