package sencraft.sensen1234.axecommand;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Axecommand extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("Axecommand has been enabled!");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Axecommand has been disabled.");
    }

    @EventHandler
    public void onPlayerSwapHandItems(PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getInventory().getItemInMainHand();

        // 检查玩家手持物是否为木斧
        if (mainHandItem != null && mainHandItem.getType() == Material.WOODEN_AXE) {
            // 玩家按下F键（交换物品）执行//undo命令
            player.performCommand("undo");
            event.setCancelled(true); // 取消物品交换
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getInventory().getItemInMainHand();

        // 检查玩家手持物是否为木斧
        if (mainHandItem != null && mainHandItem.getType() == Material.WOODEN_AXE) {
            // 玩家按下Q键（丢弃物品）执行//redo命令
            player.performCommand("redo");
            event.setCancelled(true); // 取消丢弃物品
        }
    }
}
