package com.wtd.test;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MyDataFlowJob implements DataflowJob<Integer> {
    private static final Integer num = 100;
    private static List<Integer> allList = new ArrayList<Integer>();

    static{
        for(int i = 0;i < num;i++){
            allList.add(i);
        }
    }

    public List fetchData(ShardingContext shardingContext) {
        List<Integer> list = new ArrayList<Integer>();
        //片码
        int curPage = shardingContext.getShardingItem();
        //几片
        int page = shardingContext.getShardingTotalCount();

        //每片查询的数量
        int selectNum = num/page;
        if(num % page != 0){
            selectNum++;
        }
        list = getListForPages(curPage,selectNum);
        System.out.println("第" + curPage + "片：" + StringUtils.join(list,","));
        return list;
    }

    public void processData(ShardingContext shardingContext, List list) {
        System.out.println("总的收到数据：");
        System.out.println(StringUtils.join(list,","));
        System.out.println("--------over-------------");
    }

    private List<Integer> getListForPages(Integer curPage,Integer limit){
        int start = (curPage - 1) * limit;
        int end = start + limit;
        List<Integer> temp = new ArrayList<Integer>();
        for(int i = start;i < end;i++){
            temp.add(allList.get(i));
        }
        return temp;
    }
}
