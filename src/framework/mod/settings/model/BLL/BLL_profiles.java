/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.mod.settings.model.BLL;

import framework.mod.settings.model.clss.Profiles;
import framework.mod.settings.model.clss.singletonProfile;
import framework.tools.menu_gen;

/**
 *
 * @author osotemi
 */
public class BLL_profiles {

    public static int searchProfile() {
        Profiles sett;
        String sltSett = "";
        int pos = -3, al_size;
        String profiles[];

        al_size = singletonProfile.Alist_Profile.size();
        if (al_size == 0) {//Non settings on string
            pos = -1;
        } else {
            profiles = new String[al_size];
            for (int i = 0; i < al_size; i++) {
                sett = singletonProfile.Alist_Profile.get(i);
                profiles[i] = sett.getName();
            }

            sltSett = menu_gen.menucombo(profiles, "Default", "Select settings profile", "Profile settings");
            if (sltSett == null) {//Cross/Cancel Option
                pos = -2;
            } else {
                for (int j = 0; j < al_size; j++) {
                    if (singletonProfile.Alist_Profile.get(j).getName().equals(sltSett)) {
                        pos = j;
                    }
                }
            }
        }
        return pos;
    }
}
