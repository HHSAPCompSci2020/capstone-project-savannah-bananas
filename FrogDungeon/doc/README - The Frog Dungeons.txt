The Frog Dungeons[a]
Authors: Jeremy Mills, Justin Hwang, Mikaela Kwan
Revision: 4/25/21


Introduction[b]: 
Two weeks ago, the fair Princess Gorf of the Frog Kingdom was kidnapped by the evil Frog Sorcerer and trapped in a magical dungeon. It is your job, as a frog adventurer, to rescue her and restore peace to the kingdom!


In order to rescue Princess Gorf, you must pass through a large maze-- one that is different each time you embark on the quest!  As you progress, you gain stronger items that will boost your skills, but beware! Enemies also become more powerful as you advance deeper into the dungeon. If you get knocked out, you are sent back to the beginning to restart your quest.


Use weapons, melee and ranged, to defeat the Frog Sorcerer’s army of monsters and save Princess Gorf. Enemies will drop weapons and other useful items for your task. 


Instructions[c]:
Starting Screen:
Instructions[d], Start / Resume Game, and Exit buttons.


Start / Resume Game:
After you click “Start / Resume Game”, you’ll be asked if you would like to start a new game, or resume an existing one. If you’ve never played before, “New game” will be the only option.



The dungeon is a large maze! Find your way through each room, fighting monsters and gaining items as you go, to find the Frog Sorcerer-- the final boss!


 Use WASD to move your character, left click to use a melee attack, right click to use a ranged attack, and space to pick up items or interact with NPCs. 


The doors in each new room will lock the moment the player enters and will not unlock until all enemies within have been killed. After passing through a certain number of rooms, the next room the player enters will be the final boss room. Upon defeating the Frog Sorcerer, the game ends.




Features List (THE ONLY SECTION THAT CANNOT CHANGE LATER):
Must-have Features:[e]
* Movable Frog character that can have 2 weapons (1 melee and 1 projectile). WASD to move, left click to use the melee weapon, right click to use projectile weapons. Space bar to “access” chests, doors etc.
* Moving monsters that attack the player.
* Bird’s eye view dungeon, shaped like a large maze, with rooms/hallways. The end of the maze is where the Frog Sorcerer dwells.
* Rooms that contain monsters and loot that you are locked in until you defeat the monsters and a final boss room.
* Health that can be increased with loot, as well as armor you can increase with loot.
* Randomly generated maze each time the program is run.


Want-to-have Features:[f]
* Toggleable difficulty levels - Easy, Normal, Hard. 
   * Easy: enemies have lower health and player is given additional hearts
   * Normal: all normal functions
   * Hard: enemies have high health and the player is given less hearts.
* Items such as potions that give temporary buffs.
* Once defeating Frog Sorcerer, the player can either end the game or continue exploring (rooms continue generating).
* Obstacles such as rocks and logs within rooms to make combat more interesting.
* Different enemies as rooms progress.
* Currency (flies) that can be spent at special shopkeeper rooms for items.
* A save feature, that allows you to save your progress. When you leave the game and rejoin, you are put back where you left off. When you die, you will go back to the start. [g]


Stretch Features:[h]
* Dungeon keys that open rooms that have increased loot. Dungeon keys will be obtained like other items.
* Miniboss rooms
* Custom textures and sprites
* Variation in room theme (such as a water themed room) with corresponding themed enemies.




Class List:[i]
* Entity (Superclass for any entity on the maze) X
[j]
   * Frog[k]
   * Monster (Superclass for enemies)
      * Fly (Weakest Monster)
      * Snake
      * Sorcerer (Final boss at end of dungeon)
      * //More Monster creatures TBD
* MeleeWeapon (Superclass for Melee weapons) X
   * Knife
   * Sword
   * Hammer
* ProjectileWeapon (Superclass for Projectile weapons) X
   * Bow
   * Pistol
   * Rifle
   * //More weapons could be added later.
* Projectile
* abstract Item (Superclass for items) X
   * HealthPotion
   * SpeedPotion
   * StrengthPotion
* Main
* DrawingSurface extends PApplet
* interface ScreenSwitcher
* abstract Screen (Contains a DrawingSurface, and uses PApplet methods) X
   * MenuScreen
   * PauseScreen
   * FrogDungeon (DrawingSurface Equivalent)
   * InfoScreen
* Wall (Wall that the Dungeon is generally made of) X
* Button
* ButtonListener


LINK TO UML


Credits[l][m]:
* Justin - Graphics and game function
* Jeremy - Frog, Weapons, Monsters, Items
* Mikaela - Art, Weapons, Monsters




