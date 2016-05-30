package com.cmbb.smartmarket.activity.search;

import android.content.SearchRecentSuggestionsProvider;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/21 下午5:14
 */
public class SearchRecentProvider extends SearchRecentSuggestionsProvider {

    public final static String AUTHORITY = "com.cmbb.smartmarket.search.recent";
    public final static int MODE = DATABASE_MODE_QUERIES;

    public SearchRecentProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }

}
