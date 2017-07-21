package org.wq.quartz.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Matcher;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;
import org.wq.quartz.job.MyJob;
import org.wq.quartz.listener.MyJobListener;
import org.wq.quartz.listener.MyScheduleListener;
import org.wq.quartz.listener.MyTriggerListener;

public class Myschedule {

	private static Scheduler createScheduler() throws SchedulerException {// 创建调度器
		return  StdSchedulerFactory.getDefaultScheduler();
	}

	public static void main(String[] args) {
		 Date date=new Date();
		 System.out.println("线程开始启动时间 : "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		try {
			JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
	                .usingJobData("name","叫叫叫job")
	                .usingJobData("group","狗狗狗group")
	                .build();
			Trigger trigger1 = TriggerBuilder.newTrigger()
					.usingJobData("trigger","吹吹吹trigger")
					//开始启动任务时间
					.startAt(new Date(date.getTime()+2000))
					//结束任务时间
					.endAt(new Date(date.getTime()+10000))
	                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * ? * *"))//执行频率
	                .build();
		
			Trigger trigger2 = TriggerBuilder.newTrigger()
					.usingJobData("trigger","吹吹吹trigger")
	                .withSchedule(
	                		SimpleScheduleBuilder.simpleSchedule()
	                        .withIntervalInMilliseconds(500)//任务间隔执行时间 单位 毫秒
	                        //.withIntervalInSeconds(3)//任务间隔执行时间 单位 秒
	                        .withRepeatCount(5))//触发器执行任务的重复次数n(任务执行总次数=n+1)
	                .build();
			
			
			Scheduler scheduler = createScheduler();
			scheduler.scheduleJob(jobDetail, trigger2);
			
			//添加一个job监听器
			scheduler.getListenerManager().addJobListener(new MyJobListener());
			//添加一个trigger监听器
			scheduler.getListenerManager().addTriggerListener(new MyTriggerListener());
			//添加一个schedule监听器
			scheduler.getListenerManager().addSchedulerListener(new MyScheduleListener());
			
			//启动调度器
			scheduler.start();
			Thread.sleep(10000);
			System.out.println("执行scheduler.clear()");
			scheduler.clear();
			Thread.sleep(3000);
			System.out.println("执行scheduler.shutdown()");
			scheduler.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
