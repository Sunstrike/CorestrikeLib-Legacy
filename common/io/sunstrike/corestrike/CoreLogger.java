package io.sunstrike.corestrike;

import io.sunstrike.corestrike.CoreLogger.LogLevel;

import java.util.ArrayList;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLCommonHandler;

/**
 * Logger type which prepends the severity, mod name and log item module (i.e. "[~~][Corestrike][Core] Message")
 * 
 * @author Sunstrike <sunstrike@azurenode.net>
 * @since 2012-12-28
 */
public class CoreLogger {
	
	public enum LogLevel {
		DEBUG,
		VERBOSE,
		NORMAL,
		SPARSE
	}
	
	public enum Origin {
		Core,
		Crafting
	}
	
	private Logger fmlLog = FMLCommonHandler.instance().getFMLLogger();
	private static String modname = "[CorestrikeLib]";
	private ArrayList<LogLevel> level = new ArrayList<LogLevel>();
	
	/**
	 * Primary constructor - Sets the log level as part of construction
	 * 
	 * @param lvl Log level to start in
	 */
	public CoreLogger(LogLevel lvl) {
		switch (lvl) {
		case DEBUG:
			level.add(LogLevel.DEBUG);
		case VERBOSE:
			level.add(LogLevel.VERBOSE);
		case NORMAL:
			level.add(LogLevel.NORMAL);
		case SPARSE:
			level.add(LogLevel.SPARSE);
			break;
		}
	}
	
	private String __getOriginDesc(Origin ori) {
		switch(ori) {
		case Core:
			return "[Core]";
		case Crafting:
			return "[CraftProxy]";
		default:
			return "[~~UNKNOWN~~]";
		}
	}
	
	public void severe(Origin src, String msg) {
		if (level.contains(LogLevel.SPARSE)) {
			fmlLog.severe(modname + __getOriginDesc(src) + "[!!] " + msg);
		}
	}
	
	public void NORMAL(Origin src, String msg) {
		if (level.contains(LogLevel.NORMAL)) {
			fmlLog.info(modname + __getOriginDesc(src) + "[~~] " + msg);
		}
	}
	
	public void verbose(Origin src, String msg) {
		if (level.contains(LogLevel.VERBOSE)) {
			fmlLog.fine(modname + __getOriginDesc(src) + "[++] " + msg);
		}
	}
	
	public void debug(Origin src, String msg) {
		if (level.contains(LogLevel.DEBUG)) {
			fmlLog.fine(modname + __getOriginDesc(src) + "[&&] " + msg);
		}
	}
	
	/**
	 * Change the loggers verbosity from LogLevel enum
	 * 
	 * @param lvl New log level for this logger
	 */
	public void setLogLevel(LogLevel lvl) {
		level.clear();
		switch(lvl) {
		case DEBUG:
			level.add(LogLevel.DEBUG);
		case VERBOSE:
			level.add(LogLevel.VERBOSE);
		case NORMAL:
			level.add(LogLevel.NORMAL);
		case SPARSE:
			level.add(LogLevel.SPARSE);
		}
	}

}
