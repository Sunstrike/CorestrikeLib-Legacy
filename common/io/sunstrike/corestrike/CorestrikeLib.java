package io.sunstrike.corestrike;

import io.sunstrike.corestrike.CoreLogger.LogLevel;

import java.util.ArrayList;
import java.util.Arrays;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

/**
 * @author      Sunstrike <sunstrike@azurenode.net>
 * @version     0.0.1
 * @since       2012-12-28
 */
public class CorestrikeLib extends DummyModContainer {

	/**
	 * Singleton instance
	 */
	@Instance("CorestrikeLib")
	public static CorestrikeLib instance;
	
	/**
	 * FML sided proxy
	 */
	@SidedProxy(clientSide = "io.sunstrike.corestrike.ClientProxy", serverSide = "io.sunstrike.corestrike.CommonProxy")
	public static CommonProxy proxy;
	
	/**
	 * Shared logger for the whole mod.
	 * 
	 * @see io.sunstrike.corestrike.CoreLogger
	 */
	public static CoreLogger logger = new CoreLogger(LogLevel.DEBUG);
	
	/**
	 * Mod constructor.
	 * 
	 * Builds the base mod and provides metadata.
	 */
	public CorestrikeLib() {
		super(new ModMetadata());
		ModMetadata meta = super.getMetadata();
		meta.authorList = Arrays.asList(new String[] {"Sunstrike"});
		meta.description = "Coremod library for Forge";
		meta.modId = "CorestrikeLib";
		meta.version = "0.0.1";
		meta.name = "CorestrikeLib";
	}
	
	/**
	 * Standard registration for FML mod event bus.
	 * 
	 * @param bus FML event bus
	 * @param controller FML Load Controller
	 * @return Standard 'register' response
	 */
	public boolean registerBus(EventBus bus, LoadController controller) {
		bus.register(this);
		return true;
	}

	/**
	 * FML preinitializer.
	 * 
	 * Grab configs here
	 * 
	 * @param event FML Preinit event
	 */
	@Subscribe
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		config.addCustomCategoryComment(Configuration.CATEGORY_GENERAL, "LogLevel IDs: 4=DEBUG, 3=VERBOSE, 2=INFO, 1=SPARSE");
		int logLvl = config.get(Configuration.CATEGORY_GENERAL, "LogLevel", 4).getInt(4);
		config.save();
		switch (logLvl) {
		case 4:
			logger.setLogLevel(LogLevel.DEBUG);
			break;
		case 3:
			logger.setLogLevel(LogLevel.VERBOSE);
			break;
		case 2:
			logger.setLogLevel(LogLevel.NORMAL);
			break;
		default:
			logger.setLogLevel(LogLevel.SPARSE);
			break;
		}
	}

	/**
	 * FML initializer.
	 * 
	 * @see io.sunstrike.corestrike.CommonProxy
	 * @see io.sunstrike.corestrike.ClientProxy
	 * @param event FML Init event
	 */
	@Subscribe
	public void load(FMLInitializationEvent event) {
		
	}

	/**
	 * FML postinitializer.
	 * 
	 * @param event FML Postinit event
	 */
	@Subscribe
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
}
