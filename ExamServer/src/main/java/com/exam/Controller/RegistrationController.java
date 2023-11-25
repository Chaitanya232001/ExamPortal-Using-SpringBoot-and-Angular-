package com.exam.Controller;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.exam.model.Registration;
import com.exam.model.UserRole;
import com.exam.service.RegistrationService;


//@Controller
@RestController
@RequestMapping("/ExamServer")
//@RequestMapping("/api/v1/")
@CrossOrigin(origins="http://localhost:4200")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;


    @GetMapping("/index")
    public String indexpg() {
        return "index";
    }

    @GetMapping("/Registration")
    public String regipg(Model model) {
        model.addAttribute("registration", new Registration());
        return "Registration";
    }
     
    // @PostMapping("/Registration")
    // public String registerUser(@ModelAttribute Registration registration) throws Exception {
    //     Set<UserRole> userRoles = new HashSet<>();
    //     Registration registeredUser = registrationService.createRegistration(registration, userRoles);

    //     // Directly handle SignIn creation in RegistrationServiceIMPL
    //     registrationService.createSignInForUser(registeredUser, registration.getUsername(), registration.getPassword());

    //     return "redirect:/SignIn";
    // }
 	@PostMapping("/Registration") //@PostMapping("/")
	public Registration createUser(@RequestBody Registration registration,@RequestParam String email) throws Exception
	{
	 registration.setProfile("default.png");
	 registration.setPassword(registration.getPassword());
	 Set<UserRole>roles=new HashSet<>();
	 return this.registrationService.createRegistration(registration, roles);
	}

    // @GetMapping("/deleteRegistration/{id}")
    // public String deleteUser(@PathVariable Integer id) {
    //     registrationService.deleteRegistration(id);
    //     return "redirect:/Dashboard";
    // }
   
   //delete user by userId
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Integer id)
	{
	this.registrationService.deleteRegistration(id);
	}

    @GetMapping("/{username}")
	public Registration getUser(@PathVariable("username") String username)
	{
	return this.registrationService.getreRegistration(username);
	}
  

    @GetMapping("/ForgotPassword")
    public String forgotpasspg() {
        return "ForgotPassword";
    }

    @PostMapping("/ForgotPassword")
    public String updatePassword(@RequestParam(required = false) String email, @RequestParam(required = false) String password,
            @RequestParam(required = false) String newPassword, Model model) {
        try {
            Registration existingUser = registrationService.getByEmail(email.toLowerCase());
    
            if (existingUser != null) {
                if (existingUser.getPassword().equals(password)) {

                    existingUser.setPassword(newPassword);
                    registrationService.updatePassword(existingUser);
                    model.addAttribute("message", "Password updated successfully");
                } else {
                    model.addAttribute("message", "Old password is incorrect");
                }
            } else {
                model.addAttribute("message", "User not found with the provided email");
            }
    
            return "redirect:/Dashboard";
        } catch (Exception e) {
            model.addAttribute("message", "Error updating password");
            return "redirect:/Dashboard";
        }
    }
    
    
    @GetMapping("/allUsers") 
        public List<Registration> showRegistrations(){
            return registrationService.showRegistrations();
        }

     
    @GetMapping("/Dashboard")
    public String dashboard() {
        return "Dashboard";
    }

}
