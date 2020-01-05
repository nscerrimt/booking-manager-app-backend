package mt.com.ecabs.booking_manager;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import mt.com.ecabs.booking_manager.utils.ObjectMapper;

@Configuration
public class BookingManagerConfig {

	@Bean
	@Scope("prototype")
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
	    return modelMapper;
	}
	
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
	
}