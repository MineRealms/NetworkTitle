package cn.minerealms.networktitle;

import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.event.*;



public class ClientProxy extends CommonProxy
{
    @Override
    public void Con(final FMLConstructionEvent e) throws ReplaceException {
        super.Con(e);
         ReplaceTitle.Replace();
        FMLLog.log.info("已替换窗口标题");
    }
}

