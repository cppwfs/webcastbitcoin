package org.bitcoinmonitor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RawData {
	String provider;
	String bid;
	String last;

	
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getAmount(){
		return bid;
	}
	public void setAmount(String amount){
		bid = amount;
		provider = "CoinBase";
	}
	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
		provider = "BitStamp";
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	@Override
	public String toString() {
		return "RawData [provider="+provider+", bid=" + bid + ", last=" + last + "]";
	}


}
