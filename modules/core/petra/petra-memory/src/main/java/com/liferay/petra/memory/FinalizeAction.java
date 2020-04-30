/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.memory;

import java.lang.ref.Reference;

/**
 * @author Shuyang Zhou
 */
public interface FinalizeAction {

	public void doFinalize(Reference<?> reference);

}