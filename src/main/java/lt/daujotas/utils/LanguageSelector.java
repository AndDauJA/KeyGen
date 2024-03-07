package lt.daujotas.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

public class LanguageSelector {

    public static void langselect(String lang, Model model, HttpServletRequest request){

//        if (lang != null && !lang.isEmpty()) {
//            // Čia galite nustatyti naudotojo kalbą, pavyzdžiui, išsaugoti ją sesijoje arba tiesiog perduoti į modelį
//            model.addAttribute("selectedLang", lang);
//        } else {
//            // Galite nustatyti numatytąją kalbą arba naudoti jau išsaugotą sesijoje
//            String prevLang = (String) request.getSession().getAttribute("lang");
//            model.addAttribute("selectedLang", prevLang != null ? prevLang : "en"); // "en" yra numatytoji kalba
//        }
    }
}
