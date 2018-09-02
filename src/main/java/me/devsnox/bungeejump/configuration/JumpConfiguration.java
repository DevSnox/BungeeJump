package me.devsnox.bungeejump.configuration;

public class JumpConfiguration {

    private String prefix;
    private String noPermissions;
    private String serverMessage;
    private String warpedToServer;
    private String listOfServers;
    private String consoleMessage;
    private String serverNotExists;
    private String alreadyConnected;

    public JumpConfiguration(String prefix, String noPermissions, String consoleMessage, String serverMessage, String warpedToServer, String listOfServers, String serverNotExists, String alreadyConnected) {
        this.prefix = prefix;
        this.noPermissions = noPermissions;
        this.serverMessage = serverMessage;
        this.warpedToServer = warpedToServer;
        this.listOfServers = listOfServers;
        this.consoleMessage = consoleMessage;
        this.serverNotExists = serverNotExists;
        this.alreadyConnected = alreadyConnected;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getNoPermissions() {
        return noPermissions;
    }

    public String getServerMessage() {
        return serverMessage;
    }

    public String getWarpedToServer() {
        return warpedToServer;
    }

    public String getListOfServers() {
        return listOfServers;
    }

    public String getConsoleMessage() {
        return consoleMessage;
    }

    public String getServerNotExists() {
        return serverNotExists;
    }

    public String getAlreadyConnected() {
        return alreadyConnected;
    }
}
