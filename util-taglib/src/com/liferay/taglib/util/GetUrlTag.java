/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.webcache.WebCacheItem;
import com.liferay.portal.kernel.webcache.WebCachePoolUtil;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author     Brian Wing Shun Chan
 * @deprecated As of Mueller (7.2.x)
 */
@Deprecated
public class GetUrlTag extends TagSupport {

	@Override
	public int doEndTag() throws JspException {
		try {
			WebCacheItem wci = new GetUrlWebCacheItem(_url, _expires);

			String content = (String)WebCachePoolUtil.get(
				GetUrlTag.class.getName() + StringPool.PERIOD + _url, wci);

			if (Validator.isNotNull(_var)) {
				pageContext.setAttribute(_var, content);
			}
			else {
				JspWriter jspWriter = pageContext.getOut();

				jspWriter.write(content);
			}

			return EVAL_PAGE;
		}
		catch (Exception exception) {
			throw new JspException(exception);
		}
	}

	public void setExpires(long expires) {
		_expires = expires;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public void setVar(String var) {
		_var = var;
	}

	private long _expires = Time.WEEK;
	private String _url;
	private String _var;

}