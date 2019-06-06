package com.wtd.test;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

public class DynamicAddJob implements SimpleJob {

    public void execute(ShardingContext shardingContext) {
        switch (shardingContext.getShardingItem()){
            case 0:
                System.out.println("doing sharding 0...job name is "+shardingContext.getJobName());
                // do something by sharding item 0
                break;
            case 1:
                System.out.println("doing sharding 1...job name is "+shardingContext.getJobName());
                // do something by sharding item 1
                break;
        }
    }
}
