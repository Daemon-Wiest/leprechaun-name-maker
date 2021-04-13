package com.leprechaun.web;
import java.util.List;


import org.springframework.web.bind.annotation.*;

import com.leprechaun.business.FirstNameTranslation;
import com.leprechaun.db.FirstNameTranslationRepo;
@CrossOrigin
@RestController
	
@RequestMapping ("/api/first-names")
public class FirstNameTranslationController {

private FirstNameTranslationRepo firstNameRepo;

public List<FirstNameTranslation> getAll(){
	return firstNameRepo.findAll();
}

	
}
