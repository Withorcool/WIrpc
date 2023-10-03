package com.withorcc.simplediscordrichpresence.Discord;

import com.withorcc.simplediscordrichpresence.SimpleDiscordRichPresence;
import com.withorcc.simplediscordrichpresence.config.Config;
import de.jcm.discordgamesdk.Core;
import de.jcm.discordgamesdk.CreateParams;
import de.jcm.discordgamesdk.activity.Activity;
import net.minecraft.client.resource.language.I18n;

import java.io.File;
import java.io.IOException;
import java.time.Instant;

import static com.withorcc.simplediscordrichpresence.config.Config.ClientId;

public class RPC implements Runnable{
    @Override
    public void run(){
        File discordLibrary = null;

        try {
            discordLibrary = DownloadNativeLibrary.downloadDiscordLibrary();
        } catch (IOException var14) {
            throw new RuntimeException(var14);
        }

        if (discordLibrary == null) {
            System.err.println("Error downloading Discord SDK.");
            System.exit(-1);
        }

        Core.init(discordLibrary);
        CreateParams params = new CreateParams();
        Activity activity = new Activity();
        try {
            if(!ClientId.isEmpty()) params.setClientID(Long.parseLong(ClientId));
            params.setFlags(CreateParams.getDefaultFlags());
            Core core = new Core(params);

            try {


                try {
                    if(Config.DisplayUsername) {
                        activity.setState("Username " + SimpleDiscordRichPresence.username);
                    }
                    activity.timestamps().setStart(Instant.now());

                    if(Config.DisplayLargeImage) activity.assets().setLargeImage(Config.LargeImageID);
                    if(Config.DisplaySmallImage) activity.assets().setSmallImage(Config.SmallImageID);
                    activity.assets().setLargeText(Config.LargeImageText);
                    activity.assets().setSmallText(Config.SmallImageText);
                    //activity.setDetails(cmain.rpc_status);
                    core.activityManager().updateActivity(activity);
                } catch (Throwable var11) {
                    try {
                        activity.close();
                    } catch (Throwable var9) {
                        //var11.addSuppressed(var9);
                    }

                    //throw var11;
                }

                activity.close();

                while(true) {
                    //activity.setDetails(cmain.rpc_status);
                    if(!ClientId.isEmpty()) core.runCallbacks();
                    try {
                        Thread.sleep(16L);
                    } catch (InterruptedException var10) {
                        //var10.printStackTrace();
                    }
                }
            } catch (Throwable var12) {
                try {
                    core.close();
                } catch (Throwable var8) {
                    //var12.addSuppressed(var8);
                }

                //throw var12;
            }
        } catch (Throwable var13) {
            try {
                params.close();
            } catch (Throwable var7) {
//                var13.addSuppressed(var7);
            }

//            throw var13;
        }
    }
}
