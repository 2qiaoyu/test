package com.joham.rop;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author joham
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "baseRopResponse")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseRopResponse<T> implements Serializable {

    private static final long serialVersionUID = -4948347765295324939L;

    @XmlAttribute
    private String code;

    @XmlAttribute
    private T content;

    public static BaseRopResponse SUCCESS() {
        return new BaseRopResponse("success");
    }

    public BaseRopResponse(String code) {
        this.code = code;
    }


}
