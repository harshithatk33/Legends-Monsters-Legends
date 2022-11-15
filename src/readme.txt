Author : Harshitha Tumkur Kailasa Murthy
Date : Nov 8

Legends and Monsters Game 👹👾🧌🧑🏼‍🦱
Bonus : Factory pattern used, Please keep the volume up to listen to the ongoing background music as you play the game and added board Map text Colors.

Classes I have Used and their functionalities are as below :
Generic Class
Piece : This is the unit and smallest part of the board, Its a super Class which could be used in Game Board creation.
SingleBlocks : The Single Blocks Class will hold the game plots each piece - block. This may be further used to create the whole Map/Board structure.
               Piece is used for creating these singleBlocks. This is a common class that can be used by various board games.
Map : This class consists of the scalable board function for creation of any Board. class holds constructor methods and getters and setters for the dimension of the layout of any game
AsciiColors : AsciiColors Class, this class has colors ascii codes that can be used by classes to use colors when needed.
character : this class is an abstract class for the virtual constructor characterFactory. This class will hold common methods for various characters in the game and abstract functions.
Collectible : Class to hold the items needed for my marketPlace Class.


Lengends specific Classes

HeroesandMonsters - Main Class to be executed where i have called the required functionalities for the game to run smoothly.

LegendBlocks : Class LegendBloack is a dervied class of singleBlocks. This class has specific functionalities to Legends game Board-pieces.
Game Piece : This is the derived class of super class piece. This holds functionality to create object for level and healthpower and set getters and setters for these.
Game Map :  This Class consists of entire play arena for the game of Legends (8X8) and the methods to have fixed spots on the Board.
Monsters : Monsters class is inherited by the abstract class character, this class has specifics to the Monster class.
Heroes : Heroes class is inherited by the abstract class character, this class has specifics to the Heroes class
characterFactory : is an abstract class for the virtual constructor for producing Characters for the game.

Spells :This class consists of different fields methods under spells and has getters and setters for this, Class Collectible implemented.
Potions:This class consists of different fields methods under potions and has getters and setters for this, Class Collectible implemented.
weapons:This class consists of different fields methods under weapons and has getters and setters for this, Class Collectible implemented.
Armour: Armour class is inherited by the abstract class Collectible, this class has specifics to the Armour feature of the game

CollectibleFactory : design pattern/virtual constructor implemented to hold common functionalities of the Collectible class for this game.
CollectibleProducer : produces the collectibles to create inventory to be used for heroes.
BattleCommons : BattaleCommons : This class consists of all the common methods that is needed for a hero and a monster to battle.
CommonUtilities : This class consists of all the common utilities that is useful for directly calling frequently used functionalities.

MarketPlace: This Class consists of all methods for SWAP functionalities.
Teams: Common Class used to create Teams inside the Monster and Heroes classes.
Battle: Battle Class has battle implementation.


Run Code instructions :
Volume UP!!
Unzip and execute Driver Class : Legends&Monsters
javac -d bin src/*.java
java -cp bin Legends&Monsters

information for graders:
the ascii codes for Ascii Class is taken from intenet
sound functionality files are downloaded from internet and are under sounds files.
tried to implement font type but didnt have time.


HOPE YOU ENJOY PLAYING ONCE "🤞🤞"(fingersCrossed)

