package io.github.emckee10.MilkyVote;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MVExecutor implements CommandExecutor
{
  MVMain plugin;
  MVUtil util;
  public MVExecutor(MVMain plugin)
  {
    this.plugin = plugin;
    this.util = plugin.getUtil();
    
  }
  
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
  
    boolean result = false;
    switch (command.getName().toLowerCase()) {
      case "setvotingsite":
        result = setURL(sender, args);
        break;
      case "milkyvote":
        result = vote(sender);
        break;
    }
    
    return result;
  }
  
  private boolean setURL(CommandSender sender, String[] args)
  {
    System.out.println(args.length + "");
    if (args.length == 1) {
      util.setURLSettings(args[0]);
      return true;
    }
      else
        return false;
  }
  
  private boolean vote(CommandSender sender)
  {
    return util.sendLink(sender);
  }
  
}