# CPSC304Project_project_a7z2b_e7s2b_h0z1b
# Aim
This project aims to create a game launcher. Therefore, the domain we focus on is game
datas. The first part of this launcher is a platform, which may run in MacOs or PC with its unique
ID, we use a ISA relationship to represent it. Then there is an aggregation relation of user and
game. This aggregation owns game record, which is also a weak entity to it. If a user logs out
from a game, the game record would also be erased. Then, games are classified to be a singleplayer
game and multi-player game with unique game ID. The users can have different options
to play it. Games can run on platform, and there are many hubs owned by game. In the hubs,
there is a game market that user can create transactions on it. User also has an achievement
system to record some meaningful moments in the games.
# Methodology
The database records the information of each account and builds logical relationships
between entries. It means the data is sorted and stored in a proper way. For application, firstly,
it can use the database structure to build UI, like what information should be collected, what is
its type and if there should have a quick access button to imply the relationship between two
entries. Then, it benefits the data operations, the database provide proper positions for the
data to store in, informs works more like some individual parts not as a whole, so users can
show the inform they want others see like achievement and hide what they don't want to show
like personal information. Also, it can protect the data security, only the data of the specific account
and platform will be store in that device, information of other account won't be appeared,
and if some parts of database were hacked unfortunately, good news is other information
is ok, we just need to find and fix the hacked parts, if there is no such database, all data
stored together, then the loss will be credible large.
# Tool
This database would be written by Java and SQL. Any other special hardware would
not be used.
