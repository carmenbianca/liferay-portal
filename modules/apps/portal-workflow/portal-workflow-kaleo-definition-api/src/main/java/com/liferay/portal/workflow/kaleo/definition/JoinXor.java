/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition;

/**
 * @author Michael C. Han
 */
public class JoinXor extends Join {

	public JoinXor(String name, String description) {
		super(NodeType.JOIN_XOR, name, description);
	}

}