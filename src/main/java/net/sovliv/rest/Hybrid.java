package net.sovliv.rest;

public class Hybrid {
    private String mission_name;
    private Long launch_year;
    private Links links;
    private Rocket rocket;

    public Hybrid() {
    }

    public String getMission_name() {
        return mission_name;
    }

    public void setMission_name(String mission_name) {
        this.mission_name = mission_name;
    }

    public Long getLaunch_year() {
        return launch_year;
    }

    public void setLaunch_year(Long launch_year) {
        this.launch_year = launch_year;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public static class Rocket {
        private String rocket_id;

        public Rocket() {
        }

        public String getRocket_id() {
            return rocket_id;
        }

        public void setRocket_id(String rocket_id) {
            this.rocket_id = rocket_id;
        }

        @Override
        public String toString() {
            return "Rocket{" +
                    "rocket_id='" + rocket_id + '\'' +
                    '}';
        }
    }

    static class Links {
        private String mission_patch;
        private String mission_patch_small;
        private String reddit_campaign;
        private String reddit_launch;
        private String reddit_recovery;
        private String reddit_media;
        private String presskit;
        private String article_link;
        private String wikipedia;
        private String video_link;
        private String youtube_id;

        public Links() {
        }

        public String getMission_patch() {
            return mission_patch;
        }

        public void setMission_patch(String mission_patch) {
            this.mission_patch = mission_patch;
        }

        public String getMission_patch_small() {
            return mission_patch_small;
        }

        public void setMission_patch_small(String mission_patch_small) {
            this.mission_patch_small = mission_patch_small;
        }

        public String getReddit_campaign() {
            return reddit_campaign;
        }

        public void setReddit_campaign(String reddit_campaign) {
            this.reddit_campaign = reddit_campaign;
        }

        public String getReddit_launch() {
            return reddit_launch;
        }

        public void setReddit_launch(String reddit_launch) {
            this.reddit_launch = reddit_launch;
        }

        public String getReddit_recovery() {
            return reddit_recovery;
        }

        public void setReddit_recovery(String reddit_recovery) {
            this.reddit_recovery = reddit_recovery;
        }

        public String getReddit_media() {
            return reddit_media;
        }

        public void setReddit_media(String reddit_media) {
            this.reddit_media = reddit_media;
        }

        public String getPresskit() {
            return presskit;
        }

        public void setPresskit(String presskit) {
            this.presskit = presskit;
        }

        public String getArticle_link() {
            return article_link;
        }

        public void setArticle_link(String article_link) {
            this.article_link = article_link;
        }

        public String getWikipedia() {
            return wikipedia;
        }

        public void setWikipedia(String wikipedia) {
            this.wikipedia = wikipedia;
        }

        public String getVideo_link() {
            return video_link;
        }

        public void setVideo_link(String video_link) {
            this.video_link = video_link;
        }

        public String getYoutube_id() {
            return youtube_id;
        }

        public void setYoutube_id(String youtube_id) {
            this.youtube_id = youtube_id;
        }

        @Override
        public String toString() {
            return "Links{" +
                    "mission_patch='" + mission_patch + '\'' +
                    ", mission_patch_small='" + mission_patch_small + '\'' +
                    ", reddit_campaign='" + reddit_campaign + '\'' +
                    ", reddit_launch='" + reddit_launch + '\'' +
                    ", reddit_recovery='" + reddit_recovery + '\'' +
                    ", reddit_media='" + reddit_media + '\'' +
                    ", presskit='" + presskit + '\'' +
                    ", article_link='" + article_link + '\'' +
                    ", wikipedia='" + wikipedia + '\'' +
                    ", video_link='" + video_link + '\'' +
                    ", youtube_id='" + youtube_id + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Hybrid{" +
                "mission_name='" + mission_name + '\'' +
                ", launch_year=" + launch_year +
                ", links=" + links +
                ", rocket=" + rocket +
                '}';
    }
}
