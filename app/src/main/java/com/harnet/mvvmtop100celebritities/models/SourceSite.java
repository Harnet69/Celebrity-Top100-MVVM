package com.harnet.mvvmtop100celebritities.models;

public class SourceSite {
    private String name;
    private String link;
    private String content;
    private String leftTrimRegex;
    private String rightTrimRegex;
    private final String PATTERN_NAME_LASTNAME;
    private final String PATTERN_PHOTO_LINK;

    public SourceSite(String name, String link, String leftTrimRegex, String rightTrimRegex, String patternNameLastname, String patternPhotoLink, String patternInfo) {
        this.leftTrimRegex = leftTrimRegex;
        this.rightTrimRegex = rightTrimRegex;
        this.name = name;
        this.link = link;
        PATTERN_NAME_LASTNAME = patternNameLastname;
        PATTERN_PHOTO_LINK = patternPhotoLink;
    }

    public String getLeftTrimRegex() {
        return leftTrimRegex;
    }

    public void setLeftTrimRegex(String leftTrimRegex) {
        this.leftTrimRegex = leftTrimRegex;
    }

    public String getRightTrimRegex() {
        return rightTrimRegex;
    }

    public void setRightTrimRegex(String rightTrimRegex) {
        this.rightTrimRegex = rightTrimRegex;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPATTERN_NAME_LASTNAME() {
        return PATTERN_NAME_LASTNAME;
    }

    public String getPATTERN_PHOTO_LINK() {
        return PATTERN_PHOTO_LINK;
    }
}
