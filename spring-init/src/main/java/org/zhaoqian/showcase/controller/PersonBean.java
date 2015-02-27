package org.zhaoqian.showcase.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zhaoqian.model.Person;
import org.zhaoqian.repository.PersonRepository;
import org.zhaoqian.showcase.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonBean
{
	private static final int DEFAULT_PAGE_NUM = 0;
	private static final int DEFAULT_PAGE_SIZE = 10;

	@Autowired
	PersonService psersonService;

	@Autowired
	PersonRepository personRepository;

	protected static final Logger log = LoggerFactory.getLogger(PersonBean.class);

	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) Integer page, Model model)
	{
		int pageNumber = page != null ? page : DEFAULT_PAGE_NUM;
		Page<Person> pagingPerson = psersonService.findAllForPagination(pageNumber, DEFAULT_PAGE_SIZE);
		model.addAttribute("pagingPerson", pagingPerson);
		return "/person/list";
	}

	@ModelAttribute
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public Person create(Model model)
	{
		Person person = new Person();
		return person;
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String save(@Valid Person person, BindingResult bindingResult, Model model)
	{
		log.info("create person {}", person);
		if (bindingResult.hasErrors())
		{
			log.info("Error:{}", bindingResult.getModel());
			model.addAllAttributes(bindingResult.getModel());
			return "/person/form";
		}
		personRepository.save(person);
		return "redirect:/person/list";
	}

	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable("id") String id, Model model)
	{
		Person person = personRepository.findOne(id);
		model.addAttribute(person);
		return "/person/form";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String submitEdit(@Valid Person person, BindingResult bindingResult, Model model)
	{
		log.debug("edit person={}", person);
		if (bindingResult.hasErrors())
		{
			log.warn("validation error={}", bindingResult.getModel());
			model.addAllAttributes(bindingResult.getModel());
			return "person/form";
		}
		this.personRepository.save(person);
		return "redirect:/person/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") String id)
	{

		this.personRepository.delete(id);
		return "redirect:/person/list";
	}

}
