package com.accp.vo.zyy;

import java.util.Date;

public class MerchantCollectionVo {
	  private Integer collectid;

	    private Integer userid;

	    private Integer merchantorservicebyid;

	    private String merchantorservicebyname;
        private String servicetitle;
	    private Date collectionTime;
	    private Integer creditscore;
	    private String serviceCoverImg;
	    private Integer servicePrice;
	    private String stName;
	    private Integer num;
		public Integer getCollectid() {
			return collectid;
		}
		public void setCollectid(Integer collectid) {
			this.collectid = collectid;
		}
		public Integer getUserid() {
			return userid;
		}
		public void setUserid(Integer userid) {
			this.userid = userid;
		}
		public Integer getMerchantorservicebyid() {
			return merchantorservicebyid;
		}
		public void setMerchantorservicebyid(Integer merchantorservicebyid) {
			this.merchantorservicebyid = merchantorservicebyid;
		}
		public String getMerchantorservicebyname() {
			return merchantorservicebyname;
		}
		public void setMerchantorservicebyname(String merchantorservicebyname) {
			this.merchantorservicebyname = merchantorservicebyname;
		}
		
		public Integer getCreditscore() {
			return creditscore;
		}
		public void setCreditscore(Integer creditscore) {
			this.creditscore = creditscore;
		}
		public String getServiceCoverImg() {
			return serviceCoverImg;
		}
		public void setServiceCoverImg(String serviceCoverImg) {
			this.serviceCoverImg = serviceCoverImg;
		}
		public Integer getServicePrice() {
			return servicePrice;
		}
		public void setServicePrice(Integer servicePrice) {
			this.servicePrice = servicePrice;
		}
		public String getStName() {
			return stName;
		}
		public void setStName(String stName) {
			this.stName = stName;
		}
		public Date getCollectionTime() {
			return collectionTime;
		}
		public void setCollectionTime(Date collectionTime) {
			this.collectionTime = collectionTime;
		}
		public String getServicetitle() {
			return servicetitle;
		}
		public void setServicetitle(String servicetitle) {
			this.servicetitle = servicetitle;
		}
		public Integer getNum() {
			return num;
		}
		public void setNum(Integer num) {
			this.num = num;
		}
}
