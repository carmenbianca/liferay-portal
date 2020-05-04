/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.internal;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.Portlet;

import javax.portlet.MimeResponse;
import javax.portlet.PortletRequest;
import javax.portlet.RenderURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Neil Griffin
 */
public class RenderURLImpl extends PortletURLImpl implements RenderURL {

	public RenderURLImpl(
		HttpServletRequest httpServletRequest, Portlet portlet, Layout layout,
		String lifecycle, MimeResponse.Copy copy) {

		super(httpServletRequest, portlet, layout, lifecycle, copy);
	}

	public RenderURLImpl(
		PortletRequest portletRequest, Portlet portlet, Layout layout,
		String lifecycle, MimeResponse.Copy copy) {

		super(portletRequest, portlet, layout, lifecycle, copy);
	}

	@Override
	public String getFragmentIdentifier() {
		return _fragmentIdentifier;
	}

	@Override
	public void setFragmentIdentifier(String fragmentIdentifier) {
		_fragmentIdentifier = fragmentIdentifier;
	}

	@Override
	public String toString() {
		String toString = super.toString();

		if (_fragmentIdentifier != null) {
			toString = toString.concat(
				StringPool.POUND
			).concat(
				_fragmentIdentifier
			);
		}

		return toString;
	}

	private String _fragmentIdentifier;

}