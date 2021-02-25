# twitchPredictions

This program returns how many points to bet on a Twitch prediction given how many points you have, the theoretical probability of the choice happening, and the return ratio of that choice.
The amount of points returned is the amount of points you should bet that gives you the largest growth over time (in this case, exponential growth).
This program is highly useful for those that have a gambling addiction on Twitch.

## Usage

[Download the jar file here](https://cdn.discordapp.com/attachments/276787809119895552/814290721967570984/twitchPredictions.jar).
You must have at least Java 8. Check by opening the console and typing ```java -version``` or ```java --version```. If it says Java 8, Java 1.8.0, or higher, you are good.

The jar file is not meant to be opened. Follow these directions:

1. Open the console (Command Prompt on Windows, Terminal on Mac).
2. In the console, type in ```java -jar ```. Make sure there is a space at the end.
3. Drag and drop the jar file onto the console. When you do this, the file's path will show, i.e. ```/Users/Username/Downloads/twitchPredictions.jar```.
4. Type in the arguments in the following order: ```points probability returnRatio```.
5. The program will output the results.

See below for an example on how to run the program.

## Example

![image](https://i.imgur.com/HLnRdf8.png)

You have ```10000``` points, and the prediction is: "Bastion or Fortress?"

The two options, choices A and B, are "Bastion" and "Fortress", respectively.

The true probability to encounter a Bastion in a region is ```60%```, whilst a Fortress is ```40%```.

Ten seconds before the prediction ends, the distribution of bets is ```50%``` Bastion and ```50%``` Fortress.

Bastion has a return ratio of ```1:2```, and Fortress also has a return ratio of ```1:2```.

The command you would type is: ```java -jar /Users/Username/Downloads/twitchPredictions.jar 10000 0.6 2```

For this example, the program will return the following:

```Choice A: 2000```

```Choice B: -2000```

Choice A is positive, therefore you should bet ```2000``` points on Choice A (Bastion).

Choice B is negative, so you should not bet on Choice B (Fortress).

## How it works

This program uses the Kelly Criterion, which returns the proportion of the money you should bet that gives the largest growth over a long period of time.

In the case of Twitch predictions, because payout depends on the distribution of points, the formula for the proportion of points you should bet simplifies to:

![f](http://latex2png.com/pngs/9932f854fcd731402196eaddf2448ea9.png)

where ```f``` is the fraction to bet, ```p``` is the theoretical probability, and ```b``` is the belief probability (the proportion of points bet on a choice).

Rewriting ```b``` as a return ratio, the formula is now:

![g](http://latex2png.com/pngs/cf13c12b3fa31ed772e4db3f49a5bb11.png)

This is the formula the program uses because return ratios are more precise, especially when the belief probabilities are very low or very high. 

## Important Notes

- This program can, in theory, be used for predictions that have a hard-to-calculate true probability, i.e. "Will we win as Impostors?" However, in order to find this probability, one would have to do data collection on the streamer. Therefore, this program cannot help you in this case, since you can't know the true probability unless you collect data.

- It is not possible for both choices to be positive or negative. If that happens, you have made a mistake entering the command.

- It is possible for both choices to be ```0```. In that case, the program is telling you that you should not bet any points on either choice.

- The program will never ask you to bet ```100%``` of your points unless the true probability is ```1```. Over a long period of time, betting ```100%``` of your money is guaranteed to make you go broke.
