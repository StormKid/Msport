package com.msport.clientmaster.view;

import android.app.Dialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.view.wheelview.adapters.AbstractWheelTextAdapter;
import com.msport.clientmaster.view.wheelview.views.OnWheelChangedListener;
import com.msport.clientmaster.view.wheelview.views.OnWheelScrollListener;
import com.msport.clientmaster.view.wheelview.views.WheelView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * 更改封面对话框
 * 
 * @author ywl
 *
 */
public class ChangeAddressDialog extends Dialog implements View.OnClickListener {

	private WheelView wvProvince;
	private WheelView wvCitys;
	private TextView btnSure;
	private TextView btnCancel;


	// 存储省对应的所有市
	private Map<String, String[]> mCitiesDataMap = new HashMap<String, String[]>();
	// 存储市对应的所有区
	private Map<String, String[]> mAreaDataMap = new HashMap<String, String[]>();

	// 省份
	private String[] mProvinceDatas;
	// 城市
	private String[] mCitiesDatas;
	// 地区
	private String[] mAreaDatas;

	private Context context;
	private JSONObject mJsonObj;
//	private String[] mProvinceDatas;
//	private Map<String, String[]> mCitiesDataMap = new HashMap<String, String[]>();
//
	private ArrayList<String> arrProvinces = new ArrayList<String>();
	private ArrayList<String> arrCitys = new ArrayList<String>();
	private ArrayList<String> arrCountry = new ArrayList<String>();
	private AddressTextAdapter provinceAdapter;
	private AddressTextAdapter cityAdapter;

	private String strProvince = "湖北";
	private String strCity = "武汉";
	private String strCountry = "武昌区";

	private OnAddressCListener onAddressCListener;
	private int maxsize = 18;
	private int minsize = 14;
	private View contain_alls;
	private WheelView wvCountry;
	private AddressTextAdapter countryAdapter;


	public ChangeAddressDialog(Context context) {
		super(context, R.style.MyDialogStyleBottom);
		this.context = context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pop_bottom_birth);
		BeginJsonCitisData(getJson());
		wvProvince = (WheelView) findViewById(R.id.wv_birth_year);
		wvCitys = (WheelView) findViewById(R.id.wv_birth_month);
		wvCountry = (WheelView)findViewById(R.id.wv_birth_day);
		btnSure = (TextView) findViewById(R.id.one_yes);
		btnCancel = (TextView) findViewById(R.id.one_no);
		contain_alls = findViewById(R.id.contain_alls);
		btnSure.setOnClickListener(this);
		btnCancel.setOnClickListener(this);
		contain_alls.setOnClickListener(this);
		initProvinces();
		provinceAdapter = new AddressTextAdapter(context, arrProvinces, getProvinceItem(strProvince), maxsize, minsize);
		wvProvince.setVisibleItems(5);
		wvProvince.setViewAdapter(provinceAdapter);
		wvProvince.setCurrentItem(getProvinceItem(strProvince));

		initCitys(mCitiesDataMap.get(strProvince));
		cityAdapter = new AddressTextAdapter(context, arrCitys, getCityItem(strCity), maxsize, minsize);
		wvCitys.setVisibleItems(5);
		wvCitys.setViewAdapter(cityAdapter);
		wvCitys.setCurrentItem(getCityItem(strCity));

		initCounty(mAreaDataMap.get(strCity));
		countryAdapter = new AddressTextAdapter(context, arrCountry,  getAreaItem(strCountry), maxsize, minsize);
		wvCountry.setVisibleItems(5);
		wvCountry.setViewAdapter(countryAdapter);
		wvCountry.setCurrentItem(getAreaItem(strCountry));

		wvProvince.addChangingListener(new OnWheelChangedListener() {

			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				// TODO Auto-generated method stub
				String currentText = (String) provinceAdapter.getItemText(wheel.getCurrentItem());
				strProvince = currentText;
				setTextviewSize(currentText, provinceAdapter);
				String[] citys = mCitiesDataMap.get(currentText);
				initCitys(citys);
				cityAdapter = new AddressTextAdapter(context, arrCitys, 0, maxsize, minsize);
				wvCitys.setVisibleItems(5);
				wvCitys.setViewAdapter(cityAdapter);
				wvCitys.setCurrentItem(0);
				String city = citys[0];
				initCounty(mAreaDataMap.get(city));
				countryAdapter = new AddressTextAdapter(context, arrCountry,  0, maxsize, minsize);
				wvCountry.setVisibleItems(5);
				wvCountry.setViewAdapter(countryAdapter);
				wvCountry.setCurrentItem(0);
			}
		});

		wvProvince.addScrollingListener(new OnWheelScrollListener() {

			@Override
			public void onScrollingStarted(WheelView wheel) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onScrollingFinished(WheelView wheel) {
				// TODO Auto-generated method stub
				String currentText = (String) provinceAdapter.getItemText(wheel.getCurrentItem());
				setTextviewSize(currentText, provinceAdapter);
			}
		});

		wvCitys.addChangingListener(new OnWheelChangedListener() {

			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				// TODO Auto-generated method stub
				String currentText = (String) cityAdapter.getItemText(wheel.getCurrentItem());
				strCity = currentText;
				setTextviewSize(currentText, cityAdapter);
				initCounty(mAreaDataMap.get(strCity));
				countryAdapter = new AddressTextAdapter(context, arrCountry,  0, maxsize, minsize);
				wvCountry.setVisibleItems(5);
				wvCountry.setViewAdapter(countryAdapter);
				wvCountry.setCurrentItem(0);
			}
		});

		wvCitys.addScrollingListener(new OnWheelScrollListener() {

			@Override
			public void onScrollingStarted(WheelView wheel) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onScrollingFinished(WheelView wheel) {
				// TODO Auto-generated method stub
				String currentText = (String) cityAdapter.getItemText(wheel.getCurrentItem());
				setTextviewSize(currentText, cityAdapter);
			}
		});


		wvCountry.addChangingListener(new OnWheelChangedListener() {
			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				String currentText = (String) countryAdapter.getItemText(wheel.getCurrentItem());
				strCountry = currentText;
				setTextviewSize(currentText, countryAdapter);
			}
		});


		wvCountry.addScrollingListener(new OnWheelScrollListener() {
			@Override
			public void onScrollingStarted(WheelView wheel) {

			}

			@Override
			public void onScrollingFinished(WheelView wheel) {
				String currentText = (String) countryAdapter.getItemText(wheel.getCurrentItem());
				setTextviewSize(currentText, countryAdapter);
			}
		});

	}

	private class AddressTextAdapter extends AbstractWheelTextAdapter {
		ArrayList<String> list;

		protected AddressTextAdapter(Context context, ArrayList<String> list, int currentItem, int maxsize, int minsize) {
			super(context, R.layout.item_birth_year, NO_RESOURCE, currentItem, maxsize, minsize);
			this.list = list;
			setItemTextResource(R.id.tempValue);
		}

		@Override
		public View getItem(int index, View cachedView, ViewGroup parent) {
			View view = super.getItem(index, cachedView, parent);
			return view;
		}

		@Override
		public int getItemsCount() {
			return list.size();
		}

		@Override
		protected CharSequence getItemText(int index) {
			return list.get(index) + "";
		}


	}

	/**
	 * 设置字体大小
	 * 
	 * @param curriteItemText
	 * @param adapter
	 */
	public void setTextviewSize(String curriteItemText, AddressTextAdapter adapter) {
		ArrayList<View> arrayList = adapter.getTestViews();
		int size = arrayList.size();
		String currentText;
		for (int i = 0; i < size; i++) {
			TextView textvew = (TextView) arrayList.get(i);
			currentText = textvew.getText().toString();
			if (curriteItemText.equals(currentText)) {
				textvew.setTextSize(18);
			} else {
				textvew.setTextSize(14);
			}
		}
	}

	public void setAddresskListener(OnAddressCListener onAddressCListener) {
		this.onAddressCListener = onAddressCListener;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == btnSure) {
			if (onAddressCListener != null) {
				onAddressCListener.onClick(strProvince, strCity);
			}
		} else if (v == btnCancel) {
				dismiss();
		} else {
			dismiss();
		}
		dismiss();
	}

	/**
	 * 回调接口
	 * 
	 * @author Administrator
	 *
	 */
	public interface OnAddressCListener {
		void onClick(String province, String city);
	}

	/**
	 * 开始解析城市数据
	 *
	 * @Title: BeginJsonCitisData
	 * @param
	 * @return void
	 * @throws @date
	 */
	private void BeginJsonCitisData(String cityJson) {
		if (!TextUtils.isEmpty(cityJson)) {
			try {
				JSONObject object = new JSONObject(cityJson);
				JSONArray array = object.getJSONArray("citylist");

				// 获取省份的数量
				mProvinceDatas = new String[array.length()];
				String mProvinceStr = null;
				// 循环遍历
				for (int i = 0; i < array.length(); i++) {

					// 循环遍历省份，并将省保存在mProvinceDatas[]中
					JSONObject mProvinceObject = array.getJSONObject(i);
					if (mProvinceObject.has("p")) {
						mProvinceStr = mProvinceObject.getString("p");
						mProvinceDatas[i] = mProvinceStr;
					} else {
						mProvinceDatas[i] = "unknown province";
					}

					JSONArray cityArray;
					String mCityStr = null;
					try {
						// 循环遍历省对应下的城市
						cityArray = mProvinceObject.getJSONArray("c");
					} catch (Exception e) {
						e.printStackTrace();
						continue;
					}

					mCitiesDatas = new String[cityArray.length()];
					for (int j = 0; j < cityArray.length(); j++) {
						// 循环遍历城市，并将城市保存在mCitiesDatas[]中
						JSONObject mCityObject = cityArray.getJSONObject(j);
						if (mCityObject.has("n")) {
							mCityStr = mCityObject.getString("n");
							mCitiesDatas[j] = mCityStr;
						} else {
							mCitiesDatas[j] = "unknown city";
						}

						// 循环遍历地区
						JSONArray areaArray;

						try {
							// 判断是否含有第三级区域划分，若没有，则跳出本次循环，重新执行循环遍历城市
							areaArray = mCityObject.getJSONArray("a");
						} catch (Exception e) {
							e.printStackTrace();
							continue;
						}

						// 执行下面过程则说明存在第三级区域
						mAreaDatas = new String[areaArray.length()];
						for (int m = 0; m < areaArray.length(); m++) {

							// 循环遍历第三级区域，并将区域保存在mAreaDatas[]中
							JSONObject areaObject = areaArray.getJSONObject(m);
							if (areaObject.has("s")) {
								mAreaDatas[m] = areaObject.getString("s");
							} else {
								mAreaDatas[m] = "unknown area";
							}
						}

						// 存储市对应的所有第三级区域
						mAreaDataMap.put(mCityStr, mAreaDatas);
					}

					// 存储省份对应的所有市
					mCitiesDataMap.put(mProvinceStr, mCitiesDatas);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 从文件中获取json地址数据
	 */
	private String getJson() {
		StringBuilder sb = new StringBuilder();
		AssetManager mAssetManager = context.getAssets();
		try {
			InputStream is = mAssetManager.open("city.json");
			byte[] data = new byte[is.available()];
			int len = -1;
			while ((len = is.read(data)) != -1) {
				sb.append(new String(data, 0, len, "utf-8"));
			}
			is.close();
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();

		}
		return null;
	}



	/**
	 * 初始化省会
	 */
	public void initProvinces() {
		int length = mProvinceDatas.length;
		for (int i = 0; i < length; i++) {
			arrProvinces.add(mProvinceDatas[i]);
		}
	}

	/**
	 * 根据省会，生成该省会的所有城市
	 * 
	 * @param citys
	 */
	public void initCitys(String[] citys) {
		if (citys != null) {
			arrCitys.clear();
			int length = citys.length;
			for (int i = 0; i < length; i++) {
				arrCitys.add(citys[i]);
			}
		} else {
			String[] city = mCitiesDataMap.get("湖北");
			arrCitys.clear();
			int length = city.length;
			for (int i = 0; i < length; i++) {
				arrCitys.add(city[i]);
			}
		}
		if (arrCitys != null && arrCitys.size() > 0
				&& !arrCitys.contains(strCity)) {
			strCity = arrCitys.get(0);
		}
	}

	/**
	 * 生成区
	 * @param citys
     */
	public void initCounty(String[] citys) {
		if (citys != null) {
			arrCountry.clear();
			int length = citys.length;
			for (int i = 0; i < length; i++) {
				arrCountry.add(citys[i]);
			}
		} else {
			arrCountry.clear();
		}
		if (arrCountry != null && arrCountry.size() > 0
				&& !arrCountry.contains(strCountry)) {
			strCountry = arrCountry.get(0);
		}
	}

	/**
	 * 初始化地点
	 * 
	 * @param province
	 * @param city
	 */
	public void setAddress(String province, String city, String country) {
		if (province != null && province.length() > 0) {
			this.strProvince = province;
		}
		if (city != null && city.length() > 0) {
			this.strCity = city;
		}
		if (country !=null && country.length()>0){
			this.strCountry = country;
		}
	}

	/**
	 * 返回省会索引，没有就返回默认“四川”
	 * 
	 * @param province
	 * @return
	 */
	public int getProvinceItem(String province) {
		int size = arrProvinces.size();
		int provinceIndex = 0;
		boolean noprovince = true;
		for (int i = 0; i < size; i++) {
			if (province.equals(arrProvinces.get(i))) {
				noprovince = false;
				return provinceIndex;
			} else {
				provinceIndex++;
			}
		}
		if (noprovince) {
			strProvince = "湖北";
			return 22;
		}
		return provinceIndex;
	}

	/**
	 * 得到城市索引，没有返回默认“武汉”
	 * 
	 * @param city
	 * @return
	 */
	public int getCityItem(String city) {
		int size = arrCitys.size();
		int cityIndex = 0;
		boolean nocity = true;
		for (int i = 0; i < size; i++) {
			if (city.equals(arrCitys.get(i))) {
				nocity = false;
				return cityIndex;
			} else {
				cityIndex++;
			}
		}
		if (nocity) {
			strCity = "武汉";
			return 0;
		}
		return cityIndex;
	}


	public int getAreaItem(String city) {
		int size = arrCountry.size();
		int cityIndex = 0;
		boolean nocity = true;
		for (int i = 0; i < size; i++) {
			if (city.equals(arrCountry.get(i))) {
				nocity = false;
				return cityIndex;
			} else {
				cityIndex++;
			}
		}
		if (nocity) {
			strCountry = "";
			return 0;
		}
		return cityIndex;
	}

}