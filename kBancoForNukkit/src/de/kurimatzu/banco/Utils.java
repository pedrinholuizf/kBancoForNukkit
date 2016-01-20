package de.kurimatzu.banco;

import java.io.File;

import cn.nukkit.Player;
import cn.nukkit.utils.Config;

public class Utils {

	public static Config c = new Config(new File(Main.instance.getDataFolder(), "contas.yml"));
	
	
	public static double getMoney(final Player p) {
		if(c.exists(p.getUniqueId().toString())) {
			return (double) c.get(p.getUniqueId().toString());
		}
		return 0;
		
	}
	public static void deletarConta(final Player p) {
		if(c.exists(p.getUniqueId().toString())) {
			c.remove(p.getUniqueId().toString());
			c.save();
			c.save(true);
			p.sendMessage("§cConta deletada..");
		} else {
			p.sendMessage("§cops, essa conta nao existe.");
		}
	}
	public static void addMoney(final Player p , double quantia) {
		if(c.exists(p.getUniqueId().toString())) {
			c.set(p.getUniqueId().toString() , (double)c.get(p.getUniqueId().toString()) + quantia);
			c.save();
			c.save(true);
			p.sendMessage("§c[Money] §aFoi adicionado §6" + quantia + " §ade money a sua conta.");
		}
	}
	public static void setMoney(final Player p , double quantia) {
		if(c.exists(p.getUniqueId().toString())) {
			c.set(p.getUniqueId().toString() , quantia);
			p.sendMessage("§c[Money] §aFoi SETADO §6" + quantia + " §ade money a sua conta.");
			c.save();
			c.save(true);
		}
	}
	public static void removeMoney(final Player p , double quantia) {
		if(c.exists(p.getUniqueId().toString())) {
			c.set(p.getUniqueId().toString() ,(double)c.get(p.getUniqueId().toString()) - quantia);
			c.save();
			c.save(true);
			p.sendMessage("§c[Money] §aFoi removido §6" + quantia + " §ade money a sua conta.");
		}
	}
	public static void criarConta(final Player p) {
		if(!c.exists(p.getUniqueId().toString())) {
			c.set(p.getUniqueId().toString(), Double.valueOf(0));
			c.save();
			c.save(true);
		} else {
			p.sendMessage("§cops, essa conta já existe.");
		}
	}
	public static boolean exists(final Player p) {
		if(c.exists(p.getUniqueId().toString())) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
}
