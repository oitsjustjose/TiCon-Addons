package com.oitsjustjose.tinkers_addons.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.oitsjustjose.tinkers_addons.lib.Lib;

public class Log
{
	private static Logger LOGGER = LogManager.getLogger(Lib.MODID);

	public static void warn(String msg)
	{
		LOGGER.warn(msg);
	}

	public static void error(String msg)
	{
		LOGGER.error(msg);
	}

	public static void info(String msg)
	{
		LOGGER.info(msg);
	}

	public static void debug(String msg)
	{
		LOGGER.debug(msg);
	}
}
