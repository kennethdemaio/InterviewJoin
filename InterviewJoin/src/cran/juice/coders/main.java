package cran.juice.coders;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener{
	
	@Override
	public void onEnable() {
		
		System.out.println("Interview Join Enabled");
		
		this.getConfig().options().copyDefaults();
		saveDefaultConfig();	
		
		Bukkit.getPluginManager().registerEvents(this, this);
		
	}
		
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		
		Player p = e.getPlayer();
		
		if (!p.hasPermission("InterviewJoin.allow")){
			e.setCancelled(true);
			
		}
		
		if(p.isOp()){
			e.setCancelled(false);
			
		}
		
	}
	
	@Override
	public void onDisable() {
		System.out.println("Interview Join Disabled");
		
	}
}