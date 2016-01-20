package de.kurimatzu.banco;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.plugin.PluginBase;


public class Main extends PluginBase implements Listener{
	
	public static Plugin instance;
	
	public void onEnable() {
		this.getDataFolder().mkdirs();
		instance = this;
		getServer().getPluginManager().registerEvents(this, this);
		Utils.c.save();
		Utils.c.save(true);
	}
	@EventHandler
	public void join(PlayerJoinEvent e) {
		if(!Utils.exists(e.getPlayer())) {
			Utils.criarConta(e.getPlayer());
		}
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cComando somente no servidor."); 
			return true;
		}
		Player player = (Player)sender;
		if(cmd.getName().toLowerCase().contains("money")) {
			if(Utils.exists(player)) {
				player.sendMessage("§c[Money] §aSeu dinheiro e de:" + " " + Utils.getMoney(player));				
				
	}
	
		}
		
		return false;
	}
}


