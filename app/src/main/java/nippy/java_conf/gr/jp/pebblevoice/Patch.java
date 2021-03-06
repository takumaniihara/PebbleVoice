/**
 * Pebble-Voice-Settings-Extender Copyright (C) 2015 nippy-dev All rights reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package nippy.java_conf.gr.jp.pebblevoice;

import java.util.AbstractMap;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class Patch implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.equals("com.getpebble.android.basalt")) {
            findAndHookMethod("com.getpebble.android.onboarding.fragment.ChooseVoiceLanguageFragment",
                    lpparam.classLoader, "a", new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            AbstractMap<String, String> list = (AbstractMap<String, String>) param.getResult();
                            //http://developer.nuance.com/public/index.php?task=supportedLanguages
                            list.put("ara-EGY", "ar_EG");       //Arabic (Egypt)
                            list.put("ara-SAU", "ar_SA");       //Arabic (Saudi Arabia)
                            list.put("ara-XWW", "ar_AE");       //Arabic (International)
                            list.put("ind-IDN", "id_ID");       //Bahasa (Indonesia)
                            list.put("yue-CHN", "zh_HK");       //Cantonese (Simplified)
                            list.put("cat-ESP", "ca_ES");       //Catalan
                            //list.put("hrv-HRV", "N/A");       //Croatian
                            list.put("ces-CZE", "cs_CZ");       //Czech
                            list.put("nld-NLD", "nl_NL");       //Dutch
                            //list.put("eng-IND", "N/A");       //English (India)
                            list.put("ell-GRC", "el_GR");       //Greek
                            list.put("heb-ISR", "he_IL");       //Hebrew
                            list.put("hin-IND", "hi_IN");       //Hindi
                            list.put("hun-HUN", "hu_HU");       //Hungarian
                            list.put("jpn-JPN", "ja_JP");       //Japanese
                            list.put("kor_KOR", "ko_KR");       //Korean
                            list.put("zlm_MYS", "ms_MY");       //Malay
                            list.put("cmn-CHN", "cn_MA");       //Mandarin (China/Simplified)
                            list.put("cmn-TWN", "zh_TW");       //Mandarin (Taiwan/Traditional)
                            list.put("pol-POL", "pl_PL");       //Polish
                            list.put("por-BRA", "pt_BR");       //Portuguese (Brazil)
                            list.put("ron-ROU", "ro_RO");       //Romanian
                            list.put("rus-RUS", "ru_RU");       //Russian
                            list.put("slk-SVK", "sk_SK");       //Slovak
                            list.put("tha-THA", "th_TH");       //Thai
                            list.put("tur-TUR", "tr_TR");       //Turkish
                            list.put("ukr-UKR", "uk_UA");       //Ukrainian
                            list.put("vie-VNM", "vi_VN");       //Vietnamese
                        }
                    });
        }
    }
}