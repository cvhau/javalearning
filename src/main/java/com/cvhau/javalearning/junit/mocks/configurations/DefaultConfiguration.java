package com.cvhau.javalearning.junit.mocks.configurations;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class DefaultConfiguration implements Configuration {
    private ResourceBundle resourceBundle;

    public DefaultConfiguration(String configurationName) {
        this(PropertyResourceBundle.getBundle(configurationName));
    }

    public DefaultConfiguration(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public String getSQL(String key) {
        return resourceBundle.getString(key);
    }
}
