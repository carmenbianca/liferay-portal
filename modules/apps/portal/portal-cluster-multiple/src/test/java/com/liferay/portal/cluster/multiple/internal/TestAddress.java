/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.cluster.multiple.internal;

import com.liferay.portal.kernel.cluster.Address;

/**
 * @author Tina Tian
 */
public class TestAddress implements Address, Comparable<TestAddress> {

	public TestAddress(int address) {
		_address = address;
	}

	@Override
	public int compareTo(TestAddress testAddress) {
		return Integer.compare(_address, testAddress._address);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TestAddress)) {
			return false;
		}

		TestAddress testAddress = (TestAddress)obj;

		if (_address == testAddress._address) {
			return true;
		}

		return false;
	}

	@Override
	public String getDescription() {
		return String.valueOf(_address);
	}

	@Override
	public Object getRealAddress() {
		return _address;
	}

	@Override
	public int hashCode() {
		return _address;
	}

	private final int _address;

}