package org.zhaoqian.showcase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zhaoqian.model.Person;
import org.zhaoqian.repository.PersonRepository;

@Service
public class PersonService
{
	@Autowired
	PersonRepository personRepository;

	@Transactional(readOnly = true)
	public Page<Person> findAllForPagination(int page, int size)
	{
		Pageable pageable = new PageRequest(page, size, new Sort(Direction.DESC, "id"));
		Page<Person> persons = personRepository.findAll(pageable);
		return persons;
	}
}
