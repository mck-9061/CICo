package me.therealmck.cico.utils;

import me.therealmck.cico.Main;

public class MessageHelper {
    private String added1;
    private String added2;
    private String added3;
    private String crafted;
    private String failed;
    private String invalid;
    private String adminInterfaceName;
    private String playerInterfaceName;
    private String adminInterfaceAccept;
    private String playerInterfaceAccept;
    private String badCategory;
    private String badChance;

    public MessageHelper() {
        this.added1 = Main.langConfig.getString("added1");
        this.added2 = Main.langConfig.getString("added2");
        this.added3 = Main.langConfig.getString("added3");
        this.crafted = Main.langConfig.getString("crafted");
        this.failed = Main.langConfig.getString("failed");
        this.invalid = Main.langConfig.getString("invalid");
        this.adminInterfaceName = Main.langConfig.getString("admin-interface-name");
        this.playerInterfaceName = Main.langConfig.getString("player-interface-name");
        this.adminInterfaceAccept = Main.langConfig.getString("admin-interface-accept");
        this.playerInterfaceAccept = Main.langConfig.getString("player-interface-accept");
        this.badCategory = Main.langConfig.getString("bad-category");
        this.badChance = Main.langConfig.getString("bad-chance");
    }

    public String getAdded1() {
        return added1;
    }

    public String getAdded2() {
        return added2;
    }

    public String getAdded3() {
        return added3;
    }

    public String getCrafted() {
        return crafted;
    }

    public String getFailed() {
        return failed;
    }

    public String getInvalid() {
        return invalid;
    }

    public String getAdminInterfaceName() {
        return adminInterfaceName;
    }

    public String getPlayerInterfaceName() {
        return playerInterfaceName;
    }

    public String getAdminInterfaceAccept() {
        return adminInterfaceAccept;
    }

    public String getPlayerInterfaceAccept() {
        return playerInterfaceAccept;
    }

    public String getBadCategory() {
        return badCategory;
    }

    public String getBadChance() {
        return badChance;
    }
}
