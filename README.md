# SMPCore

## Overview

Java Plugin Made for Spigot API and uses EventHandlers to check for location of player within game.

## Features

* Makes use of Java HashMaps and Listeners to store locations and actively update calling players compass.
* Iterates through player inventory to determine if compass exists and supplies one if found.
* Makes use of abstract class to organize commands through a command manager and a subcommand abstract class.
* Main class delivers instance of itself to other command classes in order to allow registering of player command calls.
* Command Manager class contains private inner class and an iterator which parses player sent string and pairs subcommand to respective command class and methods.
