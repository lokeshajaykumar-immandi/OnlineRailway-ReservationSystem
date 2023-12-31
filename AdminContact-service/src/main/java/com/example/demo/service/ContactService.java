package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;



@Service
public class ContactService {

	@Autowired
	private ContactRepository contactrepository;
	Logger logger = LoggerFactory.getLogger(getClass());

	public Contact addContact (Contact contact) {
		return contactrepository.save(contact);
	}

	public List<Contact> getContact() {
		List<Contact> contact = contactrepository.findAll();
		System.out.println("Getting data from DB : " + contact);
		logger.info("Getting data from DB : " + contact);
		return contact;
	}

	public Optional<Contact> getContactbyId(String id) {
		return contactrepository.findById(id);
	}

	public void deleteContact(Contact contact) {
		contactrepository.delete(contact);
		logger.info("Deleted successfully");
	}


}