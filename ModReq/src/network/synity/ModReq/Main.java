package network.synity.ModReq;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("ModReq is working.");
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
	}
	
	@Override
	public void onDisable() {
		System.out.println("ModReq Closed.");
	}
	
    @Override
    public boolean onCommand(CommandSender sender,
            Command command,
            String label,
            String[] args) {
    	String message = String.join(" ", args);
    	Player player = (Player)sender;
        if (command.getName().equalsIgnoreCase("modreq")) {
        	
        	for(Player p : Bukkit.getOnlinePlayers()) {
        		if(p.hasPermission("modreq.receive") && message.length() != 0) {
        			String prefix = getConfig().getString("prefix");
        			String displayName = player.getDisplayName();
        			p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.GRAY + displayName + ChatColor.GRAY + " » " + ChatColor.WHITE + message);
        		}
        	}
        	
        	if(message.length() == 0) {
        		String unknownCMD = getConfig().getString("unknownCMD");
        		String cmd = getConfig().getString("cmd");
        		sender.sendMessage(unknownCMD + "\n" + cmd);
        		return true;
        	}
        	else {
        	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("confirm-msg") + ChatColor.WHITE + message));
            return true;
        	}
        }
        return false;
    }

}
