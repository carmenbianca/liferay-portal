/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template.soy.util;

/**
 * This interface can be implemented by any specialized class that is capable of
 * returning a low level value for the Soy template system. Such low level value
 * will be passed to Soy engine verbatim, without any smart/additional type
 * conversion.
 *
 * @author Leonardo Barros
 * @review
 */
public interface SoyRawData {

	public Object getValue();

}