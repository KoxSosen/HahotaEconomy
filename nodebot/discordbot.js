const Discord = require("discord.js");
const config = require("./config.json");
var mysql = require('mysql');
const client = new Discord.Client();
 
 
const prefix = ".";
client.on("message", (message) => {
  // Exit and stop if it's not there
  if (!message.content.startsWith(prefix)) return;

  if (message.content.startsWith(prefix + "bal")) {
    message.channel.send("pong!");
  } else
  if (message.content.startsWith(prefix + "nou")) {
    message.channel.send("bar!");
  } else
})  

var con = mysql.createConnection({
  host: "localhost",
  user: "yourusername",
  password: "yourpassword"
});

con.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
  con.query(sql, function (err, result) {
    if (err) throw err;
    console.log("Result: " + result);
  });
});
 
client.login(config.token);