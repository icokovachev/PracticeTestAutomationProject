package org.example.Common;

import java.util.ResourceBundle;

public class ConfigurationProvider {
    // For the sake of simplicity I have decided to use ResourceBundle to read the config.properties file
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    // I like to order the properties in the order that they are written in the config.properties file
    // I do not use getters because I do not want to expose the properties to the outside world
    public static final boolean isHeadlessEnabled = Boolean.parseBoolean(resourceBundle.getString("isHeadlessEnabled"));
    public static final String BaseURL = resourceBundle.getString("BaseURL");
    public static final String validLoginUsername = resourceBundle.getString("validLoginUsername");
    public static final String validLoginPassword = resourceBundle.getString("validLoginPassword");
    public static final String invalidLoginUsername = resourceBundle.getString("invalidLoginUsername");
    public static final String invalidLoginPassword = resourceBundle.getString("invalidLoginPassword");
}
