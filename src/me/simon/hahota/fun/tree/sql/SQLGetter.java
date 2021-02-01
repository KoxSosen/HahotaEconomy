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
			if (!exists(uuid)) {
				PreparedStatement ps2 = plugin.SQL.getConnection().prepareStatement("INSERT IGNORE INFO discord_id"
						+ "(NAME,UUID VALUES (?,?)");
				ps2.setString(1, player.getName());
				ps2.setString(2, uuid.toString());
				ps2.executeUpdate();
				
				return;
				
			}
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
			// found player do nothing lool
			return true;
		}
		  return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
}
	public void addPoints(UUID uuid, int points) {
		try {
			PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE discord-id SET POINTS=? WHERE UUID=?");
			ps.setInt(1, (getPoints(uuid) + points));
			ps.setString(2, uuid.toString());
			ps.executeUpdate();
		} catch (SQLException e) {
		e.printStackTrace();
	}	
}	
	public int getPoints(UUID uuid) {
		try {
			PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT POINTS FROM discord_id WHERE UUUID=?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			int points = 0;
			if (rs.next()) {
				points = rs.getInt("POINTS");
				return points;
			}
		} catch (SQLException e) {
		e.printStackTrace();
		}
	return 0;
	}
}
	
