package cn.minerealms.networktitle;

import net.minecraftforge.fml.common.*;
import org.apache.logging.log4j.*;
import net.minecraftforge.fml.common.event.*;

@Mod(modid = "networktitle", acceptedMinecraftVersions = "[1.10,1.12.2]")
public class NetworkTitle
{

    @SidedProxy(clientSide = "cn.minerealms.networktitle.ClientProxy")
    public static CommonProxy proxy;

    public static Logger logger;
    
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        NetworkTitle.proxy.preInit(event);
    }

    @Mod.EventHandler
    public void Con(final FMLConstructionEvent event) throws ReplaceException {
        NetworkTitle.proxy.Con(event);
    }
}
