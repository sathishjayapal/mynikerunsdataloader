package me.sathish.nikerundataload;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.File;

@ConfigurationProperties(prefix = "datastax.astra")
public class DataStaxAstraProps {
    private File SecureConnectBundle;

    public File getSecureConnectBundle() {
        return SecureConnectBundle;
    }

    public void setSecureConnectBundle(File secureConnectBundle) {
        SecureConnectBundle = secureConnectBundle;
    }
}
