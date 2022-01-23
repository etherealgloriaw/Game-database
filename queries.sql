
-- Insert

INSERT INTO Game
VALUES (?,?,?,?)
--?: (1,GameID), (2,gameName), (3,rank), (4,version)

INSERT INTO GameCompany
VALUES (?,?)
--?: (1,CName), (2,Country)

INSERT INTO DevelopGame
VALUES (?,?,?)
--?: (1,GameID), (2,CName), (3,releaseDate)

INSERT INTO SellGame
VALUES (?,?,?)
--?: (1,GameID), (2,HubID), (3,price)

INSERT INTO Hub
VALUES (?,?)
--?: (1,HubID), (2,HubArea)

INSERT INTO Community
VALUES (?,?)
--?: (1,CommunityID), (2,HubID)

INSERT INTO User
VALUES (?,?,?)
--?: (1,UserID), (2,age),(3, accountbalance)

INSERT INTO MakeComment
VALUES (?,?,?,?)
--?: (1,UserID ), (2,CommunityID ), (3,CommentID ), (4,comments)

INSERT INTO Acheivement
VALUES (?,?)
--?: (1,AcheinementName),(2, rareness)

INSERT INTO GetAcheivement
VALUES (?,?,?)
--?: (1,UserID), (2,AcheivementName),(3, AcheiveDate)

INSERT INTO Device
VALUES (?,?,?)
--?: (1,DeviceID), (2,systemVersion),(3, UserID)

INSERT INTO GameRecord
VALUES (?,?,?,?)
--?: (1,GameID ), (2,UserID ), (3,RecordID ), (4,RecordDate)

INSERT INTO AmateurUser
VALUES (?,?)
--?: (1,GameID ), (2, CollectionRate)

INSERT INTO ProfessionalUser
VALUES (?,?)
--?: (1,GameID ), (2,Ranking)
--------------------------------------------------------------------------

-- delete
DELETE FROM GameCompany
WHERE companyname = ?
--?: (1, companyname)

DELETE FROM DevelopGame
WHERE GameID = ? AND companyname = ?
--?: (1, GameID),(2, companyname)

DELETE FROM SellGame
WHERE gameID  = ? AND hubID = ?
--?: (1,gameID),(2,hubID)

DELETE FROM Hub, SellGame, Community
WHERE hubID = ?
--?: (1, hubID)

DELETE FROM User, MakeComment, Acheivement, Device, GameRecord
WHERE UserID = ?
--?: (1,UserID)

DELETE FROM MakeComment
WHERE UserID = ?  AND communityID = ? AND CommentID = ?
--?: (1,UserID),(2,communityID), (3,CommentID)

DELETE FROM Acheivement, GetAcheivement
WHERE Acheivename = ? 
--?: (1,Acheivename)

DELETE FROM GetAcheivement
WHERE UserID = ?  AND AchievementName = ?
--?: (1,UserID),(2,AchievementName)

DELETE FROM GameRecord
WHERE gameID = ?  AND userID = ? AND RecordID =?
--?: (1,gameID),(2,userID),(3, RecordID)

------------------------------------------------------------------------
-- update
-- Only list some interesting update, not all possible ones

-- (1) GAME
-- game is update to a new version
UPDATE Game
SET version = ?
WHERE gameID  = ?
--?: (1,gameID),(2,version)

-- game is update to a new rate
UPDATE Game
SET rate = ?
WHERE gameID  = ?
--?: (1,gameID),(2,rate)

-- change price of game in specific hub
UPDATE SellGame
SET price = ?
WHERE gameID  = ? AND HubID = ?
--?: (1,gameID),(2,HubID), (3, price)

-- (2) User
-- update user's account balance
UPDATE User
SET accountbalance = ?
WHERE UserID  = ?
--?: (1,UserID),(2,accountbalance)

-- change the comment content
UPDATE MakeComment
SET comments = ?
WHERE UserID  = ? AND CommunityID = ? AND CommentID = ?
--?: (1,UserID),(2,CommunityID),(3,CommentID),(4,comments)

---------------------------------------------------------------
-- Selection
-- find the gameInfo that rate > 4
SELECT * FROM Game WHERE Rate > 4
---------------------------------------------------------------
-- Projection
-- sort the released games after the given date by rate(id,name)
--Inputs: date
SELECT g.GameID, g.gameName, g.Rate
FROM DevelopGame d, Game g
WHERE d.releaseDate > ? AND d.GameID = g.GameID
ORDER BY g.rate DESC;
--?: (1,date)
---------------------------------------------------------------
-- Join
-- given a gameID, join the amateurUser and MakeComment table to 
-- find the comment of user with more than 80% collectionrate in this game.
-- Input: gameID
SELECT * FROM amateurUser u natural join MakeComment mc
WHERE u.gameID = ? AND u.CollectionRate>80% AND mc.comment IS NOT NULL
------------------------------------------------------------------
-- Aggregation with Group By
-- find the highest age in each game, where the collectionRate must be greater than 50%
SELECT gameID, MAX(age)
FROM AmateurUser
WHERE CollectionRate>=50%
GROUP BY gameID
------------------------------------------------------------------
-- Aggregation with Having
-- find the active user(comments>10) in a given community, ordered by DESC
-- Input: CommunityID
SELECT u.UserID
FROM User u, MakeComment mc
WHERE mc.CommunityID = ? AND u.UserID = mc.UserID  
GROUP BY mc.UserID
HAVING COUNT(mc.UserID) > 10
ORDER BY COUNT(mc.UserID) DESC;
------------------------------------------------------------------
-- Nested Aggregation with Group By
-- finding the earlist developed game of each gameCompany, given that the price of game is
-- not 0, which means it's not a demo.
SELECT d.CompanyName, d.GameID, MIN(d.ReleaseDate)
FROM DevelopGame d
GROUP BY CompanyName
HAVING 0 < ( SELECT s.price
                    FROM SellGame s
                    WHERE s.GameID = d.GameID);
------------------------------------------------------------------
-- Division
-- find players had got every achievement
SELECT UserID
FROM User u
WHERE NOT EXISTS
     ((SELECT a.AchievementName
     FROM Acheivement a)
     EXCEPT
     (SELECT g.AchievementName 
     FROM  GetAcheivement g
     WHERE u.UserID = g.UserID));
------------------------------------------------------------------     

    



