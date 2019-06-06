package com.wtd;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

public class JobB implements SimpleJob {
    public void execute(ShardingContext shardingContext) {
//        System.out.println("JobB>>>>getJobName>>>"+shardingContext.getJobName());
//        System.out.println("JobB>>>getShardingParameter>>>>"+shardingContext.getShardingParameter());
//        System.out.println("JobB>>>>getTaskId>>>"+shardingContext.getTaskId());
//        System.out.println("JobB>>>>getShardingItem>>>"+shardingContext.getShardingItem());
//        System.out.println("JobB>>>>getShardingTotalCount>>>"+shardingContext.getShardingTotalCount());
    }
}
