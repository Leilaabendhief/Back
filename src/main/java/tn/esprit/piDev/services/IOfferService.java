package tn.esprit.piDev.services;

import tn.esprit.piDev.entities.ExcelData;
import tn.esprit.piDev.entities.Offer;

import java.util.List;
import java.util.Map;

public interface IOfferService {
    public List<Offer> retrieveAllOffers() ;
    public Offer retrieveOffer(long idOffer) ;
    public Offer addOffer(Offer o) ;
    public void removeOffer(long idOffer) ;
    public Offer modifyOffer(Offer offer) ;
    public void saveOffersFromExcel(List<ExcelData> excelDataList) ;
    public List<Offer> getMatchedOffersForUser(Long userId) ;
    public Map<String, Long> getOfferCountsByLocation() ;
    public List<Offer> getOffersByLocation(String location) ;

}
