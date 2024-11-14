package fritz.mariefrance.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fritz.mariefrance.dto.BikeDto;
import fritz.mariefrance.exception.CreateBikeException;
import fritz.mariefrance.service.BikeService;

@RestController
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping()
    public Collection<BikeDto> getAllBikes() {
        return bikeService.getAllBikes();
    }

    @GetMapping("/{id}")
    public BikeDto getBike(@PathVariable("id") long id) {
        return bikeService.getBike(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteBike(@PathVariable("id") long id) {
        return bikeService.deleteBike(id);
    }

    @PostMapping
    public BikeDto createBike(@RequestBody BikeDto bikeDto) throws CreateBikeException {
        BikeDto responseDto = bikeService.createBike(bikeDto);

        return responseDto;
    }

    @PutMapping()
    public BikeDto updateBike(@RequestBody BikeDto bikeDto) {
        return bikeService.updateBike(bikeDto);
    }

}
