package cn.minerealms.networktitle;

class ReplaceException extends Exception {
    private String Url;

    public ReplaceException(String url) {
        this.Url=Url;
    }
    public String getUrl()
    {
        return Url;
    }
}
