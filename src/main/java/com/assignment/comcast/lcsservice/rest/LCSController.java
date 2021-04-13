package com.assignment.comcast.lcsservice.rest;

import com.assignment.comcast.lcsservice.dto.LCSRequest;
import com.assignment.comcast.lcsservice.dto.LCSResponse;
import com.assignment.comcast.lcsservice.dto.SetOfString;
import com.assignment.comcast.lcsservice.rest.impl.LCSServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RestController
public class LCSController {

private final String REQUEST_BODY_NOT_VALID   ="The format of the request is not acceptable.";

private final String SET_OF_STRING_NOT_EMPTY  ="The setOfStrings should NOT be empty in the request.";

private final String SET_OF_STRING_NOT_UNIQUE ="The setOfStrings should be a set and it should have unique values.";

@Autowired
private LCSServiceImpl lcsServiceImpl;



    public LCSController(LCSServiceImpl lcsServiceImpl) {
        this.lcsServiceImpl = lcsServiceImpl;
    }

    @GetMapping("/")
    public String getHomePage()
    {
        return "Hello World: This is Home page for LCS";
    }

    @PostMapping("/lcs")
    @ResponseBody
    private LCSResponse getLCSSubstring(@RequestBody LCSRequest request, HttpServletResponse response)
    {
        LCSResponse lcsResponse = new LCSResponse();
        System.out.println("LCS Request"+request.toString());


        if(null != request) {

            List<SetOfString> list = request.getSetOfStrings();

            if (list == null || list.size() == 0) {
                System.out.println("LCS Request set of string is null");
                lcsResponse.setMessage(SET_OF_STRING_NOT_EMPTY);
                return lcsResponse;
            }
            else {
                Set<String> items = new HashSet<>();
                list.stream().filter( n -> items.add(n.getValue())).collect(Collectors.toSet());
                items.forEach(n -> System.out.println(n));

                if(items.size() < list.size())
                {
                    lcsResponse.setMessage(SET_OF_STRING_NOT_UNIQUE);
                    return lcsResponse;
                }

                else {
                    return lcsServiceImpl.getLCSSubstring(request);
                }

            }
        }
        else {
            System.out.println("LCS Request is NULL");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            lcsResponse.setMessage(REQUEST_BODY_NOT_VALID);
            return lcsResponse;

        }
    }

    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity sendViaException() {
        throw new ForbiddenException();
    }


}
