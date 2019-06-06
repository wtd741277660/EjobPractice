package com.wtd;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

public class JobA implements SimpleJob {
    public void execute(ShardingContext shardingContext) {
        System.out.println("JobA>>>>getJobName>>>"+shardingContext.getJobName());
        System.out.println("JobA>>>getShardingParameter>>>>"+shardingContext.getShardingParameter());
        System.out.println("JobA>>>>getTaskId>>>"+shardingContext.getTaskId());
        System.out.println("JobA>>>>getShardingItem>>>"+shardingContext.getShardingItem());
        System.out.println("JobA>>>>getShardingTotalCount>>>"+shardingContext.getShardingTotalCount());
    }
}
