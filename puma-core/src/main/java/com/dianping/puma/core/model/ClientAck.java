package com.dianping.puma.core.model;

import java.io.Serializable;
import java.util.Date;

public class ClientAck implements Serializable{

	private static final long serialVersionUID = -2922003739900121110L;

	private String clientName;
	
	private BinlogInfo binlogInfo;
	
	private Date createDate;

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setBinlogInfo(BinlogInfo binlogInfo) {
		this.binlogInfo = binlogInfo;
	}

	public BinlogInfo getBinlogInfo() {
		return binlogInfo;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateDate() {
		return createDate;
	}
	
}