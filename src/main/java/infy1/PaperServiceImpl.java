package infy1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import dao.PaperDao;
import infy.Paper;
import infy.PaperDao;
import infy2.Paper12;

@Service
public class PaperServiceImpl implements PaperService {

	@Autowired
	PaperDao paperdao;
	
	public List<Paper12> getAllPapers() {

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