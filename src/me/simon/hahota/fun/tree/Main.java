package me.simon.hahota.fun.tree;


import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import mc.simon.hahota.fun.tree.sql.MySQL;

public class Main extends JavaPlugin {

 
    public MySQL SQL;

	@Override
    public void onEnable()  {
    	this.SQL = new MySQL();
    	
    	try  { 	
    		SQL.connect();
  } catch (ClassNotFoundException | SQLException e) {
	  // e.printStackTrace();  
	  Bukkit.getLogger().info("Wrong credentials");
	  }
    	
    if (SQL.isConnected()) {
    	Bukkit.getLogger().info("Suxessfully connected");
    }
    	
    			
	}

	@Override
    public void onDisable() {
		SQL.disconnect();
    }

}