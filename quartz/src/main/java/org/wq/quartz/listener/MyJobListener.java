package org.wq.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class MyJobListener implements JobListener {

	public String getName() {
		return "my first job lintener";
	}

	/**
	 * 该方法在任务执行前执行
	 * 如果  triggerlistener的  vetoJobExecution 方法返回true 该方法不会执行
	 */
	public void jobToBeExecuted(JobExecutionContext context) {
		System.out.println("(MyJobListener)什么时候执行?---->肯定是在任务方法前执行 不信你看.....");
	}

	/**
	 * job执行被触发器拒绝时执行
	 * 如果  triggerlistener的  vetoJobExecution 方法返回true 该方法才回执行
	 */
	public void jobExecutionVetoed(JobExecutionContext context) {
		System.out.print("(MyJobListener)什么时候执行?拭目以待....");
		System.out.println("得出结论是在  triggerlistener的  vetoJobExecution 方法返回true 该方法才回执行\n");
	}

	/**
	 *  任务执行完成后执行
	 *  如果jobException不为空 表示任务抛出了异常 如果这里不处理 其他地方会不知道有异常发生
	 *  如果  triggerlistener的  vetoJobExecution 方法返回true 该方法不会执行
	 */
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		System.out.print("(MyJobListener)什么时候执行?---->肯定是在任务方法执行后执行 不信你看......\t");
		System.out.println(jobException==null?"jobException是null":"jobException不是null");
	}

}
