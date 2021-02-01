package me.simon.hahota.fun.tree;


import java.sql.SQLException;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.simon.hahota.fun.tree.sql.MySQL;
import me.simon.hahota.fun.tree.sql.SQLGetter;

public class Main extends JavaPlugin {

 
    public MySQL SQL;
    public SQLGetter data;

	@Override
    public void onEnable() 	{
	this.getConfig().options().copyDefaults();
	saveDefaultConfig();
    	this.SQL = new MySQL();
        this.data = new SQLGetter(this);
    	
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