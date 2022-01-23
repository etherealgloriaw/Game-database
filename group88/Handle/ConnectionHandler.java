package group88.Handle;
import group88.tables.*;
import java.sql.*;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConnectionHandler {
    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private Connection connection = null;
	public ConnectionHandler() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		}
		catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.exit(-1);
		}
	}

	public boolean login(String username, String password) {
		try {
			if (connection != null) {
				connection.close();
			}

			connection = DriverManager.getConnection(ORACLE_URL, username, password);
			connection.setAutoCommit(false);

			System.out.println("\nConnected to Oracle!");
			return true;
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			return false;
		}
	}

	//selection query
	public List<Game> viewGames() {
		List<Game> result = new ArrayList<>();

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Game WHERE Rate > 4");
			ResultSetMetaData rsmd = rs.getMetaData();

			while(rs.next()) {
				Game newGame = new Game(rs.getString("GameID"),
										rs.getString("gameName"),
										rs.getFloat("Rate"),
										rs.getFloat("Version"));
				result.add(newGame);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}	
		
		return result;
	}

	public List<User> viewUsers() {
		List<User> result = new ArrayList<>();
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM GameUser");
			while(rs.next()) {
				User newUser = new User(rs.getString("UserID"),
										  rs.getInt("Age"),
										  rs.getFloat("AccountBalance"));
				result.add(newUser);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}	
		
		return result;
	}

	public List<GameRecord> viewGameRecord() {
		List<GameRecord> result = new ArrayList<>();
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM GameRecord");
			while(rs.next()) {
                GameRecord newRecord = new GameRecord(rs.getString("GameID"),
										rs.getString("UserID"),
										rs.getString("RecordID"),
										rs.getTimestamp("GameDate"));
				result.add(newRecord);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}	
		
		return result;
	}

	public List<MakeComment> viewComments() {
		List<MakeComment> result = new ArrayList<>();

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM MakeComment");
			while(rs.next()) {
				MakeComment newComment = new MakeComment(rs.getString("UserID"),
													  rs.getString("CommunityID"),
													  rs.getString("CommentID"),
													  rs.getString("Comments"));
				result.add(newComment);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}	
		
		return result;
	}

	public List<SellGame> viewSellGame() {
		List<SellGame> result = new ArrayList<>();

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM SellGame");
			while(rs.next()) {
				SellGame newGame = new SellGame(rs.getString("GameID"),
												rs.getString("HubID"),
											    rs.getFloat("Price"));
				result.add(newGame);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}	
		
		return result;
	}

	// delete query
	public boolean deleteComment(String UserID, String CommunityID, String CommentID) throws SQLException {
		PreparedStatement prepState = connection.prepareStatement
				("delete from MAKECOMMENT where COMMENTID = ?");
		prepState.setString(1,CommentID);
		int result = prepState.executeUpdate();
		connection.commit();
		return result == 1;
    }

    // insert query
    public boolean addGameRecords(String GameID, String UserID) throws SQLException {
        String currentTime = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
		String RecordID = currentTime + UserID;
        PreparedStatement prepState = connection.prepareStatement
                ("insert into GameRecord values(?,?,?,CURRENT_TIMESTAMP)");
        prepState.setString(1,GameID);
        prepState.setString(2,UserID);
        prepState.setString(3,RecordID);
		int result = prepState.executeUpdate();
		connection.commit();
		return result == 1;
    }

    // update query
    public boolean updatePrice(String GameID, String HubID, String newPrice) throws SQLException {
		PreparedStatement prepState = connection.prepareStatement
				("update SellGame set Price = ? where GameID LIKE ? AND HubID LIKE ?");
		prepState.setFloat(1, Float.parseFloat((newPrice)));
		prepState.setString(2,GameID);
		prepState.setString(3, HubID);
		int result = prepState.executeUpdate();
		connection.commit();
		return result == 1;

    }

    // projection query
    // sort the released games after the given date by rate(id,name)
    public List<String[]> sortGameofInputYear(String year) {
		List<String[]> result = new ArrayList<>();
		String[] colName = {"GameID", "gameName", "Rate"};
		result.add(colName); 
		try {
			PreparedStatement prepState;
			String startdate = year + "-01-01";
    		String enddate =  year + "-12-31";
			String sql = ("SELECT d.GameID, g.GAMEID, g.gameName, g.Rate FROM DevelopGame d, Game g" +
				" WHERE d.releaseDate >= TO_TIMESTAMP (?, 'YYYY-MM-DD') " +
				" AND d.releaseDate <= TO_TIMESTAMP(?, 'YYYY-MM-DD')" + " AND d.GAMEID = g.GameID " + "ORDER BY g.rate DESC");
			prepState = connection.prepareStatement(sql);
			prepState.setString(1, startdate);
			prepState.setString(2, enddate);
            ResultSet rs = prepState.executeQuery();
			while(rs.next()) {
				String[] row = new String[colName.length];
				row[0] = rs.getString("GameID");
				row[1] = rs.getString("gameName");
				row[2] = rs.getString("Rate");
				result.add(row);
			}
			rs.close();
            prepState.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}	
		return result;
	}

	// join query
	// given a gameID, join the amateurUser and MakeComment table 
	// to find the comment of user with more than 80% collectionrate in this game.
    public List<String[]> findMasterComment(String GameID) {
		List<String[]> result = new ArrayList<>();
		String[] colName = {"userID", "GameID", "CollectionRate","CommunityID", "CommentID", "Comments"};
		result.add(colName); 
		try {
			PreparedStatement prepState;
            String sql = ("SELECT * FROM amateurUser u NATURAL join MakeComment\n" +
					"    WHERE GAMEID = ? AND u.COLLECTIONRATE>=0.8");
			prepState = connection.prepareStatement(sql);
			prepState.setString(1, GameID);
            ResultSet rs = prepState.executeQuery();
			while(rs.next()) {
				String[] row = new String[colName.length];
				row[0] = rs.getString("userID");
				row[1] = rs.getString("GameID");
				row[2] = String.valueOf(rs.getFloat("CollectionRate"));
				row[3] = rs.getString("CommunityID");
				row[4] = rs.getString("CommentID");
				row[5] = rs.getString("Comments");
				result.add(row);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}	
		return result;
	}

	// Aggregation with Group By query
	// find the highest age in each game, where the collectionRate must be greater than 50%
    public List<String[]> gethighestageineachGame() {
    	List<String[]> result = new ArrayList<>();
		String[] colName = {"gameID", "age"};
		result.add(colName); 
		try {
            Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT gameID, MAX(age) FROM AmateurUser NATURAL join GAMEUSER G" +
					" WHERE CollectionRate >= 0.5 GROUP BY gameID");
			while(rs.next()) {
				String[] row = new String[colName.length];
				row[0] = rs.getString("gameID");
				row[1] = String.valueOf(rs.getInt("MAX(age)"));
				result.add(row);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}	
		return result;
    }

    // Aggregation with Having query
    // find the active user(comments>10) in a given community, ordered by DESC
    public List<String> viewActiveUsers(String CommunityID) {
		List<String> result = new ArrayList<String>();
		try {
			PreparedStatement prepState;
            String sql = ("SELECT u.UserID FROM GameUser u, MakeComment mc\n" +
					"WHERE mc.CommunityID = ? AND u.UserID = mc.UserID\n" +
					"GROUP BY mc.UserID HAVING COUNT(mc.UserID) > 3 ORDER BY COUNT(mc.UserID) DESC");
			prepState = connection.prepareStatement(sql);
			prepState.setString(1, CommunityID);
            ResultSet rs = prepState.executeQuery();
			while(rs.next()) {
				String newActiveUser = rs.getString("UserID");
				result.add(newActiveUser);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}	
		return result;
	}

	// Nested Aggregation with Group By
	// finding the earlist developed game of each gameCompany, given that the price of game is not 0, which means it's not a demo.
    public List<String[]> getearlistdevelopedGame() {
    	List<String[]> result = new ArrayList<>();
		String[] colName = {"CompanyName", "GameID","price"};
		result.add(colName); 
		try {
            Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COMPANYNAME, GAMEID, PRICE from DEVELOPGAME natural join SELLGAME where SELLGAME.PRICE>0");
			while(rs.next()) {
				String[] row = new String[colName.length];
				row[0] = rs.getString("CompanyName");
				row[1] = rs.getString("GameID");
				row[2] = String.valueOf(rs.getFloat("price"));
				result.add(row);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}	
		return result;
    }

    // Division query
    // find players had got every achievement
    public List<String> viewUsersWithFullAcheivement() {
		List<String> result = new ArrayList<String>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT u.UserID\n" +
					"FROM GAMEUSER u\n" +
					"WHERE NOT EXISTS\n" +
					"    ((SELECT a.AchievementName\n" +
					"      FROM Achievement a)\n" +
					"    MINUS\n" +
					"    (SELECT g.AchievementName\n" +
					"     FROM  GetAchievement g\n" +
					"     WHERE u.UserID = g.UserID))");
			while(rs.next()) {
				String newUser = rs.getString("UserID");
				result.add(newUser);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}	
		return result;
	}






}

