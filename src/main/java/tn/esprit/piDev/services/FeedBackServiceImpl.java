package tn.esprit.piDev.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.piDev.entities.FeedBack;
import tn.esprit.piDev.exception.ResourceNotFoundException;
import tn.esprit.piDev.repositories.FeedBackRepository;

import java.util.List;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class FeedBackServiceImpl implements IFeedBackService {
    @Autowired
    FeedBackRepository feedBackRepository ;
    public List<FeedBack> retrieveAllFeedBacks() {
        return feedBackRepository.findAll();
    }


    public FeedBack retrieveFeedBack(long idFeedBack) {
        return feedBackRepository.findById(idFeedBack).orElseThrow(()-> new ResourceNotFoundException("Feedback","id",idFeedBack)) ;

    }


    public FeedBack addFeedBack(FeedBack f) {
        return feedBackRepository.save(f);
    }


    public void removeFeedBack(long idFeedBack) {
        feedBackRepository.deleteById(idFeedBack);
    }


    public FeedBack modifyFeedBack(FeedBack feedBack) {
        return feedBackRepository.save(feedBack);
    }
}
