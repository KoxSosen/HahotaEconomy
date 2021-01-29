package me.simon.hahota.fun.tree;

import org.bukkit.plugin.java.JavaPlugin;

import com.mysql.jdbc.Connection;

public class Main extends JavaPlugin {
	
    String host, port, database, username, password;
    static Connection connection;
 
    @Override
    public void onEnable() {  
        host = "localhost";
        port = "3306";
        database = "TestDatabase";
        username = "user";
        password = "pass";    
    }
 
    @Override
    public void onDisable() {
    }


}
