package com.withorcc.simplediscordrichpresence;
import com.withorcc.simplediscordrichpresence.Discord.RPC;
import com.withorcc.simplediscordrichpresence.config.Config;
import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
@Environment(EnvType.CLIENT)
public class SimpleDiscordRichPresence implements ClientModInitializer {

    private static SimpleDiscordRichPresence instance;

    public static SimpleDiscordRichPresence instance() {
        return instance;
    }

    public SimpleDiscordRichPresence() {
        instance = this;
    }

    static MinecraftClient client = MinecraftClient.getInstance();
    public static String username = client.getSession().getUsername();

    @Override
    public void onInitializeClient() {
        MidnightConfig.init("wirichpresence", Config.class);
        RPC prec = new RPC();
        Thread t = new Thread(prec);
        t.start();
    }
}
