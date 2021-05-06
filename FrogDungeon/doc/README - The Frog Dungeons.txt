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
[a]Instructions:
The first step in creating an excellent APCS final project is to write up a README. At this stage, this README file acts as your project proposal. Once you’ve filled in all components, Shelby will read through it and suggest edits. Ultimately, you need a document that adequately describes your project idea and we must agree on this plan.


Have one member of your group make a copy of this Google Doc. Then, they should share it with all other members and with Mr. Shelby so that every group member has edit permissions, and Shelby can add comments on your ideas.


There’s a lot of parts of this document that you might not have full answers for yet. Because you haven’t written the program yet, it’s difficult to think about the instructions or which group members will do which parts. Even though this is hard to think about, you must have something in these sections that acts as your current plan. However, during the course of the project, you’ll continuously update this document. This means that you will not be held to exactly what you put here - components of this document can change (and it’s pretty common!).


There is one exception: the Features List section. Once Shelby OKs your README, the Features List section cannot be modified. For this reason, it is most important that you get a solid idea of what you want to make and the primary features it will have now.


Talk with your group. Consider drawing some pictures of what you think your project might look like. Be precise. When you’re ready, fill this out together. Each component in brackets below ( [these things] ) should be replaced with your ideas. Note that there are several sample READMEs posted on this assignment for you to use as guidance.
[b][In a few paragraphs totaling about ½ page, introduce the high-level concept of your program. What this looks like depends a lot on what type of thing you are making. An introduction for an application will look different than one for a game. In general, your introduction should address questions like these:


What does your program do?
What problem does it solve? Why did you write it?
What is the story?
What are the rules? What is the goal?
Who would want to use your program?
What are the primary features of your program?]
[c][Explain how to use the program. This needs to be specific: 
Which keyboard keys will do what? 
Where will you need to click? 
Will you have menus that need to be navigated? What will they look like? 
Do actions need to be taken in a certain order?]
[d]eventually, it would be good to list all the items/weapons they can collect and what they do
[e][These are features that we agree you will definitely have by the project due date. A good final project would have all of these completed. At least 5 are required. Each feature should be fully described (at least a few full sentences for each)]
[f][These are features that you would like to have by the project due date, but you’re unsure whether you’ll hit all of them. A good final project would have perhaps half of these completed. At least 5 are required. Again, fully describe each.]
[g]is this within one run, or does it commit somehow to local storage on your computer?
[h][These are features that we agree a fully complete version of this program would have, but that you probably will not have time to implement. A good final project does not necessarily need to have any of these completed at all. At least 3 are required. Again, fully describe each.]
[i][This section lists the Java classes that make up the program and very briefly describes what each represents. It’s totally fine to put this section in list format and not to use full sentences.]
[j]you should probably put more detail about what exactly these all are and why theyre different
[k]classes look really good and cohesive!
[l]List the group members and describe how each member contributed to the completion of the final program. This could be classes written, art assets created, leadership/organizational skills exercises, or other tasks. Initially, this is how you plan on splitting the work.
Give credit to all outside resources used. This includes downloaded images or sounds, external java libraries, parent/tutor/student coding help, etc.]
[m][Gives credit for project components. This includes both internal credit (your group members) and external credit (other people, websites, libraries). To do this: