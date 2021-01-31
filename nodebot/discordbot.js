const Discord = require("discord.js");
const config = require("./config.json");
var mysql = require('mysql');
const client = new Discord.Client();

 
var con = mysql.createConnection({
  host: config.host,
  user: config.user,
  password: config.password,
  database: config.database
});

con.connect(err => {
    // Console log if there is an error
    if (err) return console.log(err);

    // No error found?
    console.log(`MySQL has been connected!`);
});

client.on('ready', () => {
    // Log when bot is ready
    console.log(`${client.user.tag} is online!`);
});
		
 
client.login(config.token);