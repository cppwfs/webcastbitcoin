package org.bitcoinmonitor;

import java.io.IOException;

import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@Component
public class Transform {

	@Transformer( inputChannel = "transformChannel", outputChannel = "mqttOut" )
	public String transformToCommonFormat(String json) throws JsonMappingException, JsonParseException, IOException{
	ObjectMapper objectMapper = new ObjectMapper();
    
    //convert json string to object
    RawData data = objectMapper.readValue(json, RawData.class);
    return data.toString();
	}
}
