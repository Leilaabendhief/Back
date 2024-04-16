package tn.esprit.piDev.services;

import tn.esprit.piDev.entities.FeedBack;


import java.util.List;

public interface IFeedBackService {
    public List<FeedBack> retrieveAllFeedBacks() ;
    public FeedBack retrieveFeedBack(long idFeedBack) ;
    public FeedBack addFeedBack(FeedBack f) ;
    public void removeFeedBack(long idFeedBack) ;
    public FeedBack modifyFeedBack(FeedBack feedBack) ;
}
