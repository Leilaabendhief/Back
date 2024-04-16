package tn.esprit.piDev.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.piDev.repositories.OfferRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class ExcelService {


    private final OfferRepository offerRepository;


   /* public String uploadOfferFromExcel(MultipartFile file) {

    }*/
}
