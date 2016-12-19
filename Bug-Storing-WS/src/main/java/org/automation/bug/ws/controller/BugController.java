package org.automation.bug.ws.controller;

import org.automation.bug.ws.controller.core.BaseController;
import org.automation.bug.ws.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by shantonu on 12/18/16.
 */
@Controller
public class BugController extends BaseController {
    @Autowired
    private BugService bugService;


}
