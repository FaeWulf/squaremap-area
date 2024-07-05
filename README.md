# Squaremap Area for 1.21 fabric

Squaremap Area is an addon for the Squaremap mod that adds an "Area layer" to display configurable areas that the owner
wants to show on the map.

![Preview](https://github.com/FaeWulf/public-imgs/blob/main/mods/squaremap-area/preview.png?raw=true)

## Configuration

Upon first run, the mod will generate a `areas.json` file in the `squaremap` folder. Here is an example of the
default configuration:

```json
{
  "minecraft:overworld": {
    "identifier": "minecraft:overworld",
    "provider": "area_minecraft",
    "areas": []
  },
  "minecraft:the_nether": {
    "identifier": "minecraft:the_nether",
    "provider": "area_minecraft",
    "areas": []
  },
  "minecraft:the_end": {
    "identifier": "minecraft:the_end",
    "provider": "area_minecraft",
    "areas": []
  }
}
```

### Adding Areas

Users can add areas to the `"areas"` list in the `areas.json` file. Each area should follow this structure:

```json
{
  "name": "Area 3",
  "color": "#ff0000",
  "points": [
    {
      "z": cord,
      "x": cord
    },
    ...
  ]
}
```

- **name**: The name to display for the area.
- **color**: The color to display the area in hexadecimal format.
- **points**: A list of points that define the polygon of the area.

### Reloading Configuration

Owners can use the `/reload` command to update the data without restarting the server.

## Requirements

- Fabric API
- Squaremap

## Usage

1. Run the server to generate the initial configuration file.
2. Edit the `squaremap-areas.json` file to add the areas you want to display.
3. Use the `/reload` command to apply the changes.

## Support

For support, feature requests, or bug reports, please visit the mod's GitHub issues page.
or join my Discord server: [link](https://discord.gg/xZneCTcEvb)

## License

Feel free to use in modpack with proper credit, please don't redistribute it.

---