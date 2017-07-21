package org.wq.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.Trigger.CompletedExecutionInstruction;
import org.quartz.TriggerListener;

public class MyTriggerListener implements TriggerListener {

	private static  int i=0;
	
	public String getName() {
		return "my  first trigger linstener";
	}

	public void triggerFired(Trigger trigger, JobExecutionContext context) {
		System.out.println("(MyTriggerListener)什么时候执行?---->肯定是在trigger触发执行 不信你看.....");
	}

	/**
	 * 任务开始前 或者 任务的joblistener的 jobToBeExecuted执行前执行
	 * 紧跟 triggerlistener的  triggerFired 方法执行
	 */
	public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
		// TODO Auto-generated method stub
		//return false 表示 触发器执行job
		//return true 表示 触发器拒绝执行job
		System.out.print("(MyTriggerListener)什么时候执行?----> 我也不知道 只有试试看.....");
		System.out.println("得出结论是在  任务开始前 或者 任务的joblistener的 jobToBeExecuted执行前执行");
		//这里可以根据逻辑 返回true or false 来控制任务执行与否
		i++;
		if(i%2==0){
			i=0;
			return true;
		}
		return false;
	}

	public void triggerMisfired(Trigger trigger) {
		System.out.println("(MyTriggerListener)什么时候执行?---->肯定是在trigger触发发现MisFire执行 不信你看.....");
	}

	/**
	 * 触发任务执行完 并且 任务的joblistener执行完后执行该方法
	 * 如果  triggerlistener的  vetoJobExecution 方法返回true 该方法不会执行
	 */
	public void triggerComplete(Trigger trigger, JobExecutionContext context,
			CompletedExecutionInstruction triggerInstructionCode) {
		System.out.println("(MyTriggerListener)什么时候执行?---->肯定是在trigger触发完成执行 不信你看.....\n");
		
	}
  

}
