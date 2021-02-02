const Discord = require("discord.js");
const config = require("./config.json");
var mysql = require('mysql');
const client = new Discord.Client();
const prefix = ".";
 
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

client.on("message", async (message) => {
  // If the message is from a bot, or doesn't start with the prefix, return
  if (
    message.author.bot ||
    !message.content.toLocaleLowerCase().startsWith(prefix)
  )
    return;

const rpsOptions = ["rock", "paper", "scissors"];
 
  // rock paper scissors
  if (commandName == "rps") {
    // if no arguments, more than one argument or not a valid argument, return
    // (variable in string reference: https://developer.mozilla.org/en-US/docs/Learn/JavaScript/First_steps/Strings#template_literals)
    if (!args.length || args.length > 1 || !rpsOptions.includes(args[0])) {
      return message.channel.send(
        `Invalid argument(s)\nExample: \`${prefix}rps ${rpsOptions[0]}\``
      );
    }
 
    const userInput = args[0].toLowerCase();
    const computerInput = rpsOptions[Math.floor(Math.random() * 3)]; // random 0, 1 or 2
 
    // if the player and computer chose the same, tie
    if (userInput === computerInput)
      return message.channel.send(
        `The game ended in a tie!\nYou both chose \`${userInput}\``
      );
 
    let playerWon = false;
 
    // under these conditions, the player won the game
    if (
      (userInput === rpsOptions[0] && computerInput === rpsOptions[2]) || // rock vs scissors
      (userInput === rpsOptions[1] && computerInput === rpsOptions[0]) || // paper vs rock
      (userInput === rpsOptions[2] && computerInput === rpsOptions[1]) // scissors vs paper
    ) {
      playerWon = true;
    }
 
    // create embed
    const rpsEmbed = new Discord.MessageEmbed().setAuthor(
      "Rock Paper Scissors"
    );
    // (inline if-statements reference https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Conditional_Operator)
    rpsEmbed.setTitle(
      `${playerWon ? message.author.username : "Computer"} won! 🎉`
    );
    rpsEmbed.setDescription(
      `(${message.author.username}) \`${userInput}\` vs (Computer) \`${computerInput}\``
    );
 
    // return the result
    return message.channel.send(rpsEmbed);
 
    // you could add code that updates the player's money
 
    // if(playerWon) {
    //   give reward
    // } else {
    //   substract money
    // }
  }
});


		
 
client.login(config.token);