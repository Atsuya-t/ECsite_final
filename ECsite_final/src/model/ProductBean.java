package model;

public class ProductBean {
	private int proCd;
	private String proName="";
	private int stockNo;
	private int proPrice;
	private int catId;
	private String proImg="";
	private String proMsg="";

	public ProductBean(){}
	public ProductBean(int proCd,String proName,int stockNo,int proPrice,int catId,String proImg,String proMsg){
		this.proCd = proCd;
		this.proName = proName;
		this.stockNo = stockNo;
		this.proPrice = proPrice;
		this.catId = catId;
		this.proImg = proImg;
		this.proMsg = proMsg;
	}

	public int getProCd() {
		return proCd;
	}
	public String getProName() {
		return proName;
	}
	public int getStockNo() {
		return stockNo;
	}
	public int getProPrice() {
		return proPrice;
	}
	public int getCatId() {
		return catId;
	}
	public String getProImg() {
		return proImg;
	}
	public String getProMsg() {
		return proMsg;
	}
}
