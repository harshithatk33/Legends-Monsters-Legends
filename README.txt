Legends and Monsters Game

Classes I have Used and their functionalities are as below :
Generic Class
Piece : This is the unit and smallest part of the board, Its a super Class which could be used in Game Board creation.
SingleBlocks : The Single Blocks Class will hold the game plots each piece - block. This may be further used to create the whole Map/Board structure.
               Piece is used for creating these singleBlocks. This is a common class that can be used by various board games.
Map : This class consists of the scalable board function for creation of any Board. class holds constructor methods and getters and setters for the dimension of the layout of any game
AsciiColors : This class consists of ascii Code for colors to use when required.
character : abstract class is an abstract class for the virtual constructor characterFactory. This class will hold common methods for various characters in the game and abstract functions.



Lengends specific Classes

LegendBlocks : Class LegendBloack is a dervied class of singleBlocks. This class has specific functionalities to Legends game Board-pieces.
Game Piece : This is the derived class of super class piece. This holds functionality to create object for level and healthpower and set getters and setters for these.
Game Map :  This Class consists of entire play arena for the game of Legends (8X8) and the methods to have fixed spots on the Board.
Monsters : Monsters class is inherited by the abstract class character, this class has specifics to the Monster class.
Heroes : Heroes class is inherited by the abstract class character, this class has specifics to the Heroes class


Spells :This class consists of different fields methods under spells and has getters and setters for this.
Potions:
weapons:
Armour: Armour class is inherited by the abstract class  Collectible, this class has specifics to the Armour feature of the game


BattleCommons : BattaleCommons : This class consists of all the common methods that is needed for a hero and a monster to battle.
CommonUtilities : This class consists of all the common utilities that is useful for directly calling frequently used functionalities.
AsciiColors : AsciiColors Class, this class has colors ascii codes that can be used by classes to use colors when needed.


