package infy1;

import java.util.List;

import infy2.BuyerModel;
import infy2.ItemModel;
import infy2.OrderModel;
import infy2.Paper12;

public interface PaperService {

	public List<Paper12> getAllPapers();
	
	public List<ItemModel> getAllItems();
	
	public String saveOrder( OrderModel orderModel);
	
	public List<BuyerModel> fetchBuyerInfo();
}
