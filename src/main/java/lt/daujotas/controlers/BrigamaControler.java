//package lt.daujotas.controlers;
//
//import lombok.RequiredArgsConstructor;
//import lombok.Value;
//import lombok.extern.log4j.Log4j2;
//import lt.daujotas.service.ClientAccountService;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//@Controller
//@Log4j2
//@RequiredArgsConstructor
//
//@PropertySource("classpath:keygenerator.properties")
//public class BrigamaControler {
//    private final ClientAccountService clientAccountService;
//
//    @Value("${company.name}")
//    private String companyName;
//    @Value("${developer.name}")
//    private String developerNAme;
//
//    @GetMapping
//    public String getFormFromCreate(Model model, String message){
//
//
//        model.addAttribute("companyName", companyName);
//        model.addAttribute("developerNAme", developerNAme);
//    }
//}
