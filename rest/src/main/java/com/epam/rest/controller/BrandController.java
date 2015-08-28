package com.epam.rest.controller;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.rest.entity.Brand;
import com.epam.rest.entity.Episode;
import com.epam.rest.entity.Show;
import com.epam.rest.service.BrandService;
import com.epam.rest.service.EpisodeService;
import com.epam.rest.service.ShowService;

@Controller
@RequestMapping("/brands")
public class BrandController {
	@Autowired
	BrandService brandServices;
	@Autowired
	ShowService showServices;
	@Autowired
	EpisodeService episodeServices;
	private static final Logger logger = Logger.getLogger(BrandController.class);

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getBrands(Model model) throws Exception {
		logger.debug("Received request to show all brends");
		List<Brand> brands = brandServices.getBrandList();
		model.addAttribute("brands", brands);
		return "brands";
	}

	@RequestMapping(value = "/json", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Brand>> getBrandsJson(Model model) throws Exception {
		List<Brand> brands = brandServices.getBrandList();
		return new ResponseEntity<List<Brand>>(brands, HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addBrand(@ModelAttribute Brand brand) throws Exception {
		logger.debug("Received request to add new user");
		brandServices.addBrand(brand);
		return "userpage";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editBrand(@ModelAttribute("userAttribute") Brand brand, @RequestParam(value = "brandId", required = true) Integer id, Model model) throws Exception {
		logger.debug("Received request to update brand");
		brandServices.editBrand(brand);
		return "brands";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteBrand(@RequestParam(value = "brandId", required = true) Integer id) throws Exception {
		logger.debug("Received request to delete existing brand");
		brandServices.deleteBrand(id);
		return "brands";
	}

	@RequestMapping(value = "/shows", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Set<Show>> getShow(@RequestParam(value = "id") Integer id, Model model) throws Exception {
		Brand brand = brandServices.getBrandById(id);
		Set<Show> shows = brand.getShows();
		return new ResponseEntity<Set<Show>>(shows, HttpStatus.OK);
	}

	@RequestMapping(value = "/shows/add", method = RequestMethod.POST)
	public String addShow(@ModelAttribute Show show) throws Exception {
		logger.debug("Received request to add new show");
		showServices.addShow(show);
		return "brands";
	}

	@RequestMapping(value = "/shows/edit", method = RequestMethod.POST)
	public String editShow(@ModelAttribute Show show, @RequestParam(value = "showId", required = true) Integer id, Model model) throws Exception {
		logger.debug("Received request to update show");
		showServices.editShow(show);
		return "brands";
	}

	@RequestMapping(value = "/shows/delete", method = RequestMethod.POST)
	public String deleteShow(@RequestParam(value = "showId", required = true) Integer id) throws Exception {
		logger.debug("Received request to delete existing show");
		showServices.deleteShow(id);
		return "brands";
	}

	@RequestMapping(value = "/shows/episodes", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Set<Episode>> getEpisodes(@RequestParam(value = "id") Integer id, Model model) throws Exception {
		Show show = showServices.getShowById(id);
		Set<Episode> episodes = show.getEpisodes();
		return new ResponseEntity<Set<Episode>>(episodes, HttpStatus.OK);
	}

	@RequestMapping(value = "/shows/episodes/add", method = RequestMethod.POST)
	public String addEpisode(@ModelAttribute Episode episode) throws Exception {
		logger.debug("Received request to add new episode");
		episodeServices.addEpisode(episode);
		return "brands";
	}

	@RequestMapping(value = "/shows/episodes/edit", method = RequestMethod.POST)
	public String editEpisode(@ModelAttribute Episode episode, @RequestParam(value = "episodeId", required = true) Integer id, Model model) throws Exception {
		logger.debug("Received request to update episode");
		episodeServices.editEpisode(episode);
		return "brands";
	}

	@RequestMapping(value = "/shows/episodes/delete", method = RequestMethod.POST)
	public String deleteEpisode(@RequestParam(value = "episodeId", required = true) Integer id) throws Exception {
		logger.debug("Received request to delete existing episode");
		episodeServices.deleteEpisode(id);
		return "brands";
	}

}
