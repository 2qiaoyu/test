package com.joham.spider;

import java.util.List;

public class Data {

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        private String last_id;
        private int is_available;
        private int visible_on;
        private String last_resource_id;
        private String last_column_id;
        private int resource_count;
        private List<GoodsListBean> goods_list;

        public String getLast_id() {
            return last_id;
        }

        public void setLast_id(String last_id) {
            this.last_id = last_id;
        }

        public int getIs_available() {
            return is_available;
        }

        public void setIs_available(int is_available) {
            this.is_available = is_available;
        }

        public int getVisible_on() {
            return visible_on;
        }

        public void setVisible_on(int visible_on) {
            this.visible_on = visible_on;
        }

        public String getLast_resource_id() {
            return last_resource_id;
        }

        public void setLast_resource_id(String last_resource_id) {
            this.last_resource_id = last_resource_id;
        }

        public String getLast_column_id() {
            return last_column_id;
        }

        public void setLast_column_id(String last_column_id) {
            this.last_column_id = last_column_id;
        }

        public int getResource_count() {
            return resource_count;
        }

        public void setResource_count(int resource_count) {
            this.resource_count = resource_count;
        }

        public List<GoodsListBean> getGoods_list() {
            return goods_list;
        }

        public void setGoods_list(List<GoodsListBean> goods_list) {
            this.goods_list = goods_list;
        }

        public static class GoodsListBean {

            private String app_id;
            private String resource_id;
            private String title;
            private String img_url;
            private String img_url_compress;
            private String start_at;
            private String try_audio_url;
            private String try_m3u8_url;
            private String audio_url;
            private String audio_m3u8_url;
            private String audio_compress_url;
            private String video_url;
            private String video_m3u8_url;
            private int resource_type;
            private int view_count;
            private int comment_count;
            private int is_try;
            private int can_view;
            private int audio_length;
            private int video_length;
            private ProductInfoBean product_info;
            private int periodical_count;
            private int finished_state;
            private int learn_progress;
            private int is_finish;
            private List<?> resource_list;

            public String getApp_id() {
                return app_id;
            }

            public void setApp_id(String app_id) {
                this.app_id = app_id;
            }

            public String getResource_id() {
                return resource_id;
            }

            public void setResource_id(String resource_id) {
                this.resource_id = resource_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }

            public String getImg_url_compress() {
                return img_url_compress;
            }

            public void setImg_url_compress(String img_url_compress) {
                this.img_url_compress = img_url_compress;
            }

            public String getStart_at() {
                return start_at;
            }

            public void setStart_at(String start_at) {
                this.start_at = start_at;
            }

            public String getTry_audio_url() {
                return try_audio_url;
            }

            public void setTry_audio_url(String try_audio_url) {
                this.try_audio_url = try_audio_url;
            }

            public String getTry_m3u8_url() {
                return try_m3u8_url;
            }

            public void setTry_m3u8_url(String try_m3u8_url) {
                this.try_m3u8_url = try_m3u8_url;
            }

            public String getAudio_url() {
                return audio_url;
            }

            public void setAudio_url(String audio_url) {
                this.audio_url = audio_url;
            }

            public String getAudio_m3u8_url() {
                return audio_m3u8_url;
            }

            public void setAudio_m3u8_url(String audio_m3u8_url) {
                this.audio_m3u8_url = audio_m3u8_url;
            }

            public String getAudio_compress_url() {
                return audio_compress_url;
            }

            public void setAudio_compress_url(String audio_compress_url) {
                this.audio_compress_url = audio_compress_url;
            }

            public String getVideo_url() {
                return video_url;
            }

            public void setVideo_url(String video_url) {
                this.video_url = video_url;
            }

            public String getVideo_m3u8_url() {
                return video_m3u8_url;
            }

            public void setVideo_m3u8_url(String video_m3u8_url) {
                this.video_m3u8_url = video_m3u8_url;
            }

            public int getResource_type() {
                return resource_type;
            }

            public void setResource_type(int resource_type) {
                this.resource_type = resource_type;
            }

            public int getView_count() {
                return view_count;
            }

            public void setView_count(int view_count) {
                this.view_count = view_count;
            }

            public int getComment_count() {
                return comment_count;
            }

            public void setComment_count(int comment_count) {
                this.comment_count = comment_count;
            }

            public int getIs_try() {
                return is_try;
            }

            public void setIs_try(int is_try) {
                this.is_try = is_try;
            }

            public int getCan_view() {
                return can_view;
            }

            public void setCan_view(int can_view) {
                this.can_view = can_view;
            }

            public int getAudio_length() {
                return audio_length;
            }

            public void setAudio_length(int audio_length) {
                this.audio_length = audio_length;
            }

            public int getVideo_length() {
                return video_length;
            }

            public void setVideo_length(int video_length) {
                this.video_length = video_length;
            }

            public ProductInfoBean getProduct_info() {
                return product_info;
            }

            public void setProduct_info(ProductInfoBean product_info) {
                this.product_info = product_info;
            }

            public int getPeriodical_count() {
                return periodical_count;
            }

            public void setPeriodical_count(int periodical_count) {
                this.periodical_count = periodical_count;
            }

            public int getFinished_state() {
                return finished_state;
            }

            public void setFinished_state(int finished_state) {
                this.finished_state = finished_state;
            }

            public int getLearn_progress() {
                return learn_progress;
            }

            public void setLearn_progress(int learn_progress) {
                this.learn_progress = learn_progress;
            }

            public int getIs_finish() {
                return is_finish;
            }

            public void setIs_finish(int is_finish) {
                this.is_finish = is_finish;
            }

            public List<?> getResource_list() {
                return resource_list;
            }

            public void setResource_list(List<?> resource_list) {
                this.resource_list = resource_list;
            }

            public static class ProductInfoBean {

                private String app_id;
                private String id;
                private String title;
                private String img_url;
                private String img_url_compressed;
                private String summary;
                private int resource_type;
                private String resource_id;
                private int view_count;
                private int periodical_count;

                public String getApp_id() {
                    return app_id;
                }

                public void setApp_id(String app_id) {
                    this.app_id = app_id;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getImg_url() {
                    return img_url;
                }

                public void setImg_url(String img_url) {
                    this.img_url = img_url;
                }

                public String getImg_url_compressed() {
                    return img_url_compressed;
                }

                public void setImg_url_compressed(String img_url_compressed) {
                    this.img_url_compressed = img_url_compressed;
                }

                public String getSummary() {
                    return summary;
                }

                public void setSummary(String summary) {
                    this.summary = summary;
                }

                public int getResource_type() {
                    return resource_type;
                }

                public void setResource_type(int resource_type) {
                    this.resource_type = resource_type;
                }

                public String getResource_id() {
                    return resource_id;
                }

                public void setResource_id(String resource_id) {
                    this.resource_id = resource_id;
                }

                public int getView_count() {
                    return view_count;
                }

                public void setView_count(int view_count) {
                    this.view_count = view_count;
                }

                public int getPeriodical_count() {
                    return periodical_count;
                }

                public void setPeriodical_count(int periodical_count) {
                    this.periodical_count = periodical_count;
                }
            }
        }
    }
}
