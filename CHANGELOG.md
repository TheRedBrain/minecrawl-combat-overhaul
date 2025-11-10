# 1.0.0

TODO
- finish heavy attacks
  - animations
- first iteration of enchantments
- remove mana?

First release.

## Additions

- added a first iteration of "heavy attacks" to weapons
  - these are spells which are always bound to the use item hotkey
  - heavy attacks require special conditions to be available, depending on the weapon type:
    - daggers require a weapon of the same kind in the offhand
    - some weapons don't have heavy attacks
    - all other weapons require the 2-handed stance

## Changes

## Fixes

## Backend/Technical stuff

- adjusted default player attributes (attack damage and attack speed are now 0 by default), items were modified to account for this (this change should not result in any changes in game play, but is required for future gameplay features to work properly)
- using the 'Default Components' mod, all third-party items used by the mod pack are now configured via the built-in data pack. This will drastically improve efficiency when implementing future content updates and balancing tweaks.
- all weapon items were tweaked to use the "attackrangeattribute:generic.attack_range" entity attribute instead of the "minecraft:player.entity_interaction_range" attribute. There should be no consequences in regular gameplay.

#