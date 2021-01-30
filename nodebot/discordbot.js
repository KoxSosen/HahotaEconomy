const Discord = require("discord.js");
const config = require("./config.json");
const client = new Discord.Client();
 
// Set the prefix
const prefix = ".";
client.on("message", (message) => {
  // Exit and stop if it's not there
  if (!message.content.startsWith(prefix)) return;

  if (message.content.startsWith(prefix + "ping")) {
    message.channel.send("pong!");
  } else
  if (message.content.startsWith(prefix + "foo")) {
    message.channel.send("bar!");
  }
});
 
client.login(config.token);