package com.nttdata.hibernate_t1;

import java.util.Date;

import com.nttdata.hibernate_t1.utilities.InterfaceUtils;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.LayoutBase;

public class NTTDataLayout extends LayoutBase<ILoggingEvent> {

	/** Print prefix */
	private String prefix;
	
	/** Print thread name */
	private boolean printThreadName = Boolean.TRUE;
	
	
	/**
	 * Generate layout
	 * 
	 * @param event
	 * @return String
	 */
	@Override
	public String doLayout(ILoggingEvent event) {
		
		final StringBuilder sb = new StringBuilder();
		sb.append(InterfaceUtils.toStrBuilder((new Date(event.getTimeStamp()).toString()), " ", prefix, " ", event.getLevel().toString()));
		
		if(printThreadName) {
			sb.append(InterfaceUtils.toStrBuilder(" [", event.getThreadName(),"] "));
		}
		
		sb.append((InterfaceUtils.toStrBuilder(" ", event.getLoggerName(), " - ", event.getFormattedMessage(), "\n")));
		
		return sb.toString();
	}

}
