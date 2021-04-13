package com.leprechaun.web;
import java.util.List;


import org.springframework.web.bind.annotation.*;

import com.leprechaun.business.FirstNameTranslation;
import com.leprechaun.business.LastNameTranslation;
import com.leprechaun.business.User;
import com.leprechaun.db.FirstNameTranslationRepo;
import com.leprechaun.db.LastNameTranslationRepo;
import com.leprechaun.db.UserRepo;
@CrossOrigin
@RestController
	
@RequestMapping ("/api/users")
public class UserController {

	@AutoWired
private UserRepo userRepo;

	@Autowired
private FirstNameTranslationRepo fntRepo;

	@Autowired
private LastNameTranslationRepo lntRepo;

	public List<User> getAll(){
	return userRepo.findAll();
}
@PostMapping("/api/create-user")
public User create(@RequestBody User u) {
	//generate lep name
	//first letter of firstname=firstnametranslation
	String firstLetter= u.getFirstName().substring(0, 1);
	//get firstnametranslation by firstletter
	FirstNameTranslation fnt= fntRepo.findByLetter(firstLetter);
	//birthmonth=lastnametranslation
	LastNameTranslation lnt=lntRepo.findByBirthMonth(u.getBirthMonth());
	
	String leprechaunName = fnt.getTranslation()+" "+lnt.getTranslation();
	u.setLeprechaunName(leprechaunName);
	return userRepo.save(u);
}
	
}
