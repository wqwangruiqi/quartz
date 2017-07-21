package org.wq.quartz.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 
 * @author wangqiang 联系邮箱:417297506@qq.com 2017年7月21日 下午2:05:32 类的说明:job执行类
 *
 */
public class MyJob implements Job {
	
	private String name;
	private String group;
	private String trigger;
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		//int i=1/0;
		System.out.print("任务开始执行..........");
		System.out.print(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSS").format(new Date()));
		System.out.print(group+"======>"+name+"======>"+trigger);
		System.out.println("任务结束执行！");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getTrigger() {
		return trigger;
	}

	public void setTrigger(String trigger) {
		this.trigger = trigger;
	}

	
}
