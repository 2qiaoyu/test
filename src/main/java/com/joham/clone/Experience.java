package com.joham.clone;

/**
 * 工作经历
 *
 * @author joham
 */
public class Experience {

    private String educationBackground;

    private String skills;

    public void setExperience(String educationBackground, String skills) {
        // TODO Auto-generated constructor stub
        this.educationBackground = educationBackground;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return educationBackground + skills;
    }
}
