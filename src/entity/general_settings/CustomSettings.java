/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.general_settings;

import entity.CustomApplication;

/**
 *
 * @author Nikola
 */
public class CustomSettings {
    private int id;
    private CustomApplication application;
    private String username;
    private String password;
    private boolean quickStart;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomApplication getApplication() {
        return application;
    }

    public void setApplication(CustomApplication application) {
        this.application = application;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isQuickStart() {
        return quickStart;
    }

    public void setQuickStart(boolean quickStart) {
        this.quickStart = quickStart;
    }
}
