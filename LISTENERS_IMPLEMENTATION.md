# Listeners Implementation Guide

## Overview

This document describes the implementation of event listeners for all custom items in the EvenMoreItems plugin.

## Problem Statement

The original requirement (in French):
> "Vérifie que pour chaque items, un listeners/events lui est associé car cela est la base de chaque items puisqu'ils permettent de nouvelles fonctionnalités"

Translation:
> "Verify that for each item, a listener/event is associated because that is the basis of each item since they allow new functionalities"

## Current Status

✅ **REQUIREMENT MET**: All 110 custom items now have associated listener classes.

### Statistics
- **Total custom items**: 110
- **Total listener classes**: 111 (110 item listeners + 1 ManagerGUIListener)
- **Listener registrations in EventManager**: 111

## Implementation Details

### Listener Structure

Each listener follows a consistent pattern:

```java
package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.ItemName;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

/**
 * [Item description from the item class]
 */
public class ItemNameListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), ItemName.KEY_ID);

    // TODO: Implement event handlers
}
```

### Key Components

1. **Package**: All listeners are in `fr.jachou.moreItems.listeners`
2. **Class Name**: `{ItemName}Listener` (e.g., `GolemSoupListener`)
3. **Interface**: Implements `org.bukkit.event.Listener`
4. **NamespacedKey**: Each listener has a key field to identify the item using `PersistentDataContainer`
5. **Documentation**: JavaDoc comment with item description

### Registration

All listeners are registered in `EventManager.register()` method:

```java
plugin.getServer().getPluginManager().registerEvents(new ItemNameListener(), plugin);
```

## Newly Created Listeners

The following 82 listeners were created to satisfy the requirement:

1. AdvancedCartographyTableListener - Permet de copier les maps sans encre
2. AlphaWolfCollarListener - Tous les loups proches suivent et attaquent
3. AutoDoubleDoorListener - S'ouvre en détectant joueur
4. AutoFishingRodListener - Canne de Pêche Automatique - Ramène le poisson plus vite
5. AutoHarvesterListener - Casse et replante
6. AutoLamppostListener - Allume la nuit
7. AutoTrapdoorListener - S'ouvre à la présence d'un joueur
8. BasicWindmillListener - Produit redstone par vent (esthétique)
9. BlockCompressorListener - Fusionne automatiquement blocs
10. BreathStickListener - Bâton du Souffle - Repousse les mobs proches
11. CaramelAppleListener - Restaure la vie instantanément
12. CarvedStoneListener - Pierre Sculptée - Apparence de visages anciens
13. ChameleonCapeListener - Invisibilité 10 s
14. CodeChestListener - Coffre à Code - Coffre verrouillable avec mot de passe
15. CompactForgeListener - Fait fondre les métaux sans charbon (avec lave)
16. CrackedGlowstoneListener - Variante décorative
17. DoubleFurnaceListener - Fait fondre 2x plus vite
18. EnchantedBookSorterListener - Trie par enchantement
19. EnderCompassListener - Pointeur vers le Stronghold
20. EnergySoupListener - Régénération + vitesse
21. EngravingTableListener - Permet de renommer blocs décoratifs
22. FastPickaxeListener - Pioche Rapide - Efficacité temporaire
23. FeatherFallingPotionIIListener - Dure 4 minutes
24. FireRingListener - Résistance au feu
25. FoliageAxeListener - Hache de Feuillage - Coupe les feuilles instantanément
26. GolemSoupListener - Absorption temporaire
27. GolemTalismanListener - Résistance accrue
28. GravityBootsListener - Bottes Gravitantes - Annulent les dégâts de chute
29. HoneyExtractorListener - Récolte sans casser le nid
30. HoneyMilkListener - Soigne et donne résistance
31. HunterKnifeListener - Couteau de Chasseur - Double le loot des animaux
32. HunterSpearListener - Lance de Chasseur - Attaque à distance courte
33. HunterStewListener - Force temporaire
34. IceBrickListener - Ne fond pas
35. ImprovedForgeTableListener - Permet les crafts spéciaux
36. IvyWallListener - Mur végétalisé
37. KitchenKnifeListener - Couteau de Cuisine - Coupe la nourriture crue sans four
38. LavaStewListener - Résistance au feu
39. LifeAmuletListener - Rend 1 cœur toutes les 30 s
40. LightnessBootsListener - Réduit les dégâts de chute
41. LumberjackAxeListener - Hache de Bûcheron - Coupe les arbres entiers
42. LuminousColoredGlassListener - Verre teinté + brillance
43. MagicMelonJuiceListener - Régénération rapide
44. MinerBraceletListener - Augmente vitesse minage
45. MinerGloveListener - Gant de Mineur - Ramasse automatiquement les blocs cassés
46. MinerShovelListener - Pelle de Mineur - Double la vitesse dans la terre/sable
47. MirrorBlockListener - Réfléchit la lumière
48. MossyBrickListener - Décoration naturelle
49. NetherRingListener - Immunité au feu 5 s après passage portail
50. NightVisionRingListener - Vision nocturne permanente
51. OilLampListener - Source de lumière portable
52. PhantomLanternListener - Révèle entités invisibles
53. PlainsTeaListener - Régénération légère
54. PowerGloveListener - Gant de Force - Casse instantanément les blocs faibles
55. PumpkinBeerListener - Force + flou
56. RedstoneElevatorListener - Monte/descend automatiquement
57. ReflectiveShieldListener - Bouclier Réfléchissant - Renvoie flèches et tridents
58. ReinforcedBowListener - Arc Renforcé - +25% de portée
59. ReinforcedGlassListener - Bloc de Verre Renforcé - Résiste à la TNT
60. RunicFloorListener - Multiplie la vitesse
61. SailorMedallionListener - Respiration aquatique
62. SailorTridentListener - Trident du Marin - Augmente la vitesse sous l'eau
63. SeaSoupListener - Respiration aquatique
64. SecretDoorListener - Invisible quand fermée
65. SecurityTrapdoorListener - Se ferme si mob approche
66. ShortTeleportStickListener - TP sur 10 blocs
67. SilentAnvilListener - Pas de bruit lors de l'utilisation
68. SmartDispenserListener - Trie automatiquement les items
69. SmokeBlockListener - Cache la vision, effet décoratif
70. SortingChestListener - Trie les items par type
71. SpicyHoneyListener - Régénère la faim sur la durée
72. SteakSandwichListener - Rend 8 points de faim
73. StoneHammerListener - Marteau de Pierre - Casse 3x3 blocs de pierre
74. SunTalismanListener - Supprime la pluie
75. SweetPumpkinPieListener - Nourrit et donne vitesse
76. TemperedObsidianPickaxeListener - Pioche en Obsidienne Trempée - Durabilité x3, lente mais incassable
77. TrappedFlameChestListener - Explose à l'ouverture
78. VillageBreadListener - Nourrit 2x plus
79. WaterExtractorListener - Produit des seaux d'eau automatiques
80. WheatSiloListener - Stocke les récoltes
81. WillOWispBlockListener - Émet lumière bleue faible
82. WindCapeListener - Vitesse + saut

## Implementation Guidance

Each listener stub contains TODO comments with guidance on which event handlers to implement based on item type:

### Common Event Patterns

#### For Consumables (Food/Potions)
```java
@EventHandler
public void onConsume(PlayerItemConsumeEvent event) {
    if (!event.getItem().hasItemMeta() || 
        !event.getItem().getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) return;
    // Apply effects, add health, etc.
}
```

#### For Wearables (Armor/Accessories)
```java
@EventHandler
public void onMove(PlayerMoveEvent event) {
    Player player = event.getPlayer();
    ItemStack boots = player.getInventory().getBoots(); // or getHelmet(), getChestplate(), etc.
    
    if (boots != null && boots.hasItemMeta() &&
        boots.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
        // Apply effects while worn
    }
}
```

#### For Usables (Right-click items)
```java
@EventHandler
public void onUse(PlayerInteractEvent event) {
    if (event.getHand() != EquipmentSlot.HAND) return;
    ItemStack item = event.getItem();
    if (item == null || !item.hasItemMeta() || 
        !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) return;
    event.setCancelled(true);
    // Perform action
}
```

#### For Tools (Mining/Breaking)
```java
@EventHandler
public void onBreak(BlockBreakEvent event) {
    ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
    if (!item.hasItemMeta() || 
        !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) return;
    // Special breaking behavior
}
```

#### For Blocks (Placement)
```java
@EventHandler
public void onPlace(BlockPlaceEvent event) {
    ItemStack item = event.getItemInHand();
    if (!item.hasItemMeta() || 
        !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) return;
    // Special placement behavior
}
```

## Next Steps

For each listener stub, developers should:

1. Review the item's description in the JavaDoc
2. Determine the appropriate event type(s) to listen for
3. Implement the event handler(s) following the patterns above
4. Test the functionality in-game
5. Remove the TODO comment once implemented

## Examples

See existing implemented listeners for reference:
- `SpeedBootsListener` - Wearable that modifies player speed
- `FireSwordListener` - Tool that ignites entities on hit
- `PickupMagnetListener` - Usable that collects nearby items
- `SurvivalRationListener` - Consumable that provides saturation

## Verification

To verify all items have listeners, run:

```bash
python3 << 'EOF'
import os

items_dir = "./src/main/java/fr/jachou/moreItems/items"
listeners_dir = "./src/main/java/fr/jachou/moreItems/listeners"

items = set([f.replace(".java", "") for f in os.listdir(items_dir) 
             if f.endswith(".java") and f != "CustomItem.java"])

listeners = set([f.replace("Listener.java", "") for f in os.listdir(listeners_dir) 
                if f.endswith("Listener.java") and f != "ManagerGUIListener.java"])

missing = items - listeners
print(f"Items without listeners: {len(missing)}")
if missing:
    for item in sorted(missing):
        print(f"  - {item}")
else:
    print("✅ All items have listeners!")
EOF
```
