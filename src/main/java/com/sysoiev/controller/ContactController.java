package com.sysoiev.controller;

import com.sysoiev.dao.DaoMySqlClass;
import com.sysoiev.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ContactController {

        @Autowired
        DaoMySqlClass dao;//will inject dao from XML file

        /*It displays a form to input data, here "command" is a reserved request attribute
         *which is used to display object data into form
         */
        @RequestMapping("/contactform")
        public String showform(Model m){
            m.addAttribute("command", new Contact());
            return "contactform";
        }
        /*It saves object into database. The @ModelAttribute puts request data
         *  into model object. You need to mention RequestMethod.POST method
         *  because default request is GET*/
        @RequestMapping(value="/save",method = RequestMethod.POST)
        public String save(@ModelAttribute("contact") Contact contact){
            dao.save(contact);
            return "redirect:/viewemp";//will redirect to viewemp request mapping
        }
        /* It provides list of employees in model object */
        @RequestMapping("/viewcontact")
        public String viewemp(Model m){
            List<Contact> list=dao.getContacts();
            m.addAttribute("list",list);
            return "viewcontact";
        }
        /* It displays object data into form for the given id.
         * The @PathVariable puts URL data into variable.*/
        @RequestMapping(value="/editcontact/{id}")
        public String edit(@PathVariable int id, Model m){
            Contact contact=dao.getContactById(id);
            m.addAttribute("command",contact);
            return "empeditform";
        }
        /* It updates model object. */
        @RequestMapping(value="/editsave",method = RequestMethod.POST)
        public String editsave(@ModelAttribute("emp") Contact contact){
            dao.update(contact);
            return "redirect:/viewemp";
        }
        /* It deletes record for the given id in URL and redirects to /viewemp */
        @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)
        public String delete(@PathVariable int id){
            dao.delete(id);
            return "redirect:/viewemp";
        }
    }