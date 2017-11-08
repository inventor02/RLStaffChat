package me.georgepeppard.rlstaffchat.enums;

public enum MessageType {
    STAFF_CHAT("rlstaffchat.staff.see", "rlstaffchat.staff.send", "rlstaffchat.staff.reply"),
    ADMIN_CHAT("rlstaffchat.admin.see", "rlstaffchat.admin.send", "rlstaffchat.admin.reply");

    private String seePermission, sendPermission, replyPermission = "";

    private MessageType(String seePermission, String sendPermission, String replyPermission) {
        this.seePermission = seePermission;
        this.sendPermission = sendPermission;
        this.replyPermission = replyPermission;
    }

    public String getSeePermission() {
        return seePermission;
    }

    public String getSendPermission() {
        return sendPermission;
    }

    public String getReplyPermission() {
        return replyPermission;
    }
}
