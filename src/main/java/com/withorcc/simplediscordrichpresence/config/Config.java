package com.withorcc.simplediscordrichpresence.config;

import eu.midnightdust.lib.config.MidnightConfig;

public class Config extends MidnightConfig {
    @Entry(name = "RPC ClientId") public static String ClientId = "1158765176070348891";
    @Entry(name = "Display Username") public static boolean DisplayUsername = true;
    @Entry(name = "Display Large Image") public static boolean DisplayLargeImage = true;
    @Entry(name = "Large Image ID") public static String LargeImageID = "1";
    @Entry(name = "Large Image Text") public static String LargeImageText = "Large Image";

    @Entry(name = "Display Small Image") public static boolean DisplaySmallImage = true;
    @Entry(name = "Large Small ID") public static String SmallImageID = "2";
    @Entry(name = "Small Image Text") public static String SmallImageText = "Small Image";
}
