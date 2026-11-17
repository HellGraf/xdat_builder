package org.sart.xdat;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Project {
   public EProjectType type;
   public String src;
}
