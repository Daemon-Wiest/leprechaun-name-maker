package com.leprechaun.web;
import java.util.List;


import org.springframework.web.bind.annotation.*;

import com.leprechaun.business.LastNameTranslation;

import com.leprechaun.db.LastNameTranslationRepo;
@CrossOrigin
@RestController
	
@RequestMapping ("/api/last-names")
public class LastNameTranslationController {
@AutoWired
private LastNameTranslationRepo lastNameRepo;

public List<LastNameTranslation> getAll(){
	return lastNameRepo.findAll();
}

	
}
