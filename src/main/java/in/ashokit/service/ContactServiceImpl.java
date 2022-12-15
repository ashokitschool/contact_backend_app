package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.binding.Contact;
import in.ashokit.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository repo;

	@Override
	public String saveContact(Contact contact) {

		contact = repo.save(contact); // insertion

		if (contact.getContactId() != null) {
			return "Contact Saved";
		} else {
			return "Contact Failed To Save";
		}
	}

	@Override
	public List<Contact> getAllContacts() {
		return repo.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {

		Optional<Contact> findById = repo.findById(contactId);

		if (findById.isPresent()) {
			return findById.get();
		}

		return null;
	}

	@Override
	public String updateContact(Contact contact) {
		if (repo.existsById(contact.getContactId())) {
			repo.save(contact); // update operation
			return "Update Success";
		} else {
			return "No Record Found";
		}
	}

	@Override
	public String deleteContactById(Integer contactId) {
		if (repo.existsById(contactId)) {
			repo.deleteById(contactId);
			return "Record Deleted";
		} else {
			return "No Record Found";
		}
	}

}
