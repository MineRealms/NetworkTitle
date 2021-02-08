package cn.minerealms.networktitle;

import net.minecraftforge.common.config.*;
import net.minecraftforge.fml.common.event.*;

import java.io.*;

public class CommonProxy
{
    public static Configuration config;

    public void Con(final FMLConstructionEvent e) throws ReplaceException {

    }

    public void preInit(final FMLPreInitializationEvent e) {
        final File directory = e.getModConfigurationDirectory();
        CommonProxy.config = new Configuration(new File(directory.getPath(), "networktitle.cfg"));
        Config.readConfig();
    }
}
