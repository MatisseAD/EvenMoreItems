package fr.jachou.moreItems.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.Color;

import java.util.*;
import java.util.function.Consumer;
import java.util.UUID;

/**
 * Ultra-complet ItemBuilder pour créer et personnaliser vos ItemStack de façon fluide.
 */
public class ItemBuilder {
    private final ItemStack item;
    private final ItemMeta meta;
    private final PersistentDataContainer container;

    private ItemBuilder(Material material, int amount) {
        this.item = new ItemStack(material, amount);
        this.meta = this.item.getItemMeta();
        this.container = meta.getPersistentDataContainer();
    }

    private ItemBuilder(ItemStack stack) {
        this.item = stack.clone();
        this.meta = this.item.getItemMeta();
        this.container = meta.getPersistentDataContainer();
    }

    /**
     * Crée un ItemBuilder à partir d'un Material.
     */
    public static ItemBuilder of(Material material) {
        return new ItemBuilder(material, 1);
    }

    /**
     * Crée un ItemBuilder à partir d'un ItemStack existant.
     */
    public static ItemBuilder from(ItemStack stack) {
        return new ItemBuilder(stack);
    }

    /**
     * Définit la quantité.
     */
    public ItemBuilder amount(int amount) {
        this.item.setAmount(amount);
        return this;
    }

    /**
     * Change le material (ne conserve pas les meta non compatibles).
     */
    public ItemBuilder material(Material material) {
        this.item.setType(material);
        return this;
    }

    /**
     * Définit le nom affiché (support des codes couleur §).
     */
    public ItemBuilder name(String name) {
        meta.setDisplayName(name);
        return this;
    }

    /**
     * Définit le lore complet (support des codes §).
     */
    public ItemBuilder lore(List<String> lore) {
        meta.setLore(lore);
        return this;
    }

    /**
     * Ajoute une ligne de lore.
     */
    public ItemBuilder addLore(String line) {
        List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
        lore.add(line);
        meta.setLore(lore);
        return this;
    }

    /**
     * Vide le lore.
     */
    public ItemBuilder clearLore() {
        meta.setLore(new ArrayList<>());
        return this;
    }

    /**
     * Définit le CustomModelData (1.14+).
     */
    public ItemBuilder customModelData(int data) {
        meta.setCustomModelData(data);
        return this;
    }

    /**
     * Ajoute un enchantement forcé.
     */
    public ItemBuilder enchant(Enchantment ench, int level) {
        meta.addEnchant(ench, level, true);
        return this;
    }

    /**
     * Enlève un enchantement.
     */
    public ItemBuilder removeEnchant(Enchantment ench) {
        meta.removeEnchant(ench);
        return this;
    }

    /**
     * Ajoute un Flag (cacher attributs, enchant, etc.).
     */
    public ItemBuilder flag(ItemFlag flag) {
        meta.addItemFlags(flag);
        return this;
    }

    /**
     * Rend l'objet incassable.
     */
    public ItemBuilder unbreakable(boolean unbreakable) {
        meta.setUnbreakable(unbreakable);
        return this;
    }

    /**
     * Définit le propriétaire d'une tête de joueur.
     */
    public ItemBuilder skullOwner(String owner) {
        try {
            org.bukkit.inventory.meta.SkullMeta skull = (org.bukkit.inventory.meta.SkullMeta) meta;
            skull.setOwnerProfile(Bukkit.getOfflinePlayer(owner).getPlayerProfile());
        } catch (ClassCastException ignored) {}
        return this;
    }

    /**
     * Définit la couleur d'une cuirasse (LeatherArmorMeta).
     */
    public ItemBuilder color(Color color) {
        if (meta instanceof LeatherArmorMeta lam) {
            lam.setColor(color);
        }
        return this;
    }

    /**
     * Applique un AttributeModifier.
     */
    public ItemBuilder attribute(Attribute attribute, AttributeModifier modifier) {
        meta.addAttributeModifier(attribute, modifier);
        return this;
    }

    /**
     * Ajoute une donnée persistante (PDC).
     */
    public <T, Z> ItemBuilder persistentData(NamespacedKey key, PersistentDataType<T, Z> type, Z value) {
        container.set(key, type, value);
        return this;
    }

    /**
     * Active l'effet "glow" sans enchant actif.
     */
    public ItemBuilder glow() {
        enchant(Enchantment.UNBREAKING, 1);
        flag(ItemFlag.HIDE_ENCHANTS);
        return this;
    }

    /**
     * Modifie le meta via un Consumer.
     */
    public ItemBuilder editMeta(Consumer<ItemMeta> editor) {
        editor.accept(meta);
        return this;
    }

    /**
     * Retourne l'ItemStack final.
     */
    public ItemStack build() {
        item.setItemMeta(meta);
        return item;
    }
}
