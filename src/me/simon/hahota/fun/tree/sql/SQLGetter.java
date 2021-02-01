package me.simon.hahota.fun.tree.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.entity.Player;

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
	
	public void createPlayer(Player player) {
		try {
			UUID uuid = player.getUniqueId();
			PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * from discord_ids where UUID=?");
			ps.setString(1,uuid.toString());
			ResultSet results = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
	}
	}
	
	
	public boolean exists(UUID uuid) {
		try {
		PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * from discord_ids where UUID=?");
		ps.setString(1,uuid.toString());
		ResultSet results = ps.executeQuery();
		if (results.next()) {
			return true;
		}
		  return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
}
}
