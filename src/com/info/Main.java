package com.info;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        getLogger().info("Plugin Pertama Berhasil Dinyalakan!");
        // Mendaftarkan perintah /halo agar dikenali server
        this.getCommand("halo").setExecutor(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin Pertama Dimatikan!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // Cek apakah yang mengetik adalah pemain (bukan konsol server)
        if (sender instanceof Player) {
            Player pemain = (Player) sender;
            // Kirim pesan balasan ke pemain tersebut
            pemain.sendMessage("§aHalo juga! Perintah ini dikirim dari plugin HP-mu!");
            return true;
        } else {
            sender.sendMessage("Perintah ini hanya bisa dipakai oleh pemain di dalam game!");
            return true;
        }
    }
}
