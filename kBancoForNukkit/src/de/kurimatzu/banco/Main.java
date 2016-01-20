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
			if(args.length == 1) {
				if(args[0].contains("pay")) {
					player.sendMessage("§c[Money] §a/money pay <nick> <quantia>");
				}
				return true;
			}
			if(args.length == 2) {
				if(args[0].contains("pay")) {
					player.sendMessage("§c[Money] §a/money pay <nick> <quantia>");
					return true;
				}

			}
			if(args.length == 3) {
				if(args[0].contains("pay")) {
					String jogador = args[1];
					int quantia = Integer.parseInt(args[2]);
					if(getServer().getPlayer(jogador) != null) {
						getServer().getPlayer(jogador).sendMessage("§c[Money] §a" + player.getName() + " §cenviou a você §a" + quantia + " coins.");
						Utils.addMoney(getServer().getPlayer(jogador), quantia);
						return true;
					} else {
						player.sendMessage("§cJogador Offline.");
						return true;
					}
				}
			}

			if(Utils.exists(player)) {
				player.sendMessage("§c[Money] §aSeu dinheiro e de:" + " " + Utils.getMoney(player));				

			}

		}

		return false;
	}
}


