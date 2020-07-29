package infy2;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import infy1.PaperService;

@RestController
public class TesyController {
	
	
	Logger logger = LoggerFactory.getLogger(TesyController.class);
	
	@Autowired
	PaperService paperService;
@RequestMapping("/a")
@GetMapping
public List<Paper12> getAllPapers() {
	
	return paperService.getAllPapers();
}

@RequestMapping("/getAllItems")
@GetMapping
public List<ItemModel> getAllItems() {
	
	return paperService.getAllItems();
}
@RequestMapping("/saveAll")
@PostMapping
public List<Paper12> saveAllPapers(@RequestBody Paper12 pp) {
	
	return paperService.getAllPapers();
}

@RequestMapping("/saveOrder")
@PostMapping
public String saveOrder(@RequestBody OrderModel orderModel) {
	
	return paperService.saveOrder(orderModel);
}

@RequestMapping("/getAllBuyer")
@GetMapping
public List<BuyerModel> fetchBuyerInfo() {
	
	return paperService.fetchBuyerInfo();
}
}
