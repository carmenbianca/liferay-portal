/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.item.selector.criteria.upload.criterion;

import com.liferay.item.selector.BaseItemSelectorCriterion;
import com.liferay.portal.kernel.upload.UploadServletRequestConfigurationHelperUtil;

/**
 * @author Ambrín Chaudhary
 */
public class UploadItemSelectorCriterion extends BaseItemSelectorCriterion {

	public UploadItemSelectorCriterion() {
	}

	public UploadItemSelectorCriterion(
		String portletId, String url, String repositoryName) {

		this(
			portletId, url, repositoryName,
			UploadServletRequestConfigurationHelperUtil.getMaxSize());
	}

	public UploadItemSelectorCriterion(
		String portletId, String url, String repositoryName, long maxFileSize) {

		_portletId = portletId;
		_url = url;
		_repositoryName = repositoryName;
		_maxFileSize = maxFileSize;
	}

	public UploadItemSelectorCriterion(
		String portletId, String url, String repositoryName, long maxFileSize,
		String[] extensions) {

		_portletId = portletId;
		_url = url;
		_repositoryName = repositoryName;
		_maxFileSize = maxFileSize;
		_extensions = extensions;
	}

	public String[] getExtensions() {
		return _extensions;
	}

	public long getMaxFileSize() {
		return _maxFileSize;
	}

	public String getPortletId() {
		return _portletId;
	}

	public String getRepositoryName() {
		return _repositoryName;
	}

	public String getURL() {
		return _url;
	}

	public void setExtensions(String[] extensions) {
		_extensions = extensions;
	}

	public void setMaxFileSize(long maxFileSize) {
		_maxFileSize = maxFileSize;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	public void setRepositoryName(String repositoryName) {
		_repositoryName = repositoryName;
	}

	public void setURL(String url) {
		_url = url;
	}

	private String[] _extensions;
	private long _maxFileSize;
	private String _portletId;
	private String _repositoryName;
	private String _url;

}