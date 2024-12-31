package com.letsleavelines;

import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.TilePaint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.Widget;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;
import java.awt.*;

@Slf4j
@PluginDescriptor(
		name = "LetsLeaveLines",
		description = "Colors all tiles your character moves on.",
		tags = {"tiles", "color", "visual"}
)
public class TileColorPlugin extends Plugin
{
	private final Client client;
	private Color tileColor = Color.CYAN;

	@Inject
	private TileColorPlugin(Client client)
	{
		this.client = client;
	}

	@Override
	protected void startUp()
	{
		log.info("TileColorPlugin started");
	}

	@Override
	protected void shutDown()
	{
		log.info("TileColorPlugin stopped");
	}

	@Subscribe
	private void onGameTick(GameTick event)
	{
		// This event is used to keep the plugin active and color tiles
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("tilecolor"))
		{
			tileColor = new Color(client.getConfig(TileColorConfig.class).tileColor());
		}
	}

	@Subscribe
	private void onTilePaint(TilePaint event)
	{
		if (event.getCanvas() != null)
		{
			for (Tile tile : client.getMapRegionsTiles())
			{
				if (tile != null && tile.getWorldLocation().isInScene())
				{
					if (tile.getWorldLocation().getPlane() == client.getPlane())
					{
						event.getCanvas().drawTile(tile.getLocalLocation(), tileColor, Perspective.HEIGHTmapElevation(tile), Perspective.LOCAL_HEIGHT, Perspective.LOCAL_HEIGHT);
					}
				}
			}
