package org.ctrlengine.ctrlengine_rpg.core;

import java.io.File;
import java.util.ArrayList;

import org.ctrlengine.ctrlengine_rpg.core.registered.*;
import static org.ctrlengine.ctrlengine_rpg.core.Log.logger;

/**
 * @author Ctrlengine Development Team
 */
public class FileManagement {
    public static String getPath = "file:src/main/resources/";
    //简单注册，如材料
    static ArrayList<registered.goods> goodsList = new ArrayList<>();
    static ArrayList<registered.weapons> weaponsList = new ArrayList<>();
    static ArrayList<registered.block> blocksList = new ArrayList<>();
    static ArrayList<registered.armour> armourList = new ArrayList<>();
    public static boolean register(String name,String initiator,String path){
        logger.debug("注册:{},{},{}",name,initiator,path);
        File file = new File(path);
        if (file.exists()) {
            goodsList.add(new registered.goods(name,initiator+":"+name,initiator,path));
            logger.info("注册完成:{}",name);
            return true;
        } else {
            logger.error("注册失败:{}",name);
            return false;
        }
    }
    public static boolean register(
            String name,
            String id,
            String path,
            String initiator,
            long maxAttack,
            long minAttack,
            long maxRange,
            long minRange,
            long maxDamage,
            long minDamage,
            long durability,
            long waitTime
    ){
        logger.debug("注册:{},{},{}",name,initiator,path);
        File file = new File(path);
        if (file.exists()) {
            weaponsList.add(new registered.weapons(name,id,path,initiator,maxAttack,minAttack,maxRange,minRange,maxDamage,minDamage,durability,waitTime));
            logger.info("注册完成:{}",name);
            return true;
        }
        else {
            logger.error("注册失败:{}",name);
            return false;
        }
    }
    public static boolean register(
            String name,
            String id,
            String path,
            String initiator,
            double maxProtection,
            double minProtection,
            long durability,
            long waitTime
    ){
        logger.debug("注册:{},{},{}",name,initiator,path);
        File file = new File(path);
        if (file.exists()) {
            armourList.add(new registered.armour(name,id,path,initiator,maxProtection,minProtection,durability,waitTime));
            logger.info("注册完成:{}",name);
            return true;
        }
        else {
            logger.error("注册失败:{}",name);
            return false;
        }
    }
    public static boolean register(
            String name,
            String id,
            String path,
            String initiator,
            long stack
    ){
        logger.debug("注册:{},{},{}",name,initiator,path);
        File file = new File(path);
        if (file.exists()) {
            blocksList.add(new registered.block(name,id,path,initiator,stack));
            logger.info("注册完成:{}",name);
            return true;
        }
        else {
            logger.error("注册失败:{}",name);
            return false;
        }
    }
}
