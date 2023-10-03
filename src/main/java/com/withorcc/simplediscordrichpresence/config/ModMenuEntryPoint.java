package com.withorcc.simplediscordrichpresence.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

public class ModMenuEntryPoint implements ModMenuApi {
    @Override public ConfigScreenFactory<?> getModConfigScreenFactory() { return parent -> Config.getScreen(parent, "wirichpresence"); }
}
