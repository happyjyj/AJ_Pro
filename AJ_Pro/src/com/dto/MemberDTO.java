package com.dto;

public class MemberDTO {
	private String um_loginid;
	private String um_passwd;
	private String um_name;
	private String um_email;
	private String um_tel;
	private String um_photo;
	private String um_photo_bg;
//	private String um_sns;

	public MemberDTO() {
		super();
	}

	public MemberDTO(String um_loginid, String um_passwd, String um_name, String um_email, String um_tel,
			String um_photo, String um_photo_bg) {
		super();
		this.um_loginid = um_loginid;
		this.um_passwd = um_passwd;
		this.um_name = um_name;
		this.um_email = um_email;
		this.um_tel = um_tel;
		this.um_photo = um_photo;
		this.um_photo_bg = um_photo_bg;
//		this.um_sns = um_sns;
	}

	public String getUm_loginid() {
		return um_loginid;
	}

	public void setUm_loginid(String um_loginid) {
		this.um_loginid = um_loginid;
	}

	public String getUm_passwd() {
		return um_passwd;
	}

	public void setUm_passwd(String um_passwd) {
		this.um_passwd = um_passwd;
	}

	public String getUm_name() {
		return um_name;
	}

	public void setUm_name(String um_name) {
		this.um_name = um_name;
	}

	public String getUm_email() {
		return um_email;
	}

	public void setUm_email(String um_email) {
		this.um_email = um_email;
	}

	public String getUm_tel() {
		return um_tel;
	}

	public void setUm_tel(String um_tel) {
		this.um_tel = um_tel;
	}

	public String getUm_photo() {
		return um_photo;
	}

	public void setUm_photo(String um_photo) {
		this.um_photo = um_photo;
	}

	public String getUm_photo_bg() {
		return um_photo_bg;
	}

	public void setUm_photo_bg(String um_photo_bg) {
		this.um_photo_bg = um_photo_bg;
	}

	@Override
	public String toString() {
		return "MemberDTO [um_loginid=" + um_loginid + ", um_passwd=" + um_passwd + ", um_name=" + um_name
				+ ", um_email=" + um_email + ", um_tel=" + um_tel + ", um_photo=" + um_photo + ", um_photo_bg="
				+ um_photo_bg + "]";
	}

//	public String getUm_sns() {
//		return um_sns;
//	}
//
//	public void setUm_sns(String um_sns) {
//		this.um_sns = um_sns;
//	}
	
	

}
