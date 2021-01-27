package com.icelegend;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.Map.Entry;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityCategory;
import org.bukkit.entity.Hoglin;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.PiglinBrute;
import org.bukkit.entity.Player;
import org.bukkit.entity.Strider;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.entity.Zoglin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DamageListener implements Listener {
	IceLegend ic;

	public DamageListener(IceLegend ic) {
		// TODO Auto-generated constructor stub
		this.ic = ic;
	}
	@EventHandler
	// The event listener that will be triggered, when the player switch its item.
	public void onItemSwitch(PlayerItemHeldEvent event) {
		Player p = event.getPlayer();
		ItemStack item = p.getInventory().getItem(event.getNewSlot());
		ItemMeta im = item.getItemMeta();
		
		List<String> attr_list = (List<String>) ic.attr_name_config.getList("attribute");

		for (String s : attr_list) {
			switch (s) {
			case "attack":
				s = "generic.attack_damage";
				break;
			case "attack_speed":
				s = "generic.attack_speed";
				break;
			case "piercing":
				break;
			case "magic":
				break;
			case "shoot":
				break;
			case "range":
				break;
			case "mana_cost":
				break;
			case "critical_chance":
				break;
			case "critical_rate":
				break;
			case "arthropod":
				break;
			case "mob":
				break;
			case "nether":
				break;
			case "water":
				break;
			case "player":
				break;
			case "drain_chance":
				break;
			case "drain_rate":
				break;
			case "light_chance":
				break;
			case "light_damage":
				break;
			case "slow_chance":
				break;
			case "slow_rate":
				break;
			case "poison_chance":
				break;
			case "poison_damage":
				break;
			case "confuse_chance":
				break;
			case "float_chance":
				break;
			case "float_level":
				break;
			case "burn_chance":
				break;
			case "freeze_time":
				break;
			case "armor":
				break;
			case "armour_toughness":
				break;
			case "mana":
				break;
			case "health":
				break;
			case "rebound_chance":
				break;
			case "rebound_rate":
				break;
			case "physic_defence":
				break;
			case "magic_defence":
				break;
			case "undead_defence":
				break;
			case "water_defence":
				break;
			case "mob_defence":
				break;
			case "player_defence":
				break;
			case "arthropod_defence":
				break;
			case "light_defence":
				break;
			case "slow_defence":
				break;
			case "poison_defence":
				break;
			case "burn_desfence":
				break;
			case "float_defence":
				break;
			case "freeze_defence":
				break;

			}
		}
		AttributeModifier mod = new AttributeModifier(UUID.randomUUID(), attr_list.get(0),
				ic.components_yml_config.getDouble("" + attr_list.get(0)), Operation.ADD_NUMBER, EquipmentSlot.HAND);
		im.addAttributeModifier(Attribute.GENERIC_FLYING_SPEED, mod);
	}
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent event){
		Entity victim = event.getEntity();
		Entity damager = event.getDamager();
		World world = victim.getWorld();
		Location location = victim.getLocation();
		if (damager instanceof Player) {
			Player p = (Player) damager;
			ItemStack item = p.getInventory().getItemInMainHand();
			//try {
			ic.getLogger().info(item.getItemMeta().toString());
				Map<Attribute, Collection<AttributeModifier>> attr = item.getItemMeta().getAttributeModifiers().asMap();
			
			Map<String, Double> name_list = new HashMap<String, Double>();
			for (Entry<Attribute, Collection<AttributeModifier>> entry : attr.entrySet()) {
				Iterator value = entry.getValue().iterator();
				for (AttributeModifier am : item.getItemMeta().getAttributeModifiers(entry.getKey())) {
					double v = am.getAmount();
					String name = am.getName();
					damager.sendMessage(name);
					ic.getLogger().info(name);
					name_list.put(name, v);
				}
			}
			int slow_rate = 1;
			int poison_damage=1;
			int confuse_level=1;
			int float_level=1;
			double burn_rate=0.0;
			double freeze_time=0.0;
			double drain_rate=0.0;
			double critical_rate=0.0;
			for (Entry<String, Double> entry : name_list.entrySet()) {
				Random r = new Random();
				double v = entry.getValue();
				int dur = 100;
				switch (entry.getKey()) {
				case "piercing":
					
					break;
				case "magic":
					break;
				case "shoot":
					if(((Player) damager).getInventory().getItemInMainHand().equals(new ItemStack(Material.BOW) )||
							((Player) damager).getInventory().getItemInMainHand().equals(new ItemStack(Material.CROSSBOW))){
						event.setDamage(event.getDamage()+v);
					}
					break;
				case "range":
					break;
				case "mana_cost":
					break;
				case "critical_chance":
					if(r.nextDouble()<=v) {
						event.setDamage(critical_rate+event.getDamage());
					}
					break;
				case "critical_rate":
					critical_rate = v;
					break;
				case "drain_chance":
					break;
				case "drain_rate":
					break;
				case "light_chance":
					if(r.nextDouble()<=v)
						world.strikeLightning(location);
					break;
				case "light_damage":
					break;
				case "slow_rate":
					slow_rate= (int) v;
				case "slow_chance":
					if(r.nextDouble() <= v) {
						((LivingEntity) victim).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, dur, slow_rate));
					}
					break;
				
				case "poison_chance":
					if(r.nextDouble() <= v) {
						((LivingEntity) victim).addPotionEffect(new PotionEffect(PotionEffectType.POISON, dur, poison_damage));
					}
					break;
				case "poison_damage":
					poison_damage = (int) v;
					break;
				case "confuse_chance":
					if(r.nextDouble() <= v) {
						((LivingEntity) victim).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, dur, confuse_level));
						ic.getLogger().info("The victim is now poisoned!");
					}
					break;
				case "float_level":
					float_level = (int) v;
					break;
				case "float_chance":
					if(r.nextDouble() <= v) {
						((LivingEntity) victim).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, dur, float_level));
					}
					break;
				
				case "burn_chance":
					if(r.nextDouble() <= v) {
						int burn_dur = 3*20; // 3 sec
						victim.setFireTicks(burn_dur);
					}
					break;
				case "freeze_time":
					
					break;
				case "armor":
					PlayerInventory inv = ((Player) damager).getInventory();
					ItemStack armour[] = inv.getArmorContents();
					for (ItemStack a : armour) {
						ItemMeta im = a.getItemMeta();
						
						AttributeModifier mod = new AttributeModifier(UUID.randomUUID(), entry.getKey(),
								ic.components_yml_config.getDouble(""+entry.getKey()), Operation.ADD_NUMBER, EquipmentSlot.HAND);
						im.addAttributeModifier(Attribute.GENERIC_ARMOR, mod);
						a.setItemMeta(im);
					}
					break;
				case "armour_toughness":
					inv = ((Player) damager).getInventory();
					armour = inv.getArmorContents();
					for (ItemStack a : armour) {
						ItemMeta im = a.getItemMeta();
						AttributeModifier mod = new AttributeModifier(UUID.randomUUID(), entry.getKey(),
								ic.components_yml_config.getDouble(""+entry.getKey()), Operation.ADD_NUMBER, EquipmentSlot.HAND);
						im.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, mod);
						a.setItemMeta(im);
					}
					break;
				case "mana":
					break;
				case "health":
					inv = ((Player) damager).getInventory();
					armour = inv.getArmorContents();
					break;
				case "rebound_chance":
					
					break;
				case "rebound_rate":
					break;
				case "physic_defence":
					break;
				case "magic_defence":
					break;
				case "undead_defence":
					break;
				case "water_defence":
					break;
				case "mob_defence":
					break;
				case "player_defence":
					break;
				case "arthropod_defence":
					break;
				case "light_defence":
					break;
				case "slow_defence":
					break;
				case "poison_defence":
					break;
				case "burn_dfence":
					break;
				case "flaot_defence":
					break;
				case "freeze_defence":
					break;
				}
			}
			if (victim instanceof Piglin || victim instanceof MagmaCube || victim instanceof WitherSkeleton
					|| victim instanceof Strider || victim instanceof Blaze || victim instanceof PiglinBrute
					|| victim instanceof Zoglin || victim instanceof Hoglin) // Nether
			{
				for (Entry<String, Double> entry : name_list.entrySet())
					if (entry.getKey().equals("nether"))
						event.setDamage(event.getDamage() + entry.getValue());
			} else if (victim instanceof Mob) { // Mob
				for (Entry<String, Double> entry : name_list.entrySet())
					if (entry.getKey().equals("mob"))
						event.setDamage(event.getDamage() + entry.getValue());
			} else if (victim instanceof Player) { // Player

				for (Entry<String, Double> entry : name_list.entrySet()) 
					if (entry.getKey().equals("player"))
						event.setDamage(event.getDamage() + entry.getValue());
			} else if (victim instanceof LivingEntity) {
				LivingEntity v = (LivingEntity) victim;
				if (v.getCategory().equals(EntityCategory.ARTHROPOD)) { // Arthropod
					for (Entry<String, Double> entry : name_list.entrySet())
						if (entry.getKey().equals("arthopod"))
							event.setDamage(event.getDamage() + entry.getValue());
				} else if (v.getCategory().equals(EntityCategory.UNDEAD)) { // Undead
					for (Entry<String, Double> entry : name_list.entrySet())
						if (entry.getKey().equals("undead"))
							event.setDamage(event.getDamage() + entry.getValue());
				} else if (v.getCategory().equals(EntityCategory.WATER)) { // Water
					for (Entry<String, Double> entry : name_list.entrySet())
						if (entry.getKey().equals("water"))
							event.setDamage(event.getDamage() + entry.getValue());
				}
			}
			//}catch(java.lang.NullPointerException ne) {
				//ic.getLogger().info("Player using non-attributed weapons");
			//}
		}
	}
}
