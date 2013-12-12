AsciiStuff
==========

An api for creating pixel art in minecraft chat plugins

## What is it?

An API for developers to add blocks of color to chat and possibly create pictures within chat such as the ones seen here http://imgur.com/a/hoxLD

##Issues

Issues and feature requests should be posted on the Github Issue Tracker.

##How to use
Add the jar to the build path of your plugin.
Create a new AsciiStuff object
      AsciiStuff asciiStuff = new AsciiStuff();
Use the methods to create the art in the chat box

##Example
```java
player.sendMessage(asciiStuff.skinLine("RED", "BLACK", "YELLOW", "RED", "RED", "YELLOW", "BLACK", "RED"));
```

##Example player faces

###On death

This prints lines to the dead player
```java
@EventHandler
public void onPlayerDeath(PlayerDeathEvent event) {
	Player p = event.getEntity().getPlayer();
	if(event.getEntity().getKiller() instanceof Player){
		asciistuff.printPlayerFace(p, event.getEntity().getKiller());
	}
}
```

###Other

Get face as a string list
```java
String playername = "Herobrine";
player.sendMessage(asciistuff.getPlayerFace(playername));
```