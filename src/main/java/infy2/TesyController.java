package infy2;

import java.util.ArrayList;

import javax.enterprise.inject.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import infy1.PaperService;

import java.util.List;

@RestController
public class TesyController {
	
	@Autowired
	PaperService paperService;
@RequestMapping("/a")
@GetMapping
public List<Paper12> getAllPapers() {
	
	return paperService.getAllPapers();
}
}
