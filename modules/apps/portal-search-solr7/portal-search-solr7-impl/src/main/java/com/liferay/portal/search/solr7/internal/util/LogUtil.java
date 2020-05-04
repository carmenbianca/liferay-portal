/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.util;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.log.Log;

import org.apache.solr.client.solrj.SolrResponse;
import org.apache.solr.common.SolrException;

/**
 * @author Michael C. Han
 */
public class LogUtil {

	public static void logSolrException(Log log, SolrException solrException) {
		if (log.isWarnEnabled()) {
			StringBundler sb = new StringBundler(5);

			sb.append("{class=");
			sb.append(solrException.getClass());
			sb.append(", message=");
			sb.append(solrException.getMessage());
			sb.append("}");

			log.warn(sb);
		}
	}

	public static void logSolrResponse(Log log, SolrResponse solrResponse) {
		if (log.isInfoEnabled()) {
			StringBundler sb = new StringBundler(5);

			sb.append("{elapsedTime=");
			sb.append(solrResponse.getElapsedTime());
			sb.append(", response=");
			sb.append(solrResponse);
			sb.append("}");

			log.info(sb);
		}
	}

}