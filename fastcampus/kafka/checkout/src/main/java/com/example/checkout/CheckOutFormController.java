package com.example.checkout;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CheckOutFormController {

    @GetMapping("/checkOutForm")
    public String checkOutForm(Model model) {
        log.info("checkOutForm");
        return "checkOutForm";
    }
}
