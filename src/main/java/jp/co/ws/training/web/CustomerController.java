package jp.co.ws.training.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.ws.training.domain.Customer;
import jp.co.ws.training.form.CustomerForm;
import jp.co.ws.training.service.CustomerService;
import jp.co.ws.training.util.ConstUtil;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @ModelAttribute
    CustomerForm setUpForm() {
        return new CustomerForm();
    }

    @GetMapping
    String list(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customers/list";
    }


    @PostMapping(path = "edit" , params="create")
    String create(@Validated CustomerForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            BeanUtils.copyProperties(model, form);
            form.setMode(ConstUtil.MODE_CREATE);

        	return "customers/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(form, customer);
        customerService.create(customer);
        return "redirect:/customers";
    }

    @GetMapping(path = "edit", params = "form")
    String editForm(@RequestParam Integer id, CustomerForm form) {
        Customer customer = customerService.findOne(id);
        //更新モードを設定
        form.setMode(ConstUtil.MODE_UPDATE);
        BeanUtils.copyProperties(customer, form);
        return "customers/edit";
    }


    /**
    * 新規画面表示
    * @param id
    * @param form
    * @param result
    * @return@RequestParam(value = "name", required = false)
    */
   @GetMapping(path = "new")
   String newForm(@RequestParam Optional<Integer> id,CustomerForm form) {

       //新規モードを設定
       form.setMode(ConstUtil.MODE_CREATE);

       return "customers/edit";
   }


    /**
     *
     * @param id
     * @param form
     * @param result
     * @return@RequestParam(value = "name", required = false)
     */
    @PostMapping(path = "edit", params = "update")
    String edit(@RequestParam Integer id , @Validated CustomerForm form, BindingResult result) {
        if (result.hasErrors()) {
            form.setMode(ConstUtil.MODE_CREATE);

        	return "customers/edit";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(form, customer);
        customer.setId(id);
        customerService.update(customer);

        return "redirect:/customers";
    }

    @RequestMapping(path = "edit", params = "goToTop")
    String goToTop() {
        return "redirect:/customers";
    }

    @RequestMapping(path = "edit", params = "goToTopFromCreate")
    String goToTopFromCreate() {
        return "redirect:/customers";
    }

    /**
     *
     * @param id
     * @param form
     * @return
     */
    @GetMapping(path = "reference", params = "form")
    String referenceForm(@RequestParam Integer id, CustomerForm form) {
        Customer customer = customerService.findOne(id);
        BeanUtils.copyProperties(customer, form);
        return "customers/ref";
    }

    @GetMapping(path = "reference", params = "goToTop")
    String goToBack() {
        return "redirect:/customers";
    }

    @PostMapping(path = "delete")
    String delete(@RequestParam Integer id) {
        customerService.delete(id);
        return "redirect:/customers";
    }
}