package me.simon.hahota.fun.tree.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import me.simon.hahota.fun.tree.Main;

public class SQLGetter {
	
	private Main plugin;
	public SQLGetter(Main plugin) {
	this.plugin = plugin;
	}	
	
	public void createTable() {
		PreparedStatement ps;
		try {
			ps = plugin.SQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXITS discord_ids "
					+ "(mcname VARCHAR(100), discordid VARCHAR(100), POINTS INT(100),PRIMARY KEY (discordid))");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}
 
}
