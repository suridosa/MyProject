package com.suridosa.callpopup.domain;

import java.util.List;

public class GeoDomain {
	
	private Meta meta;
	private List<Documents> documents;

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public List<Documents> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Documents> documents) {
		this.documents = documents;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GeoDomain [meta=");
		builder.append(meta);
		builder.append(", documents=");
		builder.append(documents);
		builder.append("]");
		return builder.toString();
	}

}