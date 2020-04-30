/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.common;

/**
 * @author Michael C. Han
 */
public enum DSSignaturePackageStatus {

	COMPLETED("completed"), CREATED("created"), DECLINED("delined"),
	DELETED("deleted"), DELIVERED("delivered"), FAILED("failed"), SENT("sent"),
	SIGNED("signed"), VOIDED("voided");

	public String getStatus() {
		return _status;
	}

	private DSSignaturePackageStatus(String status) {
		_status = status;
	}

	private final String _status;

}