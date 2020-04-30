/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.network.utilities.web.internal.util;

import com.liferay.network.utilities.web.internal.model.DNSLookup;
import com.liferay.network.utilities.web.internal.model.Whois;
import com.liferay.portal.kernel.webcache.WebCacheItem;
import com.liferay.portal.kernel.webcache.WebCachePoolUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class NetworkUtil {

	public static DNSLookup getDNSLookup(String domain) {
		WebCacheItem wci = new DNSLookupWebCacheItem(domain);

		return (DNSLookup)WebCachePoolUtil.get(
			NetworkUtil.class.getName() + ".dnslookup." + domain, wci);
	}

	public static Whois getWhois(String domain) {
		WebCacheItem wci = new WhoisWebCacheItem(domain);

		return (Whois)WebCachePoolUtil.get(
			NetworkUtil.class.getName() + ".whois." + domain, wci);
	}

}