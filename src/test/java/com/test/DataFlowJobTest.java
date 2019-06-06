package com.test;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.dataflow.DataflowJobConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.exception.JobSystemException;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.wtd.test.DynamicAddJob;
import com.wtd.test.MyDataFlowJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:application-job.xml"})
public class DataFlowJobTest {
    private static final String CRON_DATE_FORMAT = "ss mm HH dd MM ? yyyy";

    @Resource
    private ZookeeperRegistryCenter zookeeperRegistryCenter;

    @Test
    public void testAdd(){
        long now = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            String cron = "0/5 * * * * ?";
            JobCoreConfiguration coreConfig = JobCoreConfiguration.newBuilder("dynamicJob-" + i, cron, 2).build();

            DataflowJobConfiguration dataFlowConfig = new DataflowJobConfiguration(coreConfig, MyDataFlowJob.class.getCanonicalName(),false);
            JobScheduler jobScheduler = new JobScheduler(zookeeperRegistryCenter,
                    LiteJobConfiguration.newBuilder(dataFlowConfig).build());
            try {
                jobScheduler.init();
            }catch (JobSystemException e){
                e.printStackTrace();
            }
        }
        try {
            TimeUnit.SECONDS.sleep(30);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /***
     * @param date 时间
     * @return cron类型的日期
     */
    public static String getCron(final Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(CRON_DATE_FORMAT);
        String formatTimeStr = "";
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        System.out.println(formatTimeStr);
        return formatTimeStr;
    }
}
