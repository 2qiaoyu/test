package com.joham.rop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author joham
 */
@Builder
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wechatShareSetRopResponse")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WechatShareSetRopResponse {

    @XmlAttribute
    private String shareAppId;

    @XmlAttribute
    private String shareAppSecret;

}
