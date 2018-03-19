package com.sf.social.signinmvc.common.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sf.social.signinmvc.security.dto.SocialUserDetails;
import com.sf.social.signinmvc.user.model.SocialMediaService;
import com.sf.util.BusinessException;
import com.sf.util.DAOException;
import com.sf.util.Parametros;

/**
 * @author Petri Kainulainen
 */
@Controller
@SessionAttributes( {"EmpleadoLogueado","tipoConexion","UserProfile" })
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
	private ConnectionRepository connectionRepository;
    
    
    protected static final String VIEW_NAME_HOMEPAGE = "home";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHomePage(ModelMap model,Principal principal) {
    	
    	MultiValueMap<String, Connection<?>> conecciones = connectionRepository.findAllConnections();
		
		boolean isFacebook = false;
		boolean isTwitter = false;
		
		Facebook facebook = null;
		Twitter twitter = null;
		try {
			facebook = connectionRepository.getPrimaryConnection(Facebook.class).getApi();	
			isFacebook = true;
		} catch (Exception e) {
			e.printStackTrace();
		}	
		try {
			twitter = connectionRepository.getPrimaryConnection(Twitter.class).getApi();
			isTwitter = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (isFacebook) {
			model.addAttribute("tipoConexion", SocialMediaService.FACEBOOK);
			model.addAttribute("UserProfile",facebook.userOperations().getUserProfile());
			
		}
		if (isTwitter) {
			model.addAttribute("tipoConexion", SocialMediaService.TWITTER);
			model.addAttribute("UserProfile", twitter.userOperations().getUserProfile());
		}
		
		SocialUserDetails userDetails = getRealPrincipal(principal);
		//estudio.setEmpresa(userDetails.getEmpresa());
		
		/*try {
			
		} catch (DAOException e) {
			LOGGER.error("DAOException: Error consultando estudios filtrados por empresa y estado. El error es: " + e.getMessage(), e);
		} catch (BusinessException e) {
			LOGGER.error("BusinessException: Error consultando estudios filtrados por empresa y estado. El error es: " + e.getMessage(), e);
		}*/
		
		
		
        LOGGER.debug("Rendering homepage.");
        return VIEW_NAME_HOMEPAGE;
    }
    
    private SocialUserDetails getRealPrincipal(Principal principal) {
        if (principal instanceof SocialUserDetails) {
            return (SocialUserDetails) principal;
        }
        if (principal instanceof Authentication) {
            Object innerPrincipal = ((Authentication) principal).getPrincipal();
            if (innerPrincipal instanceof SocialUserDetails)
                return (SocialUserDetails) innerPrincipal;
        }
        // should not get here... my login service always sets a UserDetails instance.
        return null;
    }
}
