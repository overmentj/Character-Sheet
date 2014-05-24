package org.moss.charactersheet.util;

public class LabelUtils
{

    private LabelUtils()
    {

    }

    public static String multiLine(String text)
    {
        return multiLine(text, false);
    }

    public static String multiLine(String text, boolean centre)
    {
        String result = "<html>";

        if (centre)
        {
            result = result + "<div style=\"text-align: center;\">";
        }

        result = result + text.replaceAll("\n", "<br />");

        return result;

    }
}
