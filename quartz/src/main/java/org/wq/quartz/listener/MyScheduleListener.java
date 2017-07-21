package org.wq.quartz.listener;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.SchedulerListener;
import org.quartz.Trigger;
import org.quartz.TriggerKey;


/**
 * 
 * @author wangqiang
 *联系邮箱:417297506@qq.com
 * 2017年7月21日 下午4:21:29
 * 类的说明:
 *schedule监听器 该类各个方法自己体会 
 */

public class MyScheduleListener implements SchedulerListener {

	public void jobScheduled(Trigger trigger) { 
		System.out.println("(MyScheduleListener)jobScheduled ------什么时候执行？");
		
	}

	public void jobUnscheduled(TriggerKey triggerKey) {
		System.out.println("(MyScheduleListener)--------------");
		
	}

	public void triggerFinalized(Trigger trigger) {
		System.out.println("(MyScheduleListener)有调度器被完全停止调度时执行===========");
		
	}

	public void triggerPaused(TriggerKey triggerKey) {
		// TODO Auto-generated method stub
		
	}

	public void triggersPaused(String triggerGroup) {
		// TODO Auto-generated method stub
		
	}

	public void triggerResumed(TriggerKey triggerKey) {
		// TODO Auto-generated method stub
		
	}

	public void triggersResumed(String triggerGroup) {
		// TODO Auto-generated method stub
		
	}

	public void jobAdded(JobDetail jobDetail) {
		// TODO Auto-generated method stub
		
	}

	public void jobDeleted(JobKey jobKey) {
		// TODO Auto-generated method stub
		
	}

	public void jobPaused(JobKey jobKey) {
		// TODO Auto-generated method stub
		
	}

	public void jobsPaused(String jobGroup) {
		// TODO Auto-generated method stub
		
	}

	public void jobResumed(JobKey jobKey) {
		// TODO Auto-generated method stub
		
	}

	public void jobsResumed(String jobGroup) {
		// TODO Auto-generated method stub
		
	}

	public void schedulerError(String msg, SchedulerException cause) {
		// TODO Auto-generated method stub
		
	}

	public void schedulerInStandbyMode() {
		// TODO Auto-generated method stub
		
	}

	public void schedulerStarted() {
		System.out.println("(MyScheduleListener)调度器启动完成");
		// TODO Auto-generated method stub
		
	}

	public void schedulerStarting() {
		System.out.println("(MyScheduleListener)调度器正在启动");
		// TODO Auto-generated method stub
		
	}

	//scheduler关闭完成后执行
	public void schedulerShutdown() {
		// TODO Auto-generated method stub
		System.out.println("(MyScheduleListener)调度器关闭完成");
	}

	//执行scheduler.shutdown()方法执行完成后执行
	public void schedulerShuttingdown() {
		System.out.println("(MyScheduleListener)调度器正在关闭");
	}

	//scheduler.clear();方法执行完成后执行
	public void schedulingDataCleared() {
		System.out.println("(MyScheduleListener)调度器数据清除完成");
	}

	 

}
