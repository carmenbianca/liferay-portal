/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.memory;

import java.lang.ref.Reference;

/**
 * @author Shuyang Zhou
 */
public class DummyFinalizeAction implements FinalizeAction {

	@Override
	public void doFinalize(Reference<?> reference) {
	}

}