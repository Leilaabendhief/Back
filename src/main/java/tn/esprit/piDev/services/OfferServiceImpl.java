package tn.esprit.piDev.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tn.esprit.piDev.entities.ExcelData;
import tn.esprit.piDev.entities.Offer;
import tn.esprit.piDev.entities.User;
import tn.esprit.piDev.entities.UserDTO;
import tn.esprit.piDev.repositories.FavOffersRepository;
import tn.esprit.piDev.repositories.OfferRepository;
import tn.esprit.piDev.repositories.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
public class OfferServiceImpl implements IOfferService{
    @Autowired
    OfferRepository offerRepository;
    @Autowired
    FavOffersRepository favOffersRepository ;
    @Autowired
    UserRepository userRepository ;
    public List<Offer> retrieveAllOffers() {
        return offerRepository.findAll();
    }


    public Offer retrieveOffer(long idOffer) {
        return offerRepository.findById(idOffer).get() ;
    }


    public Offer addOffer(Offer o) {
        return offerRepository.save(o);
    }


    public void removeOffer(long idOffer) {
        offerRepository.deleteById(idOffer);


    }


    public Offer modifyOffer(Offer offer) {
        return offerRepository.save(offer);
    }


    public void saveOffersFromExcel(List<ExcelData> excelDataList) {
        for (ExcelData excelData : excelDataList) {
            Offer offer = transformToOffer(excelData); // Transform ExcelData to Offer
            offerRepository.save(offer);
        }
    }

    private Offer transformToOffer(ExcelData excelData) {
        Offer offer = new Offer();
        offer.setOfferTitle(excelData.getOffer_title());
        offer.setOfferDescription(excelData.getOffer_description());
        offer.setOfferStatus(excelData.getOffer_status());
        offer.setPostingDate(excelData.getPosting_date());
        offer.setClosingDate(excelData.getClosing_date());
        offer.setLocation(excelData.getLocation());
        offer.setEmployementType(excelData.getEmployment_type());
        return offer;
    }

    public List<Offer> getMatchedOffersForUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        List<Offer> matchedOffers = offerRepository.findByOfferTitleContainingIgnoreCase(user.getDomainOfStudies());
        return matchedOffers;
    }

    public Map<String, Long> getOfferCountsByLocation() {
        List<Object[]> countsByLocation = offerRepository.countOffersByLocation();
        Map<String, Long> offerCounts = new HashMap<>();

        for (Object[] result : countsByLocation) {
            String location = (String) result[0];
            Long count = (Long) result[1];
            offerCounts.put(location, count);
        }

        return offerCounts;
    }

    public List<Offer> getOffersByLocation(String location) {

        return offerRepository.findOffersByLocation(location);
    }

}
