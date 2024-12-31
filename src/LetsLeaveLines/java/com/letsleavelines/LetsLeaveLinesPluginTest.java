package com.letsleavelines;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class LetsLeaveLinesPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(LetsLeaveLinesPlugin.class);
		RuneLite.main(args);
	}
}