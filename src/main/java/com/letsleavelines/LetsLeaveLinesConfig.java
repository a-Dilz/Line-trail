package com.letsleavelines;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.Color;

@ConfigGroup("tilecolor")
public interface TileColorConfig extends Config
{
	@ConfigItem(
			keyName = "tileColor",
			name = "Tile Color",
			description = "Choose the color for tiles",
			position = 0
	)
	default int tileColor()
	{
		return Color.CYAN.getRGB(); // Default color
	}
}
