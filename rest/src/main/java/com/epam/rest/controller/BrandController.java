package com.epam.rest.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.rest.entity.Brand;
import com.epam.rest.entity.Show;
import com.epam.rest.service.BrandService;
import com.epam.rest.service.ShowService;

@Controller
@RequestMapping("/brands")
public class BrandController {
	@Autowired
	BrandService brandServices;
	@Autowired
	ShowService showServices;
	private static final Logger logger = Logger.getLogger(BrandController.class);

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getBrands(Model model) throws Exception {
		logger.debug("Received request to show all brends");
		List<Brand> brands = brandServices.getBrandList();
		model.addAttribute("brands", brands);
		return "brandspage";
	}

	@RequestMapping(value = "/json", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Brand>> getBrandsJson(Model model) throws Exception {
		logger.debug("Received requ 	est to show all brands");
		List<Brand> brands = brandServices.getBrandList();
		return new ResponseEntity<List<Brand>>(brands, HttpStatus.OK);
	}

	@RequestMapping(value = "/json1", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	@ResponseBody
	public String getBrandsJson1(Model model) throws Exception {
		logger.debug("Received request to show all brands");
		List<Brand> brands = brandServices.getBrandList();
		for (Brand brand : brands) {
			System.out.println(brand.getBrandName());
			for (Show show : brand.getShows())
				System.out.println(show.getShowName());
		}

		// ObjectWriter ow = new
		// ObjectMapper().writer().withDefaultPrettyPrinter();
		// String json = ow.writeValueAsString(brands);
		return "";
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String getShows(@RequestParam(value = "id", required = true) Integer id, Model model) throws Exception {
		logger.debug("Received request to show all Shows");
		Show show = showServices.getShowById(id);
		model.addAttribute("show", show);
		return "showpage";
	}
}
