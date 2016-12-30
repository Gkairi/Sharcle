package com.ca.innovate.controller.model;

/**
 * Created by talma07 on 12/30/2016.
 */
public class ChatDetails {

    private String uuid;
    private String groupId;
    private String chatText;
    private String userId;
    private String timeStamp;

    public String getUuid() {
        return uuid;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getChatText() {
        return chatText;
    }

    public String getUserId() {
        return userId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }



    public ChatDetails(Builder builder) {
        this.chatText = builder.chatText;
        this.groupId = builder.groupId;
        this.userId = builder.userId;
        this.timeStamp = builder.timeStamp;
        this.uuid = builder.uuid;

    }


    static  public class Builder {


        private String uuid;
        private String groupId;
        private String chatText;
        private String userId;
        private String timeStamp;

        public ChatDetails build() {
            return new ChatDetails(this);
        }

        public Builder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder groupId(String groupId) {
            this.groupId = groupId;
            return this;
        }

        public Builder chatText(String chatText) {
            this.chatText = chatText;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder timeStamp(String timeStamp ) {
            this.timeStamp = timeStamp;
            return this;
        }




    }
}
