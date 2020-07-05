package org.academy;

import java.util.Base64;

public class TestConfigurations {

    private static String read(String value) {
        return PropertyReader.get().readValue(value);
    }

    public static String getUrl() {
        return read("main_url");
    }

    public static String getBrowser() {
        return read("browser");
    }

    public static String getPassword() {
        return new String(Base64.getDecoder().decode(read("pass")));
    }

    public static String getLogin() {
        return new String(Base64.getDecoder().decode(read("login")));
    }

    public static String getPageUrl(String name) {
        return read("main_url") + read(name);
    }

    public static String getParam(String param) {
        return read(param);
    }

    public static String getSearchApp() {
        return read("searchApp");
    }

    public static String getIssuesUrl() {
        return read("issues_url");
    }

    public static String getIssue21420Url() {
        return read("issue21420_url");
    }

    public static String getFile() {
        return read("file_properties");
    }

    public static String getTrendingUrl() {
        return read("trending_url");
    }

    public static String getLabel() {
        return read("label");
    }

    public static String getPageTitle() {
        return read("pageTitle");
    }

    public static String getPageBody() {
        return read("pageBody");
    }

    public static String getTestPageUrl() {
        return read("wikiPage_url");
    }

    public static String getCollaborator() {
        return read("collaborator");
    }
    public static String getUserCookie(){
        return read("userCookie");
    }

    public static String getApiUri() {
        return read("api_uri");
    }

    public static String getApiToken() {
        return new String(Base64.getDecoder().decode(read("api_token")));
    }

    public static String getProject() {
        return read("project");
    }

    public static String getProjectBody() {
        return read("projectBody");
    }
}
