/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.general_settings;

import domain.AppUser;

/**
 *
 * @author Nikola
 */
public class GeneralSettings {
    private int id;
    private SettingsLayoutType layoutType;
    private AppUser appUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public SettingsLayoutType getLayoutType() {
        return layoutType;
    }

    public void setLayoutType(SettingsLayoutType layoutType) {
        this.layoutType = layoutType;
    }
}
