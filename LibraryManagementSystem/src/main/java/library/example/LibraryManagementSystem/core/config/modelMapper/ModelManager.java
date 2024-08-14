package library.example.LibraryManagementSystem.core.config.modelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelManager implements IModelMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public ModelManager(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.modelMapper;
    }

    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper;
    }
}
