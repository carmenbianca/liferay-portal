/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.jmx.model;

import java.io.Serializable;

import java.util.List;
import java.util.Objects;

/**
 * @author Shuyang Zhou
 */
public class Domain implements Serializable {

	public Domain(String domainName) {
		_domainName = domainName;

		_loaded = false;
		_mBeans = null;
	}

	public Domain(String domainName, List<MBean> mBeans) {
		_domainName = domainName;
		_mBeans = mBeans;

		_loaded = true;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Domain)) {
			return false;
		}

		Domain domain = (Domain)obj;

		if (Objects.equals(_domainName, domain._domainName)) {
			return true;
		}

		return false;
	}

	public String getDomainName() {
		return _domainName;
	}

	public List<MBean> getMBeans() {
		return _mBeans;
	}

	@Override
	public int hashCode() {
		return _domainName.hashCode();
	}

	public boolean isLoaded() {
		return _loaded;
	}

	private final String _domainName;
	private final boolean _loaded;
	private final List<MBean> _mBeans;

}