package com.msport.clientmaster.util;

import android.text.TextUtils;
import android.widget.EditText;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @author like
 * 2016-5-17
 */
public class StringUtil {
	// 判断字符串是否为空
	public static boolean isEmpty(String str) {
		return str == null || str.equals("");

	}

	/**
	 * 判断是不是合法手机 handset 手机号码
	 */
	public static boolean isHandset(String handset) {
		try {
			if (!handset.substring(0, 1).equals("1")) {
				return false;
			}
			if (handset == null || handset.length() != 11) {
				return false;
			}
			String check = "^[0123456789]+$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(handset);
			boolean isMatched = matcher.matches();
			return isMatched;
		} catch (RuntimeException e) {
			return false;
		}
	}

	// 密码验证—长度在6~20之间，只能包含字符、数字、下划线
	public static boolean isPassword(String password) {
		Pattern pattern = Pattern.compile("^\\w{6,20}$");
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

	// 验证邮箱
	public static boolean isEmail(String email) {
		String str = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);
		return m.matches();
	}

	// 验证身份证——18位
	public static boolean isIdentityCard(String identityCard) {
		Pattern pattern = Pattern.compile("([0-9]{17}([0-9]|X|x))|([0-9]{15})");
		Matcher matcher = pattern.matcher(identityCard);
		return matcher.matches();
	}

	/************字符串加**************/
	public static String addString(String one, String two){
		BigDecimal oneBig = new BigDecimal(one);
		BigDecimal twoBig = new BigDecimal(two);
		String result = oneBig.add(twoBig).toString();
		return result;

	}


	/**
	 * 两String相乘
	 *
	 * @param one
	 * @param two
	 * @return
	 */
	public static String multipString(String one, String two) {
		BigDecimal onb = new BigDecimal(one);
		BigDecimal twb = new BigDecimal(two);
		String result = onb.multiply(twb).toString();
		return result;

	}

	public static int multipInt(String one, String two) {
		BigDecimal onb = new BigDecimal(one);
		BigDecimal twb = new BigDecimal(two);
		int result = onb.multiply(twb).intValue();
		return result;

	}




	/**
	 * 两String相减
	 * @param qian
	 * @param hou
	 * @return
	 */
	public static String musString(String qian, String hou) {
		BigDecimal qianJ = new BigDecimal(qian);
		BigDecimal houJ = new BigDecimal(hou);
		String result = qianJ.subtract(houJ).toString();
		return result;

	}

	/************字符串除[请在用此方法之前做好判断]**************/
	public static String divString(String fenzi, String fenmu){
		BigDecimal fenziBig = new BigDecimal(fenzi);
		BigDecimal fenmuBig = new BigDecimal(fenmu);
		String result = fenziBig.divide(fenmuBig).toString();
		return result;

	}

	/**
	 * is null or its length is 0 or it is made by space
	 *
	 * <pre>
	 * isBlank(null) = true;
	 * isBlank(&quot;&quot;) = true;
	 * isBlank(&quot;  &quot;) = true;
	 * isBlank(&quot;a&quot;) = false;
	 * isBlank(&quot;a &quot;) = false;
	 * isBlank(&quot; a&quot;) = false;
	 * isBlank(&quot;a b&quot;) = false;
	 * </pre>
	 *
	 * @param str
	 * @return if string is null or its size is 0 or it is made by space, return
	 *         true, else return false.
	 */
	public static boolean isBlank(String str) {
		return (str == null || str.trim().length() == 0);
	}

	/**
	 * is null or its length is 0
	 *
	 * <pre>
	 * isEmpty(null) = true;
	 * isEmpty(&quot;&quot;) = true;
	 * isEmpty(&quot;  &quot;) = false;
	 * </pre>
	 *
	 * @param str
	 * @return if string is null or its size is 0, return true, else return
	 *         false.
	 */
	public static boolean isEmpty(CharSequence str) {
		return (str == null || str.length() == 0);
	}

	/**
	 * compare two string
	 *
	 * @param actual
	 * @param expected
	 * @return
	 * @see ObjectUtils#isEquals(Object, Object)
	 */
	// public static boolean isEquals(String actual, String expected) {
	// return ObjectUtils.isEquals(actual, expected);
	// }

	/**
	 * get length of CharSequence
	 *
	 * <pre>
	 * length(null) = 0;
	 * length(\"\") = 0;
	 * length(\"abc\") = 3;
	 * </pre>
	 *
	 * @param str
	 * @return if str is null or empty, return 0, else return
	 *         {@link CharSequence#length()}.
	 */
	public static int length(CharSequence str) {
		return str == null ? 0 : str.length();
	}

	/**
	 * null Object to empty string
	 *
	 * <pre>
	 * nullStrToEmpty(null) = &quot;&quot;;
	 * nullStrToEmpty(&quot;&quot;) = &quot;&quot;;
	 * nullStrToEmpty(&quot;aa&quot;) = &quot;aa&quot;;
	 * </pre>
	 *
	 * @param str
	 * @return
	 */
	public static String nullStrToEmpty(Object str) {
		return (str == null ? "" : (str instanceof String ? (String) str : str
				.toString()));
	}

	/**
	 * capitalize first letter
	 *
	 * <pre>
	 * capitalizeFirstLetter(null)     =   null;
	 * capitalizeFirstLetter("")       =   "";
	 * capitalizeFirstLetter("2ab")    =   "2ab"
	 * capitalizeFirstLetter("a")      =   "A"
	 * capitalizeFirstLetter("ab")     =   "Ab"
	 * capitalizeFirstLetter("Abc")    =   "Abc"
	 * </pre>
	 *
	 * @param str
	 * @return
	 */
	public static String capitalizeFirstLetter(String str) {
		if (isEmpty(str)) {
			return str;
		}

		char c = str.charAt(0);
		return (!Character.isLetter(c) || Character.isUpperCase(c)) ? str
				: new StringBuilder(str.length())
						.append(Character.toUpperCase(c))
						.append(str.substring(1)).toString();
	}

	/**
	 * encoded in utf-8
	 *
	 * <pre>
	 * utf8Encode(null)        =   null
	 * utf8Encode("")          =   "";
	 * utf8Encode("aa")        =   "aa";
	 * utf8Encode("啊啊啊啊")   = "%E5%95%8A%E5%95%8A%E5%95%8A%E5%95%8A";
	 * </pre>
	 *
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 *             if an error occurs
	 */
	public static String utf8Encode(String str) {
		return URLEncoder.encode(str);
	}

	/**
	 * 指定编码方式
	 * @param str
	 * @param encode "utf-8","iso-8859-1"
     * @return
     */
	public static String utf8Encode(String str,String encode){
		if (!isEmpty(str)) {
			try {
				return URLEncoder.encode(str, encode);
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(
						"UnsupportedEncodingException occurred. ", e);
			}
		}
		return str;
	}

	/**
	 * encoded in utf-8, if exception, return defultReturn
	 *
	 * @param str
	 * @param defultReturn
	 * @return
	 */
	public static String utf8Decode(String str, String defultReturn) {
		if (!isEmpty(str) && str.getBytes().length != str.length()) {
			try {
				return URLDecoder.decode(str, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return defultReturn;
			}
		}
		return str;
	}

	/**
	 * get innerHtml from href
	 *
	 * <pre>
	 * getHrefInnerHtml(null)                                  = ""
	 * getHrefInnerHtml("")                                    = ""
	 * getHrefInnerHtml("mp3")                                 = "mp3";
	 * getHrefInnerHtml("&lt;a innerHtml&lt;/a&gt;")                    = "&lt;a innerHtml&lt;/a&gt;";
	 * getHrefInnerHtml("&lt;a&gt;innerHtml&lt;/a&gt;")                    = "innerHtml";
	 * getHrefInnerHtml("&lt;a&lt;a&gt;innerHtml&lt;/a&gt;")                    = "innerHtml";
	 * getHrefInnerHtml("&lt;a href="baidu.com"&gt;innerHtml&lt;/a&gt;")               = "innerHtml";
	 * getHrefInnerHtml("&lt;a href="baidu.com" title="baidu"&gt;innerHtml&lt;/a&gt;") = "innerHtml";
	 * getHrefInnerHtml("   &lt;a&gt;innerHtml&lt;/a&gt;  ")                           = "innerHtml";
	 * getHrefInnerHtml("&lt;a&gt;innerHtml&lt;/a&gt;&lt;/a&gt;")                      = "innerHtml";
	 * getHrefInnerHtml("jack&lt;a&gt;innerHtml&lt;/a&gt;&lt;/a&gt;")                  = "innerHtml";
	 * getHrefInnerHtml("&lt;a&gt;innerHtml1&lt;/a&gt;&lt;a&gt;innerHtml2&lt;/a&gt;")        = "innerHtml2";
	 * </pre>
	 *
	 * @param href
	 * @return <ul>
	 *         <li>if href is null, return ""</li>
	 *         <li>if not match regx, return source</li>
	 *         <li>return the last string that match regx</li>
	 *         </ul>
	 */
	public static String getHrefInnerHtml(String href) {
		if (isEmpty(href)) {
			return "";
		}

		String hrefReg = ".*<[\\s]*a[\\s]*.*>(.+?)<[\\s]*/a[\\s]*>.*";
		Pattern hrefPattern = Pattern
				.compile(hrefReg, Pattern.CASE_INSENSITIVE);
		Matcher hrefMatcher = hrefPattern.matcher(href);
		if (hrefMatcher.matches()) {
			return hrefMatcher.group(1);
		}
		return href;
	}

/**
     * process special char in html
     *
     * <pre>
     * htmlEscapeCharsToString(null) = null;
     * htmlEscapeCharsToString("") = "";
     * htmlEscapeCharsToString("mp3") = "mp3";
     * htmlEscapeCharsToString("mp3&lt;") = "mp3<";
     * htmlEscapeCharsToString("mp3&gt;") = "mp3\>";
     * htmlEscapeCharsToString("mp3&amp;mp4") = "mp3&mp4";
     * htmlEscapeCharsToString("mp3&quot;mp4") = "mp3\"mp4";
     * htmlEscapeCharsToString("mp3&lt;&gt;&amp;&quot;mp4") = "mp3\<\>&\"mp4";
     * </pre>
     *
     * @param source
     * @return
     */
	public static String htmlEscapeCharsToString(String source) {
		return StringUtil.isEmpty(source) ? source : source
				.replaceAll("&lt;", "<").replaceAll("&gt;", ">")
				.replaceAll("&amp;", "&").replaceAll("&quot;", "\"");
	}

	/**
	 * transform half width char to full width char
	 *
	 * <pre>
	 * fullWidthToHalfWidth(null) = null;
	 * fullWidthToHalfWidth("") = "";
	 * fullWidthToHalfWidth(new String(new char[] {12288})) = " ";
	 * fullWidthToHalfWidth("！＂＃＄％＆) = "!\"#$%&";
	 * </pre>
	 *
	 * @param s
	 * @return
	 */
	public static String fullWidthToHalfWidth(String s) {
		if (isEmpty(s)) {
			return s;
		}

		char[] source = s.toCharArray();
		for (int i = 0; i < source.length; i++) {
			if (source[i] == 12288) {
				source[i] = ' ';
				// } else if (source[i] == 12290) {
				// source[i] = '.';
			} else if (source[i] >= 65281 && source[i] <= 65374) {
				source[i] = (char) (source[i] - 65248);
			} else {
				source[i] = source[i];
			}
		}
		return new String(source);
	}

	/**
	 * transform full width char to half width char
	 *
	 * <pre>
	 * halfWidthToFullWidth(null) = null;
	 * halfWidthToFullWidth("") = "";
	 * halfWidthToFullWidth(" ") = new String(new char[] {12288});
	 * halfWidthToFullWidth("!\"#$%&) = "！＂＃＄％＆";
	 * </pre>
	 *
	 * @param s
	 * @return
	 */
	public static String halfWidthToFullWidth(String s) {
		if (isEmpty(s)) {
			return s;
		}

		char[] source = s.toCharArray();
		for (int i = 0; i < source.length; i++) {
			if (source[i] == ' ') {
				source[i] = (char) 12288;
				// } else if (source[i] == '.') {
				// source[i] = (char)12290;
			} else if (source[i] >= 33 && source[i] <= 126) {
				source[i] = (char) (source[i] + 65248);
			} else {
				source[i] = source[i];
			}
		}
		return new String(source);
	}

	/**
	 * 判断一个字符串是否是字母
	 *
	 * @param str
	 * @return
	 */
	public static boolean isLetter_1(String str) {
		boolean flag = false;
		if (str != null) {
			if ((str.charAt(0) >= 'A' && str.charAt(0) <= 'Z')
					|| (str.charAt(0) >= 'a' && str.charAt(0) <= 'z')) {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 *
	 * @param str
	 * @return
	 */
	public static boolean isLetter(String str) {
		String reg = "[a-zA-Z]";
		return str.matches(reg);
	}

	/**
	 * 将长String 字符串写入文件中
	 */

	public static void putStringInFile(String json, String path) {

		try {
			FileWriter fileWriter = new FileWriter(new File(path));
			fileWriter.write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 格式化两位小数
	 * @param value
	 * @return
	 */
	public static String formatDigital(double value)
	{
		DecimalFormat df = new DecimalFormat("######0.00");
		return df.format(value);
	}
	public static String formatDigital(float value)
	{
		DecimalFormat df = new DecimalFormat("######0.00");
		return df.format(value);
	}


	/**
	 * 拼接图片字符串
	 */
	public static final String MAIN_DO = "http://120.25.97.0";//TODO 外网
//	public static final String MAIN_DO = "http://192.168.0.109:8710";//内网
	/**
	 * 获得图片地址url
	 * @param url
	 * @return
	 */
	public static String getRealImgUrl(String url){
		String result = "";
		if (null == url||url.contains("http:")){
			return url;
		}
		if (url!=null) {
			String[] value = new String[]{};
			if (url.contains("\\|"));{
			value = url.split("\\|");}
			String getvalue = value[(value.length-1)];
			String utf8Decode = utf8Decode(getvalue, getvalue);
//			result =MAIN_DO+getvalue.replaceAll("/files/", "/_thumbs/files/");
			result =MAIN_DO+utf8Decode.replaceAll("/files/", "/_thumbs/files/");
		}
		LogUtils.e("imgUrl" , result);
		return result;
	}




	/**
	 * 获取地址
	 * @return
	 */
	public static List<String> getLocationRange(String servRange){
		List<String> arrays = new ArrayList<String>();
		if (servRange==null||TextUtils.isEmpty(servRange)) {
			return arrays;
		}
		String[] servRanges = servRange.split(",");
		List<String> location = new ArrayList<String>();
		location.add("江岸区");
		location.add("江汉区");
		location.add("硚口区");
		location.add("汉阳区");
		location.add("武昌区");
		location.add("洪山区");
		location.add("青山区");
		location.add("东西湖区");
		location.add("蔡甸区");
		location.add("江夏区");
		location.add("黄陂区");
		location.add("新洲区");
		location.add("汉南区");
		for (String ranges : servRanges) {
			if (!TextUtils.isEmpty(ranges)) {
				int range = Integer.parseInt(ranges);
				arrays.add(location.get(range));
			}

		}

		return arrays;
	}

	/**
	 * 获取所有的地址项目
	 * @return
     */
	public static List<String> getLocationRange(){
		List<String> location = new ArrayList<String>();
		location.add("江岸区");
		location.add("江汉区");
		location.add("硚口区");
		location.add("汉阳区");
		location.add("武昌区");
		location.add("洪山区");
		location.add("青山区");
		location.add("东西湖区");
		location.add("蔡甸区");
		location.add("江夏区");
		location.add("黄陂区");
		location.add("新洲区");
		location.add("汉南区");
		return location;
	}



	/**
	 * 判断输入小数点，只能输入到后两位
	 * @param editText
	 * @param s
	 */
	public static void editPoint(EditText editText, CharSequence s){
		if (s.toString().contains(".")) {
			if (s.length() - 1 - s.toString().indexOf(".") > 2) {
				s = s.toString().subSequence(0,
						s.toString().indexOf(".") + 3);
				editText.setText(s);
				editText.setSelection(s.length());
			}
		}
		if (s.toString().trim().substring(0).equals(".")) {
			s = "0" + s;
			editText.setText(s);
			editText.setSelection(2);
		}

		if (s.toString().startsWith("0")
				&& s.toString().trim().length() > 1) {
			if (!s.toString().substring(1, 2).equals(".")) {
				editText.setText(s.subSequence(0, 1));
				editText.setSelection(1);
				return;
			}
		}

	}



}
