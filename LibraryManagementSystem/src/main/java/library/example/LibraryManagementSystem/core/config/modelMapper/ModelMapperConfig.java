package library.example.LibraryManagementSystem.core.config.modelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

}
