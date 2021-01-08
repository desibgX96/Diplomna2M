package com.diplomna2m.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

	@XmlRootElement(name = "detail")
	@XmlAccessorType(XmlAccessType.FIELD)
	public class DetailToXML {

		@XmlElement(name = "mistakes")
		private List<DetailXML> listMistakes = null;;

		public List<DetailXML> getlistMistakes() {
			return listMistakes;
		}

		public void setlistMistakes(List<DetailXML> listMistakes) {
			this.listMistakes = listMistakes;
		}
		
	}

