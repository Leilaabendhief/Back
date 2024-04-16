package tn.esprit.piDev.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.piDev.entities.FeedBack;
import tn.esprit.piDev.services.IFeedBackService;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/**")
@RequestMapping("/feedback")
public class FeedBackRestController {
    @Autowired
    IFeedBackService feedBackService ;


    @GetMapping("/retrieve-all-feedbacks")
    public List<FeedBack> getFeedbacks() {
        List<FeedBack> listFeedbacks = feedBackService.retrieveAllFeedBacks() ;
        return listFeedbacks;
    }

    @GetMapping("/retrieve-feedback/{idFeedBack}")
    public FeedBack retrieveFeedBack(@PathVariable("idFeedBack") long idFeedBack ) {
        FeedBack  feedBack=feedBackService.retrieveFeedBack(idFeedBack) ;
        return feedBack ;
    }


    @PostMapping("/add-feedback")
    public FeedBack addFeedBack(@RequestBody FeedBack f) {
        FeedBack feedBack=feedBackService.addFeedBack(f) ;
        return feedBack ;
    }


    @DeleteMapping("/remove-feedback/{idFeedBack}")
    public void removeFeedBack(@PathVariable("idFeedBack") long  idFeedBack) {
        feedBackService.removeFeedBack(idFeedBack);
    }

    @PutMapping("/modify-feedback")
    public FeedBack modifyFeedBack(@RequestBody FeedBack f) {
        FeedBack feedBack=feedBackService.modifyFeedBack(f) ;
        return feedBack ;
    }
}
