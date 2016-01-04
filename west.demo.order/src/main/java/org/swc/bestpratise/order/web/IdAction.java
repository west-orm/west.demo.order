package org.swc.bestpratise.order.web;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/IdServer")
public class IdAction {
	
	private ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
	
	@RequestMapping(value = "/get")
	public @ResponseBody String get(RedirectAttributes redirectAttributes) {
		long start = System.nanoTime();
		if(queue.isEmpty())
		{
			queue.add("s1"+System.nanoTime());
		}
		
		Object peek = queue.poll();
		
		long end = System.nanoTime();
		long total = end - start;
		return String.valueOf(peek)+"-"+(total);
		
	}

}
