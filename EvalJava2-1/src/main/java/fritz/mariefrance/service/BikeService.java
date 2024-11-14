package fritz.mariefrance.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fritz.mariefrance.dto.BikeDto;
import fritz.mariefrance.exception.CreateBikeException;
import fritz.mariefrance.model.BikeModel;
import fritz.mariefrance.model.Status;
import fritz.mariefrance.repository.BikeRepository;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public Collection<BikeDto> getAllBikes() {
        return modelsToDtos(bikeRepository.findAll());
    }

    public BikeDto createBike(BikeDto dto) throws CreateBikeException {
        if (dto.getId() != null) {
            throw new CreateBikeException("Impossible de mettre un Id pour créer un vélo");
        }
        BikeModel bikeModelToAdd = dtoToModel(dto);
        BikeModel bikeAddedInDb = bikeRepository.save(bikeModelToAdd);
        return modelToDto(bikeAddedInDb);
    }

    public BikeDto updateBike(BikeDto dto) {
        return modelToDto(bikeRepository.save(dtoToModel(dto)));
    }

    public BikeDto getBike(long id) {
        Optional<BikeModel> bikeModel = bikeRepository.findById(id);
        return bikeModel.map(this::modelToDto).orElse(null);
    }

    public Collection<BikeDto> getBikeByStatus(Status status) {
        return modelsToDtos(bikeRepository.findByStatus(status));
    }

    public boolean deleteBike(long id) {
        bikeRepository.deleteById(id);
        return true;
    }

    private Collection<BikeDto> modelsToDtos(Iterable<BikeModel> bikeModels) {
        Collection<BikeDto> bikeDtos = new ArrayList<>();
        bikeModels.forEach(bikeModel -> bikeDtos.add(modelToDto(bikeModel)));
        return bikeDtos;
    }

    private BikeDto modelToDto(BikeModel bikeModel) {
        BikeDto bikeDto = new BikeDto();
        bikeDto.setId(bikeModel.getId());
        bikeDto.setModel(bikeModel.getModel());
        bikeDto.setConceptor(bikeModel.getConceptor());
        bikeDto.setReleaseDate(bikeModel.getReleaseDate());
        bikeDto.setStatus(bikeModel.getStatus());
        return bikeDto;
    }

    private BikeModel dtoToModel(BikeDto bikeDto) {
        BikeModel bikeModel = new BikeModel();
        bikeModel.setId(bikeDto.getId());
        bikeModel.setModel(bikeDto.getModel());
        bikeModel.setConceptor(bikeDto.getConceptor());
        bikeModel.setReleaseDate(bikeDto.getReleaseDate());
        bikeModel.setStatus(bikeDto.getStatus());
        return bikeModel;
    }

}
