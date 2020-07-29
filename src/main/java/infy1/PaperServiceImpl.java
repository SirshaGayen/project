package infy1;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import infy.BuyerDao;
import infy.BuyerInfo;
import infy.Items;
import infy.ItemsDao;
import infy.Orders;
import infy.OrdersDao;
//import dao.PaperDao;
import infy.Paper;
import infy.PaperDao;
import infy2.BuyerModel;
import infy2.ItemModel;
import infy2.OrderModel;
import infy2.Paper12;
import org.springframework.cache.annotation.Cacheable;
@Service
public class PaperServiceImpl implements PaperService {

	@Autowired
	PaperDao paperdao;
	
	@Autowired
	ItemsDao itemsDao;
	
	@Autowired
	OrdersDao ordersDao;
	
	@Autowired
	BuyerDao buyerDao;
	
	@Cacheable("paper")
	public List<Paper12> getAllPapers() {
		System.out.println("inside paper service");
		List<Paper> paperList= paperdao.findAll();
		final List<Paper12> paperModel=new ArrayList<Paper12>();
		paperList.forEach(
			p->{
			Paper12 p12=new Paper12();
			p12=covertEntityToModel(p);
			paperModel.add(p12);
			
		});
		return paperModel;
	}
	private Paper12 covertEntityToModel(Paper p) {
		Paper12 p12=new Paper12(p.getId(),p.getName());
		return p12;
	}
	
	
	public List<ItemModel> getAllItems() {
		System.out.println("inside item service");
		List<Items> itemList= itemsDao.findAll();
		final List<ItemModel> itemModelList=new ArrayList<>();
		itemList.forEach(
			p->{
				ItemModel itemModel=new ItemModel();
				itemModel=covertEntityToModelItem(p);
				itemModelList.add(itemModel);
			
		});
		return itemModelList;
	}
	private ItemModel covertEntityToModelItem(Items i) {
		ItemModel itemModel=new ItemModel(i.getId(),i.getItemName(),i.getPrice());
		return itemModel;
	}
	
	
	public String saveOrder( OrderModel orderModel) {
		String s1="";
		Orders order=new Orders();
		order=covertModelToEntityOrder(orderModel);
		ordersDao.save(order);
		return s1;
	}
	
	private Orders covertModelToEntityOrder(OrderModel orderModel) {
		Orders orders=new Orders(orderModel.getItemId(),orderModel.getQuantity());
		return orders;
	}
	
	public List<BuyerModel> fetchBuyerInfo() {
		System.out.println("inside buyer service");
		List<BuyerInfo> buyerList= buyerDao.findAll();
		final List<BuyerModel> buyerModelList=new ArrayList<>();
		buyerList.forEach(
			buyer1->{
				BuyerModel buyerModel=new BuyerModel();
				buyerModel=covertEntityToModelBuyer(buyer1);
				buyerModelList.add(buyerModel);
			
		});
		return buyerModelList;
	}
	private BuyerModel covertEntityToModelBuyer(BuyerInfo buyer) {
		BuyerModel buyerModel = new BuyerModel(buyer.getId(),buyer.getBuyerName(),
				buyer.getAddress(),buyer.getGstin(),buyer.getStateCode());
		return buyerModel;
	}
	
	
}
//List<Paper12> l1= new ArrayList();
//Paper12 p1=new Paper12();
//p1.setId(1);
//p1.setName("ABP");
//l1.add(p1);
//Paper12 p2=new Paper12();
//p2.setId(2);
//p2.setName("Telegraph");
//l1.add(p2);
//return l1;
