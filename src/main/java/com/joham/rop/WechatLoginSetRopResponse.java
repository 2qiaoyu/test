package com.joham.rop;

        import java.beans.ConstructorProperties;
        import javax.xml.bind.annotation.XmlAccessType;
        import javax.xml.bind.annotation.XmlAccessorType;
        import javax.xml.bind.annotation.XmlAttribute;
        import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author joham
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(
        name = "wechatLoginSetRopResponse"
)
public class WechatLoginSetRopResponse {
    @XmlAttribute
    private Integer mobileServerStatus;
    @XmlAttribute
    private String mobileAppId;
    @XmlAttribute
    private String mobileAppSecret;
    @XmlAttribute
    private Integer pcServerStatus;
    @XmlAttribute
    private String pcAppId;
    @XmlAttribute
    private String pcAppSecret;
    @XmlAttribute
    private Integer appServerStatus;

    public static WechatLoginSetRopResponse.WechatLoginSetRopResponseBuilder builder() {
        return new WechatLoginSetRopResponse.WechatLoginSetRopResponseBuilder();
    }

    public WechatLoginSetRopResponse() {
    }

    @ConstructorProperties({"mobileServerStatus", "mobileAppId", "mobileAppSecret", "pcServerStatus", "pcAppId", "pcAppSecret", "appServerStatus"})
    public WechatLoginSetRopResponse(Integer mobileServerStatus, String mobileAppId, String mobileAppSecret, Integer pcServerStatus, String pcAppId, String pcAppSecret, Integer appServerStatus) {
        this.mobileServerStatus = mobileServerStatus;
        this.mobileAppId = mobileAppId;
        this.mobileAppSecret = mobileAppSecret;
        this.pcServerStatus = pcServerStatus;
        this.pcAppId = pcAppId;
        this.pcAppSecret = pcAppSecret;
        this.appServerStatus = appServerStatus;
    }

    public Integer getMobileServerStatus() {
        return this.mobileServerStatus;
    }

    public String getMobileAppId() {
        return this.mobileAppId;
    }

    public String getMobileAppSecret() {
        return this.mobileAppSecret;
    }

    public Integer getPcServerStatus() {
        return this.pcServerStatus;
    }

    public String getPcAppId() {
        return this.pcAppId;
    }

    public String getPcAppSecret() {
        return this.pcAppSecret;
    }

    public Integer getAppServerStatus() {
        return this.appServerStatus;
    }

    public void setMobileServerStatus(Integer mobileServerStatus) {
        this.mobileServerStatus = mobileServerStatus;
    }

    public void setMobileAppId(String mobileAppId) {
        this.mobileAppId = mobileAppId;
    }

    public void setMobileAppSecret(String mobileAppSecret) {
        this.mobileAppSecret = mobileAppSecret;
    }

    public void setPcServerStatus(Integer pcServerStatus) {
        this.pcServerStatus = pcServerStatus;
    }

    public void setPcAppId(String pcAppId) {
        this.pcAppId = pcAppId;
    }

    public void setPcAppSecret(String pcAppSecret) {
        this.pcAppSecret = pcAppSecret;
    }

    public void setAppServerStatus(Integer appServerStatus) {
        this.appServerStatus = appServerStatus;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof WechatLoginSetRopResponse)) {
            return false;
        } else {
            WechatLoginSetRopResponse other = (WechatLoginSetRopResponse) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label95:
                {
                    Object this$mobileServerStatus = this.getMobileServerStatus();
                    Object other$mobileServerStatus = other.getMobileServerStatus();
                    if (this$mobileServerStatus == null) {
                        if (other$mobileServerStatus == null) {
                            break label95;
                        }
                    } else if (this$mobileServerStatus.equals(other$mobileServerStatus)) {
                        break label95;
                    }

                    return false;
                }

                Object this$mobileAppId = this.getMobileAppId();
                Object other$mobileAppId = other.getMobileAppId();
                if (this$mobileAppId == null) {
                    if (other$mobileAppId != null) {
                        return false;
                    }
                } else if (!this$mobileAppId.equals(other$mobileAppId)) {
                    return false;
                }

                Object this$mobileAppSecret = this.getMobileAppSecret();
                Object other$mobileAppSecret = other.getMobileAppSecret();
                if (this$mobileAppSecret == null) {
                    if (other$mobileAppSecret != null) {
                        return false;
                    }
                } else if (!this$mobileAppSecret.equals(other$mobileAppSecret)) {
                    return false;
                }

                label74:
                {
                    Object this$pcServerStatus = this.getPcServerStatus();
                    Object other$pcServerStatus = other.getPcServerStatus();
                    if (this$pcServerStatus == null) {
                        if (other$pcServerStatus == null) {
                            break label74;
                        }
                    } else if (this$pcServerStatus.equals(other$pcServerStatus)) {
                        break label74;
                    }

                    return false;
                }

                label67:
                {
                    Object this$pcAppId = this.getPcAppId();
                    Object other$pcAppId = other.getPcAppId();
                    if (this$pcAppId == null) {
                        if (other$pcAppId == null) {
                            break label67;
                        }
                    } else if (this$pcAppId.equals(other$pcAppId)) {
                        break label67;
                    }

                    return false;
                }

                Object this$pcAppSecret = this.getPcAppSecret();
                Object other$pcAppSecret = other.getPcAppSecret();
                if (this$pcAppSecret == null) {
                    if (other$pcAppSecret != null) {
                        return false;
                    }
                } else if (!this$pcAppSecret.equals(other$pcAppSecret)) {
                    return false;
                }

                Object this$appServerStatus = this.getAppServerStatus();
                Object other$appServerStatus = other.getAppServerStatus();
                if (this$appServerStatus == null) {
                    if (other$appServerStatus != null) {
                        return false;
                    }
                } else if (!this$appServerStatus.equals(other$appServerStatus)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof WechatLoginSetRopResponse;
    }


    public static class WechatLoginSetRopResponseBuilder {
        private Integer mobileServerStatus;
        private String mobileAppId;
        private String mobileAppSecret;
        private Integer pcServerStatus;
        private String pcAppId;
        private String pcAppSecret;
        private Integer appServerStatus;

        WechatLoginSetRopResponseBuilder() {
        }

        public WechatLoginSetRopResponse.WechatLoginSetRopResponseBuilder mobileServerStatus(Integer mobileServerStatus) {
            this.mobileServerStatus = mobileServerStatus;
            return this;
        }

        public WechatLoginSetRopResponse.WechatLoginSetRopResponseBuilder mobileAppId(String mobileAppId) {
            this.mobileAppId = mobileAppId;
            return this;
        }

        public WechatLoginSetRopResponse.WechatLoginSetRopResponseBuilder mobileAppSecret(String mobileAppSecret) {
            this.mobileAppSecret = mobileAppSecret;
            return this;
        }

        public WechatLoginSetRopResponse.WechatLoginSetRopResponseBuilder pcServerStatus(Integer pcServerStatus) {
            this.pcServerStatus = pcServerStatus;
            return this;
        }

        public WechatLoginSetRopResponse.WechatLoginSetRopResponseBuilder pcAppId(String pcAppId) {
            this.pcAppId = pcAppId;
            return this;
        }

        public WechatLoginSetRopResponse.WechatLoginSetRopResponseBuilder pcAppSecret(String pcAppSecret) {
            this.pcAppSecret = pcAppSecret;
            return this;
        }

        public WechatLoginSetRopResponse.WechatLoginSetRopResponseBuilder appServerStatus(Integer appServerStatus) {
            this.appServerStatus = appServerStatus;
            return this;
        }

        public WechatLoginSetRopResponse build() {
            return new WechatLoginSetRopResponse(this.mobileServerStatus, this.mobileAppId, this.mobileAppSecret, this.pcServerStatus, this.pcAppId, this.pcAppSecret, this.appServerStatus);
        }

        @Override
        public String toString() {
            return "WechatLoginSetRopResponse.WechatLoginSetRopResponseBuilder(mobileServerStatus=" + this.mobileServerStatus + ", mobileAppId=" + this.mobileAppId + ", mobileAppSecret=" + this.mobileAppSecret + ", pcServerStatus=" + this.pcServerStatus + ", pcAppId=" + this.pcAppId + ", pcAppSecret=" + this.pcAppSecret + ", appServerStatus=" + this.appServerStatus + ")";
        }
    }
}
