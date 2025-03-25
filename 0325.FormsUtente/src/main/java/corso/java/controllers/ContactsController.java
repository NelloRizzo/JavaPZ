package corso.java.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import corso.java.entities.ContactEntity;
import corso.java.repositories.ContactsRepository;

@Controller
@RequestMapping("/contacts")
public class ContactsController {

	@Autowired
	ContactsRepository contacts;

	@GetMapping
	public String list(Map<String, Object> map) {
		map.put("contacts", contacts.findAll());
		return "contacts/list";
	}

	@GetMapping("/add")
	public String addContact(Map<String, Object> map) {
		map.put("contact", new ContactEntity());
		return "contacts/insert";
	}

	@PostMapping("/add")
	public String addContact(@ModelAttribute ContactEntity data) {
		contacts.save(data);
		return "redirect:/contacts";
	}
}
