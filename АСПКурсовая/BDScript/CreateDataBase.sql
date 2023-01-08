create database testKursDB;

-- 1. создавать таблицы нужно сверху вниз --
-- 2. потом добавить индексов в таблицы, когда примерно будет известно, какие запросы к ней будут делатьс€ --
-- 3. потом возможно как-то добавить фотографию в Ѕƒ --

drop table APUSERTEAM
drop table CONSTANT
drop table APUSERGAME
drop table TOURNAMENTTABLE
drop table TEAM
drop table COMMENT
drop table COMMENT
drop table GAME
drop table TOURNAMENT
drop table REQUEST
drop table NOTIFICATION
drop table APUSER


CREATE TABLE TOURNAMENTTABLE
(
   tournamentid    int,
   teamid          int,
   gamesnumber     int,
   gameswin        int,
   gamesdraw       int,
   gamesloss       int,
   goalsscored     int,
   goalsconseded   int,
   goalsdifference int,
   points          int,

   primary key(tournamentid, teamid),
   foreign key(tournamentid) references tournament(tournamentid),
   foreign key(teamid)     references team(teamid)
)

GO

CREATE TABLE NOTIFICATION
(
   notificationid        int,
   notificationdate      datetime2,
   notificationstatus    nvarchar(20),
   notificationrecipient int,

   primary key(notificationid),
   foreign key(notificationrecipient) references apuser(userid)
)

GO

CREATE TABLE REQUEST
(
   requestid        int,
   requesttype      nvarchar(20),
   requestdate      datetime2,
   requestrecipient int,
   requestsender    int,

   primary key(requestid),
   foreign key(requestrecipient) references apuser(userid),
   foreign key(requestsender)    references apuser(userid)
)

GO

CREATE TABLE MESSAGE
(
   messageid        int,
   messagetext      nvarchar(max),
   messagedatetime  datetime2,
   gameid           int,
   messagesender    int,

   primary key(messageid),
   foreign key(gameid)        references game(gameid),
   foreign key(messagesender) references apuser(userid)
)

GO

CREATE TABLE COMMENT
(
   commentid        int,
   commenttext      nvarchar(max),
   commenddatetime  datetime2,
   commentrecipient int,
   commentsender    int,

   primary key(commentid),
   foreign key(commentrecipient) references apuser(userid),
   foreign key(commentsender)    references apuser(userid)
)

GO

CREATE TABLE APUSERGAME
(
   gameid    int,
   userid    int,
   usertype  nvarchar(20),
  
   primary key(gameid, userid),
   foreign key(gameid)    references game(gameid),
   foreign key(userid) references apuser(userid)
)

GO

CREATE TABLE GAME
(
   gameid          int,
   gamename        nvarchar(50),
   gameadress      nvarchar(100),
   gamedate        datetime2,
   maxplayers      int,
   currentplayers  int,
   gamestatus      nvarchar(20),
   gameformat      nvarchar(10),
   firstteamgoals  int,
   secondteamgoals int,
   gametype        nvarchar(20),
   tournament      int,                 

   primary key(gameid),
   foreign key(tournament) references tournament(tournamentid)
)

GO

CREATE TABLE TOURNAMENT
(
   tournamentid        int,
   tournamentname      nvarchar(50),
   tournamentstartdate date,
   tournamentenddate   date,
   teamsnumber         int,
   tournamentprizefund decimal(10,2),
   tournamentstatus    nvarchar(20),
   usercreator         int,

   primary key(tournamentid),
   foreign key(usercreator) references apuser(userid)
)

GO

CREATE TABLE CONSTANT
(
   constantid    int,
   constanttype  nvarchar(20),
   constantname  nvarchar(20),
   constantvalue int,

   primary key(constantid)
)

GO

CREATE TABLE APUSERTEAM
(
   teamid int,
   userid int,
   usertype nvarchar(20),

   primary key(teamid, userid),
   foreign key(teamid) references team(teamid),
   foreign key(userid) references apuser(userid)
)

-- ѕомен€ть айди у команды на целое число

GO
CREATE TABLE TEAM
(
   teamid      int,
   teamname    nvarchar(50),
   createdate  datetime2,

   primary key(teamid),
)

-- ¬озможно эту таблицу придетс€ как-то стыковать, если мы будем использовать библиотечную таблицу дл€ входа --

CREATE TABLE APUSER
(
   userid           int,
   useremail        nvarchar(50),
   userpassword     nvarchar(10),
   userrole         nvarchar(10),
   userfirstname    nvarchar(50),
   userlastname     nvarchar(50),
   usersex          nvarchar(2),
   userposition     nvarchar(20),
   userdateofbirth  date,
   userstatus       nvarchar(20),

   primary key(userid),
)
