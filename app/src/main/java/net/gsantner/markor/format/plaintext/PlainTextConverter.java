/*#######################################################
 *
 *   Maintained by Gregor Santner, 2018-
 *   https://gsantner.net/
 *
 *   License: Apache 2.0 / Commercial
 *  https://github.com/gsantner/opoc/#licensing
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
#########################################################*/
package net.gsantner.markor.format.plaintext;

import android.content.Context;
import android.support.v4.text.TextUtilsCompat;

import net.gsantner.markor.format.TextConverter;
import net.gsantner.markor.util.AppSettings;

@SuppressWarnings("WeakerAccess")
public class PlainTextConverter extends TextConverter {
    private static final String HTML100_BODY_PRE_BEGIN = "<pre style='white-space: pre-wrap;font-family: " + TOKEN_FONT + "' >";
    private static final String HTML101_BODY_PRE_END = "</pre>";


    //########################
    //## Methods
    //########################

    @Override
    public String convertMarkup(String markup, Context context) {
        String converted = "", onLoadJs = "", head = "";
        converted = HTML100_BODY_PRE_BEGIN
                + TextUtilsCompat.htmlEncode(markup)
                + HTML101_BODY_PRE_END;
        return putContentIntoTemplate(context, converted, onLoadJs, head);
    }

    @Override
    protected String getContentType() {
        return CONTENT_TYPE_HTML;
    }
}
