package tn.esprit.piDev.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.piDev.entities.ExcelData;
import tn.esprit.piDev.entities.ExcelReader;
import tn.esprit.piDev.entities.FavOffers;
import tn.esprit.piDev.entities.Offer;
import tn.esprit.piDev.repositories.FavOffersRepository;
import tn.esprit.piDev.services.IOfferService;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@AllArgsConstructor

@RequestMapping("/offer")
public class OfferRestController {
    @Autowired
    IOfferService offerService ;

    @Autowired
    private FavOffersRepository favOfferRepository;



    @GetMapping("/retrieve-all-offers")
    public List<Offer> getOffers() {
        List<Offer> listOffers = offerService.retrieveAllOffers() ;
        return listOffers ;
    }

    @GetMapping("/retrieve-offer/{idOffer}")
    public Offer retrieveOffer(@PathVariable("idOffer") long idOffer) {
        Offer  offer=offerService.retrieveOffer(idOffer) ;
        return offer ;
    }


    @PostMapping("/add-offer")
    public Offer addOffer(@RequestBody Offer o) {
        Offer offer=offerService.addOffer(o) ;
        return offer ;
    }

    @DeleteMapping("/remove-offer/{idOffer}")
    public void removeOffer(@PathVariable("idOffer") long idOffer) {
        offerService.removeOffer(idOffer);
    }

    @PutMapping("/modify-offer")
    public Offer modifyOffer(@RequestBody Offer o) {
        Offer offer=offerService.modifyOffer(o) ;
        return offer ;
    }
    @PostMapping("/upload")
    public void uploadOffersFromExcel(@RequestBody MultipartFile file) throws IOException, ParseException {
        ExcelReader excelReader = new ExcelReader();
        List<ExcelData> excelDataList = excelReader.readExcelFile(file);
        offerService.saveOffersFromExcel(excelDataList);
    }

    @GetMapping("/match/{userId}")
    public ResponseEntity<List<Offer>> getMatchedOffersForUser(@PathVariable Long userId) {
        List<Offer> matchedOffers = offerService.getMatchedOffersForUser(userId);
        return ResponseEntity.ok(matchedOffers);
    }

    @GetMapping("/countByLocation")
    public Map<String, Long> getOfferCountsByLocation() {
        return offerService.getOfferCountsByLocation();
    }

    @GetMapping("/offersByLocation")
    public List<Offer> getOffersByLocation(@RequestParam("location") String location) {

        List<Offer> offers = offerService.getOffersByLocation(location);

        return offers;
    }

    @GetMapping("/getFavOffers")
    public List<FavOffers> getAllFavoriteOffers() {
        return favOfferRepository.findAll();
    }

    @PostMapping("/addTofav")
    public FavOffers addToFavorites(@RequestBody FavOffers favOffer) {
        return favOfferRepository.save(favOffer);
    }

    @DeleteMapping("/removeFavOffers/{idfavOffer}")
    public void removeFromFavorites(@PathVariable Long idfavOffer) {
        favOfferRepository.deleteById(idfavOffer);
    }

}
