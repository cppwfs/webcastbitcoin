/**
 * 
 */
package org.bitcoinmonitor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.messaging.MessageHandler;

/**
 * @author Glenn Renfro
 *
 */
@Configuration
@EnableIntegration
public class BitCoinIntegration {

	
	@InboundChannelAdapter(value = "bitStampHttp", poller = @Poller(maxMessagesPerPoll = "1", fixedRate = "10000"))
	public String bitStampPoller() {
		return "";
	}

	@Bean
	@ServiceActivator(inputChannel = "bitStampHttp")
	public MessageHandler bitStampHandler() {
		HttpRequestExecutingMessageHandler handler = new HttpRequestExecutingMessageHandler("https://www.bitstamp.net/api/ticker/");
		handler.setExpectedResponseType(String.class);
		handler.setOutputChannelName("transformChannel");
		System.out.println(handler.getConversionService());
		return handler;
	}





}
