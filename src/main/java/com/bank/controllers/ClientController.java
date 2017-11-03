package com.bank.controllers;

import com.bank.model.entity.Account;
import com.bank.services.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientController {

    @Autowired
    private IClientService clientService;

    @RequestMapping("/client")
    public String getClientPage() {
        return "client_main";
    }

    @RequestMapping(value = "/transfer/inside", method = RequestMethod.POST)
    public String transferInside(@RequestParam(value = "from") Account from,
                                 @RequestParam(value = "toInside") Account to,
                                 @RequestParam Double value
    ) {

        clientService
                .transferFromAccToAcc(from, to, value);

        return "redirect:/";
    }

    @RequestMapping(value = "/transfer/toClient", method = RequestMethod.POST)
    public String transferToClient(@RequestParam(value = "from") Account from,
                                 @RequestParam Integer clientAccountId,
                                 @RequestParam Double value
    ) {

        clientService
                .transferToClientAccount(from, clientAccountId, value);

        return "redirect:/";
    }
}
