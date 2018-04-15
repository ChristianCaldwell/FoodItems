package testplugin;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Testplugin extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public void onDisable() {

	}

	public ItemStack getPork() {
		ItemStack lp = new ItemStack(Material.GRILLED_PORK, 1);
		ItemMeta meta = lp.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_RED + "Levitation Porkchop");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§6Eat this to levitate!");
		meta.setLore(lore);
		lp.setItemMeta(meta);

		return lp;
	}

	public ItemStack getBeef() {
		ItemStack cb = new ItemStack(Material.COOKED_BEEF, 1);
		ItemMeta meta = cb.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_PURPLE + "Mad Cow Disease");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§6I wouldn't eat this if I were you...");
		meta.setLore(lore);
		cb.setItemMeta(meta);

		return cb;
	}

	public ItemStack getChicken() {
		ItemStack cc = new ItemStack(Material.COOKED_CHICKEN, 1);
		ItemMeta meta = cc.getItemMeta();
		meta.setDisplayName(ChatColor.YELLOW + "Regeneration Chicken");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§6This chicken infuses into your heart and helps to heal you faster.");
		meta.setLore(lore);
		cc.setItemMeta(meta);

		return cc;
	}

	@EventHandler
	public void onPoweredFoodEat(PlayerItemConsumeEvent event) {
		Player p = event.getPlayer();
		if (p.getInventory().getItemInMainHand().getItemMeta().getLore().contains("§6Eat this to levitate!")) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 100, 3));
		} else if (p.getInventory().getItemInMainHand().getItemMeta().getLore()
				.contains("§6I wouldn't eat this if I were you...")) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 3));
			p.getWorld().spawnEntity(p.getLocation().add(1D, 25D, 0D), EntityType.COW);
			p.getWorld().spawnEntity(p.getLocation().add(2D, 24D, 0D), EntityType.COW);
			p.getWorld().spawnEntity(p.getLocation().add(3D, 23D, 0D), EntityType.COW);
			p.getWorld().spawnEntity(p.getLocation().add(0D, 22D, 1D), EntityType.COW);
			p.getWorld().spawnEntity(p.getLocation().add(0D, 21D, 2D), EntityType.COW);
			p.getWorld().spawnEntity(p.getLocation().add(0D, 20D, 3D), EntityType.COW);
			p.getWorld().spawnEntity(p.getLocation().add(-1D, 19D, 0D), EntityType.COW);
			p.getWorld().spawnEntity(p.getLocation().add(-2D, 18D, 0D), EntityType.COW);
			p.getWorld().spawnEntity(p.getLocation().add(-3D, 17D, 0D), EntityType.COW);
			p.getWorld().spawnEntity(p.getLocation().add(0D, 16D, -1D), EntityType.COW);
			p.getWorld().spawnEntity(p.getLocation().add(0D, 15D, -2D), EntityType.COW);
			p.getWorld().spawnEntity(p.getLocation().add(0D, 14D, -3D), EntityType.COW);
		} else if (p.getInventory().getItemInMainHand().getItemMeta().getLore()
				.contains("§6This chicken infuses into your heart and helps to heal you faster.")) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 300, 3));

		}

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (sender instanceof Player) {

			if (cmd.getName().equalsIgnoreCase("giveLP")) {
				player.sendMessage("Giving Levetation Porkchop!");
				Player p = (Player) sender;
				p.getInventory().addItem(getPork());
			}

			if (cmd.getName().equalsIgnoreCase("giveMCD")) {

				player.sendMessage("Giving Mad Cow Disease!");
				Player p = (Player) sender;
				p.getInventory().addItem(getBeef());
			}

			if (cmd.getName().equalsIgnoreCase("giveRC")) {
				player.sendMessage("Giving Regeneration Chicken!");
				Player p = (Player) sender;
				p.getInventory().addItem(getChicken());
			}

		} else {
			sender.sendMessage("This is a player based command.");
		}

		return false;
	}

}
