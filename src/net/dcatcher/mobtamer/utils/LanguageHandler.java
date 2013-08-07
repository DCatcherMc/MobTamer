package net.dcatcher.mobtamer.utils;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class LanguageHandler {

    private static final String LANGUAGE_LOCATION = "/assets/dcmodjam/lang/";
    public static String[] localeFiles = {LANGUAGE_LOCATION + "en_US.xml"};

    public static void loadLangs(){
        for(String file : localeFiles){
            LanguageRegistry.instance().loadLocalization(file, "en_US", true);
        }
    }

    public static String getName(String name){
        name = name.substring(1, 6);
        return name;
    }
}
