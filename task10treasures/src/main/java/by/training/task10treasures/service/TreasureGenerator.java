package by.training.task10treasures.service;

import by.training.task10treasures.dal.Reader;

import java.io.IOException;
import java.util.Random;

public class TreasureGenerator {
    private static final String[] TREASURE_NAMES = {"Crown","Sword", "Armor", "Ring", "Chest", "Skull", "Spear" , "Amulet", "Image", "Book"};
    private static final String[] TREASURE_ADJECTIVE = {"King's", "Duke", "Dwarf" ,"Elf", "Giant's" , "Emperor's", "Undead" ,"Demon", "Angel", "Orc"};

    public void generate(Reader reader) throws IOException {
        Random random = new Random();
        for (String treasureAdjective : TREASURE_ADJECTIVE) {
            for (String treasureName : TREASURE_NAMES) {
                String treasure = treasureAdjective + " " + treasureName + "_" + random.nextInt(500) + "_" + random.nextInt(60);
                reader.writeData(treasure);
            }
        }
    }
}
