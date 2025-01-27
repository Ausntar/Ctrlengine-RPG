package org.ctrlengine.ctrlengine_rpg.core;

/**
 * @author Ctrlengine Development Team
 */
public class registered {
    public static class goods {
        public String name;
        public String id;
        public String path;
        public String initiator;

        public goods(String name, String id,String path, String initiator) {
            this.name = name;
            this.id = id;
            this.path = path;
            this.initiator = initiator;
        }
        @Override
        public String toString() {
            return "Goods{name='" + name + "', id='" + id + "', initiator='" + initiator + "'}";
        }
    }
    public static class weapons {
        public String name;
        public String id;
        public String path;
        public String initiator;

        public long maxAttack;
        public long minAttack;
        public long maxRange;
        public long minRange;
        public long maxDamage;
        public long minDamage;
        public long durability;
        public long waitTime;

        public weapons(
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
        ) {
            this.name = name;
            this.id = id;
            this.path = path;
            this.initiator = initiator;
            this.maxAttack = maxAttack;
            this.minAttack = minAttack;
            this.maxRange = maxRange;
            this.minRange = minRange;
            this.maxDamage = maxDamage;
            this.minDamage = minDamage;
            this.durability = durability;
            this.waitTime = waitTime;
        }
    }
    public static class armour {
        public String name;
        public String id;
        public String path;
        public String initiator;
        //百分比计算
        public double maxProtection;
        public double minProtection;
        public long durability;
        public long waitTime;

        public armour(
                String name,
                String id,
                String path,
                String initiator,
                double maxProtection,
                double minProtection,
                long durability,
                long waitTime
        ) {
            this.name = name;
            this.id = id;
            this.path = path;
            this.initiator = initiator;
            this.maxProtection = maxProtection;
            this.minProtection = minProtection;
            this.durability = durability;
            this.waitTime = waitTime;
        }
    }
    public static class block{
        public String name;
        public String id;
        public String path;
        public String initiator;

        public long stack;
        public block(
                String name,
                String id,
                String path,
                String initiator,
                long stack
        ){
            this.name = name;
            this.id = id;
            this.path = path;
            this.initiator = initiator;
            this.stack = stack;
        }
    }
}
