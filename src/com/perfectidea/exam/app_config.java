package com.perfectidea.exam;

public class app_config {
	public enum AppMode {
		Demo,
		Production,
	}
	
	private static final AppMode mode = AppMode.Demo;
	private static final String parseAppIdDemo = "vWiOE5dwkugDXk6GD7g6wgH8bJXd2dfcLwhT8Po1";
	private static final String parseClientKeyDemo = "PMcsuKTp7z5FR5NGWCsmmDV27Gvv67hawQ9wMpgP";
	private static final String parseAppId = "ngjQOIjJjcL7QgpbV6GkgTE71XjRJsftGFXFyCrR";
	private static final String parseClientKey = "ZFfrx5EmcMhnSErq9NfN5ov9hUPTLdO7tzXdhqq9";
	
	/*
	 * database versions
	 * */
	public static final Integer controlDB = 1;
	public static final Integer dataDB = 1;
	public static final Integer fin00 = 1;
	public static final Integer ins01 = 1;
	public static final Integer ins02 = 1;
	public static final Integer ins03 = 1;
	public static final Integer ins04 = 1;
	public static final Integer bank01 = 1;
	public static final Integer bank02 = 1;
	public static final Integer bank03 = 1;
	public static final Integer bank04 = 1;
	public static final Integer bank05 = 1;
	public static final Integer bank06 = 1;
	public static final Integer sec01 = 1;
	public static final Integer sec02 = 1;
	public static final Integer sec03 = 1;
	public static final Integer sec04 = 1;
	public static final Integer sec05 = 1;
	public static final Integer sec06 = 1;
	public static final Integer sec07 = 1;
	public static final Integer sec08 = 1;
	
	/*
	 * licneses
	 * */
	public static final String licenseId1 = "fin00";
	public static final String licenseId2 = "ins01";
	public static final String licenseId3 = "ins02";
	public static final String licenseId4 = "ins03";
	public static final String licenseId5 = "ins04";
	public static final String licenseBank01 = "bak01";
	public static final String licenseBank02 = "bak02";
	public static final String licenseBank03 = "bak03";
	public static final String licenseBank04 = "bak04";
	public static final String licenseBank05 = "bak05";
	public static final String licenseBank06 = "bak06";
	public static final String licenseSec01 = "sec01";
	public static final String licenseSec02 = "sec02";
	public static final String licenseSec03 = "sec03";
	public static final String licenseSec04 = "sec04";
	public static final String licenseSec05 = "sec05";
	public static final String licenseSec06 = "sec06";
	public static final String licenseSec07 = "sec07";
	public static final String licenseSec08 = "sec08";
	
	/**
	 * Parse.framework application id
	 * */
	public static String getParseAppId() {
		if (mode.equals(AppMode.Production)) {
			return parseAppId;
		}
		return parseAppIdDemo;
	}
	
	/**
	 * Parse.framework client key
	 * */
	public static String getParseClientKey() {
		if (mode.equals(AppMode.Production)) {
			return parseClientKey;
		}
		return parseClientKeyDemo;
	}
	
	public static final String companyName = "Perfect-Idea Inc.";
	public static final String authorName = "證照王";
	public static final String supportEmail = "service@perfectidea.com.tw";
	public static final String reportEamil = "perfectidea54169320@gmail.com";
	
	public static String getSystemInformation() {
		return "「證照王」製作團隊係由多位碩博士以及證照達人所組成，主要針對有志報考各項專業證照之學生或專業人士，提供一個綠色環保概念的行動學習平台。";
	}
	
	public static String getCompanyInformation() {
		return "智慧型手機及平板的普及率顛覆了傳統商業模式，有創意的好點子除了可以藉由APP打開知名度，更可以開發屬於自己的市場，「正點行銷管顧」是您創意的實踐家。";
	}
	
	public static String getServiceInformation() {
		return "本公司手機平板APP開發團隊具有長年經驗，歡迎公司團體或創意達人提具各種新創商業模式合作提案。";
	}
	
	public static String warningMessage() {
		return "";
	}
}
